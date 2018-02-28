package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.Heater;


public class HeaterDAO implements GenericDao<Heater,Long> {

	public Heater create(Heater t) {
	    /* EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	        EntityManager manager = factory.createEntityManager();
	        EntityTransaction transaction = manager.getTransaction();
	        transaction.begin();
	        manager.persist(t);
	        transaction.commit();*/

		EntityManagerHelper.getEntityManager().getTransaction().begin();
		EntityManagerHelper.getEntityManager().persist(t);
		EntityManagerHelper.getEntityManager().getTransaction().commit();

	        return t;
	}

	public Heater read(Long id) {
		return SingletonEntityManager.getInstance().find(Heater.class, id);
		
	}

	public Heater update(Heater t) {
		return SingletonEntityManager.getInstance().merge(t);
	}

	public void delete(Heater t) {
		SingletonEntityManager.getInstance().remove(t);
		
	}





}
