package rest;

/**
 * Created by othmane on 24/01/2018.
 */
import Entities.Heater;
import Entities.Home;
import dao.HomeDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/home")
public class HomeRest {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Entities.Home getHome(@PathParam("id") Long id) {
        HomeDAO homeDAO=new HomeDAO();
        return  homeDAO.read(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entities.Home> getHomes() {
        HomeDAO homeDAO=new HomeDAO();
        return homeDAO.readAll();
    }


    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Home home) {
        HomeDAO homeDAO=new HomeDAO();
        homeDAO.create(home);
        String result = "Home saved : " +home;
        return Response.status(201).entity(result).build();

    }

}
