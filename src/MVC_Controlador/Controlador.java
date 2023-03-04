package MVC_Controlador;

import Entidades.Personas.Direccion;
import Entidades.Tren.TipoPasajero;
import MVC_Modelo.Modelo.Modelo;
import MVC_Vista.Vista;

public class Controlador  {
	private Modelo modelo=new Modelo();
	private Vista vista=new Vista();
	
	public Controlador(Modelo modelo, Vista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}
	public Controlador(){

	}

	public void start(){
		vista.bienvenida();
	}
	public void mostrarRutastren(){
		modelo.desplegarRutastren();
	}
	public void eleecionRuta(){
		int numerotren=vista.mostrarOpcionesElegirRuta();
		modelo.definirRuta(numerotren);
	}

	public void solicitarDatos(){

		String nombre=vista.ingresarNombre();
		String apellido=vista.ingresarApellido();
		String tipoId=vista.ingresarTipoIdentificacion();
		int numeroIde=vista.ingresarNumeroIdentificacion();

		String ciudad=vista.ingresarDireccionCiudad();
		String calle= vista.ingresarDireccionCalle();
		String carrera= vista.ingresarDireccionCarrera();
		Direccion direccionActual=modelo.definirDireccion(ciudad,calle,carrera);

		int telefono= vista.ingresarNumTelefonico();

		int idRegistro=modelo.definirId(numeroIde);
		TipoPasajero pasajeroTipo=modelo.tipoPasajeroEscoger(vista.elegirPasajeroDeTiquete());
		añadirPersona(nombre, apellido, tipoId, numeroIde,direccionActual,telefono,idRegistro,pasajeroTipo);

	}

	public void solicitarDatosEmergencia(){
		String nombre=vista.ingresarNombreEmergencia();
		String apellido=vista.ingresarApellidoEmergencia();
		String tipoId=vista.ingresarTipoIdentificacionEmergencia();
		int numeroIde=vista.ingresarNumeroIdentificacionEmergencia();
		String ciudad=vista.ingresarDireccionCiudadEmergencia();
		String calle= vista.ingresarDireccionCalleEmergencia();
		String carrera= vista.ingresarDireccionCarreraEmergencia();
		int telefono= vista.ingresarNumTelefonicoEmergencia();
		Direccion direccionActual=modelo.definirDireccion(ciudad,calle,carrera);
		añadirContactoEmergencia(nombre, apellido, tipoId, numeroIde,direccionActual,telefono);

	}
	public void añadirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion,
										 Direccion direccionActual, int telefono){
		modelo.añadirContactoEmergencia(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono);

	}
	public void añadirPersona(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion,
							  Direccion direccionActual, int telefono, int idRegistro, TipoPasajero tipoPasajeroo){
		modelo.añadirPasajeroVagon(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono,idRegistro,tipoPasajeroo);


	}




}
