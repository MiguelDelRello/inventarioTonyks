<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<script src="<%=request.getContextPath()%>/recursos/js/modalPrenda.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/Table.css" /> 
<title>Insert title here</title>
</head>

<body>
		 <table id="tablaPrenda" >
	        <thead>
	            <tr>
            	<th>Id</th>	
                <th>Marca</th>
                <th>Tipo</th>
                <th>Modelo</th>
                <th>Talla</th>
                <th>Stock</th>
                <th>Compra</th>
                <th>Venta</th>
                <th>Ganancia</th>
                <th style="display:none;">Descripci&oacute;n</th>		                                		                
            </tr>
        </thead>
        <tbody>
           
              	<c:forEach var="prenda" items="${prendaList}">
              	<tr>
	                <td>${prenda.idPrenda}</td>
	                <td>${prenda.marca}</td>
	                <td>${prenda.tipo}</td>
	                <td>${prenda.modelo}</td>
	                <td>${prenda.talla}</td>
	                <td>${prenda.stock}</td>
    	            <td>${prenda.costo}</td>
    	            <td>${prenda.venta}</td>
    	            <td>${prenda.venta-prenda.costo}</td>
    	            <td style="display: none;">${prenda.descripcion}</td>    	            
    	            <tr>
                </c:forEach>
            
		        </tbody>
		    </table> 
	</body>
</html>