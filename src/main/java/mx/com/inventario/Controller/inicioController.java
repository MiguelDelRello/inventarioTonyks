package mx.com.inventario.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class inicioController {

	
	
	
	@GetMapping("/venta")
	public String puntoVenta() {
		
		return "venta";
	}
	

}
