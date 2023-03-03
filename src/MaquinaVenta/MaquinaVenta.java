package MaquinaVenta;
import java.time.LocalDateTime;

import Entidades.Tren.Tren;
import Entidades.Tren.Vagon;
import Listas.LinkedList;
import Entidades.Tren.TipoPasajero;


public class MaquinaVenta extends Tiquete{


	public MaquinaVenta(Tren tren, String destino, String origen, LocalDateTime fechaSalida, LocalDateTime fechaLlegada,
						Vagon puesto, int pesoCarga, int idPasajero, TipoPasajero categoriaPasajero) {
		super(tren, destino, origen, fechaSalida, fechaLlegada, puesto, pesoCarga, idPasajero, categoriaPasajero);
		// TODO Auto-generated constructor stub
	}
	
	LinkedList<Tiquete> listaTiquetes =new LinkedList();
	
	//Tiquete tiquete;
	
	public boolean agregarTiquete(Tiquete tiquete) {
		boolean tiqueteAgregado=false;
		try {
			if(tiquete.validarTiquete(pesoCarga)) {
				listaTiquetes.add(tiquete);
				tiqueteAgregado=true;
			}
		}catch (Exception e){
            e.printStackTrace();
        }finally{
            return tiqueteAgregado; 
        }
	}


}
