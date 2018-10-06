package br.com.spegg.DataBase;

import br.com.spegg.models.UBSConstrucao;
import br.com.spegg.models.UBSExistentes;
import br.com.spegg.models.UBSFuncionamento;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataBase<T> {

    public List<T> run(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        File[] nomes = getImgs("arquivos");
        List<T> objs = new ArrayList<T>();

        for (File arquivo : nomes) {
            String arquivoCSV = arquivo.getPath();
            BufferedReader br = null;
            String linha = "";
            String csvDivisor = ",";
            try {

                br = new BufferedReader(new FileReader(arquivoCSV));
                while ((linha = br.readLine()) != null) {
                    T obj = clazz.newInstance();
                    String[] data = linha.split(csvDivisor);
                    List<String> list = Arrays.asList(data);
                    if (!list.isEmpty() && list.size() > 0) {
                        if (list.contains("gid")) {
                            continue;
                        }
                        if (obj instanceof UBSConstrucao && ((UBSConstrucao) obj).getNomeArquivo().equals(arquivoCSV)) {
                            ((UBSConstrucao) obj).setNo_cidade(data[0]);
                            ((UBSConstrucao) obj).setNomeCidade(data[1]);
                            ((UBSConstrucao) obj).setTaxa(data[2]);
                            ((UBSConstrucao) obj).setValor(data[3]);
                            objs.add(obj);
                        } else if (obj instanceof UBSExistentes && ((UBSExistentes) obj).getNomeArquivo().equals(arquivoCSV)) {
                            ((UBSExistentes) obj).setNo_cidade(data[0]);
                            ((UBSExistentes) obj).setNomeCidade(data[1]);
                            ((UBSExistentes) obj).setTaxa(data[2]);
                            ((UBSExistentes) obj).setValor(data[3]);
                            objs.add(obj);
                        } else if (obj instanceof UBSFuncionamento && ((UBSFuncionamento) obj).getNomeArquivo().equals(arquivoCSV)) {
                            ((UBSFuncionamento) obj).setCodCnes(data[0]);
                            ((UBSFuncionamento) obj).setLat(data[1]);
                            ((UBSFuncionamento) obj).setLongi(data[2]);
                            ((UBSFuncionamento) obj).setNo_fantasia(data[3]);
                            ((UBSFuncionamento) obj).setNo_logradouro(data[4]);
                            ((UBSFuncionamento) obj).setNu_endereco(data[5]);
                            ((UBSFuncionamento) obj).setNo_bairro(data[6]);
                            ((UBSFuncionamento) obj).setNu_telefone(data[7]);
                            ((UBSFuncionamento) obj).setCo_cep(data[8]);
                            ((UBSFuncionamento) obj).setUf(data[9]);
                            ((UBSFuncionamento) obj).setCidade(data[10]);
                            ((UBSFuncionamento) obj).setAno_ubs_det(data[11]);
                            ((UBSFuncionamento) obj).setMes_ubs_det(data[12]);
                            objs.add(obj);
                        }
                    }

                }

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

    public static File[] getImgs(String path) {
        File file = new File(path);
        return file.listFiles();
    }

}
