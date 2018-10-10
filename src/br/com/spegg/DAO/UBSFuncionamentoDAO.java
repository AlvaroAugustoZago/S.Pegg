package br.com.spegg.DAO;

import br.com.spegg.JPA.JPAConnection;
import br.com.spegg.models.UBSFuncionamento;

import java.util.List;

public class UBSFuncionamentoDAO extends JPAConnection {

    public void incluir(List<UBSFuncionamento> funcionamentos) {
        for (UBSFuncionamento constr : funcionamentos) {
            synchronized (constr) {
                System.out.println("persistindo obj:" + constr.getCidade() + " do " + constr.getNomeArquivo());
                super.incluir(constr);
            }

        }
    }

}
