package org.proyecto.empresaA_bpel_server.dao.impl;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Cliente_ADao;
import org.proyecto.empresaA_bpel_server.model.Cliente_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import persistence.HibernateUtil;



//@Repository("Cliente_ADao")


// le decimos a Spring que es una clase DAO y que se inyectar� el objeto SessionFactory
//de Hibernate con la anotacion @Autowired

public class Cliente_ADaoImpl implements Cliente_ADao {
	

	


         @Override
	public void save(Cliente_A cliente_A) {

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(cliente_A);
            trans.commit();
	
	}


         @Override
	public void update(Cliente_A cliente_A) {

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.merge(cliente_A);
            trans.commit();
		
	}
        @Override
	public void delete(Cliente_A cliente_A) {

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.delete(cliente_A);
            trans.commit();

		
	}

	@SuppressWarnings("unchecked")
        @Override
	public Cliente_A findByCliente_AIdCliente_a(String cliente_AIdCliente_a) {

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            List <Cliente_A> list =session.createCriteria(Cliente_A.class )
                        .add(Restrictions.eq("idusuarios_a",Integer.parseInt(cliente_AIdCliente_a)))
                        .list();
            trans.commit();
            return list.get(0);
                
                
	}
	
	@SuppressWarnings("unchecked")
        @Override
	public Usuario_A findByCliente_A_login_usuario_a(String cliente_A_login_usuario_a) {

             Session session=HibernateUtil.getSessionFactory().getCurrentSession();
              Transaction trans=session.beginTransaction();
             List <Usuario_A> list =session.createCriteria (Usuario_A.class )
                        .add(Restrictions.eq("login_usuario_a",cliente_A_login_usuario_a))
                        .list();
                
                
		if(list.isEmpty()){
                       trans.commit();
			return null;
                }
                trans.commit();
		return (Usuario_A)list.get(0);
		
	}

	@SuppressWarnings("unchecked")
        @Override
	public List<Cliente_A> findAll (){
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
           List <Cliente_A> list= session.createCriteria (Cliente_A.class )
               .list();
             trans.commit();
             return list;
	}


}