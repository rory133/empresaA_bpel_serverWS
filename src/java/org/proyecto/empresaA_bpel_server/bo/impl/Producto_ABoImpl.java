package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;
import org.proyecto.empresaA_bpel_server.bo.Producto_ABo;
import org.proyecto.empresaA_bpel_server.dao.Producto_ADao;
import org.proyecto.empresaA_bpel_server.dao.impl.Producto_ADaoImpl;
import org.proyecto.empresaA_bpel_server.model.Producto_A;







public class Producto_ABoImpl implements Producto_ABo{
	

	Producto_ADao producto_ADao =new Producto_ADaoImpl();


	
	public void setProducto_BDao(Producto_ADao producto_ADao) {
		this.producto_ADao = producto_ADao;
	}
	
	@Override 
	public void save(Producto_A producto_A) {
		this.producto_ADao.save(producto_A);
		
	}
        @Override 
	public void update(Producto_A producto_A) {
		producto_ADao.update(producto_A);
		
	}
        @Override 
	public void delete(Producto_A producto_A) {
		producto_ADao.delete(producto_A);
		
	}
        @Override 
	public Producto_A findByProducto_AIdProducto_a(String Producto_AIdProducto_a) {
		
		return producto_ADao.findByProducto_AIdProducto_a(Producto_AIdProducto_a);
	}
        @Override 
	public Producto_A findByProducto_A_nombre(String producto_A_nombre) {
		
		return producto_ADao.findByProducto_A_nombre(producto_A_nombre);
	}
        @Override 
	public List<Producto_A> findAll (){
		return producto_ADao.findAll();
	}

}
