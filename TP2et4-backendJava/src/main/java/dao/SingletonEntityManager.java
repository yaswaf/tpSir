package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by othmane on 24/01/2018.
 */
public class SingletonEntityManager  {

    private static EntityManager firstInstance=null;


    private SingletonEntityManager(){};

    public static EntityManager getInstance(){

        if(firstInstance == null){

            EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
             firstInstance = factory.createEntityManager();
        }
        System.out.print("null");
        return firstInstance;

    }
}
