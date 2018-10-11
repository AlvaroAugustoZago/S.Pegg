package br.com.spegg.DAO;

import java.util.List;

import br.com.spegg.JPA.JPAConnection;
import br.com.spegg.models.UBSEquipes;

public class UBSEquipesDAO extends JPAConnection {
	
	 public void incluir(List<UBSEquipes> equipes) {
	        for (UBSEquipes equip: equipes) {
	            synchronized (equip) {
					System.out.println("persistindo obj:" + equip.getNo_cidade() + " do " + equip.getNomeArquivo());
	                super.incluir(equip);
	            }

	        }
	    }

}
