package com.example.demo.concesionario.service;

import java.util.List;

import com.example.demo.concesionario.repository.modelo.dto.VehiculoDTO;
import com.example.demo.concesionario.service.to.VehiculoTO;

public interface IVehiculoService {

	
	public void insertar(VehiculoTO vehiculoTO);
	public List<VehiculoDTO> buscarTodos();
	public void eliminar(String placa);
	public VehiculoTO buscar (String placa);

	
	
}
