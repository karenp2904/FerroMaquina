package Entidades.Tren;

import Entidades.Tren.Tren;
import Listas.LinkedList;
import Listas.LinkedListNode;
import Entidades.Personas.Pasajero;

public class Vagon {
	
	static int cantidadPersonas=30;// por cada vagon 30 personas
	
	LinkedList<Pasajero> listaPuestos=new LinkedList();
	Tren tren;

	public boolean añadirPasajero(Pasajero pasajero) {
		boolean añadido=false;
		try {
			if(tren.vagonInicial()) {
				cantidadPersonas=26;
			}
			if(listaPuestos.size()<=cantidadPersonas) {
				listaPuestos.add(pasajero);
				añadido=true;
			}
		}catch (Exception e){
            e.printStackTrace();
        }finally {
        	return añadido;
        }
	}
	
	public int buscarPasajero(Pasajero pasajero) {
		boolean pasajeroEnVagon=false;
		int contarPuesto=0;
		try {
			while(pasajeroEnVagon=true){
				LinkedListNode<Pasajero> pasajeroAux=new LinkedListNode();
				pasajeroAux=listaPuestos.head;
				if (pasajeroAux.getObject()==pasajero) {
					pasajeroEnVagon=true;
					return contarPuesto;
				}else {
					contarPuesto++;
				}
			}
			
		}catch (Exception e){
            e.printStackTrace();
           return (Integer) null;
        }
		return contarPuesto;
	}
	
	
	


}
