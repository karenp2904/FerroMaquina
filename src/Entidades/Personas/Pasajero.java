package Entidades. Personas;

import Entidades.Tren.TipoPasajero;

public class Pasajero extends Persona {


	public Pasajero(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono, int idRegistro, TipoPasajero pasajero) {
		super(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
		this.idRegistro = idRegistro;
		this.tipoPasajero=tipoPasajero;
	}



	private int idRegistro;
	private TipoPasajero tipoPasajero;

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	
	
	
	
	
	


	
	

	

}
