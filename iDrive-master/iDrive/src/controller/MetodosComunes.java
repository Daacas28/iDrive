package controller;

import org.hibernate.Session;

public abstract class MetodosComunes {

	
	public abstract Object consultarDatos(Session sesion);
	public abstract Object modificarDatos(Session sesion);
	public abstract Object eliminarDatos (Session sesion);
	
	public MetodosComunes() {
		// TODO Auto-generated constructor stub
	}

}
