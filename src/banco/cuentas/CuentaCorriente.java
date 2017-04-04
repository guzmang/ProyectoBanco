package banco.cuentas;

import java.util.ArrayList;

import banco.personas.Cliente;

public class CuentaCorriente extends Cuenta{

	private ArrayList<Cliente> titulares = new ArrayList<Cliente>();
	private final double giroEnRojo;

	public CuentaCorriente (int nroDeCuenta,
							Cliente titularPrincipal,
							double saldo,
							double giroEnRojo){
		super(nroDeCuenta, titularPrincipal, saldo);
		this.titulares.add(titularPrincipal);
		this.giroEnRojo = giroEnRojo;
	}

	public void extraer(double saldoExtraido){
		double aux = getSaldo() + giroEnRojo;
		if(saldoExtraido > aux)
			System.out.println("Error: El saldo a extraer excede sus fondos");
		else{
			setSaldo(getSaldo() - saldoExtraido);
			System.out.println("Ha extraido $" + saldoExtraido + 
				". Quedan $" + getSaldo() + " en su cuenta.");
		}
	}
	
	public void agregarTitular(Cliente nuevoTitular){
		this.titulares.add(nuevoTitular);
	}
	
	public ArrayList<Cliente> getTitulares(){
		return titulares;
	}	
	
}
