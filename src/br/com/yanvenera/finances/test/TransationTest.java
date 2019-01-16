package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.model.Transation;
import br.com.yanvenera.finances.model.TransationType;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Calendar;

public class TransationTest {

    public static void main(String[] args){

        Account account = new Account();
        account.setAccount("987654");
        account.setBank("BANCO DO BRAZA");
        account.setBranch("1242");
        account.setHolder("Teste");

        Transation transation = new Transation();
        transation.setDate(Calendar.getInstance());
        transation.setDescription("Primeira movimentação");
        transation.setTipo(TransationType.SAIDA);
        transation.setValue(new BigDecimal("250.5"));
        transation.setAccount(account);

        EntityManager em = new JPAUtil().getEntityManager();

        em.getTransaction().begin();

        em.persist(account);
        em.persist(transation);

        em.getTransaction().commit();

        em.close();
    }
}
