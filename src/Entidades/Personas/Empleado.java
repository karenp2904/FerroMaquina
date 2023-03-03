package Personas;

public class Empleado extends Persona {

	String empleado;
	
	public Empleado(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion,
			Direccion direccionActual, int telefono,  String empleado) {
		super(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
	
		this.empleado = empleado;
	}
	
	
	
	

}
