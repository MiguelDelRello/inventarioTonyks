package mx.com.inventario.Dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.TransactionScoped;
import mx.com.inventario.Dao.ventaDAO;
import mx.com.inventario.Entity.PRENDA;



@Repository
@TransactionScoped
public class ventaDaoImpl  implements ventaDAO{


	  @Autowired
	  private SessionFactory sessionFactory;
	
	
	public PRENDA scannDao(String modelo) {
		
		PRENDA prenda = new PRENDA();
		
		
		
		Session session = sessionFactory.openSession();

	    try {
	    	System.out.println(modelo);

	    	Query<PRENDA> query =  session.createQuery("FROM PRENDA where modelo = '"+modelo +"' ",PRENDA.class);
	  
	    	prenda = query.getSingleResult();
	    	
	    	System.out.println(prenda.toString());
	    	
	    	
	    } catch (Exception e) {
	    	System.out.println("Error al scannear prenda" + e);
	    } finally {
	        session.close();
	    }			
	
	
		
		return prenda;
	}

}
