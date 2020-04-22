/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brkic.milos.fon.fisweb.listener;

import brkic.milos.fon.fisweb.domen.Department;
import brkic.milos.fon.fisweb.domen.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author milos
 */
public class ContextListener implements ServletContextListener  {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
       //dodaj pocetne korisnike
       sce.getServletContext().setAttribute("users", createUsers());
       
       //inicijalizuj listu departmenta
       sce.getServletContext().setAttribute("departments", new ArrayList<Department>());
    }
 
    private List<User> createUsers(){
        return new ArrayList<User>(){
            {
                add(new User("pera","peric", "pera@gmail.com", "pera"));
                add(new User("milos","brkic", "milos@gmail.com", "milos"));
                add(new User("jovan","jovanic", "jovan@fon.rs", "jovan"));
            }
        };
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {        
    }
}
