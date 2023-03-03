package Entidades.Tren;

public class TipoPasajero {
	String eco;
	String premium;
	String ejecutivo;
	
	public int definirPasajero(String pasajeroTipo) {
		int valorPasaje=0;
		if(pasajeroTipo==eco) {
			valorPasaje= 75000;
		}
		if(pasajeroTipo==premium) {
			valorPasaje= 1000000;
		}
		if(pasajeroTipo==ejecutivo) {
			valorPasaje= 200000;
		}
		return valorPasaje;
	}

}
