package models;
// Generated 03-feb-2017 13:15:08 by Hibernate Tools 4.3.5.Final

import java.util.Date;

/**
 * RegistroRuta generated by hbm2java
 */
public class RegistroRuta implements java.io.Serializable {

	private Integer idRegistro;
	private Cliente cliente;
	private Ruta ruta;
	private Vehiculos vehiculos;
	private Date fechaRuta;

	public RegistroRuta() {
	}

	public RegistroRuta(Cliente cliente, Ruta ruta, Vehiculos vehiculos, Date fechaRuta) {
		this.cliente = cliente;
		this.ruta = ruta;
		this.vehiculos = vehiculos;
		this.fechaRuta = fechaRuta;
	}

	public Integer getIdRegistro() {
		return this.idRegistro;
	}

	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ruta getRuta() {
		return this.ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public Vehiculos getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(Vehiculos vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Date getFechaRuta() {
		return this.fechaRuta;
	}

	public void setFechaRuta(Date fechaRuta) {
		this.fechaRuta = fechaRuta;
	}

}
