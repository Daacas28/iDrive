package controller;

import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.hibernate.Session;
import models.Cliente;
import models.Ruta;

public class MetodosCliente extends MetodosComunes {

	public MetodosCliente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object consultarDatos(Session sesion, int id) {
		
	Cliente cliente = (Cliente) sesion.get(Cliente.class, id);
		
		return cliente;
		
	}

	@Override
	public Object modificarDatos(Session sesion, int id, Object objeto) {
		
		Cliente cliente = (Cliente) sesion.get(Cliente.class, id);
		Cliente nuevoCliente = new Cliente();
		nuevoCliente = (Cliente) objeto;
		
		sesion.beginTransaction();
		cliente.setNombre(nuevoCliente.getNombre());
		cliente.setTelefono(nuevoCliente.getTelefono());
		cliente.setDni(nuevoCliente.getDni());
		sesion.persist(cliente);
		sesion.getTransaction().commit();
		

		return objeto;
	}

	@Override
	public Object eliminarDatos(Session sesion, int id) {
		Cliente cliente = (Cliente) sesion.get(Cliente.class, id);
		sesion.beginTransaction();
		sesion.delete(cliente);
		sesion.getTransaction().commit();
		MetodosCliente.mostrarClienteBorrado(cliente);

		return null;
	}

	public static void clienteNoExiste(Session sesion, int id){
		
		JPanel panelNoExiste = new JPanel();
		panelNoExiste.setLayout(new BoxLayout(panelNoExiste, BoxLayout.Y_AXIS));
		
		JLabel labelNo = new JLabel();
		String frase="Lo siento.\nEl cliente con id: "+id+" no existe";
		labelNo.setText(frase);
		panelNoExiste.add(labelNo);

		
		JOptionPane.showMessageDialog(panelNoExiste, panelNoExiste, "Cliente no encontrado", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int numClientes(Session sesion) {
		int num = 0;
		Iterator iterador;
		iterador = sesion.createQuery("FROM Cliente").iterate();
		while (iterador.hasNext()) {
			Cliente cliente = (Cliente) iterador.next();
			num++;
		}
		return num;
	}

	public static Object[] todosClientes(Session sesion) {
		Iterator iterador;
		int cont = 0;

		int contCliente = numClientes(sesion);
		Object[] cliente = new Object[contCliente];

		iterador = sesion.createQuery("FROM Cliente").iterate();
		while (iterador.hasNext()) {
			cont++;
			Cliente cli = (Cliente) iterador.next();
			cliente[cont] = cli;
		}

		return cliente;

	}

	public static void nuevoCliente(Session sesion, Cliente cliente) {
		sesion.beginTransaction();
		sesion.persist(cliente);
		sesion.getTransaction().commit();
		mostrarClienteCreado(cliente);
	}

	public static void mostrarClienteBorrado(Cliente cliente) {

		JPanel panelBorrado = new JPanel();
		panelBorrado.setLayout(new BoxLayout(panelBorrado, BoxLayout.Y_AXIS));

		// JLabel labelNombre = new JLabel("Nombre: "+cliente.getNombre());
		panelBorrado.add(new JLabel("ID Cliente: " + cliente.getIdCliente()));
		panelBorrado.add(new JLabel("Nombre: " + cliente.getNombre()));
		panelBorrado.add(new JLabel("DNI: " + cliente.getDni()));
		panelBorrado.add(new JLabel("Teléfono: " + cliente.getTelefono()));

		JOptionPane.showMessageDialog(panelBorrado, panelBorrado, "Cliente borrado", JOptionPane.INFORMATION_MESSAGE);

	}

	public static void mostrarClienteCreado(Cliente cliente) {

		JPanel panelCreado = new JPanel();
		panelCreado.setLayout(new BoxLayout(panelCreado, BoxLayout.Y_AXIS));

		// JLabel labelNombre = new JLabel("Nombre: "+cliente.getNombre());
		panelCreado.add(new JLabel("ID Cliente: " + cliente.getIdCliente()));
		panelCreado.add(new JLabel("Nombre: " + cliente.getNombre()));
		panelCreado.add(new JLabel("DNI: " + cliente.getDni()));
		panelCreado.add(new JLabel("Teléfono: " + cliente.getTelefono()));

		JOptionPane.showMessageDialog(panelCreado, panelCreado, "Cliente creado", JOptionPane.INFORMATION_MESSAGE);

	}
	public static void mostrarClienteActualizados(Cliente cliente) {

		JPanel panelCreado = new JPanel();
		panelCreado.setLayout(new BoxLayout(panelCreado, BoxLayout.Y_AXIS));

		// JLabel labelNombre = new JLabel("Nombre: "+cliente.getNombre());
		panelCreado.add(new JLabel("ID Cliente: " + cliente.getIdCliente()));
		panelCreado.add(new JLabel("Nombre: " + cliente.getNombre()));
		panelCreado.add(new JLabel("DNI: " + cliente.getDni()));
		panelCreado.add(new JLabel("Teléfono: " + cliente.getTelefono()));

		JOptionPane.showMessageDialog( panelCreado, panelCreado, "Cliente actualizado", JOptionPane.INFORMATION_MESSAGE);

	}
}
