package MVC_Modelo.Modelo;

import Entidades.Personas.Direccion;
import Entidades.Personas.Pasajero;
import Entidades.Personas.Persona;
import Entidades.Personas.PersonaEmergencia;
import Entidades.Tren.RutaTren;
import Entidades.Tren.TipoPasajero;
import Entidades.Tren.Tren;
import Entidades.Tren.Vagon;
import MVC_Controlador.Controlador;
import MVC_Modelo.Listas.LinkedList;
import MVC_Modelo.Listas.LinkedListNode;
import MVC_Modelo.MaquinaVenta.Tiquete;

import java.time.LocalDateTime;
import java.util.Iterator;


public class Modelo {
   private Controlador controlador;
   private Tiquete tiquete=new Tiquete();
   private Vagon vagon=new Vagon();
   private Tren tren;
   private Direccion direccion;
   private PersonaEmergencia contactoEmergencia;
   private Pasajero pasajero;
   private TipoPasajero tipoDePasajero;
   private RutaTren rutas;
   private Persona persona= new Persona();



   public Modelo(Controlador controlador) {
      this.controlador = controlador;
   }
   public Modelo(){

   }

   //metodo para definir la direccion del pasajero que se implementa en el controlador
   public Direccion definirDireccion(String ciudad, String calle, String carrera){
      Direccion direccion1=new Direccion(ciudad,calle,carrera);
      return direccion1;
   }
   //meetodo para definir al pasajero
   public Pasajero definirPasajero(){
      return pasajero;
   }
   //metodo para la persona de mergencia
   public PersonaEmergencia definirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono){
       contactoEmergencia=new PersonaEmergencia(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
      return contactoEmergencia;
   }

   //metodo para las rutas del tren
   public LinkedList listaDeRutasTren(){
      return tiquete.listaRutas();// informacion de la lista de rutas
   }

   //metodo que despliega las rutas del tren
   public void desplegarRutastren(){
      tiquete.desplegarRutas();// muestra la lista de rutas
   }

   //metodo en ell que se elije un ruta
   public RutaTren definirRuta(int numerotren){
      rutas=tiquete.elegirRuta(numerotren);
      iniciarTren();
      agregarTiqueteMod();
      return rutas;
   }
   public void iniciarTren(){
      rutas.getTren().añadirVagon();
   }

   //se añade el pasajero
   public boolean añadirPasajeroVagon(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono, int idRegistro, TipoPasajero tipoPasajeros){
      pasajero=new Pasajero(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono, idRegistro,tipoPasajeros);
     //vagon=new Vagon(pasajero);
      definirPasajero();
      return  vagon.añadirPasajero(pasajero,rutas);
   }

   //se añade al contacto de emergencia
   public boolean añadirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono){
      contactoEmergencia=new PersonaEmergencia(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono);
      return true;
   }

   //se defin el ID de registro del pasajero, el cual sera el numero de idenficacion ingresado
   public int definirId(int numeroIdentificacion){
      pasajero.setIdRegistro(numeroIdentificacion);
      return pasajero.getIdRegistro();
   }


   //se busca al pasajero en el tren
      public int buscarPasajeroTrenMod(String idTren, Pasajero pasajero) {
         return rutas.getTren().buscarEnTren(idTren,pasajero);// se usa el pasjero actual
      }

      // se define el precio del pasajero segun su eleccion
   public int precioTipoPasajeroMod(String eleccionTipo){
         return tipoDePasajero.definirPasajero(eleccionTipo);
   }
      //se define el tipo de pasajero por nombre
   public TipoPasajero tipoPasajeroEscogerNombre(String tipoElegido){
         tipoDePasajero= new TipoPasajero(tipoElegido);
         return tipoDePasajero;
   }


   //se añade un vagon al tren
   public boolean añadirVagonTren (){

         boolean varible=tren.añadirVagon();
         return varible;
   }
   public LocalDateTime getHoraCompraMode(){
      return tiquete.getFechaHoraCompra();
   }
   public int getPesoCargaMode(){
      return tiquete.getPesoCarga();
   }

   public void guardarInformacion(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono){
      persona=new Persona(nombre,apellido,numeroIdentificacion,tipoIdentificacion,direccionActual,telefono);

   }

   //añadir tiquete
   public void agregarTiqueteMod(){
      System.out.println("-------------TIQUETE DEL PASAJERO------------------");
      System.out.println("     Datos del Pasajero     ");
      System.out.println("\nNombre: " + persona.getNombre());
      System.out.println("Apellido: " + persona.getApellido());
      System.out.println("Direccion: " + persona.getDireccionActual());
      System.out.println("Tipo identificación: " + persona.getTipoIdentificacion());
      System.out.println("Numero identificación: " +pasajero.getIdRegistro());// el registro es igual a la identificacion
      System.out.println("Telefono: " + persona.getTelefono());
      System.out.println();
      System.out.println("Id registro: " + pasajero.getIdRegistro());
      System.out.println("Peso de carga: "+ getPesoCargaMode());
      System.out.println("Precio: "+ tiquete.getValorPasaje());
      System.out.println("Tipo pasajero: " + pasajero.getTipoPasajero());

      System.out.println("     Datos del contacto de emergencia     ");
      System.out.println("\nNombre: " + contactoEmergencia.getNombre());
      System.out.println("Apellido: " + contactoEmergencia.getApellido());
      System.out.println("Direccion: " + contactoEmergencia.getDireccionActual());
      System.out.println("Tipo identificación: " + contactoEmergencia.getTipoIdentificacion());
      System.out.println("Numero identificación: " + contactoEmergencia.getNumeroIdentificacion());// el registro es igual a la identificacion
      System.out.println("Telefono: " + contactoEmergencia.getTelefono());

      System.out.println("     Datos del tren     ");
      System.out.println("Tren: " + rutas.getTren().getIdTren());
      System.out.println("Origen: " + rutas.getOrigen());
      System.out.println("Destino: " + rutas.getDestino());
      System.out.println("Fecha de salida: " + rutas.getFechaSalida());
      System.out.println("Fecha de llegada: " + rutas.getFechaLlegada());
      System.out.println("---------------------------------------------");

      tiquete.generarTiquete(pasajero,contactoEmergencia,tren);

   }

   }
