package Entidades.Personas;

public class Direccion {


	private String calle;
	private String carrera;
	private String ciudad;

	
	public Direccion(String ciudad,String calle, String carrera) {
		this.calle = calle;
		this.carrera = carrera;
		this.ciudad = ciudad;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	

}
