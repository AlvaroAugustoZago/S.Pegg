package br.com.spegg.models;

import javax.persistence.Entity;

@Entity
public class UBSExistentes {

    private String no_cidade;
    private String nomeCidade;
    private String valor;
    private String taxa;

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

    public String getNomeArquivo() {
        return "arquivos/ubs_existentesnone.csv.csv";
    }
}
