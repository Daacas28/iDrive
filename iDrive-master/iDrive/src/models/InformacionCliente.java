package models;
// Generated 03-feb-2017 13:15:08 by Hibernate Tools 4.3.5.Final

/**
 * InformacionCliente generated by hbm2java
 */
public class InformacionCliente implements java.io.Serializable {

	private Integer idInformacion;
	private Cliente cliente;
	private int totalGasto;
	private int totalViajes;

	public InformacionCliente() {
	}

	public InformacionCliente(Cliente cliente, int totalGasto, int totalViajes) {
		this.cliente = cliente;
		this.totalGasto = totalGasto;
		this.totalViajes = totalViajes;
	}

	public Integer getIdInformacion() {
		return this.idInformacion;
	}

	public void setIdInformacion(Integer idInformacion) {
		this.idInformacion = idInformacion;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTotalGasto() {
		return this.totalGasto;
	}

	public void setTotalGasto(int totalGasto) {
		this.totalGasto = totalGasto;
	}

	public int getTotalViajes() {
		return this.totalViajes;
	}

	public void setTotalViajes(int totalViajes) {
		this.totalViajes = totalViajes;
	}

}