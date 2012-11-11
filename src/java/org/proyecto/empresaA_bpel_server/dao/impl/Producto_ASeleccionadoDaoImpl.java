package org.proyecto.empresaA_bpel_server.dao.impl;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaA_bpel_server.dao.Producto_ASeleccionadoDao;
import org.proyecto.empresaA_bpel_server.model.Producto_ASeleccionado;
import persistence.HibernateUtil;


//@PersistenceContext(type=PersistenceContextType.EXTENDED)
public class Producto_ASeleccionadoDaoImpl  implements Producto_ASeleccionadoDao{
	
      @Override
      public void save(Producto_ASeleccionado producto_ASeleccionado) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.save(producto_ASeleccionado);
            trans.commit();
           
	}


        @Override
	public void update(Producto_ASeleccionado producto_ASeleccionado) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.merge(producto_ASeleccionado);
            trans.commit();           

	}
        @Override
	public void delete(Producto_ASeleccionado producto_ASeleccionado) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            session.delete(producto_ASeleccionado);
            trans.commit(); 
	
	}
        @Override       
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a(String producto_ASeleccionadoIdProducto_a) {
            System.out.println("antes de inicializar session en daoImpl");
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            System.out.println("antes de consulta");
            //List <Producto_ASeleccionado> list =session.createCriteria(Producto_ASeleccionado.class,producto_ASeleccionadoIdProducto_a )
            List <Producto_ASeleccionado> list =session.createCriteria(Producto_ASeleccionado.class,producto_ASeleccionadoIdProducto_a )
                       .add(Restrictions.eq("idproductoSeleccionado",Integer.parseInt(producto_ASeleccionadoIdProducto_a)))
                        .list();
            trans.commit();
            //return (Producto_ASeleccionado)list.get(0);
             return list.get(0);
        }
        
        
        @Override	
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionado_nombre(String producto_ASeleccionado_nombre) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();
            List <Producto_ASeleccionado> list =session.createCriteria(Producto_ASeleccionado.class )
                        .add(Restrictions.eq("NOMBRE_PRODUCTOA",producto_ASeleccionado_nombre))
                        .list();
            trans.commit();            
            return list.get(0);   
        }

        
	@Override
	@SuppressWarnings("unchecked")
	public Producto_ASeleccionado findByProducto_ASeleccionadoIdProducto_a_y_carro_a(String Producto_ASeleccionadoIdProducto_a, String carro){
           //SessionFactory sessionFactory = new Configuration().configure().configure().buildSessionFactory();
           //Session session= sessionFactory.getCurrentSession();
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();    
            //Hibernate.initialize("org.proyecto.empresaA_bpel_server.model.Carro_A");
           
        List <Producto_ASeleccionado> list = session.createCriteria (Producto_ASeleccionado.class )
                       // .createAlias("producto_ASeleccionado.carro_a", "carro")
                        .add(Restrictions.eq("carro_a.idcarro_a",Integer.parseInt(carro)))
                        .list();
                
                
		if(list.isEmpty()){
			return null;
		}
		else{
			
		System.out.println("hay productos seleccionados con ese carro  en find ");
		Iterator<Producto_ASeleccionado> itr = list.iterator();
		while (itr.hasNext()) {
			Producto_ASeleccionado element = itr.next();
			System.out.println("en bucle while id del producto actual : "+element.getIdproductoSeleccionado());
			if(element.getProducto_a().getIdproductoa()==Integer.parseInt(Producto_ASeleccionadoIdProducto_a)){
				System.out.println("Se encontro ese producto en find, esta es su id:"+element.getIdproductoSeleccionado());
				trans.commit(); 
                                return element;
			}
		}

		trans.commit(); 
		return null;
		
		}
		
	}
        @Override
	@SuppressWarnings("unchecked")
	public List <Producto_ASeleccionado> findByProducto_ASeleccionadoPorIdcarro_a(String carro_a){
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();    
                List <Producto_ASeleccionado> lista = session
                		.createCriteria (Producto_ASeleccionado.class )
                        .add(Restrictions. eq("carro_a.idcarro_a",Integer.parseInt(carro_a)))
                        .list();
                trans.commit();
		return lista;
		
	
		
	}

        @Override
	@SuppressWarnings("unchecked")
	public List<Producto_ASeleccionado> findAll (){
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction trans=session.beginTransaction();  
             List <Producto_ASeleccionado> lista= session.createCriteria (Producto_ASeleccionado.class )
                     .list();
             trans.commit();
	return lista;
	}


}

