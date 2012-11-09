/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.proyecto.empresaA_bpel_server.bo.Producto_ABo;
import org.proyecto.empresaA_bpel_server.bo.impl.Producto_ABoImpl;
import org.proyecto.empresaA_bpel_server.model.ListaProductos_A;
import org.proyecto.empresaA_bpel_server.model.Producto_A;

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

    /**
     * Creamos un nuevo producto
     */
    @WebMethod(operationName = "crearProducto")
    public String crearProducto(@WebParam(name = "producto_a") Producto_A producto_a) {
        Producto_ABo productos_A=new Producto_ABoImpl();
        
        productos_A.save(producto_a);
	String idPruducto=String.valueOf(producto_a.getIdproductoa());
	//devolvemos el producto recien creado
	return idPruducto;

    }

    /**
     * actualizamos un producto
     */
    @WebMethod(operationName = "productoUpdate")
    public String productoUpdate(@WebParam(name = "producto_a") Producto_A producto_a) {
        Producto_ABo productos_A=new Producto_ABoImpl();
        
        productos_A.update(producto_a);
        String idProducto=String.valueOf(producto_a.getIdproductoa());

        //devolvemos el id delproducto recien actualizado
        return idProducto;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "productoXid")
    public Producto_A productoXid(@WebParam(name = "id") String id) {
        Producto_ABo productos_A=new Producto_ABoImpl();
        Producto_A pruductoTemp= productos_A.findByProducto_AIdProducto_a(id);
        return pruductoTemp;
    }

    /**
     * borramos un producto
     */
    @WebMethod(operationName = "productoDelete")
    @Oneway
    public void productoDelete(@WebParam(name = "id") String id) {
        Producto_ABo productos_A=new Producto_ABoImpl();
        Producto_A producto_a;
        producto_a=productos_A.findByProducto_AIdProducto_a(id);
        productos_A.delete(producto_a);
    }
    
    
   

}
