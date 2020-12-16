package com.progracol.bingo.repo.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.progracol.bingo.entity.game.Figura;


@Repository
public interface FiguraRepo extends JpaRepository<Figura, Integer>{
	
	/**
	 * Este Query consulta la figura que se va a evaluar en la partida 
	 * @param figura nombre de la figura que se desea evaluar
	 * @return objeto Figura
	 */
	@Query("SELECT fg FROM Figura fg where lower(fg.figure_name) = lower(:figure_name)")
	public Figura consultarFigura(
			@Param("figure_name") String figura);
	
}
