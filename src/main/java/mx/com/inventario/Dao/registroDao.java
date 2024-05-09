package mx.com.inventario.Dao;

import java.util.List;

import mx.com.inventario.Entity.marca;
import mx.com.inventario.Entity.PRENDA;

public interface registroDao {
	public String agregarPrendaDao(PRENDA prenda);
	public List<marca> obtenerMarcas();
	public List<PRENDA> buscarPrenda(PRENDA prenda);
	public List<PRENDA> obtenerPrendas(boolean exist);
	public String agregarMarcaDao(marca marca);
	public String eliminarPrendaDao(Integer idPrenda);
	
	
}
