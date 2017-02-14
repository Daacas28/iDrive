package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class RadioBoton extends JRadioButton  implements ActionListener{

	private String text;
	private RadioBoton boton;
	private int id;
	private enum pestanya {
		Usuario , Rutas
		}
	
	
	public RadioBoton (String text){
		this.text = text;
		setText(text);
	}
	
	public interface ClickRadioButton{
		public void actionRadioBoton(RadioBoton boton);
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
	private ClickRadioButton radio;
	
	public RadioBoton (ClickRadioButton radio){
		boton.addActionListener(this);
		this.radio=radio;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		radio.actionRadioBoton(boton);
		System.out.println("boton");
	}
}
