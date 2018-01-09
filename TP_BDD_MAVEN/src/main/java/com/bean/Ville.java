package com.bean;



public class Ville {
	
	private String code_commune_INSEE ;
	private String nom_commune;
	private String libelle_acheminement;
	private String code_postal;
	private String ligne_5;
	private CoordonneesGPS coordonnees_gps;
	
	public Ville () {
			
	}
	
	public Ville(String code_commune_INSEE, String nom_commune, String libelle_acheminement, String code_postal,String ligne_5,
			CoordonneesGPS coordonnees_gps) {
		super();
		this.code_commune_INSEE = code_commune_INSEE;
		this.nom_commune = nom_commune;
		this.libelle_acheminement = libelle_acheminement;
		this.code_postal=code_postal;
		this.ligne_5 = ligne_5;
		this.coordonnees_gps = coordonnees_gps;
	}

	public String getCode_commune_INSEE() {
		return code_commune_INSEE;
	}

	public void setCode_commune_INSEE(String code_commune_INSEE) {
		this.code_commune_INSEE = code_commune_INSEE;
	}

	public String getNom_commune() {
		return nom_commune;
	}

	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	public String getLibelle_acheminement() {
		return libelle_acheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelle_acheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return ligne_5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	public CoordonneesGPS getCoordonnees_gps() {
		return coordonnees_gps;
	}

	public void setCoordonnees_gps(CoordonneesGPS coordonnees_gps) {
		this.coordonnees_gps = coordonnees_gps;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	
			
}
