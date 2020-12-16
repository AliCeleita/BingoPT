package com.progracol.bingo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progracol.bingo.dto.ListaDto;
import com.progracol.bingo.entity.game.Carton;
import com.progracol.bingo.service.ICartonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@PreAuthorize("hasAuthority('Superadmin')")
@Api(tags = "Cartones")
@RestController
@RequestMapping("/cartones")
public class CartonController {

	@Autowired
	ICartonService service;
	
	@GetMapping(path = "/consultar/{page}/{size}")
	@ApiOperation(value = "Servicio consultar", notes = "Este servicio se encarga de consultar los cartones de bingo existentes")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK") })
	public  ResponseEntity<Page<Carton>> rentorPageable(@PathVariable int page, @PathVariable int size) {		
		Page<Carton> listarCartones = service.listarcartones(page, size);
		return new ResponseEntity<Page<Carton>>(listarCartones, HttpStatus.OK);
	}
	
	@PostMapping(path = "/ganador/{figura}")
	@ApiOperation(value = "Servicio evaluar ganadores", notes = "Este servicio evalua los ganadores del bingo segun los valores ingresados")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "Esta es la lista de ganadores"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_ACCEPTABLE, message = "Estos valores no son aceptados") })
	public ResponseEntity<List<Carton>> guardar(@RequestBody ListaDto numeros, @PathVariable char figura) throws Exception {
		List<Carton> respuesta = service.evaluate(numeros.getNumeros(), figura);
		return new ResponseEntity<List<Carton>>(respuesta, HttpStatus.CREATED);	
	}
}
