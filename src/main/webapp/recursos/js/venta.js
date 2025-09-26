
document.addEventListener('DOMContentLoaded', function() {
	    document.getElementById('scannPrendaForm').addEventListener('submit', function(event) {
	        event.preventDefault(); // Evita que el formulario se env&iacute;e de forma tradicional

	        const formData = new FormData(this);

	        fetch('scannPrenda', {
	            method: 'POST',
	            body: formData,
	            headers: {
                         'Accept': 'application/json' // Esto asegura que el servidor sepa que esperas JSON
                  }
	            
	        })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Error en la solicitud');
            }
        })
	    .then(data => {
	            console.log('Success:', data);

       if ( data.idPrenda !== null){
		     
          if ( data.stock !=0){
		     
		     
            document.getElementById('pExistencia').innerText = 'Existencia : '  + data.stock;
            document.getElementById('pDesc').innerText =       'Descripcion : ' + data.descripcion;
            document.getElementById('imgPrenda').src =         '/Imagenes/'     + data.imagen;
            
            var  subtotal = document.getElementById('SubTotal');
            var     total = document.getElementById('Total');

            var contenido = subtotal.innerText;
            
            subtotal.innerText = parseInt(contenido) + data.venta;
               total.innerText = parseInt(contenido) + data.venta;

            
			var tabla = document.getElementById("tablaVenta").getElementsByTagName('tbody')[0];
 
            var nuevafila = tabla.insertRow();
            
            
            
            var celCheck   = nuevafila.insertCell(0);
            var celId      = nuevafila.insertCell(1);
            var celModelo  = nuevafila.insertCell(2);
            var celMarca   = nuevafila.insertCell(3);
            var celTipo    = nuevafila.insertCell(4); 
            var celTalla   = nuevafila.insertCell(5);
            var celVenta   = nuevafila.insertCell(6);
            var celStock   = nuevafila.insertCell(7); 
            var celDesc    = nuevafila.insertCell(8);
            var celImagen  = nuevafila.insertCell(9);
             
			celId.innerHTML      = data.idPrenda;
			celModelo.innerHTML  = data.modelo;
			celMarca.innerHTML   = data.marca;
			celTipo.innerHTML    = data.tipo;
			celTalla.innerHTML   = data.talla;
			celVenta.innerHTML   = data.venta;
			celStock.innerHTML   = data.stock;
			celDesc.innerHTML    = data.descripcion;
			celImagen.innerHTML  = data.imagen;			
			
			celStock.hidden  = true;
			celDesc.hidden   = true;
			celImagen.hidden = true;			
			
			
			 var checkbox = document.createElement('input');
			 checkbox.type = 'checkbox';
			 celCheck.appendChild(checkbox);
			 
             document.getElementById('modeloScann').value = '';
			 

            }
         }

	        })
	        
	        .catch(error => {
	            console.error('Error:', error);
	            // Aqu&iacute; puedes manejar los errores
	        });
	    });
	    
});

  
  function cancelar(){
  
  console.log("Cancelar")
    var tabla = document.getElementById('tablaVenta');
      var tbody = tabla.getElementsByTagName('tbody')[0];
      var filas = tabla.getElementsByTagName('tr');	  
	  let EliminarList = [];


	  for(var x = 1; x < filas.length; x++) {
		  var fila = tabla.rows[x];
	      EliminarList.push(fila);

	  }

	  EliminarList.forEach(lista =>{ 
	     //console.log(lista);
	     tbody.removeChild(lista);
	     }) ;


            document.getElementById('pExistencia').innerText = 'Existencia : ';
            document.getElementById('pDesc').innerText =       'Descripcion : ' ;
            document.getElementById('imgPrenda').src =         'recursos/img/logo.png';


}  


  
  function eliminarPrenda(){
	  
	  var tabla = document.getElementById('tablaVenta');
      var tbody = tabla.getElementsByTagName('tbody')[0];
      var filas = tabla.getElementsByTagName('tr');	  
	  
	  let EliminarList = [];
	  
	  for(var x = 1; x < filas.length; x++) {
	 	var celda = tabla.rows[x].cells[0];	
        var check = celda.querySelector('input[type="checkbox"]');

		if(check.checked){
			
			
     		var fila = tabla.rows[x];
 		
   
            var  subtotal = document.getElementById('SubTotal');
            var  total = document.getElementById('Total');            
            var contenido = subtotal.innerText;
            var costo = tabla.rows[x].cells[6].innerText;
            
            EliminarList.push(fila);
            
            subtotal.innerText = parseInt(contenido) - parseInt(costo);
            total.innerText = parseInt(contenido) - parseInt(costo);     		

//     		tbody.removeChild(fila);

			
		}
	  }  
	  
	  EliminarList.forEach(lista =>{ 
	     //console.log(lista);
	     tbody.removeChild(lista);
	     }) ;
	  
  }
  
  
document.addEventListener('DOMContentLoaded', function () {
    var tabla = document.getElementById('tablaVenta');

    tabla.addEventListener('click', function (event) {
        var fila = event.target.closest('tr'); // Detecta la fila más cercana al elemento clickeado
        if (!fila || fila.parentNode.tagName !== 'TBODY') return; // Ignora encabezados

        var existencia = document.getElementById('pExistencia');
        var descripcion = document.getElementById('pDesc');			 
        var imagen = document.getElementById('imgPrenda');

        existencia.textContent = 'Existencia : ' + fila.cells[7].textContent;
        descripcion.textContent = 'Descripcion : ' + fila.cells[8].textContent;
        imagen.src = '/Imagenes/' + fila.cells[9].textContent;

        console.log('Click en fila, imagen: ' + imagen.src);
    });
});
