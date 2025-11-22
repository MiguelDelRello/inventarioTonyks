
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

import jakarta.transaction.Transactional;
import mx.com.inventario.Entity.marca;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.registroService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import jakarta.servlet.http.HttpServletRequest;



@Transactional
@Controller
public class registroController {

	public registroController() {}
	
	@Autowired
	private registroService regService;

	List<PRENDA> prendaList = new ArrayList<>();
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
				
		prendaBusqueda.setTalla(request.getParameter("tallaBusqueda"));		
		prendaBusqueda.setIdMarca(Integer.parseInt(request.getParameter("marcaBusqueda")));		
		
		 
		buscarList = regService.buscarPrenda(prendaBusqueda);
		// buscarList = sustituirMarca(buscarList,marcaList);
		 
        modelo.addAttribute("prendaList", buscarList.stream().filter(p -> p.getStock() != 0  ).toList());		  
		 modelo.addAttribute("prendaListAgotada", buscarList.stream().filter(p -> p.getStock().equals(0)  ).toList() );
		 modelo.addAttribute("marcaList", marcaList);
		 
			return "prenda";
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
		      .ifPresent(marca -> prenda.setIdMarca(marca.getIdMarca()) );
		
    	prenda.setCosto(Double.parseDouble(request.getParameter("costo")));
    	prenda.setDescripcion(request.getParameter("descripcion"));
 //   	prenda.setImagen(imagenArchivo.getOriginalFilename());
    	prenda.setModelo(request.getParameter("modelo"));
    	prenda.setStock(Integer.parseInt(request.getParameter("stock")));
    	prenda.setTalla(request.getParameter("talla"));
    	prenda.setTipo(request.getParameter("tipo"));	
    	prenda.setVenta(Integer.parseInt(request.getParameter("venta")));
    	
	   modelo.addAttribute("mensaje", regService.agregarPrendaService(prenda));
	   
	   
		return nuevaPrenda(modelo);
	}
	
	
	
	
	@GetMapping("/nuevaPrenda" )
	public String nuevaPrenda (Model modelo) {
			
		System.out.println("--------------------------Nueva prenda-------------------------------");
		

	     prendaList        = regService.obtenerPrendas();
		 marcaList         = regService.obtenerMarcas();		 
			
		 marcaList.forEach(System.out::println);
		 
         modelo.addAttribute("prendaList", prendaList.stream().filter(p -> p.getStock() != 0  ).toList());		  
		 modelo.addAttribute("prendaListAgotada", prendaList.stream().filter(p -> p.getStock().equals(0)  ).toList() );
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
	    		if(p.getIdMarca().equals(m.getIdMarca())) {   			
	    			p.setIdMarca(Integer.parseInt(m.getNombre()));
	    		}
		 });
	 });
	 
	 
	return prenda; 
}	
	



}
