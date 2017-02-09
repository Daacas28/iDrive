package view;

import java.awt.Rectangle;

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

import sun.management.jdp.JdpGenericPacket;

public class Crear {

	public static JMenuBar iniciarMenu(){
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
	public static JScrollPane generaPanel(int numero){
		
		JPanel seleccionarRuta;
		JPanel paneles;
		
		JLabel labelImagen;
		RadioBoton radioButton;
		ImageIcon icono;
		JScrollPane scroll;
		ButtonGroup grupoBotones =  new ButtonGroup();
		seleccionarRuta = new JPanel();
		
		for (int i = 0; i < numero; i++) {
			paneles = new JPanel();
			paneles.setLayout(new BoxLayout(paneles, BoxLayout.Y_AXIS));
			radioButton = new RadioBoton("Seleccionado");
			radioButton.setId(i+1);
			grupoBotones.add(radioButton);
			//radioButton.
			labelImagen = new JLabel("Aqui irá una\nImagen");
			labelImagen.setBounds(new Rectangle(5, 10, 5, 10));
			
			
			paneles.add(radioButton);
			paneles.add(labelImagen);
			
			seleccionarRuta.add(paneles);
		}
		
		scroll = new JScrollPane(seleccionarRuta);
		
		return scroll;
	}
}
