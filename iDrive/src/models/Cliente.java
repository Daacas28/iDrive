package models;
// Generated 03-feb-2017 13:15:08 by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente implements java.io.Serializable {

	private Integer idCliente;
	private String nombre;
	private String dni;
	private String telefono;
	private Set registroRutas = new HashSet(0);
	private Set informacionClientes = new HashSet(0);

	public Cliente() {
	}

	public Cliente(String nombre, String dni, String telefono) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}

	public Cliente(String nombre, String dni, String telefono, Set registroRutas, Set informacionClientes) {
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.registroRutas = registroRutas;
		this.informacionClientes = informacionClientes;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set getRegistroRutas() {
		return this.registroRutas;
	}

	public void setRegistroRutas(Set registroRutas) {
		this.registroRutas = registroRutas;
	}

	public Set getInformacionClientes() {
		return this.informacionClientes;
	}

	public void setInformacionClientes(Set informacionClientes) {
		this.informacionClientes = informacionClientes;
	}

}
