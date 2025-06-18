package mx.com.inventario.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.TransactionScoped;
import mx.com.inventario.Dao.registroDao;
import mx.com.inventario.Entity.marca;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.registroService;

@Service
@TransactionScoped
public class registroServiceImpl implements registroService {

	@Autowired
	private registroDao regDao;


	@Override
	public List<marca> obtenerMarcas(){ return regDao.obtenerMarcas(); }

	@Override
	public List<PRENDA> obtenerPrendas(boolean exist) { return regDao.obtenerPrendas(exist);	}

	@Override
	public String agregarPrendaService(PRENDA prenda) {	return regDao.agregarPrendaDao(prenda);	}
	
	@Override
	public String agregarMarcaService(marca marca) { return regDao.agregarMarcaDao(marca); }

	@Override
	public String eliminarPrenda(Integer idPrenda) { return regDao.eliminarPrendaDao(idPrenda);	}

	@Override
	public List<PRENDA> buscarPrenda(PRENDA prenda) { return regDao.buscarPrenda(prenda);	}

	@Override
	public String obtenerMarca(String id) { return regDao.obtenerMarca(id);
	}

}
