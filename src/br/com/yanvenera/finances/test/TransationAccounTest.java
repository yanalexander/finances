package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.model.Category;
import br.com.yanvenera.finances.model.Transation;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TransationAccounTest {

    public static void main(String[] args){

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();


        Transation transation = em.find(Transation.class, 8);
        Account account = transation.getAccount();

        System.out.println(account.getTransationList().size());

        em.close();
    }
}
