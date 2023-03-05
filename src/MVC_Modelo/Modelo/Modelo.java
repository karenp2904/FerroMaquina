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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.time.LocalDateTime;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;


public class Modelo {
   private Controlador controlador;
   private Tiquete tiquete=new Tiquete();
   private Vagon vagon=new Vagon();
   private Tren tren;
   private Direccion direccion, direccionEmergencia;
   private PersonaEmergencia contactoEmergencia;
   private Persona persona;
   private Pasajero pasajero;
   private TipoPasajero tipoDePasajero;
   private RutaTren rutas;




   public Modelo(Controlador controlador) {
      this.controlador = controlador;
   }
   public Modelo(){

   }

   //metodo para definir la direccion del pasajero que se implementa en el controlador
   public Direccion definirDireccionPersona(String ciudad, String calle, String carrera){
      direccion=new Direccion(ciudad,calle,carrera);
      return direccion;
   }
   public Direccion definirDireccionPersonaEmergencia(String ciudad, String calle, String carrera){
      direccionEmergencia=new Direccion(ciudad,calle,carrera);
      return direccionEmergencia;
   }
   //meetodo para definir al pasajero
   public Pasajero definirPasajero(){
      return pasajero;
   }
   //metodo para la persona de mergencia
   public PersonaEmergencia definirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion, Direccion direccionActual, String telefono){
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
      return rutas;
   }
   public void iniciarTren(){
      rutas.getTren().añadirVagon();
   }

   //se añade el pasajero
   public boolean añadirPasajeroVagon(int tren,String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion, Direccion direccionActual, String telefono, String idRegistro, TipoPasajero tipoPasajeros){
      pasajero=new Pasajero(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono, idRegistro,tipoPasajeros);
     //vagon=new Vagon(pasajero);
      definirPasajero();
      pasajero.setTipoPasajero(tipoPasajeros);
      guardarInformacion(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono);
      rutas=tiquete.elegirRuta(tren);
      rutas.getTren().añadirPasajero(pasajero,rutas);

      agregarTiqueteMod(rutas, nombre,  apellido,  tipoIdentificacion,  numeroIdentificacion,  direccionActual,  telefono);
      return  true;
   }

   //se añade al contacto de emergencia
   public boolean añadirContactoEmergencia(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion, Direccion direccionActual, String telefono){
      contactoEmergencia=new PersonaEmergencia(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono);
      guardarInformacionEmergencia(nombre, apellido, tipoIdentificacion,  numeroIdentificacion, direccionActual, telefono);
      return true;
   }

   //se defin el ID de registro del pasajero, el cual sera el numero de idenficacion ingresado
   public String definirId(String numeroIdentificacion){
      pasajero.setIdRegistro(numeroIdentificacion);
      return pasajero.getIdRegistro();
   }

   //se busca al pasajero en el tren
      public int buscarPasajeroTrenMod(String idTren, Pasajero pasajero) {
         return rutas.getTren().buscarEnTren(idTren,pasajero);// se usa el pasjero actual
      }

      // se define el precio del pasajero segun su eleccion
   public int precioTipoPasajeroMod(String eleccion){
      tipoDePasajero=tipoPasajeroEscogerNombre(eleccion);
      return tipoDePasajero.getValorTipoPasajero();
   }
   public int getPrecioTipoPasajero(String eleccion){
      tipoDePasajero=tipoPasajeroEscogerNombre(eleccion);
     return tipoDePasajero.getValorTipoPasajero();
   }
      //se define el tipo de pasajero por nombre
   public TipoPasajero tipoPasajeroEscogerNombre(String tipoElegido) {
      tipoDePasajero=new TipoPasajero(tipoElegido);
      tipoDePasajero.setTipoPasajeroEscogido(tipoElegido);
      tipoDePasajero.definirValorPasajero(tipoElegido);
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

   public int getPesoCargaMode(int peso){
       tiquete.setPesoCarga(peso);
       return tiquete.getPesoCarga();
   }

   public void guardarInformacion(String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion, Direccion direccionActual, String telefono){
      persona=new Persona(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono);

   }
   public void guardarInformacionEmergencia(String nombre, String apellido, String tipoIdentificacion,
                                            String numeroIdentificacion, Direccion direccionActual, String telefono){
      contactoEmergencia=new PersonaEmergencia(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono);
   }

   //añadir tiquete
   public void agregarTiqueteMod(RutaTren rutas,String nombre, String apellido, String tipoIdentificacion, String numeroIdentificacion, Direccion direccionActual, String telefono){
      persona=new Persona(nombre,apellido,tipoIdentificacion,numeroIdentificacion,direccionActual,telefono);

      System.out.println("-------------TIQUETE DEL PASAJERO------------------");
      System.out.println("Id registro: " + pasajero.getIdRegistro());
      System.out.println("---------------------------------------------------");
      System.out.println("             Datos del Pasajero     ");
      System.out.println("\nNombre: " + persona.getNombre());
      System.out.println("Apellido: " + persona.getApellido());
      System.out.println("Direccion: " + persona.getDireccionActual().getCiudad());
      System.out.println("Tipo identificación: " + persona.getTipoIdentificacion());
      System.out.println("Numero identificación: " +persona.getTelefono());// el registro es igual a la identificacion
      System.out.println("Telefono: " + persona.getTelefono());
      System.out.println();
      System.out.println("Peso de carga: "+ tiquete.getPesoCarga());
      System.out.println("Precio: "+ tipoDePasajero.getValorTipoPasajero());
      System.out.println("Tipo pasajero: " + tipoDePasajero.getTipoPasajeroEscogido());

      System.out.println("-------------------------------------------------");
      System.out.println("       Datos del contacto de emergencia     ");
      System.out.println("\nNombre: " + contactoEmergencia.getNombre());
      System.out.println("Apellido: " + contactoEmergencia.getApellido());
      System.out.println("Direccion: " + contactoEmergencia.getDireccionActual().getCiudad());
      System.out.println("Tipo identificación: " + contactoEmergencia.getTipoIdentificacion());
      System.out.println("Numero identificación: " + contactoEmergencia.getNumeroIdentificacion());// el registro es igual a la identificacion
      System.out.println("Telefono: " + contactoEmergencia.getTelefono());
      System.out.println("------------------------------------------------");
      System.out.println("             Datos del tren     ");
      System.out.println("Tren: " + rutas.getTren().getIdTren());
      System.out.println("Origen: " + rutas.getOrigen());
      System.out.println("Destino: " + rutas.getDestino());
      System.out.println("Hora de compra: "+ tiquete.getFechaHoraCompra());
      System.out.println("Fecha de salida: " + rutas.getFechaSalida());
      System.out.println("Fecha de llegada: " + rutas.getFechaLlegada());
      System.out.println("------------------------------------------------");

      tiquete.generarTiquete(pasajero,contactoEmergencia,tren);
      generarArchivoXML("InformacionPasajero");

      System.out.println("------------------------------------------------");
      //rutas.getTren().buscarEnTren(rutas.getTren().getIdTren(),pasajero);

   }
   //Generar el archivo XML
   public void generarArchivoXML(String nombreArchivo) {
      try {
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

         //Se crea un nuevo documento XML
         Document newXML = dBuilder.newDocument();

         //Crea el elemento raíz
         Element rootElement = newXML.createElement("Tiquete");
         newXML.appendChild(rootElement);

         //Crea los elementos correspondientes a la información del tiquete
         //DATOS PASAJERO -------------------------------------------------------
         Element nombre = newXML.createElement("Nombre");
         nombre.appendChild(newXML.createTextNode(persona.getNombre()));
         rootElement.appendChild(nombre);

         Element apellido = newXML.createElement("Apellido");
         apellido.appendChild(newXML.createTextNode(persona.getApellido()));
         rootElement.appendChild(apellido);

         Element direccion = newXML.createElement("Dirección");
         direccion.appendChild(newXML.createTextNode(persona.getDireccionActual().getCiudad()));
         rootElement.appendChild(direccion);

         Element identificacion = newXML.createElement("Identificación");
         identificacion.appendChild(newXML.createTextNode(pasajero.getIdRegistro()));
         rootElement.appendChild(identificacion);

         Element tipoIdentificacion = newXML.createElement("TipoIdentificación");
         tipoIdentificacion.setAttribute("tipo", persona.getTipoIdentificacion());
         tipoIdentificacion.appendChild(newXML.createTextNode(persona.getNumeroIdentificacion()));
         rootElement.appendChild(tipoIdentificacion);

         Element telefono = newXML.createElement("Telefono");
         telefono.appendChild(newXML.createTextNode(persona.getTelefono()));
         rootElement.appendChild(telefono);

         Element idRegistro = newXML.createElement("IdRegistro");
         idRegistro.appendChild(newXML.createTextNode(pasajero.getIdRegistro()));
         rootElement.appendChild(idRegistro);

         Element pesoCarga = newXML.createElement("Peso_carga");
         pesoCarga.appendChild(newXML.createTextNode(pasajero.getIdRegistro()));
         rootElement.appendChild(pesoCarga);

         Element precio = newXML.createElement("Precio");
         precio.appendChild(newXML.createTextNode(pasajero.getIdRegistro()));
         rootElement.appendChild(precio);

         Element tipoPasajero = newXML.createElement("TipoPasajero");
         tipoPasajero.appendChild(newXML.createTextNode(tipoDePasajero.getTipoPasajeroEscogido()));
         rootElement.appendChild(tipoPasajero);

         //DATOS CONTACTO DE EMERGENCIA -----------------------------
         Element nombreContEmer = newXML.createElement("NombreContactoEmergencia");
         nombreContEmer.appendChild(newXML.createTextNode(contactoEmergencia.getNombre()));
         rootElement.appendChild(nombreContEmer);

         Element apellidoContEmer = newXML.createElement("ApellidoContactoEmergencia");
         apellidoContEmer.appendChild(newXML.createTextNode(contactoEmergencia.getApellido()));
         rootElement.appendChild(apellidoContEmer);

         Element direccionContEmer = newXML.createElement("DirecciónContactoEmergencia");
         direccionContEmer.appendChild(newXML.createTextNode(contactoEmergencia.getDireccionActual().getCiudad()));
         rootElement.appendChild(direccionContEmer);

         Element identificacionContEmer = newXML.createElement("IdentificaciónContactoEmergencia");
         identificacionContEmer.appendChild(newXML.createTextNode(contactoEmergencia.getNumeroIdentificacion()));
         rootElement.appendChild(identificacionContEmer);

         Element tipoIdentificacionContEmer = newXML.createElement("TipoIdentificaciónContactoEmergencia");
         tipoIdentificacionContEmer.setAttribute("tipo", contactoEmergencia.getTipoIdentificacion());
         tipoIdentificacionContEmer.appendChild(newXML.createTextNode(contactoEmergencia.getNumeroIdentificacion()));
         rootElement.appendChild(tipoIdentificacionContEmer);

         Element telefonoContEmer = newXML.createElement("TelefonoContactoEmergencia");
         telefonoContEmer.appendChild(newXML.createTextNode(contactoEmergencia.getTelefono()));
         rootElement.appendChild(telefonoContEmer);

         //DATOS TREN ----------------------------------------------------
         Element tren = newXML.createElement("Tren");
         tren.appendChild(newXML.createTextNode(rutas.getTren().getIdTren()));
         rootElement.appendChild(tren);

         Element rutaOrigen = newXML.createElement("RutaOrigen");
         rutaOrigen.appendChild(newXML.createTextNode(rutas.getOrigen()));
         rootElement.appendChild(rutaOrigen);

         Element rutaDestino = newXML.createElement("RutaDestino");
         rutaDestino.appendChild(newXML.createTextNode(rutas.getDestino()));
         rootElement.appendChild(rutaDestino);

         Element horaCompra = newXML.createElement("HoraCompra");
         horaCompra.appendChild(newXML.createTextNode(tiquete.getFechaHoraCompra().toString()));
         rootElement.appendChild(horaCompra);

         Element fechaSalida = newXML.createElement("FechaSalida");
         fechaSalida.appendChild(newXML.createTextNode(rutas.getFechaSalida().toString()));
         rootElement.appendChild(fechaSalida);

         Element fechaLlegada = newXML.createElement("FechaLlegada");
         fechaLlegada.appendChild(newXML.createTextNode(rutas.getFechaLlegada().toString()));
         rootElement.appendChild(fechaLlegada);

         // Transforma el documento en un archivo XML y lo escribe en el disco
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
         Transformer transformer = transformerFactory.newTransformer();
         DOMSource source = new DOMSource(newXML);
         StreamResult result = new StreamResult(new File(nombreArchivo));
         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
         transformer.transform(source, result);

         System.out.println("Archivo XML generado correctamente.");

      }
      catch (ParserConfigurationException pce) {
         pce.printStackTrace();
      }
      catch (TransformerConfigurationException tce) {
         tce.printStackTrace();
      }
      catch (TransformerException te) {
         te.printStackTrace();
      }
   }

   }
