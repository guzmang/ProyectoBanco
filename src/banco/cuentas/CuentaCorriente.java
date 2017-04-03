package banco.cuentas;

public class CuentaCorriente extends Cuenta{

	private final double giroEnRojo;

	public CuentaCorriente (int nroDeCuenta,
							String nombreTitular,
							double dni,
							double saldo,
							double giroEnRojo){
		super(nroDeCuenta, nombreTitular, dni, saldo);
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
	
}
