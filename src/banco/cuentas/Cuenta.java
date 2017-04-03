package banco.cuentas;

public class Cuenta {

	private int nroDeCuenta;	
	private String nombreTitular;
	private double dni;
	private double saldo;

	public Cuenta (int nroDeCuenta,
					String nombreTitular,
					double dni,
					double saldo){			
		this.nroDeCuenta = nroDeCuenta;
		this.nombreTitular = nombreTitular;
		this.dni = dni;
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
			setSaldo(getSaldo() - saldoExtraido);
			System.out.println("Ha extraido $" + saldoExtraido + 
				". Quedan $" + getSaldo() + " en su cuenta.");
		}
	}

	public double verSaldo(){
		System.out.println("Su saldo es de: $" + this.saldo);
		return this.saldo;
	}

	public double getSaldo(){
		return saldo;
	}

	public void setSaldo(double saldo){
		this.saldo = saldo;
	}					

}
