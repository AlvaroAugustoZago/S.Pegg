package br.com.spegg.Utils;

import br.com.spegg.Construtor.Arquivo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URL;
import java.util.*;

public class UtilClass<T> {
    private Class<T> clazzOfT = getTypeParameterClass();

    public UtilClass() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    }

    @SuppressWarnings("unchecked")
    public Class<T> getTypeParameterClass() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        if (paramType.getActualTypeArguments()[0].getTypeName().equals("T")) {
            return null;
        }
        return (Class<T>) paramType.getActualTypeArguments()[0];
    }

    public T getInstance() throws Exception {
        return clazzOfT.newInstance();
    }

    public static File[] getImgs(String path) {
        File file = new File(path);
        return file.listFiles();
    }

    public Class[] getAllClass() throws ClassNotFoundException, IOException {
        String packageName = "src/" + "br.com.spegg.models".replace(".", "/");
        File f = new File(packageName);
        List<File> files = Arrays.asList(f.listFiles());
        ArrayList<Class> classes = new ArrayList<Class>();
        for (File c : files) {
            classes.addAll(findClasses(c, packageName));
        }
        return classes.toArray(new Class[classes.size()]);
    }

    private List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()) {
            return classes;
        }
        if (directory.isDirectory()) {
            assert !directory.getName().contains(".");
            classes.addAll(findClasses(directory, packageName + "." + directory.getName()));
        } else if (directory.getName().endsWith(".class")) {
            classes.add(Class.forName(directory.getPath().replace("src/", "").replace("/", ".").substring(0, directory.getPath().replace("src/", "").replace("/", ".").length() - 6)));
        } else if (directory.getName().endsWith(".java")) {
            classes.add(Class.forName(directory.getPath().replace("src/", "").replace("/", ".").substring(0, directory.getPath().replace("src/", "").replace("/", ".").length() - 5)));
        }
        return classes;
    }

    public String getNomeArquivo() throws Exception {
        T obj = getInstance();
        Method nomeArquivo = clazzOfT.getMethod("getNomeArquivo");
        return (String) nomeArquivo.invoke(obj);
    }

    public Class getClassOfInstance(String arquivoCSV, String[] cabecalho) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class[] classes = getAllClass();
        for (int i = 0; i < classes.length; i++) {
            Class c = classes[i];
            Object obj = c.newInstance();
            for (Method mt : c.getMethods()) {
                if (mt.getName().equals("isArquivo")) {
                    if ((Boolean) mt.invoke(obj, arquivoCSV, cabecalho)) {
                        return classes[i];
                    }
                }
            }

        }
        return null;
    }

    public Boolean isAArquivo(String arquivoCSV, String[] cabecalho) throws IllegalAccessException, InstantiationException, IOException, ClassNotFoundException, InvocationTargetException {
        Class[] classes = getAllClass();
        for (int i = 0; i < classes.length; i++) {
            Class c = classes[i];
            Object obj = c.newInstance();
            for (Method mt : c.getMethods()) {
                if (mt.getName().equals("isArquivo")) {
                    return (Boolean) mt.invoke(obj, arquivoCSV, cabecalho);
                }
            }
        }
        return false;
    }
}
