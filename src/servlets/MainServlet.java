package servlets;

import model.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns = "/main")
public class MainServlet extends HttpServlet{

    List<Contact> contactList;

    public MainServlet(){
        contactList =  Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);

        if(session.getAttribute("logged") !=null && session.getAttribute("logged").equals("true")){

            //Korisnik je logovan mozemo da proveravamo parametre
            String add = req.getParameter("add");
            String list = req.getParameter("list");

            //Korisnik dodaje kontakt
            if(add !=null){

                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String phoneNumber = req.getParameter("phoneNumber");

                Contact contact = new Contact.Builder()
                        .firstName(firstName)
                        .lastName(lastName)
                        .phoneNumber(phoneNumber).build();

                contactList.add(contact);

                resp.sendRedirect("mainAdded.jsp");

            }

            //Korisnik lista
            if(list != null){

                StringBuilder contacts = new StringBuilder();

                for(Contact contact:contactList){
                    contacts.append("<p>");
                    contacts.append(contact.toString());
                    contacts.append("</p>");
                }

                req.setAttribute("contacts", contacts.toString());
                req.getRequestDispatcher("main.jsp").forward(req,resp);

            }


        }else{
            resp.sendRedirect("login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
