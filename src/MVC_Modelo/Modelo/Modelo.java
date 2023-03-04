package MVC_Modelo.Modelo;

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
   private TipoPasajero tipoDePasajero;

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
