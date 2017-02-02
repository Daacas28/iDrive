/**
 * Ejemplo de uso de un JInternalFrame
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.Polyline;
import com.teamdev.jxmaps.PolylineOptions;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;


/**
 * Instancia un JFrame con un JDesktopPane y dentro de este
 * un JInternalFrame.
 * @author chuidiang
 *
 */
public class PruebaInternalFrame extends MapView{

	PruebaInternalFrame sample;
	
	
	/**
	 * Crea el JFrame, el JDesktopPane, un JInternalFrame de
	 * muestra y lo visualiza.
	 */
	public PruebaInternalFrame()
	{
		
	
		// El JFrame con el JDesktopPane
		JFrame v = new JFrame("Prueba JInternalFrame");
		JDesktopPane dp = new JDesktopPane();
		v.getContentPane().add(dp);
	
		
	    
        JMenuBar menuBar = new JMenuBar();
        v.setJMenuBar(menuBar);
        
        JMenu mnNewMenu_1 = new JMenu("Vehiculos");
        menuBar.add(mnNewMenu_1);
        
        JMenu mnNewMenu_2 = new JMenu("New menu");
        menuBar.add(mnNewMenu_2);
        
        v.setJMenuBar(menuBar);
        
    	v.setVisible(true);
		
		// Se construye el panel que ira dentro del JInternalFrame
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add (new JLabel("Una etiqueta"));
		p.add (new JTextField(10));
		
		// Se construye el JInternalFrame
		
		JInternalFrame internal = new JInternalFrame("Posición del Vehículo");
		internal.setSize(742, 300);
		internal.getContentPane().add(this, BorderLayout.CENTER);
		internal.setPreferredSize(new Dimension(720, 300));
	    internal.setLocation(10, 0);
	   
		
		// Es importante darle tamaño -pack()- al JInternalFrame,
		// porque si no, tendrá tamaño 0,0 y no lo veremos.
		internal.pack();
		
		// Por defecto el JInternalFrame no es redimensionable ni
		// tiene el botón de cerrar, así que se lo ponemos.
		internal.setResizable(true);
		internal.setClosable(true);
		
		// Se mete el internal en el JDesktopPane
		dp.add(internal); 
		
		// Se visualiza todo.
		v.setSize(758,594);
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
		
		// Se visualiza el JInternalFrame 
		internal.setVisible(true);
		// Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and     
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
            	  // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = getMap();
                    // Creating a map options object
                    MapOptions mapOptions = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(mapOptions);
                    // Setting the map center
                    map.setCenter(new LatLng(50.1765326,0.1088122));
                    // Setting initial zoom value
                    map.setZoom(3.0);
                    // Creating a path (array of coordinates) that represents a polyline
                    LatLng[] path = {new LatLng(39.5091551,-0.4213993),
                            new LatLng(39.4687045,-0.3769442),
                            new LatLng(-18.142, 178.431),
                            new LatLng(-27.467, 153.027)};
                    // Creating a new polyline object
                    Polyline polyline = new Polyline(map);
                    // Initializing the polyline with created path
                    polyline.setPath(path);
                    // Creating a polyline options object
                    PolylineOptions options = new PolylineOptions();
                    // Setting geodesic property value
                    options.setGeodesic(true);
                    // Setting stroke color value
                    options.setStrokeColor("#FF0000");
                    // Setting stroke opacity value
                    options.setStrokeOpacity(1.0);
                    // Setting stroke weight value
                    options.setStrokeWeight(2.0);
                    // Applying options to the polyline
                    polyline.setOptions(options);
                }
            }
        });
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setPreferredSize(new Dimension(300,200));
        internal.getContentPane().add(tabbedPane, BorderLayout.EAST);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Ruta Actual", null, panel, null);
        
        JPanel panel_1 = new JPanel();
        tabbedPane.addTab("Clientes Hoy", null, panel_1, null);
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(20, 311, 89, 23);
        dp.add(btnNewButton);
    
    }
		
	
	/** Instancia esta clase */
	public static void main(String[] args) {
		
		 final PruebaInternalFrame sample = new PruebaInternalFrame();
	        
	    
	}
}
