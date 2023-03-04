package Entidades.Tren;

import MVC_Modelo.Listas.LinkedList;
import MVC_Modelo.Listas.LinkedListNode;
import Entidades.Personas.Pasajero;

import java.util.Iterator;

public class Vagon {

	static int cantidadPersonas = 30;// por cada vagon 30 personas

	LinkedList<Pasajero> listaPuestos = new LinkedList();
	Tren tren;
	Pasajero pasajero;

	public Vagon(Pasajero pasajero) {
		añadirPasajero(pasajero);
	}
	public Vagon(){
	}
	public int getCantidadPersonas(){
		return cantidadPersonas;
	}

	public LinkedList<Pasajero> listaPuestos(){
		try{
			Iterator ite=listaPuestos().iterator();
			while (ite.hasNext()) {
				LinkedListNode puestoPasajero= (LinkedListNode) ite.next();
				Pasajero pasajero= (Pasajero) puestoPasajero.getObject();
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			return listaPuestos;
		}

	}


	public boolean añadirPasajero(Pasajero pasajero) {
		boolean añadido = false;
		try {
			tren= new Tren(tren.getIdTren());
			if (tren.vagonInicial()) {
				cantidadPersonas = 26;
			}
			if (listaPuestos.size() <= cantidadPersonas) {
				listaPuestos.add(pasajero);
				añadido = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return añadido;
		}
	}

	public int buscarPasajero(int  idRegistro) {
		boolean pasajeroEnVagon = false;
		int contarPuesto = 1;
		try {
			if(idRegistro!=0){
				Iterator ite=listaPuestos().iterator();
				LinkedListNode<Pasajero> pasajeroAux = new LinkedListNode();
				while (ite.hasNext()) {
					pasajeroAux= (LinkedListNode<Pasajero>) ite.next();
					Pasajero passe= (Pasajero) pasajeroAux.getObject();
					if (passe.getIdRegistro() == idRegistro) {
						pasajeroEnVagon = true;
						return contarPuesto;
					} else {
						contarPuesto++;
						pasajeroAux = pasajeroAux.getNext();
					}
				}
			}else{
				return 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (pasajeroEnVagon==true){
				return contarPuesto;
			}
			else{
				return 0;
			}
		}
	}

}
