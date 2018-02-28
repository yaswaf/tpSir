package rest;
import Entities.ElectronicDevice;
import Entities.Heater;
import dao.*;

/**
 * Created by othmane on 24/01/2018.
 */
import Entities.Home;
import Entities.Personne;
import dao.SingletonEntityManager;

import javax.annotation.PostConstruct;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
public class PersonRest {



    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Personne getPersonneById(@PathParam("id") Long id) {
        PersonDAO personDAO=new PersonDAO();
        return  personDAO.read(id);
    }


//    @GET
//    @Path("/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Personne> getPersonneByName(@PathParam("name") String name) {
//        PersonDAO personDAO=new PersonDAO();
//        return  personDAO.readByName(name);
//    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersonnes() {
        PersonDAO personDAO=new PersonDAO();
        return  personDAO.readAll();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPersonInJSON(Personne personne) {
        PersonDAO personDAO=new PersonDAO();
        personDAO.create(personne);
        String result = "Person saved : " +personne;
        return Response.status(201).entity(result).build();

    }

}
