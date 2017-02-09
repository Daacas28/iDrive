package controller;

import javax.swing.ImageIcon;

import view.VentanaPrincipal;

public class MetodosGraficos {

	public MetodosGraficos() {
	
	}

	public static ImageIcon crearImageIcon(String url){
		java.net.URL imgURL = VentanaPrincipal.class.getResource(url);
		if(imgURL != null){
			return new ImageIcon(imgURL);
		} else {
			System.err.println("No se encontro la imagen.");
			return null;
		}
	}
	
}
