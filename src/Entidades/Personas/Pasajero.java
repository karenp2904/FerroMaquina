package Entidades. Personas;

import Entidades.Tren.TipoPasajero;

public class Pasajero extends Persona{


	public Pasajero(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion, Direccion direccionActual, String telefono, String idRegistro, TipoPasajero pasajero) {
		super(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
		this.idRegistro = idRegistro;
		this.tipoPasajero=tipoPasajero;
	}



	private String idRegistro;
	private TipoPasajero tipoPasajero;

	public String getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(String idRegistro) {
		this.idRegistro = idRegistro;
	}


	public TipoPasajero getTipoPasajero() {
		return tipoPasajero;
	}

	public void setTipoPasajero(TipoPasajero tipoPasajero) {
		this.tipoPasajero = tipoPasajero;
	}
}
