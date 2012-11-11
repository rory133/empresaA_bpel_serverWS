/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.empresaA_bpel_server.webServices;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.proyecto.empresaA_bpel_server.bo.Producto_ASeleccionadoBo;
import org.proyecto.empresaA_bpel_server.bo.impl.Producto_ASeleccionadoBoImpl;
import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.dao.impl.Producto_ASeleccionadoDaoImpl;
import org.proyecto.empresaA_bpel_server.model.ListaProductos_ASeleccionados;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;

/**
 *
 * @author juanma
 */
@WebService(serviceName = "Producto_ASeleccionadoWebService")
public class Producto_ASeleccionadoWebService {

  
    /**
     * se crea un nuevo producto_seleccionado
     */
    @WebMethod(operationName = "crearProducto_ASeleccionado")
    @Oneway
    public void crearProducto_ASeleccionado(@WebParam(name = "producto_ASeleccionado") Producto_ASeleccionado producto_ASeleccionado) {
        Producto_ASeleccionadoBo producto_SeleccionadoBo=new Producto_ASeleccionadoBoImpl();
        producto_SeleccionadoBo.save(producto_ASeleccionado);
        
    }
    
    
    /**
     * se actualiza el valor de un productoSeleccionado
     */
    @WebMethod(operationName = "producto_ASeleccionadoUpdate")
    public String producto_ASeleccionadoUpdate(@WebParam(name = "producto_ASeleccionado") Producto_ASeleccionado producto_ASeleccionado) {
        Producto_ASeleccionadoBo producto_SeleccionadoBo=new Producto_ASeleccionadoBoImpl();
        producto_SeleccionadoBo.update(producto_ASeleccionado);
        String idProductoSeleccionado=String.valueOf(producto_ASeleccionado.getProducto_a().getIdproductoa());

        //devolvemos el id delproductoBseleccionado recien actualizado
        return idProductoSeleccionado;
    }

    /**
     * eliminamos un producto_seleccionado
     */
    @WebMethod(operationName = "producto_ASeleccionadoDelete")
    @Oneway
    public void producto_ASeleccionadoDelete(@WebParam(name = "id") String id) {
        Producto_ASeleccionadoBo producto_SeleccionadoBo=new Producto_ASeleccionadoBoImpl();
        Producto_ASeleccionado producto_aSeleccionado;
        producto_aSeleccionado=producto_SeleccionadoBo.findByProducto_ASeleccionadoIdProducto_a(id);
        producto_SeleccionadoBo.delete(producto_aSeleccionado);
    }

    /**
     * Obtenemos un producto_seleccionado por su id
     */
    @WebMethod(operationName = "productoASeleccionadoXId")
    public Producto_ASeleccionado productoASeleccionadoXId(@WebParam(name = "id") String id) {
        Producto_ASeleccionadoBo producto_SeleccionadoBo=new Producto_ASeleccionadoBoImpl();
      //   Producto_ASeleccionadoDao producto_SeleccionadoBo=new Producto_ASeleccionadoDaoImpl();
        Producto_ASeleccionado pruductoTemp=producto_SeleccionadoBo.findByProducto_ASeleccionadoIdProducto_a(id);
	return pruductoTemp;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "productoBSeleccionadoXIdProductoXIdCarro")
    public Producto_ASeleccionado productoBSeleccionadoXIdProductoXIdCarro(@WebParam(name = "id") String id, @WebParam(name = "idCarro") String idCarro) {
        Producto_ASeleccionadoBo producto_SeleccionadoBo=new Producto_ASeleccionadoBoImpl();
        Producto_ASeleccionado productoTemp=producto_SeleccionadoBo.findByProducto_ASeleccionadoIdProducto_a_y_carro_a(id, idCarro);
        return productoTemp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "productosASeleccionadosXIdCarro")
    public ListaProductos_ASeleccionados productosASeleccionadosXIdCarro(@WebParam(name = "id") String id) {
        Producto_ASeleccionadoBo producto_SeleccionadoBo=new Producto_ASeleccionadoBoImpl();
        ListaProductos_ASeleccionados lista = new ListaProductos_ASeleccionados();
        lista.setDataProductoASeleccionado(producto_SeleccionadoBo.findByProducto_ASeleccionadoPorIdcarro_a(id));
	return lista;
 
    }
    
       
   
   
    
}
