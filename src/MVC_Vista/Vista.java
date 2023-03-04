package MVC_Vista;

import Entidades.Personas.Direccion;
import Entidades.Tren.Tren;
import MVC_Controlador.Controlador;

import java.util.Scanner;

public class Vista {
	   private Controlador controlador;

	public Vista(Controlador controlador) {
		this.controlador = controlador;
	}

	Scanner sc=new Scanner(System.in);
		public void bienvenida(){
			System.out.println("Bienvenido al FerroUPB");
			System.out.println("Ingrese sus datos personales");
		}

		//metodos para ingresar la informacion del pasajero
		public String ingresarNombre(){
			System.out.println("Ingrese su nombre: ");
			String nombre=sc.next();
			return nombre;
		}
		public String ingresarApellido(){
			System.out.println("Ingrese su apellido: ");
			String apellido=sc.next();
			return apellido;
		}
		public int ingresarEdad(){
			System.out.println("Ingrese su edad: ");
			int edad=sc.nextInt();
			return edad;
		}
		public String ingresarTipoIdentificacion(){
			System.out.println("Ingrese su tipo de identificacion: ");
			String tipoIdentificacion=sc.next();
			return tipoIdentificacion;
		}
		public int ingresarNumeroIdentificacion(){
			System.out.println("Ingrese su numero de identificacion: ");
			int numero=sc.nextInt();
			return numero;
		}
		public String ingresarDireccion(){
			System.out.println("Ingrese su direccion: ");
			String direccion=sc.next();
			return direccion;
		}
		public int ingresarNumTelefonico(){
			System.out.println("Ingrese su numero de telefono: ");
			int telefono=sc.nextInt();
			return telefono;
		}

		//metodos para la informacion del contacto de emergencia
		public String ingresarNombreEmergencia(){
			System.out.println("A continuación se le solicitará la información para un contacto de emergencia ");
			System.out.println("Ingrese su nombre: ");
			String nombre=sc.next();
			return nombre;
		}
		public String ingresarApellidoEmergencia(){
			System.out.println("Ingrese su apellido: ");
			String apellido=sc.next();
			return apellido;
		}
		public int ingresarEdadEmergencia(){
			System.out.println("Ingrese su edad: ");
			int edad=sc.nextInt();
			return edad;
		}
		public String ingresarTipoIdentificacionEmergencia(){
			System.out.println("Ingrese su tipo de identificacion: ");
			String tipoIdentificacion=sc.next();
			return tipoIdentificacion;
		}
		public int ingresarNumeroIdentificacionEmergencia(){
			System.out.println("Ingrese su numero de identificacion: ");
			int numero=sc.nextInt();
			return numero;
		}
		public String ingresarDireccionEmergencia(){
			System.out.println("Ingrese su direccion: ");
			String direccion=sc.next();
			return direccion;
		}
		public int ingresarNumTelefonicoEmergencia(){
			System.out.println("Ingrese su numero de telefono: ");
			int telefono=sc.nextInt();
			return telefono;
		}

		//metodos para las rutas del tren
		public void mostrarTodasRutas(){//aviso antes de que se muestren las rutas
			System.out.println("A continuacion, se mostraran los trenes disponibles con sus respectivas rutas");
		}
		public int mostrarOpcionesElegirRuta() {//se muestran las opciones de trenes, pero antes se desplegaron las rutas
			Scanner entrada=new Scanner(System.in);
			int numeroTren = 0;
			do {
				System.out.println("¿Cúal tren tiene la ruta su preferencia? " +
					"\n1. 001" +
					"\n2. 002 " +
					"\n3. 003" +
					"\n4. 004 " +
					"\n5. 005" +
					"\n6. 006 " +
					"\n7. 007 " +
					"\n8. 008 " +
					"\nElija el tren: ");
				numeroTren = entrada.nextInt();

			} while (numeroTren < 1 || numeroTren > 9);
			return numeroTren;
		}
		public int  ingresarPesoDeCarga(){// se ingresa el peso de carga
			int peso=0;
			do {
				System.out.println("Ingreso el peso de su equipaje");
				peso = sc.nextInt();
			}while (peso>150); //150 es el peso maximo que podra tener el equipaje, si es mayor el usuario tendra que colocar otro para poder seguir
			return peso;
		}

		public String elegirPrecioDeTiquete(){
			String tipo;
			System.out.println("Tipos de tarifas disponibles"
					+ "\n Ejecutivo" +
					"\nPremium" +
					"\nEcomonico" +
					"Ingrese el tipo que desea: ");
			tipo=sc.next();
			while (tipo.toLowerCase()!="ejecutivo"||tipo.toLowerCase()!="premium"||tipo.toLowerCase()!="economico"){
				System.out.println("Debe ingresar un tipo de tarifa valido.");
				System.out.println("Tarifas disponibles"
						+ "\n Ejecutivo" +
						"\nPremium" +
						"\nEcomonico" +
						"Ingrese el tipo que desea: ");
				tipo=sc.next();
			}
			return tipo;
		}


}
