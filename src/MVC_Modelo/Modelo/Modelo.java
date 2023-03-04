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
   private Persona persona;

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
   public void definirRuta(int numerotren){
      tren=tiquete.elegirRuta(numerotren);
      iniciarTren();
   }
   public void iniciarTren(){
      tren=new Tren();
      tren.añadirVagon();
   }

   //se añade el pasajero
   public boolean añadirPasajeroVagon(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono, int idRegistro, TipoPasajero tipoPasajeros){
      pasajero=new Pasajero(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono, idRegistro,tipoPasajeros);
     //vagon=new Vagon(pasajero);
      definirPasajero();
      return  vagon.añadirPasajero(pasajero);
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
      public int buscarPasajeroTrenMod(String idTren) {
         return tren.buscarEnTren(idTren,pasajero);// se usa el pasjero actual
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

   }




   //añadir tiquete
   public void agregarTiqueteMod(){

      Iterator ite=tiquete.listaRutas().iterator();
      System.out.println("-------------TIQUETE DEL PASAJERO------------------");
      while (ite.hasNext()) {
         LinkedListNode rutass = (LinkedListNode) ite.next();
         RutaTren rutas= (RutaTren) rutass.getObject();
         if(rutas.getTren()==tren){
            System.out.println();
            System.out.println("Tren: " + rutas.getTren().getIdTren());
            System.out.println("Origen: " + rutas.getOrigen());
            System.out.println("Destino: " + rutas.getDestino());
            System.out.println("Fecha de salida: " + rutas.getFechaSalida());
            System.out.println("Fecha de llegada: " + rutas.getFechaLlegada());
            System.out.println("---------------------------------------------");
         }
         tiquete.generarTiquete(pasajero,contactoEmergencia,tren);
      }
   }

   }
