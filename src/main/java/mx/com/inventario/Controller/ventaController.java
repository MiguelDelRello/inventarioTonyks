package mx.com.inventario.Controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.registroService;
import mx.com.inventario.Service.ventaService;

@Transactional
@Controller
public class ventaController {
	
	@Autowired 
	private ventaService vtaService;
	
	@Autowired
	private registroService regService;
	
	@PostMapping(value = "/scannPrenda", produces = MediaType.APPLICATION_JSON_VALUE)
	public void scannPrenda(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("id---- " + request.getParameter("modeloScann"));		
	    String modeloBusqueda = request.getParameter("modeloScann");
	    PRENDA scann = vtaService.scannService(modeloBusqueda);
	   // scann.setMarca(regService.obtenerMarca(scann.getMarca()));
	    
	    
	
	      ObjectMapper objectMapper = new ObjectMapper();
	        String jsonString = objectMapper.writeValueAsString(scann);

	    
	    System.out.println("PRENDA ---- " + scann.toString()    );
	        
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    response.getWriter().write(jsonString);
	    
	}

}
