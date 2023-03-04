package Entidades.Personas;

public abstract class Persona {
	
	//informacion datos de la persona
	
	private String nombre;
	private String apellido;
	private String tipoIdentificacion;
	private int numeroIdentificacion;
	private Direccion direccionActual;
	private int telefono;
	

	public Persona(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion,
			Direccion direccionActual, int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.direccionActual = direccionActual;
		this.telefono = telefono;
	}
	

}
