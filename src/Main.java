import br.com.spegg.DataBase.DataBase;
import br.com.spegg.models.UBSConstrucao;
import br.com.spegg.DAO.UBSConstrucaoDAO;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        DataBase<UBSConstrucao> dataBase = new DataBase();
        List<UBSConstrucao> ubsConstrucao = new ArrayList<UBSConstrucao>();
        ubsConstrucao = dataBase.run(UBSConstrucao.class);
        UBSConstrucaoDAO ubsConstrucaoDAO = new UBSConstrucaoDAO();
        ubsConstrucaoDAO.incluir(ubsConstrucao);
    }
}
