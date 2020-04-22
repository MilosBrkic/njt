/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brkic.milos.fon.fisweb.action;

import brkic.milos.fon.fisweb.domen.Department;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author milos
 */
public class DeleteDepartmentAction extends AbstractAction{

    @Override
    public String execute(HttpServletRequest request) {
               
        long id;
        ArrayList<Department> departments = (ArrayList<Department>) request.getServletContext().getAttribute("departments");
        
        try{
            String sid = request.getPathInfo().split("/")[2];
            id = Long.parseLong(sid);

            for(Department d : departments)
                if(d.getId() == id){
                    departments.remove(d);
                    request.setAttribute("message", "Department deleted!");
                    return "/WEB-INF/pages/departments.jsp";
                }            
       }
       catch(Exception e){ 
           System.err.println(e.getMessage());
       } 
    
       request.setAttribute("message", "Error");
       return "/WEB-INF/pages/departments.jsp";
    }
    
}
