package Entidades.Tren;

import java.util.Scanner;

import Listas.LinkedList;

public class Flota{ 
	
	int trenes=8; //cantidad de trenes

	Scanner entrada= new Scanner(System.in);

	LinkedList<Tren> Flota=new LinkedList();

	
	
	public Flota() {
		super();
	}




	

	
	public String desplejarRutas() {
		
		
		
		
		String destino;int elegir=0;
		
		do {
		System.out.println("Opciones de destino: "
				+ "\n1.Bogota"
				+ "\n2.Barranquilla"
				+ "\nElija su destino: ");
		elegir=entrada.nextInt();
		}while(elegir<1||elegir>2);
		
		if(elegir==1) {			
			destino="Bogota";
			System.out.println("Su destino elegido ha sido Bogota");
		}else {
			destino="Barranquilla";
			System.out.println("Su destino elegido ha sido Barranquilla");
		}
		return destino;
	}
	
	public int elegirHorarioRuta(String destino) {
		int horario=0;
		if(destino.toLowerCase()=="Bogota") {
			//ruta.getDestino()="Bogota";
			System.out.println("Ruta Bucaramanga-Bogota");
			
			do {
			System.out.println("Horarios disponibles "
					+ "1.Hora de salida 6:00am - Hora de llegada 1:00pm"
					+ "2.Hora de salida 9:00am -  Hora de llegada 5:00pm"
					+ "3.Hora de salida 11:00pm - Hora de llegada 7:00pm"
					+ "4.Hora de salida 1:00pm -  Hora de llegada 9:00pm"
					+ "Escoja su horario de salida-llegada del tren: ");
			horario=entrada.nextInt();
			}while(horario<1||horario>4);
		

		}
		if(destino.toLowerCase()=="barranquilla") {
			//ruta.getDestino()="barranquilla";
			System.out.println("Ruta Bucaramanga-Barranquilla");
			do {
				System.out.println("Horarios disponibles "
						+ "1.Hora de salida 6:00am - Hora de llegada 1:00pm"
						+ "2.Hora de salida 9:00am -  Hora de llegada 5:00pm"
						+ "3.Hora de salida 11:00pm - Hora de llegada 7:00pm"
						+ "4.Hora de salida 1:00pm -  Hora de llegada 9:00pm"
						+ "Escoja su horario de salida-llegada del tren: ");
				horario=entrada.nextInt();
				}while(horario<1||horario>4);
		}
		return horario;
	}


}
