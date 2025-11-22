package mx.com.inventario.Dao.impl;


import java.util.ArrayList;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
		    	CriteriaBuilder cb = session.getCriteriaBuilder();
		    	CriteriaQuery<marca> cq = cb.createQuery(marca.class);
		    	Root<marca> rootEntry = cq.from(marca.class);
		    	CriteriaQuery<marca> all = cq.select(rootEntry);
		    	TypedQuery<marca> allQuery = session.createQuery(all);
		    	marcaList = allQuery.getResultList();	
		    	
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

		Session session = sessionFactory.openSession();
		
		int contador = 0; 
		List<PRENDA> prendaList = new ArrayList<>();

		   CriteriaBuilder cb = session.getCriteriaBuilder();
		    CriteriaQuery<PRENDA> cq = cb.createQuery(PRENDA.class);
		    Root<PRENDA> prendaquery = cq.from(PRENDA.class);
		    
		    // Filtros basados en tu objeto
			if(prenda.getIdPrenda()!= null) {
			    cq.where(cb.equal(prendaquery.get("id_prenda"), prenda.getIdPrenda() ) );	
			}else {

				
						// entra si marca y talla tienen valor 
						if(!prenda.getIdMarca().equals(0) && !prenda.getTalla().equals("select")) {
							
							 Predicate predicate = cb.equal(prendaquery.get("idmarca"), prenda.getIdMarca());		
								       predicate = cb.and(predicate, cb.equal(prendaquery.get("talla"), prenda.getTalla()));
							
							 cq.where(predicate);	
							
						}else if (!prenda.getIdMarca().equals(0)) {
							 cq.where( cb.equal(prendaquery.get("idmarca"), prenda.getIdMarca()));
							  
						}else {
							 cq.where( cb.equal(prendaquery.get("talla"), prenda.getTalla()));
						}							
				
				
							
				
			}
		    
		    return session.createQuery(cq).getResultList();

		
		/*
		
		
		
		
		String sql =" FROM PRENDA  WHERE";
		
		
		    try {

		    	if(prenda.getIdPrenda() == null) {
        	    			    	
				    	if(!prenda.getIdMarca().equals("select")) {
						    	
						    	sql = sql.concat(" id_marca = " + prenda.getIdMarca());
						    							    	
						    	contador++;
				    	}
						    	
				    	if(!prenda.getModelo().equals("")) { 	
				    	sql = sql.concat(contador == 1 ? ( " and modelo = '" + prenda.getModelo() + "'" ):( " modelo = '" + prenda.getModelo() + "'" ));	    						    	
				    	}
		    	         
				    	if(!prenda.getTalla().equals("select")) {	
				    		sql = sql.concat(contador == 1 ? ( " and talla = '" + prenda.getTalla() + "'" ):( " talla = '" + prenda.getTalla() + "'" ));	    		
				    	}
				    	
		    	}else {
		    		sql = sql.concat( " id_prenda = " + prenda.getIdPrenda()); 
		    	}
		    	
		    	System.out.println(sql);		
		    	Query<PRENDA> query =  session.createQuery(sql,PRENDA.class);

		    	
		    	prendaList = query.getResultList();
		    	
		    	
		    } catch (Exception e) {
		    	System.out.println("Error al buscar prenda" + e);
		    } finally {
		        session.close();
		    }			
	*/	

	}

	
	
	
	@Override
	public List<PRENDA> obtenerPrendas() {
		List<PRENDA> prendaList = new ArrayList<>();
		

			Session session = sessionFactory.openSession();

		    try {

		    	
		    	CriteriaBuilder cb = session.getCriteriaBuilder();
		    	CriteriaQuery<PRENDA> cq = cb.createQuery(PRENDA.class);
		    	Root<PRENDA> rootEntry = cq.from(PRENDA.class);
		    	CriteriaQuery<PRENDA> all = cq.select(rootEntry);
		    	TypedQuery<PRENDA> allQuery = session.createQuery(all);
		    	prendaList = allQuery.getResultList();
		    	
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
