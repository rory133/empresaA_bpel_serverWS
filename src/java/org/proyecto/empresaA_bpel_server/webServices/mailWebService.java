/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.util.Mail;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "mailWebService")
public class mailWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * enviamos mensaje de bienvenida
     */
    @WebMethod(operationName = "bienVenidaMail")
    @Oneway
    public void bienVenidaMail(@WebParam(name = "cliente_a") Cliente_A cliente_a) {
            String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
            String subject="realizada correctamente alta en empresa_b";		
//        //mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);
            String to=cliente_a.getEmail_a();
          //  String from="rory3333@gmail.com";
            Mail mail = new Mail(to, subject, content);
            mail.send();
        
    }
    /**
     * enviamos mensaje de bienvenida
     */
    @WebMethod(operationName = "mensajeActualizacionMail")
    @Oneway
    public void mensajeActualizacionMail(@WebParam(name = "cliente_a") Cliente_A cliente_a) {
            String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
            String subject="realizada correctamente alta en empresa_b";		
//        //mail.sendMail(cliente_a.getLogin_usuario_a(), content, cliente_a.getEmail_a(), subject);
            String to=cliente_a.getEmail_a();
          //  String from="rory3333@gmail.com";
            Mail mail = new Mail(to, subject, content);
            mail.send();
        
    }
    @WebMethod(operationName = "mensajePagoMail")
    @Oneway
    public void mensajePagoMail(@WebParam(name = "cliente_a") Carro_A carro_a) {
        
        
        	String content="apreciado usuario le informamos que el pago de su pedido numero "+carro_a.getIdcarro_a()+" se ha realizado con exito, en breve le informaremos al realziar el envio";
	        String subject="pedido: "+carro_a.getIdcarro_a();
                String to=carro_a.getCliente_a().getEmail_a();
                Mail mail = new Mail(to, subject, content);
                mail.send();
        
    }
    @WebMethod(operationName = "mensajeEnvioMail")
    @Oneway
    public void mensajeEnvioMail(@WebParam(name = "cliente_a") Carro_A carro_a) {
        
        
                String to=carro_a.getCliente_a().getEmail_a();
                String content="apreciado usuario le informamos que el pago de su pedido numero "+carro_a.getIdcarro_a()+" ha sido enviado, en breve recibirá información de la agencia de transportes";
		String subject="pedido: "+carro_a.getIdcarro_a();	
                Mail mail = new Mail(to, subject, content);             
                mail.send();
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mensajePrueba")
    @Oneway
    public void mensajePrueba(@WebParam(name = "to") String to, @WebParam(name = "content") String content, @WebParam(name = "subject") String subject) {
    
     Mail mail = new Mail(to, subject, content);             
        mail.send();
    }
    
    
}
