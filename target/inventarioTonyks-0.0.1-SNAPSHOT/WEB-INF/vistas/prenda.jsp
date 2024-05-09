<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>Inventarios TonykZ</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/CSSGrid.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/tab.css" />
<script src="<%=request.getContextPath()%>/recursos/js/modalPrenda.js"></script>
</head>


<body>
<div class="grid-container">
<header class="header">
  	<jsp:include page="header.jsp" />
</header>
<div class="widget-1">
	<div class="div-busqueda">
		<form action="buscarPrenda" method="post">
		    <label for="idBusqueda">ID:</label>
		    <input type="text" id="idBusqueda" name="idBusqueda"   placeholder="ID" >
		    <label for="modeloBusqueda">Modelo : </label>
		    <input type="text" id="modeloBusqueda" name="modeloBusqueda"   placeholder="Modelo" >
		    <label for="marcaBusqueda">Marca:</label>
		    <select id="marcaBusqueda" name="marcaBusqueda" required >
		        <option value="select">Seleccionar</option>
		    	<c:forEach var="opcion" items="${marcaList}">
            	<option value="${opcion.nombre}">${opcion.nombre}</option>
       			</c:forEach>
			</select>		    
		    <label for="tallaBusqueda">Talla:</label>
		    <select id="tallaBusqueda" name="tallaBusqueda" required >
		      <option value="select">Seleccionar</option>
		      <option value="XS">XS</option>
		      <option value="S">S</option>
		      <option value="M">M</option>
		      <option value="L">L</option>
		      <option value="XL">XL</option>
		      <option value="2XL">2XL</option>
		    </select>
			<button type="submit" onclick="buscarPrenda" >Buscar</button>							
		</form>
	</div>
</div>
<div class="widget-2" >
		<!-- Mensaje de error -->
		<div class="mensaje error" id="mensajeError" style="display:none;">
				<label id="labelMensajeError">${mensaje}</label>
				<a href="#" onclick="('cerrarMensaje()')">X</a>
		</div>
		<!-- Mensaje de éxito -->
		<div class="mensaje exito" id="mensajeExito" style="display:none;">
				<label id="labelMensajeExito">${mensaje}</label>
				<a href="#" onclick="('cerrarMensaje')">X</a>
		</div>
</div>
<aside class="sidebar">
  <div class="containerTab">
        <div class="lbl-menu">
            <label for="radio1">Existencias</label>
            <label for="radio2">Agotados</label>
        </div>    
        <div class="contentTab">           
            <input type="radio" name="radio" id="radio1" checked>
        <div class="tab1">
                    	<jsp:include page="tablePrenda.jsp" />
		</div>                  
            <input type="radio" name="radio" id="radio2">
         <div class="tab2">
         	<jsp:include page="tablePrendaAgotada.jsp" />
        </div>   	
       </div>
    </div>
</aside>
<main class="content">
	<div class="card">
	<div class="containerImg">
	  <img src="recursos/img/logo.png" alt="Avatar" style="width: 175px; height: 175px;">
	    <h4><b id="imgMarca" ></b></h4>
	    <p id="imgModelo"></p>	    	    
    </div> 		
   </div>
</main>

 	<footer class="footer">
            	<jsp:include page="footer.jsp" />
	</footer>

</div>
  <div id="ventanaFlotantePrenda" class="modal">
	<div class="ventana">
		<h3>Nueva Prenda</h3>
   		   <form:form modelAttribute="prenda" id="formPrenda"   method="post"  enctype="multipart/form-data">
		    <label for="idPrenda">ID:</label>
		    <input type="text" id="idPrenda" name="idPrenda"   placeholder="ID" >
		    <br>
		    <label for="marca">Marca:</label>
		    <select id="marca" name="marca" required >
		        <option value="select">Seleccionar</option>
		    	<c:forEach var="opcion" items="${marcaList}">
            	<option value="${opcion.nombre}">${opcion.nombre}</option>
       			</c:forEach>
			</select>
		    <label for="talla">Talla:</label>
		    <select id="talla" name="talla" required >
		      <option value="select">Seleccionar</option>
		      <option value="XS">XS</option>
		      <option value="S">S</option>
		      <option value="M">M</option>
		      <option value="L">L</option>
		      <option value="XL">XL</option>
		      <option value="2XL">2XL</option>
		    </select>	
			<br>
		    <label for="modelo">Modelo :</label>
		    <input type="text" id="modelo" name="modelo" required  placeholder="Modelo">
		    <br>
		    <label for="tipo">Tipo :</label>
		    <input type="text" id="tipo" name="tipo" required  placeholder="Tipo">
		    <br>
		    <label for="costo">Compra :</label>
		    <input type="number" id="costo" name="costo" required class="input-mediano" placeholder="Precio compra">
		    <label for="venta">Venta :</label>
		    <input type="number" id="venta" name="venta" required class="input-mediano" placeholder="Precio venta">
			<br><br>
		    <label for="stock">Stock : </label>
		    <input type="number" id="stock" name="stock" required class="input-mediano" placeholder="Stock">
			<br><br>
			<label for="descripcion">Descripci&oacute;n :</label>
			<br>
			<textarea id="descripcion" name="descripcion"  required placeholder="Descripci&oacute;n"></textarea>
			<br><br>
			<label for="imagen">Cargar Imagen :</label>
   		    <input type="file" id="imagen" name="imagen" accept="image/*">
   		    </form:form>
			<br>
			<button id="btnguardarPrenda"  type="submit" onclick="guardarPrenda() ">Guardar</button>&nbsp;&nbsp; 
			<button id="btnEliminarPrenda" type="submit" onclick="eliminarPrenda()" class="btn-eliminar">Eliminar</button>&nbsp;&nbsp; 
            <button type="submit" onclick="ocultarModal('ventanaFlotantePrenda')" >Cerrar</button>
		</div>
	 </div>
  	<div id="ventanaFlotanteMarca" class="modal">
		<div class="ventana">
		  <form action="guardarMarca"  method="post">
		  	<h3>Nueva Marca</h3>
			<br><br>
		    <label for="nombre">Nombre:</label>
		    <input type="text" id="nombreMarca" name="nombreMarca" required  placeholder="Nombre">
		    <br><br>
			<label for="descripcionMarca">Descripci&oacute;n:</label>
			<br><br>
			<textarea id="descripcionMarca" name="descripcionMarca"  required placeholder="Descripci&oacute;n"></textarea>
			<br><br>
			<button type="submit">Guardar</button>&nbsp;&nbsp; 
            <button type="submit" onclick="ocultarModal('ventanaFlotanteMarca')" >Cerrar</button>
		  </form>
		</div>
	</div>
</body>
</html>