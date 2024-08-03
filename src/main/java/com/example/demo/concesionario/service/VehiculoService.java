package com.example.demo.concesionario.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.concesionario.repository.IVehiculoRepository;
import com.example.demo.concesionario.repository.modelo.Vehiculo;
import com.example.demo.concesionario.repository.modelo.dto.VehiculoDTO;
import com.example.demo.concesionario.service.to.VehiculoTO;

@Service
public class VehiculoService implements IVehiculoService {

	
	@Autowired 
	private IVehiculoRepository iVehiculoRepository;
	
	@Override
	public void insertar(VehiculoTO vehiculoTO) {
		// TODO Auto-generated method stub
		
		iVehiculoRepository.insertar(this.convertirAVehiculo(vehiculoTO));
	}

	@Override
	public List<VehiculoDTO> buscarTodos() {
		// TODO Auto-generated method stub
		
		 List<Vehiculo> listVehiculos= this.iVehiculoRepository.buscarTodos();
		 List<VehiculoDTO> listVehiculosDTO= new ArrayList<>();
		 for (Vehiculo vehiculo : listVehiculos) { 
			
			 VehiculoDTO vehiDto = new VehiculoDTO(vehiculo.getPlaca(), vehiculo.getMarca(), vehiculo.getColor());
			 listVehiculosDTO.add(vehiDto);
		}
		 
		 
		return listVehiculosDTO;
	}

	@Override
	public void eliminar(String placa) {
		// TODO Auto-generated method stub
		
		this.iVehiculoRepository.eliminar(placa);
	}

	@Override
	public VehiculoTO buscar(String placa) {
		// TODO Auto-generated method stub
		Vehiculo vehiculo= this.iVehiculoRepository.buscar(placa);
		
		return this.convetiraVehiculoTO(vehiculo);
	}

	
	
	
	private VehiculoTO convetiraVehiculoTO(Vehiculo vehiculo) {
		
		VehiculoTO vehiculoTO= new VehiculoTO();
		
		vehiculoTO.setColor(vehiculo.getColor());
		vehiculoTO.setId(vehiculo.getId());
		vehiculoTO.setMarca(vehiculo.getMarca());
		vehiculoTO.setModelo(vehiculo.getModelo());
		vehiculoTO.setPrecio(vehiculo.getPrecio());
		vehiculoTO.setPlaca(vehiculo.getPlaca());
	
		return vehiculoTO;
	}
	
	
	private Vehiculo convertirAVehiculo(VehiculoTO vehiculoTO) {
	    Vehiculo vehiculo = new Vehiculo();
	    
	    vehiculo.setColor(vehiculoTO.getColor());
	    vehiculo.setId(vehiculoTO.getId());
	    vehiculo.setMarca(vehiculoTO.getMarca());
	    vehiculo.setModelo(vehiculoTO.getModelo());
	    vehiculo.setPrecio(vehiculoTO.getPrecio());
	    vehiculo.setPlaca(vehiculoTO.getPlaca());
	    
	    return vehiculo;
	}
	
	
	
	
	
	
	//http://localhost:8085/API/v1.0/Matricula/profesores/2
	
}
