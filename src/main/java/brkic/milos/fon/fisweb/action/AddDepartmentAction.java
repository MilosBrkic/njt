/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brkic.milos.fon.fisweb.action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author milos
 */
public class AddDepartmentAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {               
        return "/WEB-INF/pages/new.jsp";
    }
    
}
