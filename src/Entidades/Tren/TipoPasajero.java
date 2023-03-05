package Entidades.Tren;

public class TipoPasajero {

	String tipoPasajeroEscogido;

	int valorTipoPasajero;

	public TipoPasajero(String tipopasajero) {
		definirPasajeroClase(tipopasajero);

	}

	public String getTipoPasajeroEscogido() {
		return tipoPasajeroEscogido;
	}

	public void setTipoPasajeroEscogido(String tipoPasajeroEscogido) {
		this.tipoPasajeroEscogido = tipoPasajeroEscogido;
	}

	public int getValorTipoPasajero() {
		return valorTipoPasajero;
	}

	public void setValorTipoPasajero(int valorTipoPasajero) {
		this.valorTipoPasajero = valorTipoPasajero;
	}

	public int definirValorPasajero(String eleccion) {
		if(eleccion.toLowerCase().equals("economico")) {
			setValorTipoPasajero(75000);
			setTipoPasajeroEscogido(eleccion);
		}
		if(eleccion.toLowerCase().equals("premium")) {
			setValorTipoPasajero(1000000);
			setTipoPasajeroEscogido(eleccion);
		}
		if(eleccion.toLowerCase().equals("ejecutivo")) {
			setValorTipoPasajero(200000);
			setTipoPasajeroEscogido(eleccion);
		}
		return getValorTipoPasajero();
	}
	public String definirPasajeroClase(String pasajeroTipo) {
		String tipo="";
		if(pasajeroTipo.toLowerCase().toString()=="economico".toString()) {
			setTipoPasajeroEscogido("economico");
		}
		if(pasajeroTipo.toLowerCase().toString()=="premium".toString()) {
			setTipoPasajeroEscogido("economico");
		}
		if(pasajeroTipo.toLowerCase().toString()=="ejecutivo".toString()) {
			setTipoPasajeroEscogido("economico");
		}
		return tipo;
	}

}
