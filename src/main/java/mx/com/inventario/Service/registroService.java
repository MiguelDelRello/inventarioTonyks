package mx.com.inventario.Service;


import java.util.List;


import mx.com.inventario.Entity.marca;
import mx.com.inventario.Entity.PRENDA;


public interface registroService {

	public List<marca> obtenerMarcas();
	public String obtenerMarca(String id);
	public List<PRENDA> buscarPrenda(PRENDA prenda);
	public List<PRENDA> obtenerPrendas(boolean exist);
	public String agregarMarcaService(marca marca);
	public String eliminarPrenda(Integer parameter);
	public String agregarPrendaService(PRENDA prenda);	
}
