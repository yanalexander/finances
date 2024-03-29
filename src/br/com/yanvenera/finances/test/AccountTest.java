package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;

public class AccountTest {

    public static void main(String[] args){

        Account account = new Account();
        account.setAccount("123456");
        account.setBank("Santander");
        account.setBranch("0101");
        account.setHolder("Mr. Johnson");

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();

        em.close();
    }
}
