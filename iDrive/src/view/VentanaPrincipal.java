package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField buscador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					System.setProperty("apple.laf.useScreenMenuBar", "true");
					System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setBounds(100, 100, 1024, 768);
		//Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		//setMaximumSize(DimMax);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
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
		JDesktopPane dp = new JDesktopPane();
		tabbedPane.addTab("Rutas", null, dp, null);
		
		//INICIO INTERNAL FRAME
		JInternalFrame internalFrame = new JInternalFrame("Rutas Actuales");
		internalFrame.setBounds(0, 0, 1535, 582);
		dp.add(internalFrame);
		internalFrame.setVisible(true);
		
		Double latitud1= 31.45;
		Double latitud2= 28.45;
		Double longitud1= 31.45;
		Double longitud2= 33.45;
		//INSTANCIAMOS LA CLASE MAPA PARA PINTAR EN EL INTERNAL FRAME, PUTOS AMOS
		Mapa mapa = new Mapa( latitud1,  longitud1,  latitud2,  longitud2);
		internalFrame.getContentPane().add(mapa);
		//FIN 
		  JTabbedPane tabbedPaneRutas = new JTabbedPane(JTabbedPane.TOP);
	        tabbedPaneRutas.setPreferredSize(new Dimension(300,200));
	        internalFrame.getContentPane().add(tabbedPaneRutas, BorderLayout.EAST);
	        
	        JPanel panel = new JPanel();
	        tabbedPaneRutas.addTab("Ruta Actual", null, panel, null);
	        
	        JPanel panel_1 = new JPanel();
	        tabbedPaneRutas.addTab("Clientes Hoy", null, panel_1, null);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBounds(0, 582, 1535, 214);
	        dp.add(panel_2);
	        
		JPanel pestanya_usuarios = new JPanel();
		tabbedPane.addTab("Usuarios", null, pestanya_usuarios, null);
		pestanya_usuarios.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BorderLayout());
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_3.setBackground(Color.GRAY);
		
		JLabel labelUsuarios = new JLabel("sdhgfj");
		labelUsuarios.setBounds(335, 11, 50, 14);
		labelUsuarios.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		
		JButton botonActualiza = new JButton("Actualizar lista");
		botonActualiza.setBounds(390, 7, 101, 23);
		botonActualiza.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
		
		JTextField fieldBuscar = new JTextField(12);
		fieldBuscar.setBounds(496, 8, 102, 20);
		fieldBuscar.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
	
		panel_3.add(labelUsuarios, BorderLayout.LINE_START);
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.GRAY);
		panel_3_1.add(botonActualiza);
		panel_3_1.add(fieldBuscar);
		panel_3.add(panel_3_1, BorderLayout.LINE_END);
		pestanya_usuarios.add(panel_3, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	
		pestanya_usuarios.add(panel_4, BorderLayout.CENTER);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	
		pestanya_usuarios.add(panel_5, BorderLayout.PAGE_END);
	}

	public void creaPanel(String urlImg){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
