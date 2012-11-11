package org.proyecto.empresaA_bpel_server.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Carro_ADao;
import org.proyecto.empresaA_bpel_server.model.Carro_A;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;




public class Carro_ADaoImpl  implements Carro_ADao {

        @Override
	public void save(Carro_A carro_A) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(carro_A);
            trans.commit();
             //   this.sessionFactory.getCurrentSession().save(carro_A);
                

	
	}


        @Override
	public void update(Carro_A carro_A) {

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.merge(carro_A);
            trans.commit();
            
            
            //  this.sessionFactory.getCurrentSession().update(carro_A);
	
	}
         @Override
	public void delete(Carro_A carro_A) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.delete(carro_A);
            trans.commit();   
         
            
            
            
            // this.sessionFactory.getCurrentSession().delete(carro_A);
		
	}
	@Override
	@SuppressWarnings("unchecked")
	public Carro_A findByCarro_AIdCarro_a(String carro_AIdCarro_a) {
              Session session=HibernateUtil.getSessionFactory().getCurrentSession();
              Transaction trans=session.beginTransaction();
                List <Carro_A> list = session.createCriteria (Carro_A.class )
                        .add(Restrictions.eq("idcarro_a",Integer.parseInt(carro_AIdCarro_a)))
                        .list();
                return list.get(0);
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Producto_ASeleccionado>findByTodosCarro_AIdCarro_a(String carro_AIdCarro_a) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            List <Producto_ASeleccionado> list = session.createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions.eq("idcarro_a",Integer.parseInt(carro_AIdCarro_a)))
                        .list();
                return list;
                
                
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Carro_A>findByTodosCarro_AIdCliente_a(String carro_AIdCliente_a) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
              List <Carro_A> list = session.createCriteria (Carro_A.class )
                        .add(Restrictions.eq("idcliente",Integer.parseInt(carro_AIdCliente_a)))
                        .list();
              return list;
                
	}
        @Override
	@SuppressWarnings("unchecked")
	public List<Carro_A> findAll(){
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
                 List <Carro_A> lista= session.createCriteria (Carro_A.class )
                                     .list();
           trans.commit();
           return lista;
                
	}

}
