/**
 * 
 */


    	
document.addEventListener('DOMContentLoaded', function () {

    var mensaje = this.getElementById("labelMensajeExito");
    var divOk   = this.getElementById("mensajeExito");
    var divErr  = this.getElementById("mensajeError");
    
    var valorLabel = mensaje.innerText || mensaje.textContent;

if (valorLabel === "Registro guardado correctamente"  || valorLabel ===  "Registro eliminado correctamente" ){
	divOk.style.display = 'block';
	

}
if (valorLabel === "Error al registrar prenda" || valorLabel === "Error al registrar marca" ||  valorLabel === "Error al eliminar prenda"){
	mostrarModal('mensajeError');
		divErr.style.display = 'block';
	
} 
	


});

  function limpiarPrenda(){
	 
			 var marca   = document.getElementById('marca');
			 var talla   = document.getElementById('talla');			 
			 var tipo    = document.getElementById('tipo');
			 var costo   = document.getElementById('costo');
			 var venta   = document.getElementById('venta');
			 var stock   = document.getElementById('stock');
			 var modelo  = document.getElementById('modelo');
			 var descripcion = document.getElementById('descripcion');
	 
			marca.value        = "select";
			tipo.value         = "Tipo";
			modelo.value       = "Modelo";
			talla.value        = "select";
			stock.value        = "0";
			costo.value        = "0";
			venta.value        = "0";
			descripcion.value  = "Descripcion";
			
	  } 
     function ocultarModal(seccion) {
        // Obtén el elemento modal por su ID
        var modal = document.getElementById(seccion);

        // Oculta el modal cambiando el estilo de display a 'none'
        modal.style.display = 'none';
        modal.method = 'get';
    }

    function mostrarModal(sec) {
        // Obtén el elemento modal por su ID
        var modal = document.getElementById(sec);

        // Muestra el modal cambiando el estilo de display a 'flex'
        modal.style.display = 'flex';
        modal.style.zIndex="2";
    }
    
    function eliminarPrenda(){
	
		document.getElementById('formPrenda').action = '/inventarioTonyks/eliminarPrenda';
        document.getElementById('formPrenda').submit();
        
	}
    
    function guardarPrenda(){
	
		document.getElementById('formPrenda').action = '/inventarioTonyks/guardarPrenda';
        document.getElementById('formPrenda').submit();
	}
    function simularAccion() {
        // Aquí puedes poner la lógica que necesites (por ejemplo, enviar datos al servidor)

        // Simulando un error
        mostrarMensaje('mensajeError');
        
        // Simulando éxito
        // mostrarMensaje('mensajeExito');
    }

    function mostrarMensaje(idMensaje) {
		
        // Ocultar todos los mensajes
        document.getElementById('mensajeError').style.display = 'none';
        document.getElementById('mensajeExito').style.display = 'none';

        // Mostrar el mensaje específico
        document.getElementById(idMensaje).style.display = 'block';
    }
    
    function cerrarMensaje(){
		alert("cerrar");
       var error = document.getElementById('mensajeError');
       var exito = document.getElementById('mensajeExito');		
        
        
        exito.style.display = "none";
        error.style.display = "none";
        
	}