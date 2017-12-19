package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Connect {
	//CTRL + SHIFT + O pour générer les imports

	  public static void main() {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	         
	      String url = "jdbc:mysql://127.0.0.1/ville_france";
	      String user = "root";
	      String passwd = "network";
	         
	      Connection conn = DriverManager.getConnection(url, user, passwd);
	         
	      //Création d'un objet Statement
	      Statement state = conn.createStatement();
	      //L'objet ResultSet contient le résultat de la requête SQL
	      ResultSet result = state.executeQuery("SELECT * FROM ville_france where Code_commune_INSEE<=01010");
	      //On récupère les MetaData
	      ResultSetMetaData resultMeta = result.getMetaData();
	         
	      
	      //On affiche le nom des colonnes
	      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
	         
	      System.out.println("\n");
	         
	      while(result.next()){         
	        for(int i = 1; i <= resultMeta.getColumnCount(); i++)
	          System.out.print("\t" + result.getObject(i).toString() + "\t |");
	            
	        System.out.println("\n------------------");

	      }

	      result.close();
	      state.close();
	         
	    } catch (Exception e) {
	      e.printStackTrace();
	    }      
	  }
	
}
