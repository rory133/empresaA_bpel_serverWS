package org.proyecto.empresaA_bpel_server.dao;

import java.util.List;

import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;

public interface Carro_ADao {
	void save(Carro_A carro_A);
	
	void update(Carro_A carro_A);
	
	void delete(Carro_A carro_A);
	
	Carro_A findByCarro_AIdCarro_a(String Carro_BIdCarro_b);
	
	 List<Producto_ASeleccionado> findByTodosCarro_AIdCarro_a(String carro_BIdCarro_b);
	 
	 List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_BIdCliente_b);
	
	List<Carro_A> findAll();
}
