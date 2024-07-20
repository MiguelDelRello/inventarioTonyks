package mx.com.inventario.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.transaction.Transactional;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.ventaService;

@Transactional
@Controller
public class ventaController {
	
	@Autowired 
	private ventaService vtaService;
	
	
	@GetMapping(value = "/scannPrenda")
	public String scannPrenda(HttpServletRequest request, Model modelo) {
		
		System.out.println("id---- " + request.getParameter("idScann"));		
	    String modeloBusqueda = request.getParameter("modeloScann");
	    PRENDA scann = vtaService.scannService(modeloBusqueda);
	    modelo.addAttribute("prenda", scann);
		
		return "venta";
	}

}
