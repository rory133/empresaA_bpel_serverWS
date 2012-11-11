package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;
import org.proyecto.empresaA_bpel_server.bo.Producto_ASeleccionadoBo;
import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.dao.impl.Producto_ASeleccionadoDaoImpl;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;






public class Producto_ASeleccionadoBoImpl implements Producto_ASeleccionadoBo{
	
        
	Producto_ASeleccionadoDao producto_ASeleccionadoDao=new Producto_ASeleccionadoDaoImpl() ;

	public void setProducto_ASeleccionadoDao(Producto_ASeleccionadoDao producto_ASeleccionadoDao) {
		this.producto_ASeleccionadoDao = producto_ASeleccionadoDao;
	}
	
	@Override 
	public void save(Producto_ASeleccionado producto_ASeleccionado) {
		this.producto_ASeleccionadoDao.save(producto_ASeleccionado);
		
	}
        @Override 
	public void update(Producto_ASeleccionado producto_ASeleccionado) {
		producto_ASeleccionadoDao.update(producto_ASeleccionado);
		
	}
        @Override 
	public void delete(Producto_ASeleccionado producto_ASeleccionado) {
		producto_ASeleccionadoDao.delete(producto_ASeleccionado);
		
	}
        @Override 
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String Producto_ASeleccionadoIdProducto_a) {
		System.out.println("antes de consulta boImpl");
		return producto_ASeleccionadoDao.findByProducto_ASeleccionadoIdProducto_a(Producto_ASeleccionadoIdProducto_a);
	}
        @Override
	public Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_ASeleccionado_nombre) {
		
		return producto_ASeleccionadoDao.findByProducto_ASeleccionado_nombre(producto_ASeleccionado_nombre);
	}
        @Override
        public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a_y_carro_a(String Producto_ASeleccionadoIdProducto_a, String carro_a){
            return producto_ASeleccionadoDao.findByProducto_ASeleccionadoIdProducto_a_y_carro_a(Producto_ASeleccionadoIdProducto_a, carro_a);
        }
        @Override 
        public List <Producto_ASeleccionado> findByProducto_ASeleccionadoPorIdcarro_a(String carro_a){
            return producto_ASeleccionadoDao.findByProducto_ASeleccionadoPorIdcarro_a(carro_a);
        }
        
	@Override 
	public List<Producto_ASeleccionado> findAll (){
		return producto_ASeleccionadoDao.findAll();
	}

}