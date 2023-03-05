package Entidades.Tren;

public class TipoPasajero {
	String economico="economico";
	String premium="premium";
	String ejecutivo="Ejecutivo";

	public TipoPasajero(String tipopasajero) {
		definirPasajeroClase(tipopasajero);

	}

	public int definirPasajero(String pasajeroTipo) {
		int valorPasaje=0;
		if(pasajeroTipo.toLowerCase()==economico) {
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
		if(pasajeroTipo.toLowerCase().toString()==economico.toString()) {
			tipo= economico;
		}
		if(pasajeroTipo.toLowerCase().toString()==premium.toString()) {
			tipo= premium;
		}
		if(pasajeroTipo.toLowerCase().toString()==ejecutivo.toString()) {
			tipo= ejecutivo;
		}
		return tipo;
	}

}
