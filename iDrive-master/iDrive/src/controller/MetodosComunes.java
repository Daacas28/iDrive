package controller;

import org.hibernate.Session;

public abstract class MetodosComunes {

	
	public abstract Object consultarDatos(Session sesion, int id);
	public abstract Object modificarDatos(Session sesion, int id, Object objet);
	public abstract Object eliminarDatos (Session sesion, int id);
	
	public MetodosComunes() {
		// TODO Auto-generated constructor stub
	}

}
