package MaquinaVenta;

import Entidades.Tren.Tren;
import Entidades.Tren.Vagon;
import Listas.LinkedList;
import Entidades.Tren.TipoPasajero;
import Entidades.Tren.RutaTren;
import java.time.LocalDateTime;
import java.util.Iterator;

public class Tiquete extends RutaTren {
	
	static int pesoMaximo=150;//por pasajero se puede llegar un peso e 150 en equipaje, se define como varibale static
	Vagon puesto;
	int pesoCarga;
	int idPasajero;
	TipoPasajero categoriaPasajero;//Tipos PREMIUN EJECUTIVO Y ECONOMICO
	int valorPasaje;

	LocalDateTime fechaHoraCompra= LocalDateTime.now();

	public Tiquete() {
	}

	public Tiquete(Tren tren, String destino, String origen, LocalDateTime fechaSalida, LocalDateTime fechaLlegada, Vagon puesto,
				   int pesoCarga, int idPasajero, TipoPasajero categoriaPasajero) {
		super(tren,destino, origen, fechaSalida, fechaLlegada);
		this.puesto = puesto;
		this.pesoCarga = pesoCarga;
		this.idPasajero = idPasajero;
		this.categoriaPasajero = categoriaPasajero;
		
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
	
	public LinkedList<RutaTren> listaRutas(){
		LinkedList<RutaTren> rutasLista= new LinkedList();
		
		//RUTAS DE BGA A BOGOTA
		Tren tren=new Tren("001");;
		RutaTren ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 6, 0),
				LocalDateTime.of(2023, 03, 01, 1, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("002");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 9, 0),
				LocalDateTime.of(2023, 03, 01, 5, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("003");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 11, 0),
				LocalDateTime.of(2023, 03, 01, 7, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("004");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 1, 0),
				LocalDateTime.of(2023, 03, 01, 9, 0));
		rutasLista.add(ruta);
		
		//RUTAS DE BGA A BARRAQUILLA
		tren=new Tren("005");;
		ruta= new RutaTren(tren,"Bucaramanga","Barranquilla",
				LocalDateTime.of(2023, 03, 01, 6, 0),
				LocalDateTime.of(2023, 03, 01, 1, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("006");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 9, 0),
				LocalDateTime.of(2023, 03, 01, 5, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("007");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 11, 0),
				LocalDateTime.of(2023, 03, 01, 7, 0));
		rutasLista.add(ruta);
		
		tren=new Tren("008");;
		ruta= new RutaTren(tren,"Bucaramanga","Bogota",
				LocalDateTime.of(2023, 03, 01, 1, 0),
				LocalDateTime.of(2023, 03, 01, 9, 0));
		rutasLista.add(ruta);
		
		return rutasLista;	
	}
	
	public void desplegarRutas() {
		Iterator ite= listaRutas().iterator();
		System.out.println("-------------RUTAS DE TRENES------------------");
		while (ite.hasNext()){
			RutaTren rutas= (RutaTren) ite.next();
			System.out.println("Tren: " + rutas.getTren());
			System.out.println("Origen: " + rutas.getOrigen());
			System.out.println("Destino: " + rutas.getDestino());
			System.out.println("Fecha de salida: " + rutas.getFechaSalida());
			System.out.println("Fecha de llegada: " + rutas.getFechaLlegada());
			System.out.println("---------------------------------------------");
		}

	}
	public int elegirRuta(){
		return 1;
	}


	
	
	public Vagon getPuesto() {
		return puesto;
	}
	public void setPuesto(Vagon puesto) {
		this.puesto = puesto;
	}
	public int getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}
	public TipoPasajero getCategoriaPasajero() {
		return categoriaPasajero;
	}
	public void setCategoriaPasajero(TipoPasajero categoriaPasajero) {
		this.categoriaPasajero = categoriaPasajero;
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
		this.valorPasaje=categoriaPasajero.definirPasajero(categoria.toLowerCase());
	}
	public int getPesoCarga() {
		return pesoCarga;
	}
	public void setPesoCarga(int pesoCarga) {
		this.pesoCarga = pesoCarga;
	}
	
	
}
