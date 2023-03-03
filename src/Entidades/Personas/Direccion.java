package Personas;

public class Direccion {
	
	
	String calle;
	String carrera;
	String ciudad;

	
	public Direccion(String calle, String carrera, String ciudad) {
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
