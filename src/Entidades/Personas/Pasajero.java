package Entidades. Personas;

public class Pasajero extends Persona {

	public Pasajero(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion,
			Direccion direccionActual, int telefono, int idRegistro) {
		super(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
		this.idRegistro = idRegistro;
	}

	private int idRegistro;

	public int getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(int idRegistro) {
		this.idRegistro = idRegistro;
	}
	
	
	
	
	
	


	
	

	

}
