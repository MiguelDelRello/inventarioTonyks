<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <title>Inventario - TonykZ</title>
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
                    <input type="text" id="idBusqueda" name="idBusqueda" placeholder="ID">
                    <label for="marcaBusqueda">Marca:</label>
                    <select id="marcaBusqueda" name="marcaBusqueda" required>
                        <option value="0">Seleccionar</option>
                        <c:forEach var="opcion" items="${marcaList}">
                            <option value="${opcion.idMarca}">${opcion.nombre}</option>
                        </c:forEach>
                    </select>		    
                    <label for="tallaBusqueda">Talla:</label>
                    <select id="tallaBusqueda" name="tallaBusqueda" required>
                        <option value="select">Seleccionar</option>
                        <option value="XS">XS</option>
                        <option value="S">S</option>
                        <option value="M">M</option>
                        <option value="L">L</option>
                        <option value="XL">XL</option>
                        <option value="2XL">2XL</option>
                    </select>
                    <button type="submit" onclick="buscarPrenda()">Buscar</button>  <!-- Agregué () -->
                </form>							
            </div>
        </div>
        <div class="widget-2">
            <!-- Mensaje de error -->
            <div class="mensaje error" id="mensajeError" style="display:none;">
                <label id="labelMensajeError">${mensaje}</label>
                <a href="#" onclick="cerrarMensaje()">X</a>  <!-- Corregido -->
            </div>
            <!-- Mensaje de éxito -->
            <div class="mensaje exito" id="mensajeExito" style="display:none;">
                <label id="labelMensajeExito">${mensaje}</label>
                <a href="#" onclick="cerrarMensaje()">X</a>  <!-- Corregido -->
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
                    <img id="imgPrenda" src="recursos/img/logo.png" alt="Avatar" style="width: 175px; height: 175px;">
                    <h4><b id="imgMarca"></b></h4>
                    <p id="imgModelo"></p>	    	    
                </div> 
            </div><br>
            <div>
                <button type="button" onclick="mostrarModal('ventanaFlotantePrenda')" class="btn-pagar">Nueva Prenda</button><br><br>  <!-- type="button" para JS -->
                <button type="button" onclick="mostrarModal('ventanaFlotanteMarca')" class="btn-pagar">Nueva Marca</button>  <!-- type="button" -->
            </div>
        </main>

        <footer class="footer">
            <jsp:include page="footer.jsp" />
        </footer>
    </div>

    <!-- Modal Prenda -->
    <div id="ventanaFlotantePrenda" class="modal">
        <div class="ventana">
            <h3>Nueva Prenda</h3>
            <form:form modelAttribute="prenda" id="formPrenda" method="post" action="/guardarPrenda" enctype="multipart/form-data">  <!-- Agregué action -->
                <label for="idPrenda">ID:</label>
                <input type="text" id="idPrenda" name="idPrenda" placeholder="ID" readonly>  <!-- readonly si es auto-gen -->
                <br>
                <label for="marca">Marca:</label>
                <select id="marca" name="marca" required>
                    <option value="select">Seleccionar</option>
                    <c:forEach var="opcion" items="${marcaList}">
                        <option value="${opcion.nombre}">${opcion.nombre}</option>
                    </c:forEach>
                </select>
                <label for="talla">Talla:</label>
                <select id="talla" name="talla" required>
                    <option value="select">Seleccionar</option>
                    <option value="XS">XS</option>
                    <option value="S">S</option>
                    <option value="M">M</option>
                    <option value="L">L</option>
                    <option value="XL">XL</option>
                    <option value="2XL">2XL</option>
                </select>
                <br><br>	
                <label for="modelo">Modelo:</label>
                <input type="text" id="modelo" name="modelo" required class="input-mediano" placeholder="Modelo">
                <label for="tipo">Tipo:</label>
                <input type="text" id="tipo" name="tipo" required class="input-mediano" placeholder="Tipo">
                <br><br>
                <label for="costo">Compra:</label>
                <input type="number" id="costo" name="costo" required class="input-mediano" placeholder="Precio compra" step="0.01">
                <label for="venta">Venta:</label>
                <input type="number" id="venta" name="venta" required class="input-mediano" placeholder="Precio venta" step="0.01">
                <br><br>    
                <label for="stock">Stock:</label>
                <input type="number" id="stock" name="stock" required class="input-mediano" placeholder="Stock">
                <br><br><br>	
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion" required placeholder="Descripción"></textarea>
                <br><br>	
                <label for="imagen">Cargar Imagen:</label>
                <input type="file" id="imagen" name="imagen" accept="image/*">
                <input type="text" id="lbImagen" name="lbImagen" style="display:none;">
            </form:form>
            <br>
            <button type="button" id="btnguardarPrenda" onclick="guardarPrenda()">Guardar</button>  <!-- type="button" + () -->
            <button type="button" id="btnEliminarPrenda" onclick="eliminarPrenda()" class="btn-eliminar">Eliminar</button>
            <button type="button" id="btnImprimir" onclick="guardarPrenda()">Imprimir etiqueta</button>  <!-- Corregido typo -->
            <button type="button" onclick="ocultarModal('ventanaFlotantePrenda')">Cerrar</button>
        </div>
    </div>

    <!-- Modal Marca -->
    <div id="ventanaFlotanteMarca" class="modal">
        <div class="ventana">
            <form action="/guardarMarca" method="post">  <!-- Agregué / para ruta absoluta -->
                <h3>Nueva Marca</h3>
                <br><br>
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombreMarca" name="nombreMarca" required placeholder="Nombre">
                <br><br>
                <label for="descripcionMarca">Descripción:</label>
                <br><br>
                <textarea id="descripcionMarca" name="descripcionMarca" required placeholder="Descripción"></textarea>
                <br><br>
                <button type="submit">Guardar</button>
                <button type="button" onclick="ocultarModal('ventanaFlotanteMarca')">Cerrar</button>  <!-- type="button" -->
            </form>
        </div>
    </div>
</body>
</html>