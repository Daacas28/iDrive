package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import models.SessionFactoryUtil;

public class VentanaPrincipal extends JFrame{
//Declaramos las variables que vaos a necesitar
	private JPanel contentPane;
	
	private final JLabel label_Nombre_Ruta = new JLabel("New label");
	private static Session sesion;
	private static JTabbedPane tabbedPane;

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		sesion = sessionFactory.openSession();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					System.setProperty("apple.laf.useScreenMenuBar", "true");
					System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					 UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				        //Update the component tree - associate the look and feel with the given frame.
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
		// Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
		// setMaximumSize(DimMax);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblBienvenido = new JLabel("Bienvenido");
		contentPane.add(lblBienvenido, BorderLayout.NORTH);

		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
//Obtengo el método de la clase CreaMenuBar que creara nuestra barra de nemu
		JMenuBar menuBar = Crear.iniciarMenu();
		setJMenuBar(menuBar);
//--------------------------------------------------------------------------
		JPanel panelInicio = new JPanel();
		tabbedPane.addTab("Inicio", null, panelInicio, null);
		
// Instanciamos la clase PestanyaRuta para que cree el panel de la pestaña de la ruta
		PestanyaVehiculos pestanyaVehiculos = new PestanyaVehiculos(tabbedPane);
//-----------------------------------------------------------------------------------
		
// Instanciamos la clase PestanyaRuta para que cree el panel de la pestaña de la ruta
		PestanyaRuta pestanyaRuta = new PestanyaRuta(label_Nombre_Ruta, tabbedPane, sesion);
//-----------------------------------------------------------------------------------

// Instanciamos la clase PestanyaUsuario para que cree el panel de la pestaña del usuario
		PestanyaUsuario pestanyaUsuario = new PestanyaUsuario(tabbedPane, sesion);
//---------------------------------------------------------------------------------------
	}
}
