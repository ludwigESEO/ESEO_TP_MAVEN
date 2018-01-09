package com.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

@Configuration
public class JDBCConfiguration{

	private static final String FICHIER_PROPERTIES = "application.properties";
	private static final String PROPERTY_URL = "jdbc.url";
	private static final String PROPERTY_NOM_UTILISATEUR = "jdbc.user";
	private static final String PROPERTY_MOT_DE_PASSE = "jdbc.password";

	@Bean
	public static Connection getConnection(){

		Connection connection = null;
		MysqlDataSource mysqlDS = null;
		
        Properties properties = new Properties();
        String url;
        String nomUtilisateur;
        String motDePasse;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);
		try {
			properties.load(fichierProperties);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        url = properties.getProperty(PROPERTY_URL);
        nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
        motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);

		mysqlDS = new MysqlDataSource();
		mysqlDS.setURL(url);
		mysqlDS.setUser(nomUtilisateur);
		mysqlDS.setPassword(motDePasse);
		

		try {
			connection = mysqlDS.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
