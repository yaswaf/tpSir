package servlet;

import Entities.Home;
import Entities.Personne;
import dao.HomeDAO;
import dao.PersonDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by othmane on 22/01/2018.
 */
@WebServlet(name="homeinfo",
        urlPatterns={"/HomeInfo"})
public class HomeInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeDAO hdao=new HomeDAO();
        Home h=new Home();

        h.setNbPieces(new Integer(request.getParameter("nbPieces")));
        h.setTaille(new Double(request.getParameter("taille")));
        PersonDAO dao=new PersonDAO();
        h.setPersonne(dao.read(new Long(request.getParameter("personid"))));
        hdao.create(h);
        this.doGet(request,response);



    }



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        PersonDAO dao = new PersonDAO();
        List<Personne> list=dao.readAll();
        out.println("<HTML> <HEAD> <title>Home</title> <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" /> \n <HEAD> <BODY>\n");
   out.println(" <div class=\"container\">");
   out.println( "<a href=\"http://localhost:8080/\">Formulaire Personne</a>");
   out.println(" <div class=\"offset-2 col-md-5\">");
   out.println("  <div class=\"form-area\">");
   out.println("   <form role=\"form\" Method=\"POST\" Action=\"/HomeInfo\">");
   out.println("  <br style=\"clear:both\">");

   out.println("  <h3 style=\"margin-bottom: 25px; text-align: center;\">Formulaire Home</h3>");

   out.println(" <div class=\"form-group \">");
   out.println(" <input type=\"number\" class=\"form-control\" id=\"nbPieces\" name=\"nbPieces\" placeholder=\"Nombres Pieces\" required>");
   out.println(" </div>");

   out.println(" <div class=\"form-group \">");
   out.println(" <input type=\"number\" class=\"form-control\" id=\"taille\" name=\"taille\" placeholder=\"Taille\" required>");
   out.println(" </div>");


   out.println(" <div class=\"form-group \">");
   out.println("<select class=\"form-control\" id=\"personid\" name=\"personid\">");

        for (Personne p: list
             ) {
            out.println(" <option value='"+p.getId()+"'>");
            out.println(""+p.getNom()+" "+p.getPrenom());
            out.println("</option>");

        }

   out.println("</select>");
   out.println("</div>");






   out.println(" <button type=\"submit\" id=\"submit\" name=\"submit\" class=\"btn btn-primary align-content-center\">Envoyer</button>");
   out.println("</form>");
   out.println("</div>  </div>  </div>");

   out.println("</BODY></HTML>");


    }
}
