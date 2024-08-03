package com.example.demo.concesionario.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.concesionario.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		entityManager.persist(vehiculo);
	}

	@Override
	public List<Vehiculo> buscarTodos() {
		// TODO Auto-generated method stub
		
		TypedQuery<Vehiculo> query= this.entityManager.createQuery("Select v from Vehiculo v", Vehiculo.class);
		return query.getResultList();
	}

	@Override
	public void eliminar(String placa) {
		 TypedQuery<Vehiculo> query = this.entityManager.createQuery(
			        "DELETE FROM Vehiculo v WHERE v.placa = :placa", Vehiculo.class);
			    query.setParameter("placa", placa);
    }
	@Override
	public Vehiculo buscar(String placa) {
	    TypedQuery<Vehiculo> query = this.entityManager.createQuery(
	        "SELECT v FROM Vehiculo v WHERE v.placa = :placa", Vehiculo.class);
	    query.setParameter("placa", placa);
	    return query.getSingleResult();
	}

}
