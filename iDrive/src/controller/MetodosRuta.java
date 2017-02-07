package controller;

import java.util.Iterator;

import org.hibernate.Session;

import models.Cliente;
import models.Ruta;

public class MetodosRuta extends MetodosComunes{

	public MetodosRuta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object consultarDatos(Session sesion) {
		Iterator iterador;
		
		iterador = sesion.createQuery("FROM Ruta").iterate();
		while (iterador.hasNext()){
			Ruta ruta = new Ruta();
			ruta.getDistanciaRuta();
			
			
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
	
	public static int consultarDistanciaRuta(Session sesion){
		Iterator iterador;
		int distancia = 0;
		
		/*iterador = sesion.createQuery("FROM Ruta WHERE id_ruta = 1").iterate();
		while (iterador.hasNext()){
			Ruta ruta = new Ruta();
			distancia = ruta.getDistanciaRuta();
		
		}*/
		
		Ruta ruta = (Ruta) sesion.get(Ruta.class, 1);
		distancia = ruta.getDistanciaRuta(); 
		return distancia;
	}
}


