package view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.classic.Session;

import controller.MetodosCliente;
import models.Cliente;

public class ModeloTabla extends DefaultTableModel{
	private static Session sesion;
	
	
					//ID Cliente	//Nombre	 //DNI		  //TELEFONO	
	Class[] tipo = {Integer.class, String.class, String.class,String.class};

	public ModeloTabla(Session sesion){
		
		this.sesion = sesion;
		
		String [] columnas = {"ID Cliente", "Nombre", "DNI", "Teléfono"};
		
		Object [][] filas = null ;
		
		setDataVector(filas,columnas);
	}
	public Class getColumnClass(int indice){
		return tipo[indice];
	}
	public boolean isCellEditable(int i, int j){
		return false;
	}
	
	public static void buscarUsuariosConTableModel(DefaultTableModel model, Session sesion) {
		
		int numCli = MetodosCliente.numClientes(sesion);
		int i = 0;
		int id = 0;
		String nombre ="", dni="", telefono="";
		
		try {
			Iterator iterador;
			
			iterador = sesion.createQuery("From Cliente").iterate();

			while (iterador.hasNext()) {
				Cliente cliente = (Cliente) iterador.next();
				// es para obtener los datos y almacenar las filas
				
				id=Integer.valueOf(cliente.getIdCliente());
				nombre=String.valueOf(cliente.getNombre());
				dni = String.valueOf(cliente.getDni());
				telefono = String.valueOf(cliente.getTelefono());
				
				model.addRow(new Object[]{
					id,nombre,dni,telefono
				});
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		//return fila;
	}
	@Override
	public void setDataVector(Object[][] dataVector, Object[] columnIdentifiers) {
		// TODO Auto-generated method stub
		super.setDataVector(dataVector, columnIdentifiers);
	}
}
