package br.com.spegg.DAO;

import br.com.spegg.JPA.JPAConnection;
import br.com.spegg.models.UBSExistentes;

import java.util.List;

public class UBSExistentesDAO extends JPAConnection {

    public void incluir(List<UBSExistentes> existentes) {
        for (UBSExistentes constr: existentes) {
            synchronized (constr) {
                System.out.println("persistindo obj:" + constr.getNo_cidade());
                super.incluir(constr);
            }

        }
    }
}
