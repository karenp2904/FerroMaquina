package MVC_Controlador;

import Entidades.Personas.Direccion;
import MVC_Modelo.Modelo.Modelo;
import MVC_Vista.Vista;

public class Controlador  {
	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}


	public void start(){
		vista.bienvenida();
		solicitarDatos();
	}

	public void solicitarDatos(){
		String nombre=vista.ingresarNombre();
		String apellido=vista.ingresarApellido();
		int edad= vista.ingresarEdad();
		String tipoId=vista.ingresarTipoIdentificacion();
		int numeroIde=vista.ingresarNumeroIdentificacion();
		String ciudad=vista.ingresarDireccionCiudad();
		String calle= vista.ingresarDireccionCalle();
		String carrera= vista.ingresarDireccionCarrera();
		int telefono= vista.ingresarNumTelefonico();





	}
	public void añadirPersona(String nombre,String apellido, int edad,String tipoIdentificacion, int tipoDeIdentificacion){

	}




}
