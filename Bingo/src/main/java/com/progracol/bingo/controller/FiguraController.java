package com.progracol.bingo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progracol.bingo.dto.FiguraDto;
import com.progracol.bingo.entity.game.Figura;
import com.progracol.bingo.service.IFiguraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@PreAuthorize("hasAuthority('Superadmin')")
@Api(tags = "Figuras")
@RestController
@RequestMapping("/figuras")
public class FiguraController {

	@Autowired
	IFiguraService service;
	
	@GetMapping(path = "/consultar")
	@ApiOperation(value = "Servicio consultar", notes = "Este servicio se encarga de consultar las figuras existentes")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK") })
	public ResponseEntity<List<Figura>> consultar(){
		List<Figura> listaFiguras = service.get();
		return new ResponseEntity<List<Figura>>(listaFiguras, HttpStatus.OK);
	}
	
	@PutMapping(path = "/editar")
	@ApiOperation(value = "Servicio editar", notes = "Este servicio se encarga de editar el objeto según su ID")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "Se ha editado exitosamente"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Esta figura no existe") })
	public ResponseEntity<String> editar(@Valid @RequestBody FiguraDto figura) throws Exception {
		String respuesta = service.update(figura);
		return new ResponseEntity<String>(respuesta, HttpStatus.OK);
	}
}
