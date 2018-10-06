package br.com.spegg.DAO;

import br.com.spegg.JPA.JPAConnection;
import br.com.spegg.models.UBSConstrucao;

import java.util.List;

public class UBSConstrucaoDAO extends JPAConnection {

    public void incluir(List<UBSConstrucao> construcao) {
        for (UBSConstrucao constr: construcao) {
            synchronized (constr) {
                super.incluir(constr);
            }

        }
    }

}
