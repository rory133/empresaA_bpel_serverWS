/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.proyecto.empresaA_bpel_server.bo.Administrador_ABo;
import org.proyecto.empresaA_bpel_server.bo.impl.Administrador_ABoImpl;
import org.proyecto.empresaA_bpel_server.dao.Administrador_ADao;
import org.proyecto.empresaA_bpel_server.dao.impl.Administrador_ADaoImpl;
import org.proyecto.empresaA_bpel_server.model.ListaAdministradores_A;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "pruebaWebService")
public class pruebaWebService {

    /**
     * This is a sample web service operation
     */
    
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listadoAdministradores")
    public ListaAdministradores_A listadoAdministradores() {
        Administrador_ABo administrador=new Administrador_ABoImpl();
       ListaAdministradores_A lista=new ListaAdministradores_A();
        lista.setDataAdministrador(administrador.findAll());
	

	   return lista;
     
    }
    
    
}
