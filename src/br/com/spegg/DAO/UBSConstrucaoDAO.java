package br.com.spegg.DAO;

import br.com.spegg.JPA.JPAConnection;
import br.com.spegg.models.UBSConstrucao;

import java.util.List;

public class UBSConstrucaoDAO extends JPAConnection {

    public void incluir(List<UBSConstrucao> construcao) {
        for (UBSConstrucao constr: construcao) {
            synchronized (constr) {
                System.out.println("persistindo obj:" + constr.getNo_cidade() + " do " + constr.getNomeArquivo());
                super.incluir(constr);
            }

        }
    }

}
