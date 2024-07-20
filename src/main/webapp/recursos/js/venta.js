 var id          = [];      
 var modelo      = [];
 var marca       = [];
 var tipo        = [];
 var talla       = [];
 var precio      = [];
 var stock       = [];
 var descripcion = [];
 var imagen      = [];
 
  document.addEventListener('DOMContentLoaded', function() {	  
  document.getElementById('modeloScann').addEventListener('keydown', function(event) {
	  

            // Verificar si la tecla presionada es "Enter"
            if (event.key === 'Enter') {

                // Prevenir la acción predeterminada del formulario si es necesario
                event.preventDefault();
     	           // Ejecutar la acción deseada
			    recolectarDatos();
                
                document.getElementById('scannPrendaForm').submit();
             
                cargarDatos();                  
                 
            }         

            
            });
             
 
      });  
    
        
       function recolectarDatos() {
        
        
            var tabla = document.getElementById('tablaPrenda');
            var filas = tabla.getElementsByTagName('tr');

            for (var i = 0; i < filas.length; i++) {
				
				
                var celdas = filas[i].getElementsByTagName('td');


				if(celdas.length>0){
						
        	            id.push(celdas[1].innerText);
           	            modelo.push(celdas[2].innerText);
        	            marca.push(celdas[3].innerText);
        	            tipo.push(celdas[4].innerText);           	            
        	            talla.push(celdas[5].innerText);
        	            precio.push(celdas[6].innerText);
        	            stock.push(celdas[7].innerText);
           	            descripcion.push(celdas[8].innerText);
        	            imagen.push(celdas[9].innerText);
                 }     
    	          
             }
             
         }   
                 
       
function cargarDatos(){
	
	        var tabla = document.getElementById('tablaPrenda');
            
            
            console.log("____________ " + id.length);
            for( var j = 0; j < id.length; j++){

		            var nuevaFila = tabla.insertRow();

            
		        	var nuevaCelda1 = nuevaFila.insertCell(0);
		            var nuevaCelda2 = nuevaFila.insertCell(1);
		            var nuevaCelda3 = nuevaFila.insertCell(2);
                 	var nuevaCelda4 = nuevaFila.insertCell(3);
		            var nuevaCelda5 = nuevaFila.insertCell(4);
		            var nuevaCelda6 = nuevaFila.insertCell(5);
		            var nuevaCelda7 = nuevaFila.insertCell(6);
                 	var nuevaCelda8 = nuevaFila.insertCell(7);
		            var nuevaCelda9 = nuevaFila.insertCell(8);
		            var nuevaCelda10 = nuevaFila.insertCell(9);		


                    var checkbox = document.createElement('input');
                    checkbox.type = 'checkbox';
                    
                    nuevaCelda1.appendChild(checkbox);
                    nuevaCelda2.innerText = id[j];
		            nuevaCelda3.innerText = modelo[j];
		            nuevaCelda4.innerText = marca[j];
		            nuevaCelda5.innerText = tipo[j];
		            nuevaCelda6.innerText = talla[j];
		            nuevaCelda7.innerText = precio[j];
		            nuevaCelda8.innerText = stock[j];
		            nuevaCelda9.innerText = descripcion[j];
		            nuevaCelda10.innerText = imagen[j];		            
		            
		            
	       }
	     
}       
       