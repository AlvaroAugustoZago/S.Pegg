package br.com.spegg.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAConnection {
    private EntityManagerFactory conexao;

    private EntityManagerFactory conectar() {
        try {
            if (conexao != null && conexao.isOpen()) {
                return conexao;
            }
        } catch (Exception e) {
        }
        conexao = Persistence.createEntityManagerFactory("SENAI"); //deve conter aqui a informação do atributo name da tag <persistence­unit>

        return conexao;
//EntityManager em = conexao.createEntityManager();
    }

    // este método será o nosso createdStatement
    public EntityManager getEntityManager() {
        return conectar().createEntityManager();
    }

    // este método será o nosso prepareStatement
    public Query getQuery(String jpql) {
        return this.getEntityManager().createQuery(jpql);
    }

    // este método será uma junção de prepareStatementGerandoId, e dos     nossos inserts
    public void incluir(Object o) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
        em.close();
    }
}