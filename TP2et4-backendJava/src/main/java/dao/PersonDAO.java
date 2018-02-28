package dao;

import java.util.List;

import Entities.Personne;
import Entities.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonDAO implements GenericDao<Personne, Long> {


    public Personne create(Personne o) {
        /*EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(o);
        transaction.commit();*/
        //SingletonEntityManager.getInstance().getTransaction().begin();
        //SingletonEntityManager.getInstance().persist(o);
        //SingletonEntityManager.getInstance().getTransaction().commit();
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
        return o;
    }

    public Personne read(Long id) {
        return SingletonEntityManager.getInstance().find(Personne.class, id);
    }

    public List<Personne> readByName(String name) {
        return  SingletonEntityManager.getInstance().createQuery("select p from Personne as p where p.nom = :name").setParameter("name", name).getResultList();
    }


    public List<Personne> readAll() {
        return  SingletonEntityManager.getInstance().createQuery("Select p from Personne as p").getResultList();
    }

    public Personne update(Personne t) {
        return  SingletonEntityManager.getInstance().merge(t);
    }

    public void delete(Personne t) {
        SingletonEntityManager.getInstance().remove(t);

    }

    List<Personne> getByMailDomain(String domain) {
        return  SingletonEntityManager.getInstance().createQuery("select p from Personne as p where p.mail like '%.'+:domain").setParameter(domain,domain).getResultList();
    }




}