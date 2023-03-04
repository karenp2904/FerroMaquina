package MVC_Controlador;

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

	public Controlador() {
	}

	public void start(){
		vista.bienvenida();
	}




}
