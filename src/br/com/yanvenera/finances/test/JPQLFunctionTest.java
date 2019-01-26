package br.com.yanvenera.finances.test;

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

        String jpql = "select sum(t.value) from Transation t where t.account = :pAccount " +
                " group by day(t.date), month(t.date), year(t.date)";
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        query.setParameter("pAccount",account);

        List<BigDecimal> somas = (List<BigDecimal>) query.getResultList();

        for (BigDecimal soma :somas) {
            System.out.println("A soma é: "+soma);
        }

        em.close();
    }
}
