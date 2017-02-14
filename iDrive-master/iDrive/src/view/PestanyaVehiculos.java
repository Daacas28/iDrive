package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class PestanyaVehiculos {

	private static JTabbedPane tabbedPane;
	private JTextField buscador;
	private static JPanel principal;

	private static JPanel panelLista;
	private static JPanel panelBuscar;

	private static JTextField fieldBuscar;

	private static JButton boton1;
	private static JButton boton2;
	private static JButton boton3;

	public PestanyaVehiculos(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
		iniciarPaneles();
	}

	public static void crearImageIcon(ImageIcon icon, int num) {

		if (icon != null) {

			Image img = icon.getImage(); // convertimos icon en una imagen
			Image otraimg = img.getScaledInstance(120, 90, java.awt.Image.SCALE_SMOOTH); // creamos																		// antigua
			ImageIcon otroicon = new ImageIcon(otraimg);

			if (num == 1) {
				boton1 = new JButton();
				boton1.setIcon(otroicon);
			} else if (num == 2) {
				boton2 = new JButton();
				boton2.setIcon(otroicon);
			} else if (num == 3) {
				boton3 = new JButton();
				boton3.setIcon(otroicon);
			}

		} else {
			System.err.println("No se encontro la imagen.");
			if (num == 1) {
				boton1.setText("Error con la imagen");
			} else if (num == 2) {
				boton2.setText("Error con la imagen");
			} else if (num == 3) {
				boton3.setText("Error con la imagen");
			}

		}
	}

	public void iniciarPaneles() {
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
		
//-----------------------------------------------------
	/*	principal = new JPanel();
		principal.setLayout(new BorderLayout());
		
		panelLista = new JPanel();
		panelBuscar = new JPanel();
		
		panelBuscar.setBackground(Color.WHITE);
		panelLista.setBackground(Color.WHITE);
	
		//Título
		TitledBorder titleBorder = new TitledBorder("Lista de Vehículos");
		titleBorder.setTitleColor(Color.BLACK);
		
		Font titleFont = UIManager.getFont("TitledBorder.font");
        titleBorder.setTitleFont( titleFont.deriveFont(Font.ITALIC + Font.BOLD) );
        
		principal.setBorder(titleBorder);
		
		//Buscar
		fieldBuscar = new JTextField(10);		
	
		//Botones con imagen
		for (int i = 0; i<3; i++){
			ImageIcon icon = new ImageIcon(getClass().getResource("/img/"+(i+1)+".jpg"));
			crearImageIcon(icon, i+1);
		}
	
		//Lo añadimos al panel
		boton1.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
		boton1.setBackground(Color.WHITE);
	
		boton2.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
		boton2.setBackground(Color.WHITE);
		
		boton3.setBorder(BorderFactory.createEmptyBorder(5, 5, 10, 10));
		boton3.setBackground(Color.WHITE);		
		
		panelBuscar.add(fieldBuscar, BorderLayout.CENTER);
		panelLista.add(boton1);
		panelLista.add(boton2);
		panelLista.add(boton3);
		
		principal.add(panelBuscar, BorderLayout.LINE_START);
		principal.add(panelLista);
		
		JScrollPane scrol = new JScrollPane(principal);
		
		pestanya_vehiculos.add(scrol);*/
	}

}
