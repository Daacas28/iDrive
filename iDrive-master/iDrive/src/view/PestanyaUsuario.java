package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.hibernate.classic.Session;

import controller.MetodosCliente;
import models.Cliente;
import models.Ruta;

public class PestanyaUsuario implements ActionListener {

	private static JTabbedPane tabbedPane;
	private static JPanel panelSuperior_1;
	private static JPanel pestanya_usuarios;
	private static JLabel labelUsuarios;
	private static JButton botonActualiza;
	private static JTextField fieldBuscar;
	private static JPanel panelSuperior_2;

	private static JPanel panelCentral;

	private static JPanel panelInferior;
	private static JTabbedPane tabbedPaneUsuarios;
	private static JPanel panelListaUsu;
	private static JTable tabla;
	private static ModeloTabla modelo;
	private static JScrollPane scrollTabla;

	private static JPanel panelAdministracionUSu;

	private static Session sesion;

	private static JLabel labelNombre;
	private static JTextField fieldNombre;

	private static JLabel labelDNI;
	private static JTextField fieldDNI;

	private static JLabel labelTelefono;
	private static JTextField fieldTelefono;

	private static JButton botonLimpiar;
	private static JButton botonModificar;
	private static JButton botonBorrar;

	private static JTextField fieldMeteId;

	private static JPanel nuevoNombre;
	private static JLabel labelNuevoNombre;
	private static JTextField valorNuevoNombre;

	private static JPanel nuevoDNI;
	private static JLabel labelNuevoDni;
	private static JTextField valorNuevoDni;

	private static JPanel nuevoTelefono;
	private static JLabel labelNuevoTelef;
	private static JTextField valorNuevoTelef;

	private static JButton botonCrearCliente;
	private static JButton botonBuscar;

	public PestanyaUsuario(JTabbedPane tabbedPane, Session sesion) {
		this.sesion = sesion;
		this.tabbedPane = tabbedPane;

		iniciarPanel();
	}

	public void iniciarPanel() {
		pestanya_usuarios = new JPanel();
		// Lo añadimos a la ventana principal
		tabbedPane.addTab("Usuarios", null, pestanya_usuarios, null);
		pestanya_usuarios.setLayout(new BorderLayout(0, 0));

		panelSuperior_1 = new JPanel();
		panelSuperior_1.setLayout(new BorderLayout());
		// panelSuperior_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelSuperior_1.setPreferredSize(new Dimension(300, 100));
		panelSuperior_1.setBackground(Color.GRAY);

		labelUsuarios = new JLabel("Datos del cliente");
		// labelUsuarios.setBounds(335, 11, 50, 14);
		// labelUsuarios.setBorder(BorderFactory.createEmptyBorder(5, 20, 5,
		// 20));

		botonActualiza = new JButton("Actualizar lista");
		// botonActualiza.setBounds(390, 7, 101, 23);
		// botonActualiza.setBorder(BorderFactory.createEmptyBorder(5, 20, 5,
		// 20));

		fieldBuscar = new JTextField(12);
		// fieldBuscar.setBounds(496, 8, 102, 20);
		// fieldBuscar.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

		panelSuperior_1.add(labelUsuarios, BorderLayout.LINE_START);
		panelSuperior_2 = new JPanel();
		panelSuperior_2.setBackground(Color.GRAY);

		// como ponerlas en el centro
		panelSuperior_2.add(botonActualiza, BorderLayout.CENTER);
		panelSuperior_2.add(fieldBuscar, BorderLayout.CENTER);
		// ----------------------------

		panelSuperior_1.add(panelSuperior_2, BorderLayout.LINE_END);
		pestanya_usuarios.add(panelSuperior_1, BorderLayout.NORTH);

		panelCentral = new JPanel();
		panelCentral.setLayout(new FlowLayout());
		panelCentral.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		// PANELCENTRAL---------------------------------
		tabbedPaneUsuarios = new JTabbedPane(JTabbedPane.LEFT);
		// Decirle al tabbedPanel que este a la izquierda y
		// saber por que no salen los dos paneles y no solo uno????

		panelListaUsu = new JPanel();
		panelListaUsu.setLayout(new BoxLayout(panelListaUsu, BoxLayout.Y_AXIS));
		panelListaUsu.setBorder(new LineBorder(Color.BLACK));
		panelListaUsu.setPreferredSize(new Dimension(1200, 500));

		// TABLA------------------------------------

		modelo = new ModeloTabla(sesion);
		ModeloTabla.buscarUsuariosConTableModel(modelo, sesion);
		tabla = new JTable(modelo);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		// tabla.getModel().addTableModelListener(this); //Si se quisiera usar
		// habría que implementar de TableModelListener
		scrollTabla = new JScrollPane(tabla);
		panelListaUsu.add(scrollTabla);

		tabbedPaneUsuarios.addTab("Lista", null, panelListaUsu, null);
		// Tabla -------------------------------
		JPanel panelNombre = new JPanel();
		labelNombre = new JLabel("Nombre: ");
		fieldNombre = new JTextField(10);
		panelNombre.add(labelNombre);
		panelNombre.add(fieldNombre);

		JPanel panelDNI = new JPanel();
		labelDNI = new JLabel("DNI: ");
		fieldDNI = new JTextField(10);
		panelDNI.add(labelDNI);
		panelDNI.add(fieldDNI);

		JPanel panelTelef = new JPanel();
		labelTelefono = new JLabel("Teléfono: ");
		fieldTelefono = new JTextField(10);
		panelTelef.add(labelTelefono);
		panelTelef.add(fieldTelefono);

		panelAdministracionUSu = new JPanel();
		panelAdministracionUSu.setLayout(new BoxLayout(panelAdministracionUSu, BoxLayout.X_AXIS));
		JLabel introduId = new JLabel("Introduzca el id del cliente");
		fieldMeteId = new JTextField(7);
		botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(this);
		JPanel panel1 = new JPanel();
		panel1.add(introduId);
		panel1.add(fieldMeteId);
		panel1.add(botonBuscar);
		//

		JLabel labelCliente = new JLabel("Cliente con ID N");

		JPanel panelBotones = new JPanel();
		botonLimpiar = new JButton("Limpiar");
		botonModificar = new JButton("Modificar");
		botonBorrar = new JButton("Borrar");

		botonLimpiar.addActionListener(this);
		botonModificar.addActionListener(this);
		botonBorrar.addActionListener(this);

		panelBotones.add(botonLimpiar);
		panelBotones.add(botonModificar);
		panelBotones.add(botonBorrar);

		JPanel panelADCliente = new JPanel();
		panelADCliente.setLayout(new BoxLayout(panelADCliente, BoxLayout.Y_AXIS));

		panelADCliente.add(panel1);
		panelADCliente.add(labelCliente);
		panelADCliente.add(panelNombre);
		panelADCliente.add(panelDNI);
		panelADCliente.add(panelTelef);
		panelADCliente.add(panelBotones);

		panelADCliente.setBorder(new LineBorder(Color.BLACK));

		panelAdministracionUSu.add(panelADCliente, BorderLayout.LINE_START);

		JPanel panelNuevoCliente = new JPanel();
		panelNuevoCliente.setLayout(new BoxLayout(panelNuevoCliente, BoxLayout.Y_AXIS));
		nuevoNombre = new JPanel();
		labelNuevoNombre = new JLabel("Nombre: ");
		valorNuevoNombre = new JTextField(10);
		nuevoNombre.add(labelNuevoNombre);
		nuevoNombre.add(valorNuevoNombre);

		nuevoDNI = new JPanel();
		labelNuevoDni = new JLabel("DNI: ");
		valorNuevoDni = new JTextField(10);
		nuevoDNI.add(labelNuevoDni);
		nuevoDNI.add(valorNuevoDni);

		nuevoTelefono = new JPanel();
		labelNuevoTelef = new JLabel("Teléfono: ");
		valorNuevoTelef = new JTextField(10);
		nuevoTelefono.add(labelNuevoTelef);
		nuevoTelefono.add(valorNuevoTelef);

		JPanel panelBoton = new JPanel();
		botonCrearCliente = new JButton("Crear Cliente");
		botonCrearCliente.addActionListener(this);
		panelBoton.add(botonCrearCliente);

		panelNuevoCliente.add(nuevoNombre);
		panelNuevoCliente.add(nuevoDNI);
		panelNuevoCliente.add(nuevoTelefono);
		panelNuevoCliente.add(panelBoton);

		panelNuevoCliente.setBorder(new LineBorder(Color.BLACK));

		panelAdministracionUSu.add(panelNuevoCliente, BorderLayout.LINE_END);
		panelAdministracionUSu.setBorder(new LineBorder(Color.BLUE));
		tabbedPaneUsuarios.addTab("Administración", null, panelAdministracionUSu, null);

		panelCentral.add(tabbedPaneUsuarios, BorderLayout.LINE_START);
		// -----------------------------------------------
		pestanya_usuarios.add(panelCentral, BorderLayout.CENTER);

		/*panelInferior = new JPanel();
		// panelInferior.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInferior.setPreferredSize(new Dimension(300, 200));

		*/
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == botonActualiza) {
			// Actualizamos la tabla de los clientes

			ModeloTabla.buscarUsuariosConTableModel(modelo, sesion);
			tabla = new JTable(modelo);

		} else if (arg0.getSource() == botonBorrar) {
			MetodosCliente metodos = new MetodosCliente();
			int id = Integer.parseInt(fieldMeteId.getText());
			metodos.eliminarDatos(sesion, id);

		} else if (arg0.getSource() == botonLimpiar) {
			fieldNombre.setText("");
			fieldDNI.setText("");
			fieldTelefono.setText("");

		} else if (arg0.getSource() == botonModificar) {
			int id = Integer.parseInt(fieldMeteId.getText());

			String nombre = String.valueOf(fieldNombre.getText());
			String dni = String.valueOf(fieldDNI.getText());
			String telefono = String.valueOf(fieldTelefono.getText());

			Cliente cliente = new Cliente();
			cliente.setNombre(nombre);
			cliente.setDni(dni);
			cliente.setTelefono(telefono);

			MetodosCliente metodos = new MetodosCliente();
			metodos.modificarDatos(sesion, id, cliente);
		} else if (arg0.getSource() == botonCrearCliente) {
			// creamos un cliente al cual le asignaremos los nuevos valores
			// ses lo pasaremos a un método que lo creara mediante una
			// transacción
			Cliente cliente = new Cliente();
			
			String nombre = String.valueOf(valorNuevoNombre.getText());
			String dni = String.valueOf(valorNuevoDni.getText());
			String telefono = String.valueOf(valorNuevoTelef.getText());
			
			Boolean nombreBo = esNombre(nombre);
			Boolean dniBo = esDNI(dni);
			Boolean telefonoBo = esTelefono(telefono);
			
			if(nombreBo && dniBo && telefonoBo){
				cliente.setNombre(nombre);
				cliente.setDni(dni);
				cliente.setTelefono(telefono);
				MetodosCliente.nuevoCliente(sesion, cliente);
			}else{
				JOptionPane.showMessageDialog(null, "Compruebe:\nEl nombre tendrá como máximo 10 carácteres."
						+ "\nEl dni tendrá como máximo 11 carácteres.\nEl telefono tendrá como máximo 9 carácteres.", "", JOptionPane.INFORMATION_MESSAGE);
			}
			
			fieldNombre.setText("");
			fieldDNI.setText("");
			fieldTelefono.setText("");

			
		} else if (arg0.getSource() == botonBuscar) {
			MetodosCliente metodos = new MetodosCliente();

			int id = Integer.valueOf(fieldMeteId.getText());
			Cliente cliente = (Cliente) metodos.consultarDatos(sesion, id);
			
			if (cliente != null){
				fieldNombre.setText(String.valueOf(cliente.getNombre()));
				fieldDNI.setText(String.valueOf(cliente.getDni()));
				fieldTelefono.setText(String.valueOf(cliente.getTelefono()));
			}else{
				MetodosCliente.clienteNoExiste(sesion, id);
			}

			

		}

	}

	// ---------------------VALIDACIONES---------------------
	public static boolean esNombre(String nombre) {
		if (nombre.length() > 10) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean esDNI(String dni) {
		if (dni.length() > 11) {
			return false;
		} else {
			return true;
		}
	}
	public static boolean esTelefono(String telefono) {
		if (telefono.length() > 9) {
			return false;
		} else {
			return true;
		}
	}
}

