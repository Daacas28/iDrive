package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.hibernate.classic.Session;

import com.sun.javafx.css.Style;

import controller.Mapa;
import controller.MetodosCliente;
import controller.MetodosRuta;
import models.Cliente;
import models.Ruta;
import view.RadioBoton.ClickRadioButton;

public class PestanyaRuta extends JFrame implements ChangeListener, ClickRadioButton , ActionListener{

	private JPanel seleccionarRuta;
	private JPanel paneles;
	private JLabel labelImagen;
	private JScrollPane scroll;

	private static JLabel label_Nombre_Ruta = new JLabel("New label");
	private static Session sesion;
	private static JTabbedPane tabbedPane;

	private static JPanel panelRutaActual;
	
	private static JPanel panelIDRuta;
	private static JPanel panelDistancia;
	private static JPanel panelLati1;
	private static JPanel panelLong1;
	private static JPanel panelLati2;
	private static JPanel panelLong2;
	
	private static JLabel labelIdRuta;
	private static JLabel valorIdRuta;
	
	private static JLabel labelDistancia;
	private static JLabel valorDistancia;
	
	private static JLabel labelLatitud1;
	private static JLabel valorLatitud1;
	
	private static JLabel labelLong1;
	private static JLabel valorLong1;
	
	private static JLabel labelLatitud2;
	private static JLabel valorLatitud2;
	
	private static JLabel labelLong2;
	private static JLabel valorLong2;
	
	private static JPanel panelIDCliente;
	private static JPanel panelNombre;
	private static JPanel panelDNI;
	private static JPanel panelTelef;
	
	private static JLabel labelIdCliente;
	private static JLabel valorIdCliente;
	
	private static JLabel labelNombre;
	private static JLabel valorNombre;
	
	private static JLabel labelDNI;
	private static JLabel valorDNI;
	
	private static JLabel labelTelef;
	private static JLabel valorTelef;
	
	private static JPanel panelIId;
		private static JLabel labelIId;
		private static JTextField textIId;
	private static JPanel panelIDistancia;
		private static JLabel labelIDistancia;
		private static JTextField textIDistancia;
	private static JPanel panelILatitud1;
		private static JLabel labelILatitud1;
		private static JTextField textILatitud1;
	private static JPanel panelILong1;
		private static JLabel labelILong1;
		private static JTextField textILong1;		
	private static JPanel panelILatitud2;
		private static JLabel labelILatitud2;
		private static JTextField textILatitud2;
	private static JPanel panelILong2;
		private static JLabel labelILong2;
		private static JTextField textILong2;		
		
	private static JButton botonBorrar;
	private static JButton botonModificar;
	private static JButton botonLimpiar;
		
	private static JButton botonBuscar;
	private static JButton crearRuta;
		
	public PestanyaRuta(JLabel label_Nombre_Ruta, JTabbedPane tabbedPane, Session session) {
		this.label_Nombre_Ruta = label_Nombre_Ruta;
		this.tabbedPane = tabbedPane;
		this.sesion = session;

		iniciarPanel();
	}

	public PestanyaRuta() {
		
	}
	
	public void iniciarPanel() {
		JPanel pestanya_rutas = new JPanel();
		JDesktopPane dp = new JDesktopPane();
		
		tabbedPane.addTab("Rutas", null, dp, null);

		tabbedPane.addChangeListener(this);

		// INICIO INTERNAL FRAME
		JInternalFrame internalFrame = new JInternalFrame("Rutas Actuales");
		internalFrame.setBounds(0, 0, 1535, 700);
		dp.add(internalFrame);
		internalFrame.setVisible(true);

		Double latitud1 = 31.45;
		Double latitud2 = 28.45;
		Double longitud1 = 31.45;
		Double longitud2 = 33.45;
		// INSTANCIAMOS LA CLASE MAPA PARA PINTAR EN EL INTERNAL FRAME, PUTOS
		// AMOS
		Mapa mapa = new Mapa(latitud1, longitud1, latitud2, longitud2);
		internalFrame.getContentPane().add(mapa);
		// FIN
		
		JTabbedPane tabbedPaneRutas = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneRutas.setPreferredSize(new Dimension(300, 200));
		internalFrame.getContentPane().add(tabbedPaneRutas, BorderLayout.EAST);

		//Añadimos los paneles al tab
		panelRutaActual = new JPanel();
		panelRutaActual.setLayout(new BoxLayout(panelRutaActual, BoxLayout.Y_AXIS));
		
		tabbedPaneRutas.addTab("Ruta Actual", null, panelRutaActual, null);
		
		//Añadimos al panel de la ruta actual los labels y todo eso
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		
//PAMEL ID RUTA
		 panelIDRuta = new JPanel(layout);
		 	labelIdRuta = new JLabel("ID:");
		 	labelIdRuta.setFont(new Font(Font.SERIF, Font.BOLD, 32));
		 	valorIdRuta = new JLabel();
		 	valorIdRuta.setFont(new Font(Font.SERIF, Font.BOLD, 32));
		 panelIDRuta.add(labelIdRuta);
		 panelIDRuta.add(valorIdRuta);
		 panelIDRuta.setBorder(new LineBorder(Color.BLACK));
		 /*p.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));*/
		 
//PANEL DISTANCIA RUTA		 
		 panelDistancia = new JPanel(layout);
		 	labelDistancia = new JLabel("Distancia Total:");
		 	labelDistancia.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 	valorDistancia = new JLabel();
		 	valorDistancia.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 panelDistancia.add(labelDistancia);
		 panelDistancia.add(valorDistancia);
//PANEL LATITUD 1 RUTA		 
		 panelLati1 = new JPanel(layout);
		 	labelLatitud1 = new JLabel("Latitud 1:");
		 	labelLatitud1.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			valorLatitud1 = new JLabel();
			valorLatitud1.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		panelLati1.add(labelLatitud1);
		panelLati1.add(valorLatitud1);
//PANEL LONGITUD 1 
		 panelLong1 = new JPanel(layout);
		 	labelLong1 = new JLabel("Longitud 1:");
		 	labelLong1.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			valorLong1 = new JLabel();
			valorLong1.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 panelLong1.add(labelLong1);
		 panelLong1.add(valorLong1);
//PANEL LATITUD 2	
		 panelLati2 = new JPanel(layout);
		 	labelLatitud2 = new JLabel("Latitud 2:");
		 		labelLatitud2.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			valorLatitud2 = new JLabel();
				valorLatitud2.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		panelLati2.add(labelLatitud2);
		panelLati2.add(valorLatitud2);
//PANEL LONGITUD 2
		 panelLong2 = new JPanel(layout);
		 	labelLong2 = new JLabel("Longitud 2:");
		 		labelLong2.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
			valorLong2 = new JLabel();
				valorLong2.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		panelLong2.add(labelLong2);
		panelLong2.add(valorLong2);
		
		JPanel panelBotonCrear = new JPanel();
		crearRuta = new JButton("Crear Ruta");
		crearRuta.addActionListener(this);
		panelBotonCrear.add(crearRuta);
		
		
		panelRutaActual.add(panelIDRuta);
		panelRutaActual.add(panelDistancia);
		panelRutaActual.add(panelLati1);
		panelRutaActual.add(panelLong1);
		panelRutaActual.add(panelLati2);
		panelRutaActual.add(panelLong2);		
		panelRutaActual.add(panelBotonCrear);
		
		JPanel panelClienteActual = new JPanel();
		panelClienteActual.setLayout(new BoxLayout(panelClienteActual, BoxLayout.Y_AXIS));
		tabbedPaneRutas.addTab("Clientes Hoy", null, panelClienteActual, null);
		//panelClienteActual.add(label_Nombre_Ruta);		

		FlowLayout layoutCliente = new FlowLayout(FlowLayout.CENTER);
//PAMEL ID CLIENTE
		 panelIDCliente = new JPanel(layoutCliente);
		 	labelIdCliente = new JLabel("ID:");
		 	valorIdCliente = new JLabel();
		 panelIDCliente.add(labelIdCliente);
		 panelIDCliente.add(valorIdCliente);
		 panelIDCliente.setBorder(new EmptyBorder(10, 10, 10, 10));
//PANEL NOMBRE	 
		 panelNombre = new JPanel(layoutCliente);
		 	labelNombre = new JLabel("Nombre:");
		 	valorNombre = new JLabel();
		 panelNombre.add(labelNombre);
		 panelNombre.add(valorNombre);
//PANEL DNI	
		 
		 panelDNI = new JPanel(layoutCliente);
		 	labelDNI = new JLabel("DNI:");
			valorDNI = new JLabel();
		panelDNI.add(labelDNI);
		panelDNI.add(valorDNI);
//PANEL TELEFONO
		 panelTelef = new JPanel(layoutCliente);
		 	labelTelef = new JLabel("Teléfono:");
			valorTelef = new JLabel();
		 panelTelef.add(labelTelef);
		 panelTelef.add(valorTelef);

		 panelClienteActual.add(panelIDCliente);
		 panelClienteActual.add(panelNombre);
		 panelClienteActual.add(panelDNI);
		 panelClienteActual.add(panelTelef);		
		
//PANEL Buscar  RUTA
		 
			/**/	 JPanel panelMostrarRutas = new JPanel();
			panelMostrarRutas.setLayout(new BoxLayout(panelMostrarRutas, BoxLayout.Y_AXIS));
				 tabbedPaneRutas.addTab("Buscar Rutas", null, panelMostrarRutas, null);
				 
				 botonBuscar = new JButton("Buscar");
				 botonBuscar.addActionListener(this);
				 
				 panelIId = new JPanel();
				 	labelIId = new JLabel ("ID");
				 	textIId = new JTextField(10);
				 panelIId.add(labelIId);
				 panelIId.add(textIId);
				 panelIId.add(botonBuscar);
				 
				 panelIDistancia = new JPanel();
				 	labelIDistancia = new JLabel ("Distancia");
				 	textIDistancia = new JTextField(10);
				 panelIDistancia.add(labelIDistancia);
				 panelIDistancia.add(textIDistancia);
				 
				 panelILatitud1 = new JPanel();
				 	labelILatitud1 = new JLabel("Latitud 1: ");
				 	textILatitud1 = new JTextField(10);
				 panelILatitud1.add(labelILatitud1);
				 panelILatitud1.add(textILatitud1);
				 
				 panelILatitud2 = new JPanel();
				 	labelILatitud2 = new JLabel("Latitud 2: ");
				 	textILatitud2 = new JTextField(10);
				 panelILatitud2.add(labelILatitud2);
				 panelILatitud2.add(textILatitud2);
				 
				 panelILong1 = new JPanel();
				 	labelILong1 = new JLabel("Longitud 1: ");
				 	textILong1 = new JTextField(10);
				 panelILong1.add(labelILong1);
				 panelILong1.add(textILong1);
				 
				 panelILong2 = new JPanel();
				 	labelILong2 = new JLabel("Longitud 2: ");
				 	textILong2 = new JTextField(10);
				 panelILong2.add(labelILong2);
				 panelILong2.add(textILong2);
				 
				 panelMostrarRutas.add(panelIId);
				 panelMostrarRutas.add(panelIDistancia);
				 panelMostrarRutas.add(panelILatitud1);
				 panelMostrarRutas.add(panelILong1);
				 panelMostrarRutas.add(panelILatitud2);
				 panelMostrarRutas.add(panelILong2);
				
				 JPanel panelBoton = new JPanel();
				 botonBorrar = new JButton("Borrar");
				 botonLimpiar = new JButton("Limpiar");
				 botonModificar = new JButton("Modificar");
				 botonBorrar.addActionListener(this);
				 botonLimpiar.addActionListener(this);
				 botonModificar.addActionListener(this);
				 panelBoton.add(botonBorrar);
				 panelBoton.add(botonLimpiar);
				 panelBoton.add(botonModificar);
				 panelMostrarRutas.add(panelBoton);
				 
				 panelRutaActual.setBorder(new LineBorder(Color.BLACK));/**/
				 
		 //Tendremos que llamar a un método que nos devuelva el número de rutas que hay 
		 int numRutas = MetodosRuta.numRutas(sesion);
		 //Para crear tantas imagenes como rutas haya
		 Crear crear = new Crear(sesion);
		 
		seleccionarRuta = new JPanel();
		Class clase = getClass();
		scroll = crear.generaPanel(numRutas, clase);
		scroll.add(seleccionarRuta);
		
		internalFrame.getContentPane().add(scroll, BorderLayout.PAGE_END);

	}

	@Override
	public void stateChanged(ChangeEvent e) {

		if (tabbedPane.getSelectedIndex()==2){//Pestanya de rutas 
			
			int id=1;
			ponerDatosPanelRuta(id);
		}
	}

	@Override
	public void actionRadioBoton(RadioBoton boton) {
		/*
		System.out.println("Has dado a un boton con id:" +boton.getId());
		
		MetodosRuta metodos = new MetodosRuta();
		int idBoton = boton.getId();
		ArrayList<Integer> idClientes = new ArrayList<>();
		
		Ruta ruta= new Ruta();
		ruta = (Ruta) metodos.consultarDatos(sesion, idBoton);
		
		if (ruta != null){
			ponerDatosPanelRuta(ruta.getIdRuta());
			Mapa mapa = new Mapa(ruta.getLatitudRuta1(), ruta.getLongitudRuta1(), ruta.getLatitudRuta2(), ruta.getLongitudRuta2());
		}
		//O lo hacemos que muestre los que tienen esa ruta.
		*/
	}

	public void ponerDatosPanelRuta(int idRuta){
		MetodosRuta metodos = new MetodosRuta();
		Ruta ruta = (Ruta) metodos.consultarDatos(sesion, idRuta);
		
		valorIdRuta.setText(String.valueOf(ruta.getIdRuta()));
		valorDistancia.setText(String.valueOf(ruta.getDistanciaRuta()));
		valorLatitud1.setText(String.valueOf(ruta.getLatitudRuta1()));
		valorLong1.setText(String.valueOf(ruta.getLongitudRuta1()));
		valorLatitud2.setText(String.valueOf(ruta.getLatitudRuta2()));
		valorLong2.setText(String.valueOf(ruta.getLongitudRuta2()));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==crearRuta){
			MetodosRuta.crearDialogNuevaRuta(sesion);
			
		}else if(e.getSource()==botonLimpiar){
			textIDistancia.setText("");
			textILatitud1.setText("");
			textILatitud2.setText("");
			textILong1.setText("");
			textILong2.setText("");
		}else if(e.getSource()==botonBorrar){
			MetodosRuta metodos = new MetodosRuta();
			int id = Integer.valueOf(textIId.getText());
			
			metodos.eliminarDatos(sesion, id);
			
		}else if(e.getSource()==botonModificar){
			
		}else if(e.getSource()==botonBuscar){
			MetodosRuta metodos = new MetodosRuta();

			int id = Integer.valueOf(textIId.getText());
			Ruta ruta = (Ruta) metodos.consultarDatos(sesion, id);
			
			textIDistancia.setText(String.valueOf(ruta.getDistanciaRuta()));
			textILatitud1.setText(String.valueOf(ruta.getLatitudRuta1()));
			textILatitud2.setText(String.valueOf(ruta.getLatitudRuta2()));
			textILong1.setText(String.valueOf(ruta.getLongitudRuta1()));
			textILong2.setText(String.valueOf(ruta.getLongitudRuta2()));	
		}
	}
}
