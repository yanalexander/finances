package br.com.yanvenera.finances.dao;

import br.com.yanvenera.finances.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class TransationDAO {

    private EntityManager em;

    public TransationDAO(EntityManager em) {
        this.em = em;
    }

    public List<BigDecimal> getSomaPorDia(Account account) {
        String jpql = "select sum(t.value) from Transation t where t.account = :pAccount " +
                " group by day(t.date), month(t.date), year(t.date)";
        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        query.setParameter("pAccount",account);

        return query.getResultList();
    }
}
