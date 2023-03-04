package MVC_Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entidades.Personas.Pasajero;
import MVC_Modelo.MaquinaVenta.Tiquete;
import MVC_Modelo.Modelo;
import MVC_Vista.Vista;

public class Controlador  {
	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}

	public Controlador() {
	}

	public void start(){

	}



}
