package banco.cuentas;

import banco.personas.Cliente;

public class CuentaSueldo extends Cuenta{

	private String nombreEmpleador;
	
	public CuentaSueldo (int nroDeCuenta,
						String nombreEmpleador,
						Cliente titular,
						double saldo){
		super(nroDeCuenta, titular, saldo);
		this.nombreEmpleador = nombreEmpleador;
	}

}
