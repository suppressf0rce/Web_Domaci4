package servlets;


import model.User;

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

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/", "/index"})
public class LoginServlet extends HttpServlet {

    List<User> users;
    public LoginServlet(){
        super();

        users = Collections.synchronizedList(new ArrayList<User>());

        //Adding user
        User admin = new User.Builder().userName("admin").password("admin").build();
        users.add(admin);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        if(session.getAttribute("logged") !=null && session.getAttribute("logged").equals("true")){
            resp.sendRedirect("main.jsp");
        }else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        if(session.getAttribute("logged") !=null && session.getAttribute("logged").equals("true")){
            resp.sendRedirect("main.jsp");
        }

        String username = req.getParameter("username");
        String password  = req.getParameter("password");

        ;
        boolean loginStatus = false;
        for(User user:users){
            if(user.getUserName().equals(username)  && user.getPassword().equals(password))
                loginStatus = true;
        }

        if(loginStatus){
            session.setAttribute("logged","true");
            resp.sendRedirect("main.jsp");
        }else{
            resp.sendRedirect("loginFailed.jsp");
        }
    }
}
