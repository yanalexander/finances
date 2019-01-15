package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;

public class AccountSupplement {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        Account acc1 = new Account();
        Account acc2 = new Account();
        Account acc3 = new Account();
        Account acc4 = new Account();
        Account acc5 = new Account();

        acc1.setBank("001 - BANCO DO BRASIL");
        acc1.setAccount("16987-8");
        acc1.setBranch("6543");
        acc1.setHolder("Maria dos Santos");

        acc2.setBank("237 - BANCO BRADESCO");
        acc2.setAccount("86759-1");
        acc2.setBranch("1745");
        acc2.setHolder("Paulo Roberto Souza");

        acc3.setBank("341 - BANCO ITAU UNIBANCO");
        acc3.setAccount("46346-3");
        acc3.setBranch("4606");
        acc3.setHolder("Antonio Duraes");

        acc4.setBank("033 - BANCO SANTANDER");
        acc4.setAccount("12345-6");
        acc4.setBranch("9876");
        acc4.setHolder("Leandra Marques");

        acc5.setBank("341 - BANCO ITAU UNIBANCO");
        acc5.setAccount("98654-3");
        acc5.setBranch("1234");
        acc5.setHolder("Alexandre Duarte");

        // persistindo as contas
        manager.persist(acc1);
        manager.persist(acc2);
        manager.persist(acc3);
        manager.persist(acc4);
        manager.persist(acc5);

        manager.getTransaction().commit();

        manager.close();

    }
}
