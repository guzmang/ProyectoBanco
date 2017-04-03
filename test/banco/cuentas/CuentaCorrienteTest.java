package banco.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaCorrienteTest {

	@Test
	public void testAndaConstructor() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		0,
																		1000);
	}

	@Test
	public void testVerSaldo() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		5000,
																		1000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==5000);
	}	

	@Test
	public void testDepositar() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		5000,
																		1000);
		double nuevoSaldo;
		nuevoSaldo = miObjetoCuentaCorriente.depositar(3000);
		assertTrue(nuevoSaldo==8000);
	}
	
	@Test
	public void testExtraerCantidadMenorAlSaldo() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		5000,
																		1000);
		miObjetoCuentaCorriente.extraer(3500);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==1500);		
	}	

	@Test
	public void testExtraerCantidadMayorAlSaldoPeroSinPasarElGiroEnRojo() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		5000,
																		1000);
		miObjetoCuentaCorriente.extraer(6000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==-1000);
	}	
	
	@Test
	public void testExtraerCantidadMayorAlSaldoYElGiroEnRojo() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		5000,
																		1000);
		miObjetoCuentaCorriente.extraer(6001);
		assertFalse(miObjetoCuentaCorriente.verSaldo()<-1000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==5000);
	}	

	@Test
	public void testExtraerConSaldoNegativoSinPasarElGiroEnRojo() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		-500,
																		1000);
		miObjetoCuentaCorriente.extraer(500);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==-1000);
	}	

	@Test
	public void testExtraerConSaldoNegativoPasandoElGiroEnRojo() {
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		"German",
																		35227679,
																		-500,
																		1000);
		miObjetoCuentaCorriente.extraer(501);
		assertFalse(miObjetoCuentaCorriente.verSaldo()<-1000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==-500);
	}		
	
}
