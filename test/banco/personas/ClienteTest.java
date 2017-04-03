package banco.personas;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.cuentas.*;

public class ClienteTest {

	@Test
	public void testAndaConstructor() {
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaSueldo cuenta2 = new CuentaSueldo(12345, "Epidata", "German", 35227679, 5000);
		
		Cliente cliente = new Cliente(cuenta1);
	}

	@Test
	public void testAgregarCuentas() {
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaCorriente cuenta2 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		Cliente cliente = new Cliente(cuenta1);
		
		// la cuenta del constructor + la que le estoy agregando = 2
		
		assertTrue(cliente.agregarCuenta(cuenta2));
		assertEquals(2, cliente.getCuentas().size());
	}
	
	@Test
	public void testCantidadCuentasSueldoYCantidadCuentasCorrientes() {
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaCorriente cuenta2 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaCorriente cuenta3 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaCorriente cuenta4 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaSueldo cuenta5 = new CuentaSueldo(12345, "Epidata", "German", 35227679, 5000);
		CuentaSueldo cuenta6 = new CuentaSueldo(12345, "Epidata", "German", 35227679, 5000);
		
		Cliente cliente = new Cliente(cuenta1);
		boolean estado;
		
		estado = cliente.agregarCuenta(cuenta2);
		estado = cliente.agregarCuenta(cuenta3);
		estado = cliente.agregarCuenta(cuenta4);
		estado = cliente.agregarCuenta(cuenta5);
		estado = cliente.agregarCuenta(cuenta6);
		
		assertEquals(4, cliente.cantidadCuentasCorrientes());
		assertEquals(2, cliente.cantidadCuentasSueldo());
	}	
	
	@Test
	public void testNoPuedoTenerMasCuentasSueldoQueCuentasCorrientes() {
		CuentaCorriente cuenta1 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaCorriente cuenta2 = new CuentaCorriente(12345, "German", 35227679, 0, 1000);
		CuentaSueldo cuenta3 = new CuentaSueldo(12345, "Epidata", "German", 35227679, 5000);
		CuentaSueldo cuenta4 = new CuentaSueldo(12345, "Epidata", "German", 35227679, 5000);
		
		Cliente cliente = new Cliente(cuenta4);
		Cliente cliente2 = new Cliente(cuenta4);
		Cliente cliente3 = new Cliente(cuenta4);
		boolean estado;
		
		estado = cliente2.agregarCuenta(cuenta1);
		
		estado = cliente3.agregarCuenta(cuenta1);
		estado = cliente3.agregarCuenta(cuenta2);
		estado = cliente3.agregarCuenta(cuenta3);
		
		assertFalse(cliente.agregarCuenta(cuenta3));
		assertEquals(1, cliente.getCuentas().size());
		
		assertFalse(cliente2.agregarCuenta(cuenta3));
		assertEquals(2, cliente2.getCuentas().size());
		
		assertEquals(4, cliente3.getCuentas().size());		
	}		
	
}
