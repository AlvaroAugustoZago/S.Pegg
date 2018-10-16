package br.com.spegg.models;

import br.com.spegg.Construtor.Arquivo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.*;

@Entity
public class UBSConstrucao extends Arquivo<UBSConstrucao> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String no_cidade;
    private String nomeCidade;
    private String valor;
    private String taxa;

    public UBSConstrucao() throws Exception {
        super();
    }

    public String getNo_cidade() {
        return no_cidade;
    }

    public void setNo_cidade(String no_cidade) {
        this.no_cidade = no_cidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTaxa() {
        return taxa;
    }

    public void setTaxa(String taxa) {
        this.taxa = taxa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeArquivo() {
        return "ubs_construcaonone";
    }
}
