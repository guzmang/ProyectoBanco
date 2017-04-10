package banco.cuentas;

import java.util.ArrayList;

import banco.personas.Cliente;

public class Cuenta {

	private int nroDeCuenta;	
	private Cliente titular;
	private double saldo;
	
	public Cuenta (int nroDeCuenta,
					Cliente titular,
					double saldo){			
		this.nroDeCuenta = nroDeCuenta;
		this.titular = titular;
		this.saldo = saldo;
	}	

	public double depositar(double saldoDepositado){
		this.saldo = this.saldo + saldoDepositado;
		return this.saldo;
	}
		
	public void extraer(double saldoExtraido){
		if(saldoExtraido > getSaldo())
			System.out.println("Error: El saldo a extraer excede sus fondos");
		else{
			this.saldo = this.saldo - saldoExtraido;
			System.out.println("Ha extraido $" + saldoExtraido + 
				". Quedan $" + getSaldo() + " en su cuenta.");
		}
	}

	public double verSaldo(){
		System.out.println("Su saldo es de: $" + this.saldo);
		return this.saldo;
	}
	
	@Override
	public boolean equals(Object obj){
	     if (obj == null)
	    	 return false;
	     if (this == obj)
	    	 return true;
	     if (!(obj instanceof Cuenta))
	    	 return false;
	     Cuenta c = (Cuenta) obj;
	     return this.nroDeCuenta == c.nroDeCuenta;
	}	
	
	public double getSaldo(){
		return this.saldo;
	}

	public void setSaldo(double saldo){
		this.saldo = saldo;
	}					

}
