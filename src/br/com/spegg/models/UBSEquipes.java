package br.com.spegg.models;

import br.com.spegg.Construtor.Arquivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Entity
public class UBSEquipes extends Arquivo<UBSEquipes> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String equipes;
	private String no_cidade;
	private String lat;
	private String longi;

	public UBSEquipes() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEquipes() {
		return equipes;
	}
	public void setEquipes(String equipes) {
		this.equipes = equipes;
	}
	public String getNo_cidade() {
		return no_cidade;
	}
	public void setNo_cidade(String no_cidade) {
		this.no_cidade = no_cidade;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	
	public String getNomeArquivo() {
        return "acs_equipesnone";
    }
	
}
