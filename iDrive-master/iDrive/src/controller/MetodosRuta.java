package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;

import models.Cliente;
import models.Ruta;
import view.PestanyaRuta;

public class MetodosRuta extends MetodosComunes implements ActionListener{

	public MetodosRuta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object consultarDatos(Session sesion, int id) {

		Ruta ruta = (Ruta) sesion.get(Ruta.class, id);

		return ruta;
	}

	@Override
	public Object modificarDatos(Session sesion, int id, Object objeto) {
		Ruta ruta = (Ruta) sesion.get(Ruta.class, id);
		mostrarRutaActualizada(ruta);

		return ruta;
	}

	@Override
	public Object eliminarDatos(Session sesion, int id) {
		Ruta ruta = (Ruta) sesion.get(Ruta.class, id);
		mostrarRutaBorrada(ruta);

		return ruta;

	}

	public static int numRutas(Session sesion) {
		int num = 0;
		Iterator iterador;

		iterador = sesion.createQuery("FROM Ruta ").iterate();
		while (iterador.hasNext()) {
			Ruta ruta = (Ruta) iterador.next();
			num++;
		}
		return num;
	}

	public static ArrayList<Integer> idClientesDeRuta(Session sesion, Ruta ruta) {
		ArrayList<Integer> numClientes = new ArrayList<>();
		Iterator iterador;
		int idRuta = ruta.getIdRuta();

		iterador = sesion.createQuery(
				"FROM Cliente c, Ruta r, RegistroRuta g where c.id_cliente=g.id_cliente and " + idRuta + "=g.id_ruta")
				.iterate();
		while (iterador.hasNext()) {
			Cliente cliente = (Cliente) iterador.next();
			int id = cliente.getIdCliente();
			numClientes.add(id);
		}

		return numClientes;
	}

	public static void nuevaRuta(Session sesion, Ruta ruta) {
		sesion.beginTransaction();
		sesion.persist(ruta);
		sesion.getTransaction().commit();
		mostrarRutaCreada(ruta);
	}

	public static void mostrarRutaBorrada(Ruta ruta) {

		JPanel panelBorrado = new JPanel();
		panelBorrado.setLayout(new BoxLayout(panelBorrado, BoxLayout.Y_AXIS));

		// JLabel labelNombre = new JLabel("Nombre: "+cliente.getNombre());
		panelBorrado.add(new JLabel("ID Ruta: " + ruta.getIdRuta()));
		panelBorrado.add(new JLabel("Distancia: " + ruta.getDistanciaRuta()));
		panelBorrado.add(new JLabel("Latitud 1: " + ruta.getLatitudRuta1()));
		panelBorrado.add(new JLabel("Longitud 1: " + ruta.getLongitudRuta1()));
		panelBorrado.add(new JLabel("Latitud 2: " + ruta.getLatitudRuta2()));
		panelBorrado.add(new JLabel("Longitud 2: " + ruta.getLongitudRuta2()));

		JOptionPane.showMessageDialog(panelBorrado, panelBorrado, "Ruta borrada", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void mostrarRutaCreada(Ruta ruta) {

		JPanel panelCreada = new JPanel();
		panelCreada.setLayout(new BoxLayout(panelCreada, BoxLayout.Y_AXIS));

		// JLabel labelNombre = new JLabel("Nombre: "+cliente.getNombre());
		panelCreada.add(new JLabel("ID Ruta: " + ruta.getIdRuta()));
		panelCreada.add(new JLabel("Distancia: " + ruta.getDistanciaRuta()));
		panelCreada.add(new JLabel("Latitud 1: " + ruta.getLatitudRuta1()));
		panelCreada.add(new JLabel("Longitud 1: " + ruta.getLongitudRuta1()));
		panelCreada.add(new JLabel("Latitud 2: " + ruta.getLatitudRuta2()));
		panelCreada.add(new JLabel("Longitud 2: " + ruta.getLongitudRuta2()));

		JOptionPane.showMessageDialog(panelCreada, panelCreada, "Ruta creada", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void mostrarRutaActualizada(Ruta ruta) {

		JPanel panelActializa = new JPanel();
		panelActializa.setLayout(new BoxLayout(panelActializa, BoxLayout.Y_AXIS));

		// JLabel labelNombre = new JLabel("Nombre: "+cliente.getNombre());
		panelActializa.add(new JLabel("ID Ruta: " + ruta.getIdRuta()));
		panelActializa.add(new JLabel("Distancia: " + ruta.getDistanciaRuta()));
		panelActializa.add(new JLabel("Latitud 1: " + ruta.getLatitudRuta1()));
		panelActializa.add(new JLabel("Longitud 1: " + ruta.getLongitudRuta1()));
		panelActializa.add(new JLabel("Latitud 2: " + ruta.getLatitudRuta2()));
		panelActializa.add(new JLabel("Longitud 2: " + ruta.getLongitudRuta2()));

		JOptionPane.showMessageDialog(panelActializa, panelActializa, "Ruta actualizada",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public static void crearDialogNuevaRuta(Session sesion) {

		JPanel nuevaDistancia;
		JLabel labelNuevaDistancia;
		JTextField valorNuevaDistancia;
		JPanel nuevaLati1;
		JLabel labelNuevaLati1;
		JTextField valorNuevaLati1;
		JPanel nuevaLong1;
		JLabel labelNuevaLong1;
		JTextField valorNuevaLong1;
		JPanel nuevaLati2;
		JLabel labelNuevaLati2;
		JTextField valorNuevaLati2;
		JPanel nuevaLong2;
		JLabel labelNuevoLong2;
		JTextField valorNuevaLong2;
		JButton crearRuta;

		// PANEL CREAR NUEVA RUTA
		JPanel panelNuevaRuta = new JPanel();
		panelNuevaRuta.setLayout(new BoxLayout(panelNuevaRuta, BoxLayout.Y_AXIS));
//		tabbedPaneRutas.addTab("Nueva Ruta", null, panelNuevaRuta, null);

		nuevaDistancia = new JPanel();
		labelNuevaDistancia = new JLabel("Distancia");
		valorNuevaDistancia = new JTextField(10);
		nuevaDistancia.add(labelNuevaDistancia);
		nuevaDistancia.add(valorNuevaDistancia);

		nuevaLati1 = new JPanel();
		labelNuevaLati1 = new JLabel("Latitud 1: ");
		valorNuevaLati1 = new JTextField(10);
		nuevaLati1.add(labelNuevaLati1);
		nuevaLati1.add(valorNuevaLati1);

		nuevaLati2 = new JPanel();
		labelNuevaLati2 = new JLabel("Latitud 2: ");
		valorNuevaLati2 = new JTextField(10);
		nuevaLati2.add(labelNuevaLati2);
		nuevaLati2.add(valorNuevaLati2);

		nuevaLong1 = new JPanel();
		labelNuevaLong1 = new JLabel("Longitud 1: ");
		valorNuevaLong1 = new JTextField(10);
		nuevaLong1.add(labelNuevaLong1);
		nuevaLong1.add(valorNuevaLong1);

		nuevaLong2 = new JPanel();
		labelNuevoLong2 = new JLabel("Longitud 2: ");
		valorNuevaLong2 = new JTextField(10);
		nuevaLong2.add(labelNuevoLong2);
		nuevaLong2.add(valorNuevaLong2);

		panelNuevaRuta.add(nuevaDistancia);
		panelNuevaRuta.add(nuevaLati1);
		panelNuevaRuta.add(nuevaLong1);
		panelNuevaRuta.add(nuevaLati2);
		panelNuevaRuta.add(nuevaLong2);

		int seleccion = JOptionPane.showOptionDialog(panelNuevaRuta,panelNuevaRuta,"Añadir una Ruta",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Cancelar", "Crear ruta"}, null);
		
		if(seleccion != 0){//Si le da a crear
			
			Ruta ruta = new Ruta();
			ruta.setDistanciaRuta(Integer.valueOf(valorNuevaDistancia.getText()));
			ruta.setLatitudRuta1(Double.valueOf(valorNuevaLati1.getText()));
			ruta.setLongitudRuta1(Double.valueOf(valorNuevaLong1.getText()));
			ruta.setLatitudRuta2(Double.valueOf(valorNuevaLati2.getText()));
			ruta.setLongitudRuta2(Double.valueOf(valorNuevaLong2.getText()));
			
			nuevaRuta(sesion, ruta);
		
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
