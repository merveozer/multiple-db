package merveozer.multipledb.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Component
public class EntityManagerLocator {
    @Autowired
    @Qualifier("primaryEntityManagerFactory")
    EntityManagerFactory primaryEntityManager;

    @Autowired
    @Qualifier("secondaryEntityManagerFactory")
    EntityManagerFactory secondaryEntityManager;

    public EntityManager getEntityManager(String enviroment) {
        EntityManagerFactory entityManager = null;
        if(enviroment.equals("primaryEntityManagerFactory")) {
            entityManager = primaryEntityManager;
        }
        else if(enviroment.equals("secondaryEntityManagerFactory")) {
            entityManager = secondaryEntityManager;
        }
        return entityManager.createEntityManager();
    }
}
