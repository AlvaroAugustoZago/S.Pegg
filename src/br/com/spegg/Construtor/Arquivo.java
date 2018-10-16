package br.com.spegg.Construtor;

import br.com.spegg.Utils.UtilClass;
import br.com.spegg.models.UBSConstrucao;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class Arquivo<T> extends UtilClass<T> {

    public Arquivo() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    }

    public boolean isArquivo(String nomeArquivo, String[] cabecalho) throws Exception {
        T obj = getInstance();
        List<String> c =  getCampos(obj);
        if (!c.isEmpty()) {
            final Set<String> uniqueStrSet = new HashSet<String>(Arrays.asList(cabecalho));
            uniqueStrSet.remove("gid");
            ArrayList cab = new ArrayList<String>(uniqueStrSet);
            return cab.retainAll(c) && nomeArquivo.contains(getNomeArquivo());
        } else {
            return false;
        }
    }


    public List<String> getCampos(T obj) {
        List<String> c = new ArrayList<>();
        Field[] campos = obj.getClass().getDeclaredFields();
        for (Field campo : campos) {
            c.add(campo.getName());
        }
        return c;
    }

}
