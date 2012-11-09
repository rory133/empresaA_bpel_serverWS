package org.proyecto.empresaA_bpel_server.dao.impl;




import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Producto_ADao;
import org.proyecto.empresaA_bpel_server.model.Producto_A;
import persistence.HibernateUtil;






// le decimos a Spring que es una clase DAO y que se inyectar� el objeto SessionFactory
//de Hibernate con la anotacion @Autowired

public class Producto_ADaoImpl implements Producto_ADao {

	

	
	@Override
	public void save(Producto_A producto_A) {

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(producto_A);
            trans.commit();
	}


        @Override
	public void update(Producto_A producto_A) {          
            
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.merge(producto_A);
            trans.commit();
   	}
        
        @Override
	public void delete(Producto_A producto_A) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.delete(producto_A);
            trans.commit();            
	}
        
        @Override
	@SuppressWarnings("unchecked")
	public Producto_A findByProducto_AIdProducto_a(String producto_AIdProducto_a) {
		 
            
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            List <Producto_A> list =session.createCriteria(Producto_A.class )
                        .add(Restrictions.eq("idproductoa",Integer.parseInt(producto_AIdProducto_a)))
                        .list();
            trans.commit();
            return list.get(0);
	}
	
        @Override
	@SuppressWarnings("unchecked")
	public Producto_A findByProducto_A_nombre(String producto_A_nombre) {
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
                Transaction trans=session.beginTransaction();
                List <Producto_A> list = session.createCriteria (Producto_A.class )
                        .add(Restrictions.eq("NOMBRE_PRODUCTOA",producto_A_nombre))
                        .list();
                //from Producto_A where NOMBRE_PRODUCTOA = ?",producto_A_nombre);
		return (Producto_A)list.get(0);
	}

        
        @Override
	@SuppressWarnings("unchecked")
	public List<Producto_A> findAll (){

            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            List <Producto_A> list= session.createCriteria (Producto_A.class )
               .list();
            trans.commit();
            return list;
	}


}

