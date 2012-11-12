/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import java.util.Date;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.proyecto.empresaA_bpel_server.bo.Cliente_ABo;
import org.proyecto.empresaA_bpel_server.bo.impl.Cliente_ABoImpl;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.ListaClientes_A;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "ClienteWebService")
public class ClienteWebService {

    /**
     * Ebtenemos el listado de todos los clientes
     */
    @WebMethod(operationName = "listadoClientes")
    public ListaClientes_A listadoClientes() {
	Cliente_ABo cliente_A=new Cliente_ABoImpl();
        ListaClientes_A lista=new ListaClientes_A();
	lista.setDataCliente(cliente_A.findAll());
        
        /////////////////////
        
//         String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
//        String subject="realizada correctamente alta en empresa_b";		
//        //mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);
//        String to="rory133@gmail.com";
//        String from="rory3333@gmail.com";
//        Mail mail = new Mail(from, to, subject, content);
//        mail.send();
        
        
        ////////////////////////
	return lista;
    }

    /**
     * Obtenemos el cliente de por su id
     */
    @WebMethod(operationName = "clienteXid")
    public Cliente_A clienteXid(@WebParam(name = "id") String id) {
        Cliente_ABo cliente_A=new Cliente_ABoImpl();
        Cliente_A clientTemp= cliente_A.findByCliente_AIdCliente_a(id);
	return clientTemp;
    }

    /**
     * Creamos un nuevo cliente
     */
    @WebMethod(operationName = "crearCliente")
    public void crearCliente(@WebParam(name = "cliente_a") Cliente_A cliente_a) {
        Cliente_ABo cliente_A=new Cliente_ABoImpl();
        cliente_a.setFecha_alta_a(new Date());
        cliente_a.setAUTHORITY("ROLE_CLIENTE");
        cliente_a.setENABLED(true);
    
        cliente_A.save(cliente_a);

    }

    /**
     * Obenemos un cliente por su login
     */
    @WebMethod(operationName = "clienteXLogin")
    public Cliente_A clienteXLogin(@WebParam(name = "login") String login) {
       Cliente_ABo cliente_A=new Cliente_ABoImpl();
       
        Cliente_A clientTemp =(Cliente_A)cliente_A.findByCliente_A_login_usuario_a(login);
        if(null!=clientTemp){		
                Integer id=clientTemp.getIdusuarios_a();
                Cliente_A clientTemp2= cliente_A.findByCliente_AIdCliente_a(String.valueOf(id));
                return clientTemp2;
        }
        return null;
    }

    /**
     * Acutalizamos un cliente
     */
    @WebMethod(operationName = "clienteUpdate")
    @Oneway
    public void clienteUpdate(@WebParam(name = "cliente_a") Cliente_A cliente_a) {
        Cliente_ABo cliente_A=new Cliente_ABoImpl();
        cliente_A.update(cliente_a);

    }

    /**
     * Borramos un cliente
     */
    @WebMethod(operationName = "clienteDelete")
    @Oneway
    public void clienteDelete(@WebParam(name = "id") String id) {
        Cliente_A cliente_temp;
        Cliente_ABo cliente_A=new Cliente_ABoImpl();
	cliente_temp= cliente_A.findByCliente_AIdCliente_a(id);
        cliente_A.delete(cliente_temp);
    }



    


}
