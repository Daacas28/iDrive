package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class PestanyaVehiculos {

	private static JTabbedPane tabbedPane;
	private JTextField buscador;
	
	public PestanyaVehiculos(JTabbedPane tabbedPane){
		this.tabbedPane=tabbedPane;
		iniciarPaneles();
	}
	
	public void iniciarPaneles(){
		JPanel pestanya_vehiculos = new JPanel();
		tabbedPane.addTab("Vehiculos", null, pestanya_vehiculos, null);
		pestanya_vehiculos.setLayout(null);

		buscador = new JTextField();
		buscador.setText("Buscar..");
		buscador.setBounds(442, 13, 164, 23);
		pestanya_vehiculos.add(buscador);
		buscador.setColumns(10);

		JLabel labelTitulo = new JLabel("Vehiculos");
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		labelTitulo.setBounds(231, 7, 175, 29);
		pestanya_vehiculos.add(labelTitulo);

		JLabel primeraImagen = new JLabel("Imagen 1");
		primeraImagen.setBackground(Color.DARK_GRAY);
		primeraImagen.setBounds(79, 65, 164, 125);
		pestanya_vehiculos.add(primeraImagen);
		primeraImagen.setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY));

		JLabel terceraImagen = new JLabel("Imagen 1");
		terceraImagen.setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY));
		terceraImagen.setBackground(Color.DARK_GRAY);
		terceraImagen.setBounds(79, 289, 164, 131);
		pestanya_vehiculos.add(terceraImagen);

		JLabel cuartaImagen = new JLabel("Imagen 1");
		cuartaImagen.setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY));
		cuartaImagen.setBackground(Color.DARK_GRAY);
		cuartaImagen.setBounds(373, 289, 164, 131);
		pestanya_vehiculos.add(cuartaImagen);

		JLabel segundaImagen = new JLabel("Imagen 1");
		segundaImagen.setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY));
		segundaImagen.setBackground(Color.DARK_GRAY);
		segundaImagen.setBounds(373, 65, 164, 125);
		pestanya_vehiculos.add(segundaImagen);

		JButton botonInfo1 = new JButton("Ver informaci\u00F3n");
		botonInfo1.setBounds(89, 201, 140, 23);
		pestanya_vehiculos.add(botonInfo1);

		JButton botonInfo3 = new JButton("Ver informaci\u00F3n");
		botonInfo3.setBounds(89, 431, 140, 23);
		pestanya_vehiculos.add(botonInfo3);

		JButton botonInfo4 = new JButton("Ver informaci\u00F3n");
		botonInfo4.setBounds(393, 431, 133, 23);
		pestanya_vehiculos.add(botonInfo4);

		JButton BotonInfo2 = new JButton("Ver informaci\u00F3n");
		BotonInfo2.setBounds(393, 201, 133, 23);
		pestanya_vehiculos.add(BotonInfo2);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(640, 13, 17, 451);
		pestanya_vehiculos.add(scrollBar);
	}
	
}
