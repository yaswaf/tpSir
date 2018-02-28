package dao;

import Entities.Home;
import Entities.Personne;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HomeDAO implements GenericDao<Home,Long>{

	public Home create(Home t) {
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
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

	public Home read(Long id) {
		return SingletonEntityManager.getInstance().find(Home.class, id);
	}

	public Home update(Home t) {
		return SingletonEntityManager.getInstance().merge(t);
	}

	public void delete(Home t) {
		SingletonEntityManager.getInstance().remove(t);
		
	}

	public List<Home> readAll() {
		return SingletonEntityManager.getInstance().createQuery("select h from Home as h").getResultList();
	}

}
