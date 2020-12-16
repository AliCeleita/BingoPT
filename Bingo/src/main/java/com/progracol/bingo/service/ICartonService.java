package com.progracol.bingo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.progracol.bingo.entity.game.Carton;

@Component
public interface ICartonService {
	
	public abstract Page<Carton> listarcartones(int page, int size);
	
	public abstract List<Carton> evaluate(List<Integer> numeros, char figura);
}
