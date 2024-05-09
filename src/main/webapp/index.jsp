<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventarios Tonyk´Z</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/Index.css" />

</head>
<body>

<div class="grid-container">
	<header class="header">
		    <img src="recursos/img/logo.png" alt="Icono" style="width: 45px; height: 45px;">
	</header>
<div class="widget-1">
	<form action="nuevaPrenda"  method="get">
		<button class="btnIcono" type="submit"><img src="recursos/img/icono-inventario.png" alt="Inventario" class="imgIcono">
		</button>	
		<h3>Inventario</h3>
    </form>
</div>
<div class="widget-2">
	<form action="nuevaPrenda"  method="get">
		<button class="btnIcono" type="submit"><img src="recursos/img/icono-pp.png" alt="Punto de Venta" class="imgIcono">
		</button>
		<h3>Punto de Venta</h3>	
    </form>
</div>
<div class="widget-3">
	<form action="nuevaPrenda"  method="get">
		<button class="btnIcono" type="submit"><img src="recursos/img/icono-reporte.png" alt="Reportes" class="imgIcono">
		</button>
		<h3>Reportes</h3>	
    </form>
</div>
 	<footer class="footer">
            	<jsp:include page="footer.jsp" />
	</footer>

</div>

</body>
</html>