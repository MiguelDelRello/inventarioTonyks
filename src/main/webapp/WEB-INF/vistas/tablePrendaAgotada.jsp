<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<script src="<%=request.getContextPath()%>/recursos/js/prenda.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/Table.css" />
<title>Insert title here</title>
</head>

<body>

	
	  	 <table id="tablaPrendaAgotada">
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
                <th style="display:none;">Descripci&oacute;n</th>		                                		                            </tr>
        </thead>
        <tbody>
           
              	<c:forEach var="prendaAgotada" items="${prendaListAgotada}">
              	<tr>
	                <td>${prendaAgotada.idPrenda}</td>
	                <td>${prendaAgotada.idMarca}</td>
	                <td>${prendaAgotada.tipo}</td>
	                <td>${prendaAgotada.modelo}</td>
	                <td>${prendaAgotada.talla}</td>
	                <td>${prendaAgotada.stock}</td>
    	            <td>${prendaAgotada.costo}</td>
    	            <td>${prendaAgotada.venta}</td>
    	            <td>${prendaAgotada.venta-prendaAgotada.costo}</td>
    	            <td style="display: none;">${prendaAgotada.descripcion}</td>
    	            <td style="display: none;">${prendaAgotada.imagen}</td>    	                	            
    	            <tr>
                </c:forEach>
            
		        </tbody>
		    </table> 
		 
	
	</body>
</html>