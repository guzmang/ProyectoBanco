package banco.cuentas;

import static org.junit.Assert.*;

import org.junit.Test;

import banco.personas.Cliente;

public class CuentaCorrienteTest {

	@Test
	public void testAndaConstructor() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		0,
																		1000);
	}

	@Test
	public void testVerSaldo() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		5000,
																		1000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==5000);
	}	

	@Test
	public void testDepositar() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		5000,
																		1000);
		double nuevoSaldo;
		nuevoSaldo = miObjetoCuentaCorriente.depositar(3000);
		assertTrue(nuevoSaldo==8000);
	}
	
	@Test
	public void testExtraerCantidadMenorAlSaldo() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		5000,
																		1000);
		miObjetoCuentaCorriente.extraer(3500);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==1500);		
	}	

	@Test
	public void testExtraerCantidadMayorAlSaldoPeroSinPasarElGiroEnRojo() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		5000,
																		1000);
		miObjetoCuentaCorriente.extraer(6000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==-1000);
	}	
	
	@Test
	public void testExtraerCantidadMayorAlSaldoYElGiroEnRojo() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		5000,
																		1000);
		miObjetoCuentaCorriente.extraer(6001);
		assertFalse(miObjetoCuentaCorriente.verSaldo()<-1000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==5000);
	}	

	@Test
	public void testExtraerConSaldoNegativoSinPasarElGiroEnRojo() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		-500,
																		1000);
		miObjetoCuentaCorriente.extraer(500);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==-1000);
	}	

	@Test
	public void testExtraerConSaldoNegativoPasandoElGiroEnRojo() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		-500,
																		1000);
		miObjetoCuentaCorriente.extraer(501);
		assertFalse(miObjetoCuentaCorriente.verSaldo()<-1000);
		assertTrue(miObjetoCuentaCorriente.verSaldo()==-500);
	}		

	@Test
	public void testPuedoTenerMuchosTitularesEnLaMismaCuenta() {
		Cliente german = new Cliente("German", 35227679);
		CuentaCorriente miObjetoCuentaCorriente = new CuentaCorriente(	12345,
																		german,
																		5000,
																		1000);
		Cliente andres = new Cliente("Andres", 3500000);
		Cliente fulano = new Cliente("Fulano", 3600000);
		
		miObjetoCuentaCorriente.agregarTitular(andres);
		miObjetoCuentaCorriente.agregarTitular(fulano);
		
		assertEquals(3, miObjetoCuentaCorriente.getTitulares().size());
	}
	
}
