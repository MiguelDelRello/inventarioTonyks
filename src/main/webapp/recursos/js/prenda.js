document.addEventListener('DOMContentLoaded', function () {
	
    var tabla = document.getElementById('tablaPrendaAgotada');
    var filas = tabla.getElementsByTagName('tr');

    for (var i = 0; i < filas.length; i++) {
 	        filas[i].addEventListener('click', function () {

			
			 var marca    = document.getElementById('imgMarca');
			 var modelo   = document.getElementById('imgModelo');			 
			 var imagen   = document.getElementById('imgPrenda');
			 
            
            
   
        	marca.textContent  = this.cells[1].textContent;
			modelo.textContent = this.cells[3].textContent;
			imagen.src = "/Imagenes/"   + this.cells[10].textContent;
            console.log("---------------" + imagen.src);

        });
    }
    
    
});


    	
document.addEventListener("DOMContentLoaded", function() {
	
    var tabla = document.getElementById("tablaPrendaAgotada");
    var filas = tabla.getElementsByTagName('tr');

    for (var i = 0; i < filas.length; i++) {
		
		    filas[i].addEventListener("dblclick", function() {
			 var idPrenda    = document.getElementById('idPrenda');
			 var marca       = document.getElementById('marca');
			 var talla       = document.getElementById('talla');			 
			 var tipo        = document.getElementById('tipo');
			 var costo       = document.getElementById('costo');
			 var venta       = document.getElementById('venta');
			 var stock       = document.getElementById('stock');
			 var modelo      = document.getElementById('modelo');
			 var descripcion = document.getElementById('descripcion');
             var labelImagen  = document.getElementById('lbImagen');
			 	 
	        idPrenda.value     = this.cells[0].textContent;
			marca.value        = this.cells[1].textContent;
			tipo.value         = this.cells[2].textContent;
			modelo.value       = this.cells[3].textContent;
			talla.value        = this.cells[4].textContent;
			stock.value        = this.cells[5].textContent;
			costo.value        = this.cells[6].textContent;
			venta.value        = this.cells[7].textContent;
			descripcion.value  = this.cells[9].textContent;			

			if(this.cells[10].textContent =="" ){
				labelImagen.value = "logo.png"
			}else {
				labelImagen.value = this.cells[10].textContent	
			}		
		    mostrarModal("ventanaFlotantePrenda"); 
		      });
     }
  });
    	
document.addEventListener('DOMContentLoaded', function () {
    var tabla = document.getElementById('tablaPrenda');
    var filas = tabla.getElementsByTagName('tr');

    for (var i = 1; i < filas.length; i++) {
        filas[i].addEventListener('click', function () {

			
			 var marca   = document.getElementById('imgMarca');
			 var modelo   = document.getElementById('imgModelo');			 
			 var imagen   = document.getElementById('imgPrenda');
			 
            
            
   
        	marca.textContent  = this.cells[1].textContent;
			modelo.textContent = this.cells[3].textContent;
			// Creamos un elemento de imagen y asignamos la URL como fuente
			imagen.src = "/Imagenes/"   + this.cells[10].textContent;
         //  console.log("---------------" + imagen.src);



            
        });
    }
});

    	
document.addEventListener("DOMContentLoaded", function() {
    var tabla = document.getElementById("tablaPrenda");
    var filas = tabla.getElementsByTagName('tr');
    for (var i = 0; i < filas.length; i++) {
		
		    filas[i].addEventListener("dblclick", function() {
			 var idPrenda     =	document.getElementById('idPrenda');
			 var marca        = document.getElementById('marca');
			 var talla        = document.getElementById('talla');			 
			 var tipo         = document.getElementById('tipo');
			 var costo        = document.getElementById('costo');
			 var venta        = document.getElementById('venta');
			 var stock        = document.getElementById('stock');
			 var modelo       = document.getElementById('modelo');
 			 var descripcion  = document.getElementById('descripcion');
             var labelImagen  = document.getElementById('lbImagen');	
	
			
	
	 
	        idPrenda.value     = this.cells[0].textContent;
			marca.value        = this.cells[1].textContent;
			tipo.value         = this.cells[2].textContent;
			modelo.value       = this.cells[3].textContent;
			talla.value        = this.cells[4].textContent;	
			stock.value        = this.cells[5].textContent;
			costo.value        = this.cells[6].textContent;
			venta.value        = this.cells[7].textContent;
			descripcion.value  = this.cells[9].textContent;
			
			if(this.cells[10].textContent =="" ){
				labelImagen.value = "logo.png"
			}else {
				labelImagen.value = this.cells[10].textContent	
			}
		    mostrarModal("ventanaFlotantePrenda");
		      });
     }
  });
    	
   