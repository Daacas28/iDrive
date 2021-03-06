package models;
// Generated 03-feb-2017 13:15:08 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Vehiculos generated by hbm2java
 */
public class Vehiculos implements java.io.Serializable {

	private Integer idVehiculo;
	private Flota flota;
	private String matricula;
	private String modelo;
	private int capacidad;
	private Set registroRutas = new HashSet(0);

	public Vehiculos() {
	}

	public Vehiculos(String matricula, String modelo, int capacidad) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.capacidad = capacidad;
	}

	public Vehiculos(Flota flota, String matricula, String modelo, int capacidad, Set registroRutas) {
		this.flota = flota;
		this.matricula = matricula;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.registroRutas = registroRutas;
	}

	public Integer getIdVehiculo() {
		return this.idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Flota getFlota() {
		return this.flota;
	}

	public void setFlota(Flota flota) {
		this.flota = flota;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Set getRegistroRutas() {
		return this.registroRutas;
	}

	public void setRegistroRutas(Set registroRutas) {
		this.registroRutas = registroRutas;
	}

}
