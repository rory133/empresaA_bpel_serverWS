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
import org.proyecto.empresaA_bpel_server.util.Mail;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "ClienteWebService")
public class ClienteWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listadoClientes")
    public ListaClientes_A listadoClientes() {
	Cliente_ABo cliente_A=new Cliente_ABoImpl();
        ListaClientes_A lista=new ListaClientes_A();
	lista.setDataCliente(cliente_A.findAll());
        
        /////////////////////
         String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
        String subject="realizada correctamente alta en empresa_b";		
        //mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);
        String to="rory133@gmail.com";
        String from="rory3333@gmail.com";
       // Mail mail = new Mail(from, to, subject, content);
        Mail mail = new Mail(from, to, subject, content);
        mail.send();
        
        
        ////////////////////////
	return lista;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "clienteXid")
    public Cliente_A clienteXid(@WebParam(name = "id") String id) {
        Cliente_ABo cliente_A=new Cliente_ABoImpl();
        Cliente_A clientTemp= cliente_A.findByCliente_AIdCliente_a(id);
	return clientTemp;
    }

    /**
     * Web service operation
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
     * Web service operation
     */
    @WebMethod(operationName = "sendMail")
    @Oneway
    public void sendMail(@WebParam(name = "mensaje") String mensaje, @WebParam(name = "parameter1") String parameter1) {
        
         String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
        String subject="realizada correctamente alta en empresa_b";		
        //mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);
        String to="rory133@gmail.com";
        String from="rory3333@gmail.com";
       // Mail mail = new Mail(from, to, subject, content);
        Mail mail = new Mail(from, to, subject, mensaje);
        mail.send();
        
    }
    
    @WebMethod(operationName = "sendMailSSL")
    @Oneway
    public void sendMailSSL(@WebParam(name = "mensaje") String mensaje, @WebParam(name = "parameter1") String parameter1) {
        
         String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
        String subject="realizada correctamente alta en empresa_b";		
        //mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);
        String to="rory133@gmail.com";
        String from="rory3333@gmail.com";
       // Mail mail = new Mail(from, to, subject, content);
        Mail mail = new Mail(from, to, subject, mensaje);
        mail.sendSSL();
        
    }
    


}
