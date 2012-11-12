/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.proyecto.empresaA_bpel_server.bo.Carro_ABo;
import org.proyecto.empresaA_bpel_server.bo.impl.Carro_ABoImpl;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.ListaCarros_A;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "CarroWebService")
public class CarroWebService {



    /**
     * obtenemos un lista de los carros
     */
    @WebMethod(operationName = "listadoCarros")
    public ListaCarros_A listadoCarros() {
       Carro_ABo carro_A=new Carro_ABoImpl();
       ListaCarros_A lista = new ListaCarros_A();
       lista.setDataCarro(carro_A.findAll());
        return lista;
    }

    /**
     * Creamos un nuevo carro
     */
    @WebMethod(operationName = "crearCarro")
    public Carro_A crearCarro(@WebParam(name = "carro_a") Carro_A carro_a) {
        Carro_ABo carro_A=new Carro_ABoImpl();
        carro_A.save(carro_a);        
        return carro_a;
    }

    /**
     * acutalizamos un carro
     */
    @WebMethod(operationName = "carroUpdate")
    public Carro_A carroUpdate(@WebParam(name = "carro_a") Carro_A carro_a) {
        Carro_ABo carro_A=new Carro_ABoImpl();
        carro_A.update(carro_a);
	//devolvemos el id delproducto recien actualizado
	return carro_a;
    }

    /**
     * borramos un carro
     */
    @WebMethod(operationName = "carroDelete")
    @Oneway
    public void carroDelete(@WebParam(name = "id") String id) {
        Carro_ABo carro_A=new Carro_ABoImpl();
        Carro_A carro_a=carro_A.findByCarro_AIdCarro_a(id);
	carro_A.delete(carro_a);
             
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "carroXId")
    public Carro_A carroXId(@WebParam(name = "id") String id) {
        Carro_ABo carro_A=new Carro_ABoImpl();
        return carro_A.findByCarro_AIdCarro_a(id);
    }

    /**
     * anotamos un carro como pagado
     */
    @WebMethod(operationName = "pagarCarro")
    @Oneway
    public void pagarCarro(@WebParam(name = "carro_a") Carro_A carro_a) {
        Carro_ABo carro_A=new Carro_ABoImpl();
        carro_a.setPagado(true);
	carro_A.update(carro_a);
        //falta enviar correo
    }
    
    
   
}
