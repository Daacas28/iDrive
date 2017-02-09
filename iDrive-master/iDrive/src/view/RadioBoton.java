package view;

import javax.swing.JRadioButton;

public class RadioBoton extends JRadioButton{

	private String text;
	
	private int id;
	private enum pestanya {
		Usuario , Rutas
		}
	
	public RadioBoton (String text){
		this.text = text;
		setText(text);
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
