package merveozer.multipledb.primary.repository;

import merveozer.multipledb.helper.EntityManagerLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AgeAverageEntityManager {
    @Autowired
    private EntityManagerLocator entityManagerLocator;

    @Transactional("primaryTransactionManager")
    public void calculateAgeAverage(){
        EntityManager entityManager = entityManagerLocator.getEntityManager("primaryEntityManagerFactory");
        EntityTransaction transactionManager = entityManager.getTransaction();
        transactionManager.begin();
        String query = "INSERT INTO age_average (age_avg) SELECT AVG(age) from user_info";
        entityManager.createNativeQuery(query).executeUpdate();
        transactionManager.commit();
    }
}
