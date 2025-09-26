package mx.com.inventario.Dao.impl;


import java.util.ArrayList;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.TransactionScoped;
import mx.com.inventario.Dao.registroDao;
import mx.com.inventario.Entity.marca;
import mx.com.inventario.Entity.PRENDA;

import org.springframework.beans.factory.annotation.Value;



@Repository
@TransactionScoped
public class registroDaoImpl implements registroDao{

	@Value("${app.ErrorMarca}")
	private String ERROR_MARCA;
	@Value("${app.RegistroGuardado}")
	private String REGISTRO_GUARDADO;
	
	  @Autowired
	  private SessionFactory sessionFactory;	  

		@Override
		public String agregarMarcaDao(marca marca) {
			
			 Session session = sessionFactory.openSession();
			 Transaction transaction = null;

			    try {
			        transaction = session.beginTransaction();
			        session.saveOrUpdate(marca);
			        transaction.commit();
			        return REGISTRO_GUARDADO;
			    } catch (Exception e) {
			        return ERROR_MARCA;
			    } finally {
			        session.close();
			    }			
			
		}
	  
	  
	@Override
	public String agregarPrendaDao(PRENDA prenda) {
			
		System.out.println("------------------------------------------" + prenda);
		
		 Session session = sessionFactory.openSession();
		 Transaction transaction = null;

			    try {
			        transaction = session.beginTransaction();
			        session.saveOrUpdate(prenda);
			        transaction.commit();
			        return REGISTRO_GUARDADO;
			    } catch (Exception e) {
			        return "Error al registrar prenda";
			    } finally {
			        session.close();
			    }			
		
	}


	@Override
	public List<marca> obtenerMarcas() {
		List<marca> marcaList = new ArrayList<>();

		Session session = sessionFactory.openSession();

		    try {
		    	Query<marca> query =  session.createQuery("FROM marca ",marca.class);
		    	marcaList = query.getResultList();
		    } catch (Exception e) {
		    	System.out.println("Error al obtener marca" + e);
		    } finally {
		        session.close();
		    }			
		
		return marcaList;
	}

	@Override
	public String obtenerMarca(String id) {
		marca marca1 = new marca();

		Session session = sessionFactory.openSession();

		    try {
		    	Query<marca> query =  session.createQuery("FROM marca where idMarca = '" +id+ "'",marca.class);
		    	marca1 = query.getSingleResult();
		    } catch (Exception e) {
		    	System.out.println("Error al obtener marca con id " + id +" - " + e);
		    } finally {
		        session.close();
		    }			
		
		return marca1.getNombre();
	}

	@Override
	public List<PRENDA> buscarPrenda(PRENDA prenda) {
		
		
		int contador = 0; 
		List<PRENDA> prendaList = new ArrayList<>();
		List<marca> marcaList = new ArrayList<>();
	
		String sql =" FROM PRENDA  WHERE";
		Session session = sessionFactory.openSession();
		
		
		    try {

		    	if(prenda.getIdPrenda() == null) {
        	    			    	
				    	if(!prenda.getMarca().equals("select")) {
						    	Query<marca> queryMarca =  session.createQuery("FROM marca where nombre= :idMarca",marca.class);
						    	queryMarca.setParameter("idMarca", prenda.getMarca());
						    	
						    	marcaList  =  queryMarca.getResultList();
				     
						    	prenda.setMarca(Integer.parseInt(marcaList.get(0).getIdMarca()) );
						    	
						    	sql = sql.concat(" marca = " + prenda.getMarca());
						    	
						    	
						    	contador++;
				    	}
						    	
				    	if(!prenda.getModelo().equals("")) { 	
				    	sql = sql.concat(contador == 1 ? ( " and modelo = '" + prenda.getModelo() + "'" ):( " modelo = '" + prenda.getModelo() + "'" ));	    						    	
				    	}
		    	         
				    	if(!prenda.getTalla().equals("select")) {	
				    		sql = sql.concat(contador == 1 ? ( " and talla = '" + prenda.getTalla() + "'" ):( " talla = '" + prenda.getTalla() + "'" ));	    		
				    	}
				    	
		    	}else {
		    		sql = sql.concat( " idPrenda = " + prenda.getIdPrenda()); 
		    	}
		    	
		    		    	 	
		    	Query<PRENDA> query =  session.createQuery(sql,PRENDA.class);

		    	
		    	prendaList = query.getResultList();
		    	
		    	
		    } catch (Exception e) {
		    	System.out.println("Error al buscar prenda" + e);
		    } finally {
		        session.close();
		    }			
		
		return prendaList;
	}

	
	
	
	@Override
	public List<PRENDA> obtenerPrendas(boolean exist) {
		List<PRENDA> prendaList = new ArrayList<>();

		   
		
			String sql = exist ?"FROM PRENDA where stock != 0": "FROM PRENDA where stock = 0";

			Session session = sessionFactory.openSession();

		    try {

		    	Query<PRENDA> query =  session.createQuery(sql,PRENDA.class);
		    	prendaList = query.getResultList();
		    	
		    } catch (Exception e) {
		    	System.out.println(e);
		    } finally {
		        session.close();
		    }			
		
		return prendaList;
			
	}




	@Override
	public String eliminarPrendaDao(Integer idPrenda) {

		
		 Session session = sessionFactory.openSession();
		 Transaction transaction = null;

		    try {
		    	PRENDA prenda = (PRENDA) session.get(PRENDA.class, idPrenda);
		    	
		        transaction = session.beginTransaction();
		        session.delete(prenda);
		        transaction.commit();
		        return "Registro eliminado correctamente";
		    } catch (Exception e) {
		    	System.out.println("Error al eliminar prenda" + e);
		        return "Error al eliminar prenda";
		    } finally {
		        session.close();
		    }					 
		 
	}

}
