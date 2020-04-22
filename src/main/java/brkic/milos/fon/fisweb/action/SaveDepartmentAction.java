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
public class SaveDepartmentAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        String shortname = request.getParameter("shortname");
        String name = request.getParameter("name");      
        
        long id = 0;
        
        ArrayList<Department> departments = (ArrayList<Department>) request.getServletContext().getAttribute("departments");
        
        //kada se vrsi izmena
        if(request.getParameter("id")!= null){
            id = Long.parseLong(request.getParameter("id"));
            for(Department d : departments)
                if(d.getId() == id){
                    d.setName(name);
                    d.setShortname(shortname);
                                    
                    return "/WEB-INF/pages/departments.jsp";
                }            
        }
                  
        if(!departments.isEmpty())
        for(int i = 0; i< departments.size(); i++) 
            id = departments.get(i).getId();
       
        id++;
        
        Department dep = new Department(id, shortname, name);
        departments.add(dep);
        
        request.setAttribute("message", "Department saved!");
                      
        return "/WEB-INF/pages/new.jsp";
    }
    
}
