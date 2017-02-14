package view;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;

import org.hibernate.Session;

import controller.Mapa;
import controller.MetodosRuta;
import models.Ruta;
import sun.management.jdp.JdpGenericPacket;
import view.RadioBoton.ClickRadioButton;

public class Crear implements  ActionListener {

	private  RadioBoton radioButton;
	private Session sesion;
	
	public Crear(Session sesion){
		this.sesion=sesion;
	}
	
	public static JMenuBar iniciarMenu() {
		JMenuBar menuBar = new JMenuBar();

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

		return menuBar;
	}

	public JScrollPane generaPanel(int numero, Class clase) {

		JPanel seleccionarRuta;
		JPanel paneles;

		JLabel labelImagen;
		
		ImageIcon icon;
		JScrollPane scroll;
		ButtonGroup grupoBotones = new ButtonGroup();
		PestanyaRuta pesRuta = new PestanyaRuta();
		seleccionarRuta = new JPanel();

		for (int i = 0; i < numero; i++) {

			icon = new ImageIcon(clase.getResource("/img/" + (i + 1) + ".jpg"));

			paneles = new JPanel();
			paneles.setLayout(new BoxLayout(paneles, BoxLayout.Y_AXIS));
			radioButton = new RadioBoton("Seleccionado");
			radioButton.setId(i + 1);
			grupoBotones.add(radioButton);
			
			radioButton.addActionListener(this);

			labelImagen = new JLabel();
			crearImageIcon(icon, labelImagen);

			paneles.add(radioButton);
			paneles.add(labelImagen);

			seleccionarRuta.add(paneles);
		}

		scroll = new JScrollPane(seleccionarRuta);

		return scroll;
	}

	public static void crearImageIcon(ImageIcon icon, JLabel label) {

		if (icon != null) {

			Image img = icon.getImage(); // convertimos icon en una imagen
			Image otraimg = img.getScaledInstance(120, 90, java.awt.Image.SCALE_SMOOTH); // creamos una imagen
																							// nueva
																							// dándole
																							// las
																							// dimensiones
																							// que
																							// queramos
																							// a
																							// la
																							// antigua
			ImageIcon otroicon = new ImageIcon(otraimg);

			label.setIcon(otroicon);

		} else {

			label.setText("No se puedo cargar la imagen");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()==radioButton){
			
		}
		System.out.println("Has dado a un boton con id:" +radioButton.getId());
		
		MetodosRuta metodos = new MetodosRuta();
		int idBoton = radioButton.getId();
		ArrayList<Integer> idClientes = new ArrayList<>();
		
		Ruta ruta= new Ruta();
		ruta = (Ruta) metodos.consultarDatos(sesion, idBoton);
		
		if (ruta != null){
			PestanyaRuta pesRuta = new PestanyaRuta();
			pesRuta.ponerDatosPanelRuta(ruta.getIdRuta());
			Mapa mapa = new Mapa(ruta.getLatitudRuta1(), ruta.getLongitudRuta1(), ruta.getLatitudRuta2(), ruta.getLongitudRuta2());
		}
		//O lo hacemos que muestre los que tienen esa ruta.
	}

}
