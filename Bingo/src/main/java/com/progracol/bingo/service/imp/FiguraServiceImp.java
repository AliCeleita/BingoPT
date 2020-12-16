package com.progracol.bingo.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progracol.bingo.dto.FiguraDto;
import com.progracol.bingo.entity.game.Figura;
import com.progracol.bingo.exception.ArgumentRequiredException;
import com.progracol.bingo.exception.ModelNotFoundException;
import com.progracol.bingo.repo.game.FiguraRepo;
import com.progracol.bingo.service.IFiguraService;

@Service
public class FiguraServiceImp implements IFiguraService{

	@Autowired
	private FiguraRepo repo;

	/**
	 * Metodo que lista todas las figuras
	*/
	@Override
	public List<Figura> get() {
		return repo.findAll();
	}

	
	/**
	 * Metodo que actualiza las posiciones de la figura
	 * @param figura indica el id de la figura existente y las posiciones a actualizar
	*/ 
	@Override
	public String update(FiguraDto figura) {
		if(figura.getFigure_id()==null) {
			throw new ArgumentRequiredException("El id de la figura es requerido");
		}
		boolean existencia = repo.existsById(figura.getFigure_id());
		if(existencia) {
			Figura fig = repo.findById(figura.getFigure_id()).orElseThrow(() 
					-> new ModelNotFoundException("Esta figura no existe"));
			repo.delete(fig);
			fig.setPositions_winner(null);
			fig.setPositions_winner(figura.getPositions_winner());
			repo.save(fig);
			return "Se ha editado la figura";
		}else {
			throw new ModelNotFoundException("Esta figura no existe");
		}
	}
}
