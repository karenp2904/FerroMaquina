package Entidades.Tren;

public class TipoPasajero {
	String eco="economico";
	String premium="premium";
	String ejecutivo="Ejecutivo";

	public TipoPasajero(String tipopasajero) {
		definirPasajeroClase(tipopasajero);

	}

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
	public String definirPasajeroClase(String pasajeroTipo) {
		String tipo="";
		if(pasajeroTipo.toLowerCase()==eco) {
			tipo= eco;
		}
		if(pasajeroTipo.toLowerCase()==premium) {
			tipo= premium;
		}
		if(pasajeroTipo.toLowerCase()==ejecutivo) {
			tipo= ejecutivo;
		}
		return tipo;
	}

}
