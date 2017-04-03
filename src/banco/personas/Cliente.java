package banco.personas;

import java.util.ArrayList;
import banco.cuentas.*;

public class Cliente {

	ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	Cliente(Cuenta cuentaInicial){
		this.cuentas.add(cuentaInicial);
	}
	
	int cantidadCuentasSueldo(){
		int cuentasSueldo = 0;
		for(int i=0; i < this.cuentas.size(); i++)
			if(this.cuentas.get(i) instanceof CuentaSueldo)
				cuentasSueldo++;
		return cuentasSueldo;
	}

	int cantidadCuentasCorrientes(){
		int cuentasCorrientes = 0;
		for(int i=0; i < this.cuentas.size(); i++)
			if(this.cuentas.get(i) instanceof CuentaCorriente)
				cuentasCorrientes++;
		return cuentasCorrientes;
	}
	
	ArrayList<Cuenta> getCuentas(){
		return cuentas;
	}
	
	// Acerca del metodo que esta a continuacion:
	// podria devolver void pero a modos didacticos se decidio que devuelva un boolean
	// para ver mejor reflejado el resultado en los tests
	
	boolean agregarCuenta(Cuenta cuentaNueva){
		if(cuentaNueva instanceof CuentaSueldo &&
				this.cantidadCuentasSueldo() >= this.cantidadCuentasCorrientes()){
			System.out.println("Error: no se ha podido agregar cuenta");
			return false;
		}
		else{
			this.cuentas.add(cuentaNueva);
			return true;
		}
	}
	
}
