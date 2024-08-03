package com.example.demo.concesionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.concesionario.repository.modelo.dto.VehiculoDTO;
import com.example.demo.concesionario.service.IVehiculoService;
import com.example.demo.concesionario.service.to.VehiculoTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RequestMapping("/vehiculos")
@RestController
public class VehiculoController {
	
	
	@Autowired
	private IVehiculoService iVehiculoService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<VehiculoTO> postMethodName(@RequestBody VehiculoTO vehiculoTO) {
		//TODO: process POST request
		HttpHeaders headers = new HttpHeaders();
		headers.add("mensaje_200", "insertado");
		
		this.iVehiculoService.insertar(vehiculoTO);
		
		return new ResponseEntity<>(vehiculoTO,headers, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping(path = "/{placa}")
	public ResponseEntity<String > deleteMethodName(@PathVariable String placa) {
		//TODO: process POST request
		HttpHeaders headers = new HttpHeaders();
		headers.add("mensaje_200", "borrado");
		
		this.iVehiculoService.eliminar(placa);
		
		return new ResponseEntity<>("borrado",headers, HttpStatus.OK);
	}
	
	
	@GetMapping(path = "/{placa}" , produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<VehiculoTO> getMethodName(@PathVariable String placa) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("mensaje_200", "get");
		
		VehiculoTO vehiculoTO= this.iVehiculoService.buscar(placa);
		return new ResponseEntity<>(vehiculoTO,headers, HttpStatus.OK);
	}
	
	///
	
	//http://localhost:8080/API/v1.0/Concesionario/vehiculos
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VehiculoDTO>> getTodosvehiculos() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("mensaje_200", "encontrado");
		
		List<VehiculoDTO> vehiculoDTOs= this.iVehiculoService.buscarTodos();
		return new ResponseEntity<>(vehiculoDTOs,headers, HttpStatus.OK);
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


