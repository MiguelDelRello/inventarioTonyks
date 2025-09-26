package inventarioTonyks;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.registroService;

public class testPrenda {

	
	@Autowired
	private registroService regService;
	
	List<PRENDA> prenda = new ArrayList<PRENDA>();
	

	
	@Test
	public void testBuscarPrenda() {
	
//prenda.add('1',)
		
	//	List<PRENDA> resultado = regService. buscarPrenda(prenda);

	}
	
	
}
