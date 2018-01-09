package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.CoordonneesGPS;
import com.bean.Ville;
import com.config.JDBCConfiguration;

public class VilleDAOImpl implements VilleDAO{

	@Override
	public ArrayList<Ville> trouverVilles() {
		ArrayList<Ville> listVilles = new ArrayList<Ville>();

		try {
			// Connection con = JDBCConfigurationSol2.getConnection();
			Connection con = JDBCConfiguration.getConnection();
			Statement statement = con.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM villes");
			while (resultSet.next()) {
				Ville ville = new Ville();

				ville.setCode_commune_INSEE(resultSet.getString("code_commune_INSEE"));
				ville.setNom_commune(resultSet.getString("nom_commune"));
				ville.setLibelle_acheminement(resultSet.getString("libelle_acheminement"));
				ville.setCode_postal(resultSet.getString("code_postal"));
				ville.setLigne_5(resultSet.getString("ligne_5"));
				CoordonneesGPS coordonnees_gps = new CoordonneesGPS(resultSet.getString("latitude"), resultSet.getString("longitude"));
				ville.setCoordonnees_gps(coordonnees_gps);

				listVilles.add(ville);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVilles;

	}

	@Override
	public void ajouterVilles(ArrayList<Ville> villes) {

		try {
			Connection con = JDBCConfiguration.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO villes (code_commune_INSEE, nom_commune, code_postal, libelle_acheminement, ligne_5, latitude,longitude) VALUES (?,?,?,?,?,?,?)");

			for (Ville ville : villes) {
				statement.setString(1, ville.getCode_commune_INSEE());
				statement.setString(2, ville.getNom_commune());
				statement.setString(3, ville.getCode_postal());
				statement.setString(4, ville.getLibelle_acheminement());
				statement.setString(5, ville.getLigne_5());
				statement.setString(6, ville.getCoordonnees_gps().getLatitude());
				statement.setString(7, ville.getCoordonnees_gps().getLongitude());
				statement.executeUpdate();
			}
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public void majVilles(ArrayList<Ville> villes) {
		try {
			// Connection con = JDBCConfigurationSol2.getConnection();
			Connection con = JDBCConfiguration.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"UPDATE ville SET nom_commune = ?, code_postal = ?,libelle_acheminement = ?, ligne_5 = ?, latitude = ?, longitude = ? WHERE code_commune_INSEE=?");
			for(Ville ville : villes) {
			statement.setString(1, ville.getNom_commune());
			statement.setString(2, ville.getCode_postal());
			statement.setString(3, ville.getLibelle_acheminement());
			statement.setString(4, ville.getLigne_5());
			statement.setString(5, ville.getCoordonnees_gps().getLatitude());
			statement.setString(6, ville.getCoordonnees_gps().getLongitude());
			statement.setString(7, ville.getCode_commune_INSEE());
			statement.executeUpdate();
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
