package com.example.demo.concesionario.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vehi")
	@SequenceGenerator(initialValue = 1, name = "seq_vehi", sequenceName = "seq_vehi")
	@Column(name = "vehi_")
	private Integer id;

	@Column(name = "vehi_placa")
	private String placa;
	
	@Column(name = "vehi_marca")
	private String marca;

	@Column(name = "vehi_modelo")
	private String modelo;
	
	@Column(name = "vehi_color")
	private String color;

	@Column(name = "vehi_precio")
	private BigDecimal precio;

	
	
	/////
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	////
	
	
	
	
	
	
	
	

}
