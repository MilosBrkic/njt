/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brkic.milos.fon.fisweb.action;

import brkic.milos.fon.fisweb.domen.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author milos
 */
public class LoginAction extends AbstractAction{
    
    @Override
    public String execute(HttpServletRequest request) {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
                     
        User user = findUser(request, email, password);
        if (user==null){
            request.setAttribute("message", "User does not exist!");
            return "/login.jsp";
        }else{          
            request.getSession(true).setAttribute("loginUser", user);
            return "/WEB-INF/pages/home.jsp";
        }
    }

    private User findUser(HttpServletRequest request, String email, String password) {
        List<User> users = (List<User>) request.getServletContext().getAttribute("users");
            
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))               
                return user;            
        }
        return null;
    }
    
}
