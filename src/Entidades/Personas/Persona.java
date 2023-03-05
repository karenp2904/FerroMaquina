package Entidades.Personas;

public class Persona {
	
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
	public Persona(){

	}

	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccionActual() {
		return direccionActual;
	}
	public void setDireccionActual(Direccion direccionActual) {
		this.direccionActual = direccionActual;
	}
	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
