package com.example.demo.concesionario.repository;

import java.util.List;

import com.example.demo.concesionario.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	
	public void insertar(Vehiculo vehiculo);
	public List<Vehiculo> buscarTodos();
	public void eliminar(String placa);
	public Vehiculo buscar (String placa);
	


	

}
