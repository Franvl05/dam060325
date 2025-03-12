import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GestorTiendaTest {
	
	private final GestorTienda gestor = new GestorTienda();

	@Test
	void testCalcularDescuento() {
		assertEquals(0.0, gestor.calcularDescuento(100, 4), 0.01);
        assertEquals(5.0, gestor.calcularDescuento(100, 5), 0.01);
        assertEquals(5.0, gestor.calcularDescuento(50, 6), 0.01);
        assertEquals(10.0, gestor.calcularDescuento(100, 10), 0.01);
        assertEquals(20.0, gestor.calcularDescuento(200, 15), 0.01); 
	}

	@Test
	void testCategorizarProducto() {
		assertEquals("Económico", gestor.categorizarProducto(5.99));
        assertEquals("Económico", gestor.categorizarProducto(9.99));
        assertEquals("Estándar", gestor.categorizarProducto(10.00));
        assertEquals("Estándar", gestor.categorizarProducto(49.99));
        assertEquals("Premium", gestor.categorizarProducto(50.00));
        assertEquals("Premium", gestor.categorizarProducto(100.00));
	}

	@Test
	void testBuscarProducto() {
		String[] inventario = {"Manzana", "Banana", "Cereza"};
		assertEquals("Manzana", gestor.buscarProducto(inventario, "Manzana"));
        assertEquals("Banana", gestor.buscarProducto(inventario, "BANANA"));
        assertEquals("Cereza", gestor.buscarProducto(inventario, "cereza"));
        assertNull(gestor.buscarProducto(inventario, "Pera"));
	}

}
