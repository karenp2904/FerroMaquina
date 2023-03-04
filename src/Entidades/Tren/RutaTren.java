package Entidades.Tren;

import java.time.LocalDateTime;

public class RutaTren {
	
	String destino;
	String origen;
	LocalDateTime fechaSalida;
	LocalDateTime fechaLlegada;
	Tren tren;

	public RutaTren() {
	}

	public RutaTren(Tren tren, String destino, String origen, LocalDateTime fechaSalida, LocalDateTime fechaLlegada) {
		this.tren=tren;
		this.destino = destino;
		this.origen = origen;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
	}

	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Tren getTren() {
		return tren;
	}

	public void setTren(Tren tren) {
		this.tren = tren;
	}
}
