package view;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.StreetViewAddressControlOptions;
import com.teamdev.jxmaps.StreetViewPanoramaOptions;
import com.teamdev.jxmaps.StreetViewPov;
import com.teamdev.jxmaps.swing.MapView;

import javax.swing.*;
import java.awt.*;

/**
 * This example demonstrates how to display street view panorama with a map.
 *
 * @author Vitaly Eremenko
 */
public class StreetViewExample extends MapView {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StreetViewExample() {
        super(true);
        
     // El JFrame con el JDesktopPane
     		JFrame v = new JFrame("Prueba JInternalFrame");
     		JDesktopPane dp = new JDesktopPane();
     		v.getContentPane().add(dp);
     		
     		// Se construye el JInternalFrame
     		PruebaInternalFrame prueba = new PruebaInternalFrame();
     		JInternalFrame internal = new JInternalFrame("Un Internal Frame");
     	//	internal.add(prueba, BorderLayout.CENTER);
     		
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
     		v.setSize(500,500);
     		v.setVisible(true);
     		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     		
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
                    Map map = getMap();
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
                    map.setCenter(new LatLng(51.500871, -0.1222632));
                    // Setting initial zoom value
                    map.setZoom(13.0);
                    // Creating a street view panorama options object
                    StreetViewPanoramaOptions options = new StreetViewPanoramaOptions();
                    // Creating a street view address control options object
                    StreetViewAddressControlOptions svControlOptions = new StreetViewAddressControlOptions();
                    // Changing position of the address control on the panorama
                    svControlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting address control options
                    options.setAddressControlOptions(svControlOptions);
                    // Setting street view panorama options
                    getPanorama().setOptions(options);
                    // Setting initial position of the street view
                    getPanorama().setPosition(map.getCenter());
                    // Creating point of view object
                    StreetViewPov pov = new StreetViewPov();
                    // Setting heading for the point of view
                    pov.setHeading(270);
                    // Setting pitch for the point of view
                    pov.setPitch(20);
                    // Applying the point of view to the panorama object
                    getPanorama().setPov(pov);
                }
            }
        });
    }

    public static void main(String[] args) {
    	new StreetViewExample();
    }
}

