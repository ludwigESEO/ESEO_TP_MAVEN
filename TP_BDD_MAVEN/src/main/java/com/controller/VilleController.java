package com.controller;

import com.blo.VilleBLO;
import com.dao.VilleDAO;

import java.io.IOException;
import java.util.ArrayList;

import com.bean.Ville;

public class VilleController {

	VilleBLO villesBLO;
	VilleDAO villesDAO;
	
	public void synchroniseVilles() {
		ArrayList<Ville> listVilleBlo = new ArrayList<Ville>();
		ArrayList<Ville> listVilleDao = new ArrayList<Ville>();
		
		try {
			listVilleBlo = villesBLO.getVilles();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listVilleDao = villesDAO.trouverVilles();
		
		listVilleBlo.removeAll(listVilleDao);
		
		villesDAO.ajouterVilles(listVilleBlo);
				
	}
	

}
	
