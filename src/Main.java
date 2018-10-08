import br.com.spegg.DataBase.DataBase;
import br.com.spegg.models.UBSConstrucao;
import br.com.spegg.models.UBSExistentes;
import br.com.spegg.models.UBSFuncionamento;
import br.com.spegg.DAO.UBSConstrucaoDAO;
import br.com.spegg.DAO.UBSExistentesDAO;
import br.com.spegg.DAO.UBSFuncionamentoDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
    	
//        DataBase<UBSConstrucao> dataBase = new DataBase();
//        List<UBSConstrucao> ubsConstrucao = new ArrayList<UBSConstrucao>();
//        ubsConstrucao = dataBase.run(UBSConstrucao.class);
//        UBSConstrucaoDAO ubsConstrucaoDAO = new UBSConstrucaoDAO();
//        ubsConstrucaoDAO.incluir(ubsConstrucao);
        
//        DataBase<UBSExistentes> dataBase1 = new DataBase();
//        List<UBSExistentes> ubsExistentes = new ArrayList<UBSExistentes>();
//        ubsExistentes = dataBase1.run(UBSExistentes.class);
//        UBSExistentesDAO ubsExistentesDAO = new UBSExistentesDAO();
//        ubsExistentesDAO.incluir(ubsExistentes);
        
        DataBase<UBSFuncionamento> dataBase2 = new DataBase();
        List<UBSFuncionamento> ubsFuncionamentos = new ArrayList<UBSFuncionamento>();
        ubsFuncionamentos = dataBase2.run(UBSFuncionamento.class);
        UBSFuncionamentoDAO ubsFuncionamentoDAO = new UBSFuncionamentoDAO();
        ubsFuncionamentoDAO.incluir(ubsFuncionamentos);
        
    }
}
