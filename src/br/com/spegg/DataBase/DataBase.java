package br.com.spegg.DataBase;

import br.com.spegg.Construtor.Construtor;
import br.com.spegg.Utils.UtilClass;
import br.com.spegg.models.UBSConstrucao;
import br.com.spegg.models.UBSEquipes;
import br.com.spegg.models.UBSExistentes;
import br.com.spegg.models.UBSFuncionamento;

import java.io.*;
import java.util.List;


public class DataBase {

    public List run() throws Exception {
        File[] nomes = UtilClass.getImgs("arquivos");
        List objs = null;
        for (File arquivo : nomes) {
            if (arquivo.getName().toLowerCase().contains("arquivo")) {
                continue;
            }
            String arquivoCSV = arquivo.getPath();
            BufferedReader br = null;
            Construtor construtor = new Construtor();
            try {
                br = new BufferedReader(new FileReader(arquivoCSV));
                System.out.println("Lendo o Arquivo:" + arquivoCSV);
                String[] cabecalho = br.readLine().split(new Construtor().csvDivisor);
                objs = construtor.montaObj(br, cabecalho, arquivoCSV);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return objs;
    }


}
