package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PestanyaUsuario {

	private static JTabbedPane tabbedPane;
	private static JPanel panelSuperior_1;
	private static JPanel pestanya_usuarios;
	private static JLabel labelUsuarios;
	private static JButton botonActualiza;
	private static JTextField fieldBuscar;
	private static JPanel panelSuperior_2;
	
	private static JPanel panelCentral;
	
	private static JPanel panelInferior;
	
	public PestanyaUsuario(JTabbedPane tabbedPane) {
		this.tabbedPane=tabbedPane;
		
		iniciarPanel();
	}
	
	public void iniciarPanel(){
		pestanya_usuarios = new JPanel();
		//Lo añadimos a la ventana principal
		tabbedPane.addTab("Usuarios", null, pestanya_usuarios, null);
		pestanya_usuarios.setLayout(new BorderLayout(0, 0));

		panelSuperior_1 = new JPanel();
		panelSuperior_1.setLayout(new BorderLayout());
		//panelSuperior_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelSuperior_1.setPreferredSize(new Dimension(300, 100));
		panelSuperior_1.setBackground(Color.GRAY);

		labelUsuarios = new JLabel("sdhgfj");
		labelUsuarios.setBounds(335, 11, 50, 14);
		labelUsuarios.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

		botonActualiza = new JButton("Actualizar lista");
		botonActualiza.setBounds(390, 7, 101, 23);
		botonActualiza.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

		fieldBuscar = new JTextField(12);
		fieldBuscar.setBounds(496, 8, 102, 20);
		fieldBuscar.setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

		panelSuperior_1.add(labelUsuarios, BorderLayout.LINE_START);
		panelSuperior_2 = new JPanel();
		panelSuperior_2.setBackground(Color.GRAY);
		
		//como ponerlas en el centro
		panelSuperior_2.add(botonActualiza, BorderLayout.CENTER);
		panelSuperior_2.add(fieldBuscar, BorderLayout.CENTER);
		//----------------------------
		
		panelSuperior_1.add(panelSuperior_2, BorderLayout.LINE_END);
		pestanya_usuarios.add(panelSuperior_1, BorderLayout.NORTH);

		panelCentral = new JPanel();
		panelCentral.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		pestanya_usuarios.add(panelCentral, BorderLayout.CENTER);

		panelInferior = new JPanel();
		//panelInferior.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelInferior.setPreferredSize(new Dimension(300, 200));
		
//generamos el panel Inferios
		JScrollPane scroll = Crear.generaPanel(5);
		scroll.add(panelInferior);
		
		pestanya_usuarios.add(scroll, BorderLayout.PAGE_END);
	}
}
