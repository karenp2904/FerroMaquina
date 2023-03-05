package Entidades.Personas;

public class Empleado extends Persona {

	private String empleado;
	
	public Empleado(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion,
			Direccion direccionActual, String telefono,  String empleado) {
		super(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
	
		this.empleado = empleado;
	}
	
	
	
	

}
