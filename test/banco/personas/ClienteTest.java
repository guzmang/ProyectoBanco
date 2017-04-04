package banco.personas;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.cuentas.*;

public class ClienteTest {

	@Test
	public void testAndaConstructor() {
		Cliente german = new Cliente("German", 35227679);
		
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, german, 0, 1000);
		CuentaSueldo cuenta2 = new CuentaSueldo(12345, "Epidata", german, 5000);
	}

	@Test
	public void testAgregarCuentas() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, german, 0, 1000);
		CuentaCorriente cuenta2 = new CuentaCorriente(12345, german, 0, 1000);
		
		assertTrue(german.agregarCuenta(cuenta1));
		assertEquals(1, german.getCuentas().size());
	}
	
	@Test
	public void testCantidadCuentasSueldoYCantidadCuentasCorrientes() {
		
		Cliente german = new Cliente("German", 35227679);
		
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, german, 0, 1000);
		CuentaCorriente cuenta2 = new CuentaCorriente(12345, german, 0, 1000);
		CuentaCorriente cuenta3 = new CuentaCorriente(12345, german, 0, 1000);
		CuentaCorriente cuenta4 = new CuentaCorriente(12345, german, 0, 1000);
		CuentaSueldo cuenta5 = new CuentaSueldo(12345, "Epidata", german, 5000);
		CuentaSueldo cuenta6 = new CuentaSueldo(12345, "Epidata", german, 5000);
		
		boolean estado;

		estado = german.agregarCuenta(cuenta1);
		estado = german.agregarCuenta(cuenta2);
		estado = german.agregarCuenta(cuenta3);
		estado = german.agregarCuenta(cuenta4);
		estado = german.agregarCuenta(cuenta5);
		estado = german.agregarCuenta(cuenta6);
		
		assertEquals(4, german.cantidadCuentasCorrientes());
		assertEquals(2, german.cantidadCuentasSueldo());
	}	
	
	@Test
	public void testNoPuedoTenerMasCuentasSueldoQueCuentasCorrientes() {

		Cliente cliente1 = new Cliente("Cliente1", 1000000);
		
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, cliente1, 0, 1000);
		CuentaCorriente cuenta2 = new CuentaCorriente(12345, cliente1, 0, 1000);
		CuentaSueldo cuenta3 = new CuentaSueldo(12345, "Epidata", cliente1, 5000);
		CuentaSueldo cuenta4 = new CuentaSueldo(12345, "Epidata", cliente1, 5000);		

		boolean estado;
		
		// Empiezo agregando una cuenta sueldo
		estado = cliente1.agregarCuenta(cuenta3);
		assertEquals(1, cliente1.getCuentas().size());
		
		// No me permite agregar otra cuenta sueldo porque ya tengo 1 y ninguna cc
		assertFalse(cliente1.agregarCuenta(cuenta4));

		// Agrego una cuenta corriente y tengo una de cada una
		estado = cliente1.agregarCuenta(cuenta1);
		assertEquals(2, cliente1.getCuentas().size());
		
		// Sigue sin dejarme agregar otra cuenta sueldo porque tendria mas de esas que de cc
		assertFalse(cliente1.agregarCuenta(cuenta4));
		
		// Agrego otra cc, asi tendria 2 de ellas y 1 cuenta sueldo, pudiendo agregar otra
		estado = cliente1.agregarCuenta(cuenta2);
		assertTrue(cliente1.agregarCuenta(cuenta4));
		
		// Al final, tendre en total 4 cuentas
		assertEquals(4, cliente1.getCuentas().size());
	}
	
}
