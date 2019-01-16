package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.model.Category;
import br.com.yanvenera.finances.model.Transation;
import br.com.yanvenera.finances.model.TransationType;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TransactionTesteWithCategory {

    public static void main(String[] args) {

        Category cat1 = new Category();
        cat1.setDescription("Travel");

        Category cat2 = new Category();
        cat2.setDescription("Business");

        Account account = new Account();
        account.setAccount("321654");
        account.setBank("VIACRED");
        account.setBranch("1010");
        account.setHolder("John Lennon");

        Transation t1 = new Transation();
        t1.setDate(Calendar.getInstance());
        t1.setDescription("Travel to Business in SP");
        t1.setTipo(TransationType.SAIDA);
        t1.setValue(new BigDecimal("100.0"));
        t1.setCategoryList(Arrays.asList(cat1,cat2));
        t1.setAccount(account);

        Transation t2 = new Transation();
        t2.setDate(Calendar.getInstance());
        t2.setDescription("Holiday in BA");
        t2.setTipo(TransationType.SAIDA);
        t2.setValue(new BigDecimal("558.0"));
        t2.setCategoryList(Arrays.asList(cat1));
        t2.setAccount(account);

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        em.persist(cat1);
        em.persist(cat2);
        em.persist(account);
        em.persist(t1);
        em.persist(t2);

        em.getTransaction().commit();

        em.close();


    }
}
