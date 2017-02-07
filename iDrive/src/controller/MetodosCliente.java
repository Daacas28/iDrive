package controller;

import java.util.Iterator;

import org.hibernate.Session;

import models.Cliente;

public class MetodosCliente extends MetodosComunes {

	public MetodosCliente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object consultarDatos(Session sesion) {
		Iterator iterador;
		
		iterador = sesion.createQuery("FROM Cliente").iterate();
		while (iterador.hasNext()){
			Cliente cliente = new Cliente();
			
			
		}
		
		
		return null;
	}

	@Override
	public Object modificarDatos(Session sesion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eliminarDatos(Session sesion) {
		// TODO Auto-generated method stub
		return null;
	}

}
