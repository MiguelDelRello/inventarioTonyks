<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Punto de venta - TonykZ</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/venta.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/Table.css" /> 
<script src="<%=request.getContextPath()%>/recursos/js/venta.js"></script>
</head>
<body>
	<div class="grid-container">
	
		<header class="headerVenta">
		
		</header>
		<div class="widgetScanner">
			<form action="scannPrenda" method="post" id="scannPrendaForm">
				<label>Modelo:</label>
			    <input type="text" id="modeloScann" name="modeloScann"   placeholder="Modelo" >&nbsp;&nbsp;&nbsp;
	            <button id="btnRemover"  type="submit" onclick="" class="btn-cancelar">Eliminar articulos</button>
			</form>
		</div>
		
		
		<div class="widget">  
  			<div class="containerImgVenta">
			  <img id="imgPrenda" src="/Imagenes/${prenda.imagen}" alt="Avatar" style="width: 150px; height: 150px;">
		    </div> 		
		    <p id="pExistencia">Existencia : ${prenda.stock}</p><br>
		    <p id="pDesc">Descripcion : ${prenda.descripcion}</p><br>
		    
		    
		    <button id="btnPagar"  type="submit" onclick="" class="btn-pagar">Pagar</button><br>
			<button id="btnCancelar" type="submit" onclick="" class="btn-cancelar">Cancelar</button><br>
		    

		</div>  <!--Widget-1 -->
		
		
		
<aside class="sidebarVenta">
	  <table id="tablaPrenda" >
	        <thead>
	         <tr>
	            <th> </th>	
            	<th>Id</th>	
                <th>Modelo</th>
                <th>Marca</th>
                <th>Tipo</th>
                <th>Talla</th>
                <th>Precio</th>
                <th  style="display: none;">Stock</th>
                <th  style="display: none;">Descripcion</th>
                <th  style="display: none;">Imagen</th>
            </tr>
         </thead>
         <tbody>
              	<tr>
              		<td><input type="checkbox"></td>
	                <td>${prenda.idPrenda}</td>
	                <td>${prenda.modelo}</td>
	                <td>${prenda.marca}</td>
	                <td>${prenda.tipo}</td>
	                <td>${prenda.talla}</td>
    	            <td>${prenda.costo}</td>
    	            <td style="display: none;">${prenda.stock}</td>
    	            <td style="display: none;">${prenda.descripcion}</td>
    	            <td style="display: none;">${prenda.imagen}</td>    	            
    	        </tr>  
		  </tbody>
     </table>
			
</aside>
			
			
		<div class="widgetTotal">
		    <p id="pSubtotal">Sub Total :</p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <p id="pTotal">Total :</p>
			
		</div>		
		
		<footer class="footerVenta">
		       	<jsp:include page="footer.jsp" />
		</footer>
		
	</div>
</body>
</html>