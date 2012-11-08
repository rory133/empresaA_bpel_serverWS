package org.proyecto.empresaA_bpel_server.bo.impl;


import java.util.List;
import org.proyecto.empresaA_bpel_server.bo.Administrador_ABo;
import org.proyecto.empresaA_bpel_server.dao.Administrador_ADao;
import org.proyecto.empresaA_bpel_server.dao.impl.Administrador_ADaoImpl;
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;







public class Administrador_ABoImpl implements Administrador_ABo{
	
	
        Administrador_ADao administrador_ADao=new Administrador_ADaoImpl();

	public void setAdministrador_BDao(Administrador_ADao administrador_ADao) {
		this.administrador_ADao = administrador_ADao;
	}
	
	@Override
	public void save(Administrador_A administrador_A) {
		this.administrador_ADao.save(administrador_A);
		
	}
        @Override
	public void update(Administrador_A administrador_A) {
		administrador_ADao.update(administrador_A);
		
	}
        @Override
	public void delete(Administrador_A administrador_A) {
		administrador_ADao.delete(administrador_A);
		
	}
        @Override
	public Administrador_A findByAdministrador_AIdAdministrador_a(String Administrador_BIdAdministrador_b) {
		
		return administrador_ADao.findByAdministrador_AIdAdministrador_a(Administrador_BIdAdministrador_b);
	}
        @Override
	public Usuario_A findByAdministrador_A_login_usuario_a(String administrador_B_login_usuario_b) {
		
		return administrador_ADao.findByAdministrador_A_login_usuario_a(administrador_B_login_usuario_b);
	}
	@Override
	public List<Administrador_A> findAll (){
		return administrador_ADao.findAll();
	}

}
