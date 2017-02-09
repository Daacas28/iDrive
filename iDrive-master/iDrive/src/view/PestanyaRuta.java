package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.hibernate.classic.Session;

import controller.Mapa;
import controller.MetodosRuta;

public class PestanyaRuta extends JFrame implements ChangeListener {

	private JPanel seleccionarRuta;
	private JPanel paneles;
	private JLabel labelImagen;
	private JScrollPane scroll;

	private static JLabel label_Nombre_Ruta = new JLabel("New label");
	private static Session sesion;
	private static JTabbedPane tabbedPane;
	private static RadioBoton radioButton;

	private static JPanel panelRutaActual;
	
	private static JPanel panelID;
	private static JPanel panelDistancia;
	private static JPanel panelLati1;
	private static JPanel panelLong1;
	private static JPanel panelLati2;
	private static JPanel panelLong2;

	public PestanyaRuta(JLabel label_Nombre_Ruta, JTabbedPane tabbedPane, Session session) {
		this.label_Nombre_Ruta = label_Nombre_Ruta;
		this.tabbedPane = tabbedPane;
		this.sesion = session;

		iniciarPanel();
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
		
		//Creamos los labels para el panel ID
		 panelID = new JPanel();
		 
		 JLabel nombreIdRuta = new JLabel("ID:");
		 JLabel valorIdRuta = new JLabel("1");
			
		 panelID.add(nombreIdRuta);
		 panelID.add(valorIdRuta);
		 
		 panelDistancia = new JPanel();
		 JLabel nombreDistancia = new JLabel("Distancia Total:");
		JTextField valorDistancia = new JTextField();
		
		panelDistancia.add(nombreDistancia);
		panelDistancia.add(valorDistancia);
		 
		 panelLati1 = new JPanel();
		 panelLong1 = new JPanel();
		 panelLati2 = new JPanel();
		 panelLong2 = new JPanel();
		
		
		JLabel latitudUno = new JLabel("Latitud Punto 1:");
		JTextField valorLatitudUno = new JTextField();
		
		JLabel longitudUno = new JLabel("Latitud Punto 1:");
		JTextField valorLongitudUno = new JTextField();
		
		
		panelRutaActual.add(panelID);
		panelRutaActual.add(panelDistancia);
	
		
		
		JPanel panelClienteActual = new JPanel();
		tabbedPaneRutas.addTab("Clientes Hoy", null, panelClienteActual, null);
		panelClienteActual.add(label_Nombre_Ruta);		

		seleccionarRuta = new JPanel();
		scroll = Crear.generaPanel(5);
		scroll.add(seleccionarRuta);

		
		internalFrame.getContentPane().add(scroll, BorderLayout.PAGE_END);

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println("Tab: " + tabbedPane.getSelectedIndex());
		int panelEscogido = tabbedPane.getSelectedIndex();

		int distancia = MetodosRuta.consultarDistanciaRuta(sesion);
		System.out.println(distancia);

		label_Nombre_Ruta.setText(String.valueOf(distancia));

	}

}
