package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JScrollBar;


public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField buscador;
	private JText jola;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 594);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMen = new JMenu("Men\u00FA");
		menuBar.add(mnMen);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnMen.add(mntmGuardar);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnMen.add(mntmAbrir);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnMen.add(mntmSalir);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		menuBar.add(mnUsuarios);
		
		JMenu mnRutas = new JMenu("Rutas");
		menuBar.add(mnRutas);
		
		JMenu mnVehiculos = new JMenu("Vehiculos");
		menuBar.add(mnVehiculos);
		
		JMenu mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		contentPane.add(lblBienvenido, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelInicio = new JPanel();
		tabbedPane.addTab("Inicio", null, panelInicio, null);
		
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
		
		JPanel pestanya_rutas = new JPanel();
		tabbedPane.addTab("Rutas", null, pestanya_rutas, null);
		
		JPanel pestanya_usuarios = new JPanel();
		tabbedPane.addTab("Usuarios", null, pestanya_usuarios, null);
	}
}
