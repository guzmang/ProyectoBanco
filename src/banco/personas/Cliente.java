package banco.personas;

import java.util.ArrayList;
import banco.cuentas.*;

public class Cliente {

	private String nombreCliente;
	private double dni;
	private ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Cliente(String nombreCliente, double dni){
		this.nombreCliente = nombreCliente;
		this.dni = dni;
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

	@Override
	public boolean equals(Object obj){
	     if (obj == null)
	    	 return false;
	     if (this == obj)
	    	 return true;
	     if (!(obj instanceof Cliente))
	    	 return false;
	     Cliente c = (Cliente) obj;
	     return this.dni == c.dni;
	}
	
	// Acerca del metodo que esta a continuacion:
	// podria devolver void pero a modos didacticos se decidio que devuelva un boolean
	// para ver mejor reflejado el resultado en los tests
	
	boolean agregarCuenta(Cuenta cuentaNueva){
		if(this.cuentas.size() == 0){
			this.cuentas.add(cuentaNueva);
			return true;						
		}			
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
