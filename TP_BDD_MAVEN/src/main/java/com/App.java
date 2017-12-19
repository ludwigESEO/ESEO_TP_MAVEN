package com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static final String FICHIER_PROPERTIES = "information.properties";
    private static final String PROPERTY_VERSION = "version";
    private static final String PROPERTY_PLATEFORM = "plateform";
	
    public static void main( String[] args )
    {
    	String version;
        String plateform;
        Connect conn = new Connect();
        
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
		Properties properties = new Properties();
		try {
			properties.load(fichierProperties);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		version = properties.getProperty(PROPERTY_VERSION);
		plateform = properties.getProperty(PROPERTY_PLATEFORM);
    	
		conn.main();
		
        System.out.println( "La Version du Projet : " + version + ".\nLa Plateforme du projet : " + plateform + "." );
    }
}
