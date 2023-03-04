package MVC_Modelo;

import MVC_Controlador.Controlador;
import MVC_Modelo.Listas.LinkedList;
import MVC_Modelo.MaquinaVenta.Tiquete;
import MVC_Modelo.MaquinaVenta.MaquinaVenta;


public class Modelo {
   private Controlador controlador;
   Tiquete tiquete;

   public LinkedList listaDeRutasTren(){
      return tiquete.listaRutas();
   }
   public void desplegarRutastren(){
      tiquete.desplegarRutas();
   }






}
