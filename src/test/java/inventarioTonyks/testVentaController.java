package inventarioTonyks;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import mx.com.inventario.Controller.ventaController;
import mx.com.inventario.Entity.PRENDA;
import mx.com.inventario.Service.ventaService;


public class testVentaController {


    @Mock
    private ventaService vtaService;

    @InjectMocks
    private ventaController vtaController;

    @Test
    public void testScannPrenda() {
        HttpServletRequest request = mock(HttpServletRequest.class);
        Model model = mock(Model.class);
        PRENDA prenda = new PRENDA(5,"5","2XL",7,10,"1234567890","camisa sin",17,"Descripción.","20220112_163250.jpg"); // Aquí deberías crear un objeto PRENDA con valores esperados para tu prueba

        // Define el comportamiento esperado para el método scannService del servicio vtaService
        when(request.getParameter("modeloScann")).thenReturn("1234567890");
        when(vtaService.scannService("1234567890")).thenReturn(prenda);

        // Llama al método que quieres probar
        String result = vtaController.scannPrenda(request, model);

        // Verifica que se hayan llamado a los métodos adecuados y con los argumentos correctos
        verify(request).getParameter("modeloScann");
        verify(vtaService).scannService("1234567890");
        verify(model).addAttribute("prenda", prenda);

        // Verifica que el resultado del método sea el esperado
        assertEquals("venta", result);
    }
	
}
