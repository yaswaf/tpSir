package servlet;

import Entities.Personne;
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
@WebServlet(name="userinfo",
        urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonDAO dao = new PersonDAO();
        Personne p=new Personne();
        p.setNom(request.getParameter("nom"));
        p.setPrenom(request.getParameter("prenom"));
        p.setMail(request.getParameter("email"));

        dao.create(p);
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        PersonDAO dao = new PersonDAO();
        List<Personne> list=dao.readAll();

        out.println("<HTML> <HEAD>  <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" /> \n<BODY>\n");
        out.println( "<div class=\"col-md-8\">");
        out.println( "<table class=\"table table-info\">");
        out.println("<thead><tr><th class=\"align-middle\">Firstname</th><th class=\"align-middle\">Lastname</th>");
        out.println("<th class=\"align-middle\">Email</th></tr></thead>");
        out.println( "<tbody>");
        for (Personne pers: list
                ) {
            out.println("<tr>");
            out.println("<td>");
            out.println(pers.getPrenom());
            out.println("</td>");

            out.println("<td>");
            out.println(pers.getNom());
            out.println("</td>");

            out.println("<td>");
            out.println(pers.getMail());
            out.println("</td>");

            out.println("</tr>");
        }
        out.println( "</tbody>");
        out.println( "</table>");
        out.println( "<a href=\"http://localhost:8080/\">Retour</a>");
        out.println( "</div>");
        out.println("</BODY></HTML>");

    }
}
