
package mx.com.inventario.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import mx.com.inventario.Entity.marca;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.registroService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;



@Transactional
@Controller
public class registroController {

	public registroController() {}
	
	@Autowired
	private registroService regService;

	List<PRENDA> prendaList = new ArrayList<>();
	List<PRENDA> prendaListAgotada = new ArrayList<>();
	List<marca> marcaList = new ArrayList<>(); 	
	List<PRENDA> buscarList = new ArrayList<>();
	
	@PostMapping(value = "/eliminarPrenda", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String eliminarPrenda(HttpServletRequest request, Model modelo,
			@RequestParam("imagen") MultipartFile imagenArchivo) throws IOException {		
		
		System.out.println("--------------------------Eliminar Prenda-------------------------");
		
	   
	    modelo.addAttribute("mensaje", regService.eliminarPrenda(Integer.parseInt(request.getParameter("idPrenda"))));
		return nuevaPrenda(modelo);
	}
	

	@PostMapping(value = "/buscarPrenda")
	public String buscarPrenda(HttpServletRequest request, Model modelo) {
		
		
		PRENDA prendaBusqueda = new PRENDA();
        
		
		if(!request.getParameter("idBusqueda").isEmpty()) { 
			prendaBusqueda.setIdPrenda(Integer.parseInt(request.getParameter("idBusqueda")));
		}
		
		
		
		prendaBusqueda.setModelo(request.getParameter("modeloBusqueda"));		
		prendaBusqueda.setTalla(request.getParameter("tallaBusqueda"));		
		prendaBusqueda.setMarca(request.getParameter("marcaBusqueda"));		
		
		
		 buscarList = regService.buscarPrenda(prendaBusqueda);
		 buscarList = sustituirMarca(buscarList,marcaList);
		 
		 
		return nuevaPrenda(modelo); 
	}
	
	
	
	@PostMapping(value = "/guardarPrenda", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String guardarPrenda(HttpServletRequest request, Model modelo,
			                     @RequestParam("imagen") MultipartFile imagenArchivo) throws IOException {		
		
		
		PRENDA prenda = new PRENDA();
		
		   final String UPLOAD_DIRECTORY = "C:\\Imagenes" ;
		
		   
		   Optional.ofNullable(request.getParameter("idPrenda"))
		   						.filter(id -> !id.isEmpty())
		   						.map(Integer::parseInt)
		   						.ifPresent(prenda::setIdPrenda);
		   		   

			// Valida si no cargo archivo de imagen al dar de alta. 
			if (!imagenArchivo.getOriginalFilename().equals("")) {
				
				Path filepath = Paths.get(UPLOAD_DIRECTORY, imagenArchivo.getOriginalFilename());
				System.out.println( " ------------ "  +  imagenArchivo.getOriginalFilename());
				imagenArchivo.transferTo(filepath);
				prenda.setImagen(imagenArchivo.getOriginalFilename());
				
			}else {
				System.out.println("-------------------logo " + request.getParameter("lbImagen"));
				prenda.setImagen(request.getParameter("lbImagen"));
			}
			
			
			
			
		marcaList.stream()
		      .filter(marca -> request.getParameter("marca").equals(marca.getNombre())  )
		      .findFirst()
		      .ifPresent(marca -> prenda.setMarca(marca.getIdMarca()) );
		
    	prenda.setCosto(Double.parseDouble(request.getParameter("costo")));
    	prenda.setDescripcion(request.getParameter("descripcion"));
 //   	prenda.setImagen(imagenArchivo.getOriginalFilename());
    	prenda.setModelo(request.getParameter("modelo"));
    	prenda.setStock(Integer.parseInt(request.getParameter("stock")));
    	prenda.setTalla(request.getParameter("talla"));
    	prenda.setTipo(request.getParameter("tipo"));	
    	prenda.setVenta(Double.parseDouble(request.getParameter("venta")));
    	
	   modelo.addAttribute("mensaje", regService.agregarPrendaService(prenda));
	   
	   
		return nuevaPrenda(modelo);
	}
	
	
	
	
	@GetMapping("/nuevaPrenda" )
	public String nuevaPrenda (Model modelo) {
			
		System.out.println("--------------------------Nueva prenda-------------------------------");
		
		if(buscarList.isEmpty() ) {
			 //obtine las prendas activas		
			 prendaList = regService.obtenerPrendas(true); 
			 modelo.addAttribute("prendaList", prendaList);
			
		}
		else {
			modelo.addAttribute("prendaList", buscarList);
		}
		 //obtine las prendas activas		
		 prendaListAgotada = regService.obtenerPrendas(false); 

		 // Obtiene las marcas
		 marcaList = regService.obtenerMarcas();		 
		
		 prendaList = sustituirMarca(prendaList,marcaList);
		 prendaListAgotada = sustituirMarca(prendaListAgotada,marcaList);
		 
		 modelo.addAttribute("prendaListAgotada", prendaListAgotada);
		 modelo.addAttribute("marcaList", marcaList);
		 	 
		return "prenda";
	}
	
	
	@PostMapping(value = "/guardarMarca"/*,  consumes = "multipart/form-data"*/)
	public String guardarMarca(/*@RequestParam("imagen") MultipartFile archivo, */HttpServletRequest request, Model modelo) {
		
		marca marca = new marca();

		
		marca.setNombre(request.getParameter("nombreMarca"));
		marca.setDescripcion(request.getParameter("descripcionMarca"));
				

	   
		modelo.addAttribute("mensaje", regService.agregarMarcaService(marca));
		
		return nuevaPrenda(modelo);
	} 
	
	
public static List<PRENDA> sustituirMarca(List<PRENDA> prenda, List<marca> marcaList) {
	 	 
	 
	 prenda.forEach(p ->  {
		 marcaList.forEach(  m -> {
	    		if(p.getMarca().equals(m.getIdMarca())) {   			
	    			p.setMarca(m.getNombre());
	    		}
		 });
	 });
	 
	 
	return prenda; 
}	
	
/*	
@PostConstruct
public void init() {
    System.out.println("RegistroController bean creado");
}	
*/


}
