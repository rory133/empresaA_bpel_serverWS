package org.proyecto.empresaA_bpel_server.bo.impl;

import java.util.List;
import org.proyecto.empresaA_bpel_server.bo.Cliente_ABo;
import org.proyecto.empresaA_bpel_server.dao.Cliente_ADao;
import org.proyecto.empresaA_bpel_server.dao.impl.Cliente_ADaoImpl;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;






public class Cliente_ABoImpl implements Cliente_ABo{
	

	Cliente_ADao cliente_ADao=new Cliente_ADaoImpl();

	public void setCliente_BDao(Cliente_ADao cliente_ADao) {
		this.cliente_ADao = cliente_ADao;
	}
	
	@Override
	public void save(Cliente_A cliente_A) {
		this.cliente_ADao.save(cliente_A);
		
	}
        @Override
	public void update(Cliente_A cliente_A) {
		cliente_ADao.update(cliente_A);
		
	}
        @Override
	public void delete(Cliente_A cliente_A) {
		cliente_ADao.delete(cliente_A);
		
	}
        @Override
	public Cliente_A findByCliente_AIdCliente_a(String Cliente_BIdCliente_b) {
		
		return cliente_ADao.findByCliente_AIdCliente_a(Cliente_BIdCliente_b);
	}
        @Override
	public Usuario_A findByCliente_A_login_usuario_a(String cliente_B_login_usuario_b) {
		
		return cliente_ADao.findByCliente_A_login_usuario_a(cliente_B_login_usuario_b);
	}
	@Override
	public List<Cliente_A> findAll (){
		return cliente_ADao.findAll();
	}

}

