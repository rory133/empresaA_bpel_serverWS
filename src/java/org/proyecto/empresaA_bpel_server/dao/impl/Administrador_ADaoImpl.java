package org.proyecto.empresaA_bpel_server.dao.impl;

import org.proyecto.empresaA_bpel_server.dao.Administrador_ADao;
import org.proyecto.empresaA_bpel_server.model.Administrador_A;
import org.proyecto.empresaA_bpel_server.model.Usuario_A;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import persistence.HibernateUtil;







// le decimos a Spring que es una clase DAO y que se inyectar� el objeto SessionFactory
//de Hibernate con la anotacion @Autowired

public class Administrador_ADaoImpl  implements Administrador_ADao {
//        @Autowired
//	 private SessionFactory sessionFactory;
//        @PersistenceContext
//        EntityManager em;
         
   
       
        @Override
	public void save(Administrador_A administrador_A) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(administrador_A);
            trans.commit();
	    //this.sessionFactory.getCurrentSession().save(administrador_A);
	
	}


        @Override
	public void update(Administrador_A administrador_A) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.merge(administrador_A);
            trans.commit();
            //this.sessionFactory.getCurrentSession().merge(administrador_A);
	}
        @Override
	public void delete(Administrador_A administrador_A) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.delete(administrador_A);
            trans.commit();
            //this.sessionFactory.getCurrentSession().delete(administrador_A);
		
	}
        @Override
	@SuppressWarnings("unchecked")
	public Administrador_A findByAdministrador_AIdAdministrador_a(String administrador_AIdAdministrador_a) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            List <Administrador_A> list =session.createCriteria(Administrador_A.class )
                        .add(Restrictions.eq("idusuarios_a",Integer.parseInt(administrador_AIdAdministrador_a)))
                        .list();
            trans.commit();
            return list.get(0);
                
//                List <Administrador_A> list = sessionFactory.getCurrentSession().createCriteria (Administrador_A.class )
//                        .add(Restrictions.eq("idusuarios_a",Integer.parseInt(administrador_AIdAdministrador_a)))
//                        .list();
//                return list.get(0);
	}
	@Override
	@SuppressWarnings("unchecked")
	public Usuario_A findByAdministrador_A_login_usuario_a(String administrador_A_login_usuario_a) {
             Session session=HibernateUtil.getSessionFactory().getCurrentSession();
              Transaction trans=session.beginTransaction();
             List <Usuario_A> list =session.createCriteria (Usuario_A.class )
                        .add(Restrictions.eq("login_usuario_a",administrador_A_login_usuario_a))
                        .list();
                
                
		if(list.isEmpty()){
                       trans.commit();
			return null;
                }
                trans.commit();
		return (Usuario_A)list.get(0);
                
                
//              List <Usuario_A> list = sessionFactory.getCurrentSession().createCriteria (Usuario_A.class )
//                        .add(Restrictions.eq("login_usuario_a",administrador_A_login_usuario_a))
//                        .list();
//		if(list.isEmpty())
//			return null;
//		return (Usuario_A)list.get(0);
	}
        @Override
	@SuppressWarnings("unchecked")
	public List<Administrador_A> findAll (){
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
           List <Administrador_A> list= session.createCriteria (Administrador_A.class )
               .list();
             trans.commit();
             return list;
        // return sessionFactory.getCurrentSession().createCriteria (Administrador_A.class )
        // .list();
            

	}
}
