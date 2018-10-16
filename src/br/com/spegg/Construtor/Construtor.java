package br.com.spegg.Construtor;

import br.com.spegg.Utils.UtilClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Construtor<T> extends UtilClass<T> {

    private String linha = "";
    public String csvDivisor = ",";


    public Construtor() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    }

    public ArrayList<Object> montaObj(BufferedReader br, String[] cabecalho, String arquivoCSV) throws Exception {
        ArrayList<Object> objs = new ArrayList<Object>();
        HashMap<String, String> campo = new HashMap<>();
        while ((linha = br.readLine()) != null) {
            String[] data = linha.split(csvDivisor);
            List<String> list = Arrays.asList(data);
            if (!list.isEmpty() && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    campo.put(cabecalho[i], list.get(i));
                }
                objs.add(setMetods(campo, arquivoCSV, cabecalho));
            }
        }
        return objs;
    }

    public Object setMetods(HashMap<String, String> campo, String arquivoCSV, String[] cabecalho) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class c = getTypeParameterClass();
        if (c == null) {
            c = getClassOfInstance(arquivoCSV, cabecalho);
        }
        Object obj = c.newInstance();
        for (Method m : c.getDeclaredMethods()) {
            if (!m.getName().startsWith("set")) {
                continue;
            }
            try {
                for (String key : campo.keySet()) {
                    if (m.getName().toLowerCase().contains(key.toLowerCase())) {
                        m.invoke(obj, campo.get(key).replaceAll("\"", ""));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

}
