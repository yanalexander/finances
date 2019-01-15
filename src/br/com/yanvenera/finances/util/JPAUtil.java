package br.com.yanvenera.finances.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory eom = Persistence.createEntityManagerFactory("finances");

    public EntityManager getEntityManager(){
        return eom.createEntityManager();
    }

}
