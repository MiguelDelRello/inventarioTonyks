<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/recursos/css/CSSGrid.css" />
<script src="<%=request.getContextPath()%>/recursos/js/modalPrenda.js"></script>
</head>
<style>
/* Navbar container */
.navbar {
/*  overflow: hidden;*/
  background-color: #333;
  font-family: Arial;
  width: 100%;
  top 0px;
}

/* Links inside the navbar */
.navbar a {
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* The dropdown container */
.dropdown {
  float: left;
  overflow: hidden;
}

/* Dropdown button */
.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit; /* Important for vertical align on mobile phones */
}

/* Add a red background color to navbar links on hover */
.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #4CAF50;
}

/* Dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

/* Add a grey background color to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}

</style>


<body>
	   <!--   <img src="recursos/img/logo.png" alt="Icono" style="width: 45px; height: 45px;">-->

<div class="navbar">
  <div class="dropdown">
    <button class="dropbtn">Captura
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#" onclick="mostrarModal('ventanaFlotanteMarca')">Marca</a>
      <a href="#" onclick="mostrarModal('ventanaFlotantePrenda')">Prenda</a>
    </div>
  </div>
</div>


</body>
</html>