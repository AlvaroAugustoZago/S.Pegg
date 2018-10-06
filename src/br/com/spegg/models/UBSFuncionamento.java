package br.com.spegg.models;

import javax.persistence.Entity;

@Entity
public class UBSFuncionamento {

    private String codCnes;
    private String lat;
    private String longi;
    private String no_fantasia;
    private String no_logradouro;
    private String nu_endereco;
    private String no_bairro;
    private String nu_telefone;
    private String co_cep;
    private String uf;
    private String cidade;
    private String ano_ubs_det;
    private String mes_ubs_det;

    public String getCodCnes() {
        return codCnes;
    }

    public void setCodCnes(String codCnes) {
        this.codCnes = codCnes;
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

    public String getNo_fantasia() {
        return no_fantasia;
    }

    public void setNo_fantasia(String no_fantasia) {
        this.no_fantasia = no_fantasia;
    }

    public String getNo_logradouro() {
        return no_logradouro;
    }

    public void setNo_logradouro(String no_logradouro) {
        this.no_logradouro = no_logradouro;
    }

    public String getNu_endereco() {
        return nu_endereco;
    }

    public void setNu_endereco(String nu_endereco) {
        this.nu_endereco = nu_endereco;
    }

    public String getNo_bairro() {
        return no_bairro;
    }

    public void setNo_bairro(String no_bairro) {
        this.no_bairro = no_bairro;
    }

    public String getNu_telefone() {
        return nu_telefone;
    }

    public void setNu_telefone(String nu_telefone) {
        this.nu_telefone = nu_telefone;
    }

    public String getCo_cep() {
        return co_cep;
    }

    public void setCo_cep(String co_cep) {
        this.co_cep = co_cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getAno_ubs_det() {
        return ano_ubs_det;
    }

    public void setAno_ubs_det(String ano_ubs_det) {
        this.ano_ubs_det = ano_ubs_det;
    }

    public String getMes_ubs_det() {
        return mes_ubs_det;
    }

    public void setMes_ubs_det(String mes_ubs_det) {
        this.mes_ubs_det = mes_ubs_det;
    }

    public String getNomeArquivo() {
        return "arquivos/ubs_funcionamentonone.csv.csv";
    }
}
