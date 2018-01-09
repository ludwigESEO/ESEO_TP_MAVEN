package com.dao;

import java.util.ArrayList;

import com.bean.Ville;

public interface VilleDAO {
	public ArrayList<Ville> trouverVilles();
	public void ajouterVilles(ArrayList<Ville> villes);
	public void majVilles(ArrayList<Ville> villes);
}