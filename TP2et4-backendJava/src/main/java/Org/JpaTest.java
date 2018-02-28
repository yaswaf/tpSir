
package Org;



import Entities.*;
import dao.ElectronicDeviceDAO;
import dao.HeaterDAO;
import dao.HomeDAO;
import dao.PersonDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * @param args
     */
    /*public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {


            Personne p = new Personne();
			p.setMail("o.wafi@uhp.ac.ma");
			p.setNom("Wafi");
			p.setPrenom("Othmane");
			manager.persist(p);




        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";

//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin");
//		List<Person> res = q.getResultList();

//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());

        manager.close();
        factory.close();
    }*/
    public static void main(String[] args) {


        PersonDAO dao = new PersonDAO();
        Personne p = new Personne();
        p.setNom("toto");
        p.setMail("toto@gmail.com");
        p.setPrenom("tata");

        HomeDAO daoh =new HomeDAO();
        Home home =new Home();
        home.setNbPieces(2);
        home.setPersonne(p);
        HeaterDAO hdao= new HeaterDAO();
        Heater heater= new Heater();
        ElectronicDeviceDAO edao=new ElectronicDeviceDAO();
        ElectronicDevice device=new ElectronicDevice();
        device.setHome(home);
        heater.setHome(home);
        heater.setPersonne(p);
        device.setPersonne(p);
//
        dao.create(p);
        daoh.create(home);
        edao.create(device);
        hdao.create(heater);

    }



}
