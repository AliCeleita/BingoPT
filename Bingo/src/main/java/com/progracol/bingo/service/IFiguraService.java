package com.progracol.bingo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.progracol.bingo.dto.FiguraDto;
import com.progracol.bingo.entity.game.Figura;

@Component
public interface IFiguraService {
	
	public abstract List<Figura> get();
	
	public abstract String update(FiguraDto figura);
	
}
