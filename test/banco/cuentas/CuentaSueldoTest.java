package banco.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaSueldoTest {

	@Test
	public void testAndaConstructor() {
		CuentaSueldo miObjetoCuentaSueldo = new CuentaSueldo(12345,
															"Epidata",
															"German",
															35227679,
															0);
	}

	@Test
	public void testVerSaldo() {
		CuentaSueldo miObjetoCuentaSueldo = new CuentaSueldo(12345,
															"Epidata",
															"German",
															35227679,
															5000);
		assertTrue(miObjetoCuentaSueldo.verSaldo()==5000);
	}
	
	@Test
	public void testDepositar() {
		CuentaSueldo miObjetoCuentaSueldo = new CuentaSueldo(12345,
															"Epidata",
															"German",
															35227679,
															5000);
		double nuevoSaldo;
		nuevoSaldo = miObjetoCuentaSueldo.depositar(3000);
		assertTrue(nuevoSaldo==8000);
	}	

	@Test
	public void testExtraerCantidadMenorAlSaldo() {
		CuentaSueldo miObjetoCuentaSueldo = new CuentaSueldo(12345,
															"Epidata",
															"German",
															35227679,
															5000);
		miObjetoCuentaSueldo.extraer(3500);
		assertTrue(miObjetoCuentaSueldo.verSaldo()==1500);		
	}
	
	@Test
	public void testExtraerCantidadMayorAlSaldo() {
		CuentaSueldo miObjetoCuentaSueldo = new CuentaSueldo(12345,
															"Epidata",
															"German",
															35227679,
															5000);
		miObjetoCuentaSueldo.extraer(6000);
		assertFalse(miObjetoCuentaSueldo.verSaldo()<0);
		assertTrue(miObjetoCuentaSueldo.verSaldo()==5000);
	}
	
}
