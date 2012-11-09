/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.proyecto.empresaA_bpel_server.bo.Producto_ABo;
import org.proyecto.empresaA_bpel_server.bo.impl.Producto_ABoImpl;
import org.proyecto.empresaA_bpel_server.model.ListaProductos_A;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "ProductoWebService")
public class ProductoWebService {
    
    /**
     * Obtenemos un listado de todos los productos
     */
    @WebMethod(operationName = "listadoProductos")
    public ListaProductos_A listadoProductos() {
        //TODO write your implementation code here:
        Producto_ABo productos_A=new Producto_ABoImpl();
        ListaProductos_A lista=new ListaProductos_A();
	lista.setDataProducto(productos_A.findAll());
        return lista;
        
    }


}
