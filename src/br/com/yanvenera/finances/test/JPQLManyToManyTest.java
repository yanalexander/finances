package br.com.yanvenera.finances.test;

import br.com.yanvenera.finances.model.Account;
import br.com.yanvenera.finances.model.Category;
import br.com.yanvenera.finances.model.Transation;
import br.com.yanvenera.finances.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JPQLManyToManyTest {

    public static void main(String[] args){

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Category category = new Category();
        category.setId(1);

        String jpql = "select t from Transation t join t.categoryList c where c = :pCategory";
        Query query = em.createQuery(jpql);
        query.setParameter("pCategory",category);

        List<Transation> result = query.getResultList();

        for (Transation t :result) {
            System.out.println("Transation description: "+t.getDescription());
        }


        em.getTransaction().commit();

        em.close();
    }
}
