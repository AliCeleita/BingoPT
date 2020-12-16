package com.progracol.bingo.repo.game;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.progracol.bingo.entity.game.Carton;
import com.progracol.bingo.entity.game.Figura;

@Repository
public interface CartonRepo extends JpaRepository<Carton, Integer>{
	
	/**
	 * Este Query obtiene las 100 primeras positicones de la tabla de los cartones
	 * @return List<Carton>
	 */
	@Query(value="select * from bingo_param_board limit 100", nativeQuery = true)
	public List<Carton> consultarCartones();
}
