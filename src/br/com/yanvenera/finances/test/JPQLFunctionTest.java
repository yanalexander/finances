package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.dao.TransationDAO;
import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.model.Transation;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class JPQLFunctionTest {

    public static void main(String[] args){

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Account account = new Account();
        account.setId(8);

        TransationDAO transationDao = new TransationDAO(em);
        List<BigDecimal> somas = transationDao.getSomaPorDia(account);

        for (BigDecimal soma :somas) {
            System.out.println("A soma é: "+soma);
        }

        em.close();
    }
}
