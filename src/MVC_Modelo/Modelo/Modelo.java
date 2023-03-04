package MVC_Modelo.Modelo;

import Entidades.Personas.Direccion;
import Entidades.Personas.Pasajero;
import Entidades.Personas.PersonaEmergencia;
import Entidades.Tren.TipoPasajero;
import Entidades.Tren.Tren;
import Entidades.Tren.Vagon;
import MVC_Controlador.Controlador;
import MVC_Modelo.Listas.LinkedList;
import MVC_Modelo.Listas.LinkedListNode;
import MVC_Modelo.MaquinaVenta.Tiquete;
import MVC_Modelo.MaquinaVenta.MaquinaVenta;

import java.util.Iterator;


public class Modelo {
   private Controlador controlador;
   private Tiquete tiquete=new Tiquete();
   private Vagon vagon=new Vagon();
   private Tren tren;
   private Direccion direccion;
   private Pasajero pasajero;
   private TipoPasajero tipoDePasajero;

   public Modelo(Controlador controlador) {
      this.controlador = controlador;
   }
   public Modelo(){

   }

   public Direccion definirDireccion(String ciudad, String calle, String carrera){
      Direccion direccion1=new Direccion(ciudad,calle,carrera);
      return direccion1;
   }
   public Pasajero definirPasajero(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono, int idRegistro, TipoPasajero pasajero){
      Pasajero p1=new Pasajero(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono,idRegistro,pasajero);
      return p1;
   }
   public PersonaEmergencia definirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono){
      PersonaEmergencia emergencia=new PersonaEmergencia(nombre, apellido, tipoIdentificacion, numeroIdentificacion, direccionActual, telefono);
      return emergencia;
   }

   public LinkedList listaDeRutasTren(){
      return tiquete.listaRutas();// informacion de la lista de rutas
   }
   public void desplegarRutastren(){
      tiquete.desplegarRutas();// muestra la lista de rutas
   }
   public void definirRuta(int numerotren){
      tiquete.elegirRuta(numerotren);
   }

   public boolean añadirPasajeroVagon(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono, int idRegistro, TipoPasajero tipoPasajeros){
      Pasajero pasajero1=new Pasajero(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono, idRegistro,tipoPasajeros);
      vagon=new Vagon(pasajero1);
      return vagon.añadirPasajero(pasajero1);
   }
   public boolean añadirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono){
      PersonaEmergencia contacto=new PersonaEmergencia(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono);
      return true;
   }

   public int definirId(int numeroIdentificacion){
      pasajero.setIdRegistro(numeroIdentificacion);
      return pasajero.getIdRegistro();
   }

   public int buscarPasajeroPuestos(int idRegistro) {
         return vagon.buscarPasajero(idRegistro);
      }

      public int precioTipoPasajero(String eleccionTipo){
         return tipoDePasajero.definirPasajero(eleccionTipo);
      }
      public TipoPasajero tipoPasajeroEscoger(String tipoElegido){
         TipoPasajero pas1= new TipoPasajero(tipoElegido);
         return pas1;
      }

      public boolean añadirVagonTren (Vagon vagon){
         boolean varible=tren.añadirVagon(vagon);
         return varible;
      }

   }
