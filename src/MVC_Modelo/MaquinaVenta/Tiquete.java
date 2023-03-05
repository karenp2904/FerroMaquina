package MVC_Modelo.MaquinaVenta;

import Entidades.Personas.Pasajero;
import Entidades.Personas.PersonaEmergencia;
import Entidades.Tren.Tren;
import Entidades.Tren.Vagon;
import MVC_Modelo.Listas.LinkedList;
import Entidades.Tren.TipoPasajero;
import Entidades.Tren.RutaTren;
import MVC_Modelo.Listas.LinkedListNode;
import MVC_Modelo.Listas.Node;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class Tiquete {
	
	static int pesoMaximo=150;//por pasajero se puede llegar un peso e 150 en equipaje, se define como varibale static

	private int pesoCarga;
	private Pasajero idPasajero;

	private int valorPasaje;
	private PersonaEmergencia personaContactoEmergencia;
	private Tren tren;
	private RutaTren ruta;

	LocalDateTime fechaHoraCompra= LocalDateTime.now();
	Scanner entrada=new Scanner(System.in);

	public Tiquete() {

	}

	public Tiquete(Tren tren,Pasajero personaPasjero, PersonaEmergencia personaEmergencia, int valorPasaje, int pesoCarga) {
		this.tren= tren;
		this.idPasajero=personaPasjero;
		this.personaContactoEmergencia=personaEmergencia;
		this.valorPasaje=valorPasaje;
		this.pesoCarga=pesoCarga;
	}


	public LinkedList<RutaTren> listaRutas(){

		LinkedList<RutaTren> rutasLista= new LinkedList();
		
		//RUTAS DE BGA A BOGOTA
		tren=new Tren("001");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 6, 0),
				LocalDateTime.of(2023, 03, 01, 13, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("002");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 9, 0),
				LocalDateTime.of(2023, 03, 01, 17, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("003");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 11, 0),
				LocalDateTime.of(2023, 03, 01, 19, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("004");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 1, 0),
				LocalDateTime.of(2023, 03, 01, 21, 0));
		rutasLista.add(ruta);
		
		//RUTAS DE BGA A BARRAQUILLA
		tren=new Tren("005");;
		ruta= new RutaTren(tren,"Bucaramanga","Barranquilla",
				LocalDateTime.of(2023, 03, 01, 6, 0),
				LocalDateTime.of(2023, 03, 01, 13, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("006");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 9, 0),
				LocalDateTime.of(2023, 03, 01, 17, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("007");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 11, 0),
				LocalDateTime.of(2023, 03, 01, 19, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("008");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 1, 0),
				LocalDateTime.of(2023, 03, 01, 21, 0));
		rutasLista.add(ruta);
		
		return rutasLista;	
	}
	
	public void desplegarRutas() {
		try {
			Iterator ite=listaRutas().iterator();
			System.out.println("-------------RUTAS DE TRENES------------------");
			while (ite.hasNext()) {
				LinkedListNode rutass = (LinkedListNode) ite.next();
				RutaTren rutas= (RutaTren) rutass.getObject();

				System.out.println("Tren: " + rutas.getTren().getIdTren());
				System.out.println("Origen: " + rutas.getOrigen());
				System.out.println("Destino: " + rutas.getDestino());
				System.out.println("Fecha de salida: " + rutas.getFechaSalida());
				System.out.println("Fecha de llegada: " + rutas.getFechaLlegada());
				System.out.println("---------------------------------------------");
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	public RutaTren elegirRuta(int numeroTren){
		Iterator<Node> ite=listaRutas().iterator();
		RutaTren rutas= (RutaTren) ite.next().getObject();
		switch (numeroTren){
			case 1:
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 2:
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 3:
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 4:
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 5:
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 6:
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 7:
				//rutas= (RutaTren) rutass.getNext().getNext().getNext().getNext().getNext().getNext().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			case 8:
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				rutas= (RutaTren) ite.next().getObject();
				System.out.println("EL tren es: " + rutas.getTren().getIdTren());
				break;
			default:
				System.out.println("NO hay tren disponible");
				break;

		}
		return rutas;
	}



	//Metodo en el cual -Se vende el tiquete si se valida el peso de carga
	public boolean validarTiquete(int pesoCarga) {
		boolean validar=false;

		try {
			if(pesoCarga<=pesoMaximo) {
				validar=true;
			}
			return validar;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			return validar;
		}
	}


	LinkedList<Tiquete> listaTiquetes =new LinkedList();// se implementa la lista de tiquetes para la venta
	public LinkedList<Tiquete> listaTiquetes(){

		return listaTiquetes;
	}

	public Tiquete generarTiquete(Pasajero pasajero,PersonaEmergencia personaEmergencia, Tren idTren){
		Tiquete tiquete = new Tiquete();
		Iterator ite=tiquete.listaRutas().iterator();
		while (ite.hasNext()) {
			LinkedListNode rutass = (LinkedListNode) ite.next();
			RutaTren rutas= (RutaTren) rutass.getObject();
			if(rutas.getTren()==idTren){
				tiquete=new Tiquete( idTren, pasajero,personaEmergencia, tiquete.getPesoCarga(), tiquete.getValorPasaje());
			}
		}
		agregarTiquete(tiquete);
		return tiquete;
	}

	public boolean agregarTiquete(Tiquete tiquete) {

		boolean tiqueteAgregado=false;
		try {
			if(tiquete.validarTiquete(tiquete.getPesoCarga())) {
				listaTiquetes.add(tiquete);
				tiqueteAgregado=true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return tiqueteAgregado;
	}



	public Pasajero getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(Pasajero idPasajero) {
		this.idPasajero = idPasajero;
	}

	public LocalDateTime getFechaHoraCompra() {
		return fechaHoraCompra;
	}
	public void setFechaHoraCompra(LocalDateTime fechaHoraCompra) {
		this.fechaHoraCompra = LocalDateTime.now();
	}
	public int getValorPasaje() {
		return valorPasaje;
	}
	public void setValorPasaje(String categoria) {
		this.valorPasaje=idPasajero.getTipoPasajero().definirPasajero(categoria);
	}
	public int getPesoCarga() {
		return pesoCarga;
	}
	public void setPesoCarga(int pesoCarga) {
		this.pesoCarga = pesoCarga;
	}
	
	
}
