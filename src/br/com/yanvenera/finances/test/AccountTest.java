package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AccountTest {

    public static void main(String[] args){

        Account account = new Account();
        account.setAccount("123456");
        account.setBank("Santander");
        account.setBranch("0101");
        account.setHolder("Mr. Johnson");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("finances");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
