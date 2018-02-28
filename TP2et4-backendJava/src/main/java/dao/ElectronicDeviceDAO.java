package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.ElectronicDevice;


public class ElectronicDeviceDAO implements GenericDao<ElectronicDevice,Long> {

	public ElectronicDevice create(ElectronicDevice t) {
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

	public ElectronicDevice read(Long id) {
		return SingletonEntityManager.getInstance().find(ElectronicDevice.class, id);
	}

	public ElectronicDevice update(ElectronicDevice t) {
		return SingletonEntityManager.getInstance().merge(t);
	}

	public void delete(ElectronicDevice t) {
		SingletonEntityManager.getInstance().remove(t);
		
	}

}
