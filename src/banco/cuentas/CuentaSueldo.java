package banco.cuentas;

public class CuentaSueldo extends Cuenta{

	private String nombreEmpleador;
	
	public CuentaSueldo (int nroDeCuenta,
						String nombreEmpleador,
						String nombreTitular,
						double dni,
						double saldo){
		super(nroDeCuenta, nombreTitular, dni, saldo);
		this.nombreEmpleador = nombreEmpleador;
	}

}
