package MVC_Controlador;

import Entidades.Personas.Direccion;
import Entidades.Tren.TipoPasajero;
import MVC_Modelo.MaquinaVenta.Tiquete;
import MVC_Modelo.Modelo.Modelo;
import MVC_Vista.Vista;

import java.time.LocalDateTime;

public class Controlador  {
	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}
	public Controlador(){

	}

	public void start(){
		vista.bienvenida();
		solicitarDatos();
	}
	public void desplejarTodasRutasControl(){
		modelo.desplegarRutastren();
		eleecionRuta();
	}
	public void eleecionRuta(){
		int numerotren=vista.mostrarOpcionesElegirRuta();
		modelo.definirRuta(numerotren);
	}

	public void solicitarDatos(){

		String nombre=vista.ingresarNombre();
		String apellido=vista.ingresarApellido();
		String tipoId=vista.ingresarTipoIdentificacion();
		String numeroIde=vista.ingresarNumeroIdentificacion();

		String ciudad=vista.ingresarDireccionCiudad();
		String calle= vista.ingresarDireccionCalle();
		String carrera= vista.ingresarDireccionCarrera();
		Direccion direccionActual=modelo.definirDireccion(ciudad,calle,carrera);

		String telefono= vista.ingresarNumTelefonico();

		String idRegistro=numeroIde;
		String eleecion= vista.elegirPasajeroDeTiquete();
		TipoPasajero pasajeroTipo=modelo.tipoPasajeroEscogerNombre(eleecion);
		añadirPersona(nombre, apellido, tipoId,numeroIde,direccionActual,telefono,idRegistro,pasajeroTipo);
		solicitarDatosEmergencia();
	}

	public void solicitarDatosEmergencia(){
		String nombre=vista.ingresarNombreEmergencia();
		String apellido=vista.ingresarApellidoEmergencia();
		String tipoId=vista.ingresarTipoIdentificacionEmergencia();
		String numeroIde=vista.ingresarNumeroIdentificacionEmergencia();
		String ciudad=vista.ingresarDireccionCiudadEmergencia();
		String calle= vista.ingresarDireccionCalleEmergencia();
		String carrera= vista.ingresarDireccionCarreraEmergencia();
		String telefono= vista.ingresarNumTelefonicoEmergencia();
		Direccion direccionActual=modelo.definirDireccion(ciudad,calle,carrera);
		añadirContactoEmergencia(nombre, apellido, tipoId, numeroIde,direccionActual,telefono);
		this.desplejarTodasRutasControl();
	}
	public int pesoCargaControl(){
		int peso= vista.ingresarPesoDeCarga();
		return peso;
	}
	public void añadirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion,
										 Direccion direccionActual, String telefono){
		modelo.añadirContactoEmergencia(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono);

	}
	public void añadirPersona(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion,
							  Direccion direccionActual, String telefono, String idRegistro, TipoPasajero tipoPasajeroo){
		modelo.añadirPasajeroVagon(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono,idRegistro,tipoPasajeroo);


	}
	public void generarTiqueteControl(){
		modelo.agregarTiqueteMod();
	}

	public LocalDateTime getHoraCompraMode(){
		return modelo.getHoraCompraMode();
	}




}
