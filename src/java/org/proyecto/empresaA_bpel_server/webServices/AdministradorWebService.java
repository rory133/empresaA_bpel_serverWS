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
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.ListaAdministradores_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "AdministradorWebService")
public class AdministradorWebService {


    /**
     * listamos todos los administradores
     */
    @WebMethod(operationName = "listadoAdministradores")
    public ListaAdministradores_A listadoAdministradores() {
      
        Administrador_ABo administrador=new Administrador_ABoImpl();
        ListaAdministradores_A lista=new ListaAdministradores_A();
        lista.setDataAdministrador(administrador.findAll());
      return lista;
    }

    /**
     * Bucamos un administraor por su id
     */
    @WebMethod(operationName = "administradorXid")
    public Administrador_A administradorXid(@WebParam(name = "id") String id) {
        Administrador_ABo administrador=new Administrador_ABoImpl(); 
	Administrador_A adminTemp=administrador.findByAdministrador_AIdAdministrador_a(id);		
		
	return adminTemp;
    }

    /**
     * cramos un administrador
     */
    @WebMethod(operationName = "crearAdministrador")
    public Administrador_A crearAdministrador(@WebParam(name = "administrador_a") Administrador_A administrador_a) {
        Administrador_ABo administrador=new Administrador_ABoImpl();        
        administrador_a.setAUTHORITY("ROLE_ADMIN");
	administrador_a.setENABLED(true);
		administrador.save(administrador_a);
        return null;
    }

    /**
     * buscamos administrador por su login
     */
    @WebMethod(operationName = "administradorXlogin")
    public Usuario_A  administradorXlogin(@WebParam(name = "login") String login) {
         Administrador_ABo administrador=new Administrador_ABoImpl(); 
        Usuario_A usuarioTemp=administrador.findByAdministrador_A_login_usuario_a(login);
	return usuarioTemp;
    }

    /**
     * Actualizamos adminitrador
     */
    @WebMethod(operationName = "administradorUpdate")
    public void administradorUpdate(@WebParam(name = "administrador_a") Administrador_A administrador_a) {
        Administrador_ABo administrador=new Administrador_ABoImpl();
        administrador_a.setAUTHORITY("ROLE_ADMIN");
	administrador_a.setENABLED(true);
	administrador.update(administrador_a);
       
     }
    
    /**
     * Borramos administrador
     */
    @WebMethod(operationName = "administradorDelete")
    public void administradorDelete(@WebParam(name = "id") String id) {
       Administrador_ABo administrador=new Administrador_ABoImpl();
       Administrador_A administrador_a;
		administrador_a= administrador.findByAdministrador_AIdAdministrador_a(id);
		administrador.delete(administrador_a);
        
    }

  
}
