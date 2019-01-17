package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.model.Transation;
import br.com.yanvenera.finances.util.JPAUtil;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JPQLTest {

    public static void main(String[] args){

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Account account = new Account();
        account.setId(8);

        String jpql = "select t from Transation t where t.account = :pAccount " +
                "order by t.description";
        Query query = em.createQuery(jpql);
        query.setParameter("pAccount",account);

        List<Transation> result = query.getResultList();

        for (Transation t :result) {
            System.out.println("Transation description: "+t.getDescription());
        }


        em.getTransaction().commit();

        em.close();
    }
}
