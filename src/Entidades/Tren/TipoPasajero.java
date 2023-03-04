package Entidades.Tren;

public class TipoPasajero {
	String eco;
	String premium;
	String ejecutivo;
	
	public int definirPasajero(String pasajeroTipo) {
		int valorPasaje=0;
		if(pasajeroTipo.toLowerCase()==eco) {
			valorPasaje= 75000;
		}
		if(pasajeroTipo.toLowerCase()==premium) {
			valorPasaje= 1000000;
		}
		if(pasajeroTipo.toLowerCase()==ejecutivo) {
			valorPasaje= 200000;
		}
		return valorPasaje;
	}

}
