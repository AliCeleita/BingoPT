package com.progracol.bingo.dto;

import java.util.List;

public class FiguraDto {
	private Integer figure_id;
	
	private List<Boolean> positions_winner;

	public Integer getFigure_id() {
		return figure_id;
	}

	public void setFigure_id(Integer figure_id) {
		this.figure_id = figure_id;
	}

	public List<Boolean> getPositions_winner() {
		return positions_winner;
	}

	public void setPositions_winner(List<Boolean> positions_winner) {
		this.positions_winner = positions_winner;
	}
}
