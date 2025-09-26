package mx.com.inventario.Service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.TransactionScoped;
import mx.com.inventario.Dao.ventaDAO;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.ventaService;

@Service
@TransactionScoped
public class ventaServiceImpl implements ventaService{

	@Autowired
	private ventaDAO vtaDao;
	
	@Override
	public PRENDA scannService(String modelo) { return vtaDao.scannDao(modelo); }

	
}
