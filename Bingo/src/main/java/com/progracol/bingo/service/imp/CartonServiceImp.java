package com.progracol.bingo.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.progracol.bingo.entity.game.Carton;
import com.progracol.bingo.entity.game.Figura;
import com.progracol.bingo.repo.game.CartonRepo;
import com.progracol.bingo.repo.game.FiguraRepo;
import com.progracol.bingo.service.ICartonService;

@Service
public class CartonServiceImp implements ICartonService{

	@Autowired
	private CartonRepo repo;
	
	@Autowired
	private FiguraRepo repoFig;
	
	/**
	 * Metodo encargado de listar paginado
	 * @param page indica el número de páginas
	 * @param size indica el tamaño que tendra cada página
	 */
	@Override
	public Page<Carton> listarcartones(int page, int size) {
		Page<Carton> listaCartones = repo.findAll(PageRequest.of(page, size));
		return listaCartones;
	}
	
	/**
	 * Metodo encargado de evaluar quienes son los ganadores
	 * @param numeros indica las balotas que se van a comparar
	 * @param figura indica la figura que se va a evaluar en esta partida 
	 */
	@Override
	public List<Carton> evaluate(List<Integer> numeros, char figura) {
		
		List<Carton> ganadores= new ArrayList<Carton>();
		
		Figura posiciones= repoFig.consultarFigura(Character.toString(figura));
		List<Boolean> posicion = posiciones.getPositions_winner();
		posicion.removeAll(Collections.singleton(null));
		
		List<Carton> cartones= repo.consultarCartones();
		
		for(Carton carton: cartones) {
			List<Integer> num = carton.getBoard_numbers();
			num.removeAll(Collections.singleton(null));
			
			num=evaluarFigura(posicion,num);
			if(num.containsAll(numeros)) {
					ganadores.add(carton);
			}
		}	
		return ganadores;
	}
	
	/**
	 *	Este método es el encargado de dejar solamente los numeros que se van
	 *	a evaluar en la figura 
	*/
	public List<Integer> evaluarFigura(List<Boolean> posicion, List<Integer> num ) {
		List<Integer> eliminar = new ArrayList<Integer>();
		List<Integer> num_el = new ArrayList<Integer>();
		for(int i=0; i<posicion.size();i++) {
			if(posicion.get(i)!=true) {
				eliminar.add(i);
			}
		}
		
		for(Integer index: eliminar ) {
			num_el.add(num.get(index));
		}
		num.removeAll(num_el);
		return num;
	}
}
