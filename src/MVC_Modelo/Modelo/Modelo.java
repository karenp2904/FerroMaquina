package MVC_Modelo.Modelo;

import Entidades.Personas.Direccion;
import Entidades.Personas.Pasajero;
import Entidades.Tren.TipoPasajero;
import Entidades.Tren.Tren;
import Entidades.Tren.Vagon;
import MVC_Controlador.Controlador;
import MVC_Modelo.Listas.LinkedList;
import MVC_Modelo.MaquinaVenta.Tiquete;
import MVC_Modelo.MaquinaVenta.MaquinaVenta;


public class Modelo {
   private Controlador controlador;
   private Tiquete tiquete;
   private Vagon vagon;
   private Tren tren;
   private Direccion direccion;
   private Pasajero pasajero;
   private TipoPasajero tipoDePasajero;

   public Direccion definirDireccion(String ciudad,String calle, String carrera){
      Direccion direccion1=new Direccion(ciudad,calle,carrera);
      return direccion1;
   }
   public Pasajero definirPersona(String nombre, String apellido, String tipoIdentificacion, int numeroIdentificacion, Direccion direccionActual, int telefono, int idRegistro){
      Pasajero p1=new Pasajero(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono,idRegistro);
      return p1;
   }

   public LinkedList listaDeRutasTren(){
      return tiquete.listaRutas();
   }
   public void desplegarRutastren(){
      tiquete.desplegarRutas();
   }

   public boolean añadirPasajeroVagon(Pasajero pasajero){
      return vagon.añadirPasajero(pasajero);
   }

   public int buscarPasajeroPuestos(Pasajero pasajero){
      return vagon.buscarPasajero(pasajero);
   }

   public int precioTipoPasajero(String tipoPasajero){
      return tipoDePasajero.definirPasajero(tipoPasajero);
   }

   public boolean añadirVagonTren(Vagon vagon){
      return tren.añadirVagon(vagon);
   }






}
