package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;

public class FindAccount {

    public static void main(String[] args){

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Account account = em.find(Account.class, 1);

        account.setHolder("Jarbas");
        account.setBranch("15487");

        em.getTransaction().commit();

    }
}
