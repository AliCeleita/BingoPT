package com.progracol.bingo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progracol.bingo.service.IUsuarioService;

import io.swagger.annotations.Api;

@Api(tags = "Usuarios")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	IUsuarioService service;
	
}
