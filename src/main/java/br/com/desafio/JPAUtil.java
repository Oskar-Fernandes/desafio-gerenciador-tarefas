package br.com.desafio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("tarefas-pu");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
