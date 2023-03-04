package Entidades.Tren;
import Entidades.Personas.Pasajero;
import MVC_Modelo.Listas.LinkedList;
import MVC_Modelo.Listas.LinkedListNode;
import MVC_Modelo.MaquinaVenta.Tiquete;

import java.util.Iterator;


public class Tren {

	String idTren;
	static int cantidadVagones=26; // son 40 vagones pero dos vagones de persona generan uno de carga 26/2=12 y 26+13=39 vagones ocupados
	LinkedList<Vagon> listavagonesTren= new LinkedList(idTren);

	public Tren(String idTren ) {
		this.idTren=idTren;
	}

	public Tren(){

	}
	Vagon vagon;
	public String getIdTren() {
		return idTren;
	}
	public void setIdTren(String idTren) {
		this.idTren = idTren;
	}

	public boolean añadirVagon() {// se añaden los vagones al tren
		boolean vagones=false;
		try {
			if(listavagonesTren.size()<cantidadVagones) {
				if (vagon.listaPuestos().size()==vagon.getCantidadPersonas()){
					listavagonesTren.add(vagon);
					vagones=true;
				}
			}else {
				return vagones;
			}
		}catch (Exception e){
            e.printStackTrace();
        }finally{
            return vagones;
        }

	}

	public boolean vagonInicial() {
		boolean vagones=false;
		try {
			if(listavagonesTren.isEmpty()) {
				vagones=true;
			}else {
				return vagones;
			}
		}catch (Exception e){
            e.printStackTrace();
        }finally{
            return vagones;
        }

	}
	public int buscarVagon(int idRegistro) {//dira en que numero de vagon se encuentra
		boolean pasajeroEnVagon = false;
		int contarVagon = 1;
		try {
			Vagon vagonBusqueda = new Vagon();
			if (idRegistro != 0) {
				if (!vagonInicial()) {//la lista estara ya con vgones para que entre, retornara false porque no esta vacia
					Iterator ite = listavagonesTren.iterator();//se itera entre los vagones del tren
					LinkedListNode<Vagon> vagonAux = new LinkedListNode<>();
					while (ite.hasNext()) {//se busca en cada vagon del tren
						Iterator iterator = vagonBusqueda.listaPuestos().iterator(); //iterador para lso puestos del vagon
						LinkedListNode<Pasajero> pasajeroAux = new LinkedListNode();
						while (iterator.hasNext()) {//itera sobre la lista de puestos en el vagon
							pasajeroAux = (LinkedListNode<Pasajero>) ite.next();
							Pasajero passe = (Pasajero) pasajeroAux.getObject();
							if (passe.getIdRegistro() == idRegistro) {// si en el vagon se encuentra el pasajero retorna
								pasajeroEnVagon = true;
								return contarVagon;
							}
						}
						contarVagon++;// cuando por cada vagon se recorra la lista de puestos, ira a uno siguiente, entonces el contador aumenta
					}
				}
			}
		}catch(Exception e){
				e.printStackTrace();
		}finally {
			if(pasajeroEnVagon) {
				return contarVagon;
			}else {
				return 0;// va varible
			}
		}
	}

	public int buscarEnTren(String idTren,Pasajero pasajero) {
		Boolean pasajeroEnVagon=false;
		int contarVagones=1;
		try {
			Tiquete tiquete=new Tiquete();
			Vagon vagon= new Vagon();
			Iterator ite=tiquete.listaRutas().iterator();//iterar sobre los trenes
			while (ite.hasNext()) {
				LinkedListNode rutass = (LinkedListNode) ite.next();
				RutaTren rutas= (RutaTren) rutass.getObject();//rutas
				if(rutas.getTren().getIdTren()==idTren){// si el idtren e igual ala ruta que esta
					System.out.println("Se encuentra en el tren "+ rutas.getTren().getIdTren());
					if(pasajero.getIdRegistro()!=0){//si el resgistro no es 0
						int vagonEncontrado=buscarVagon(pasajero.getIdRegistro());//buscara en los vagones y retornara el vagon donde esta
						System.out.println("Se encuentra en el vagon " + vagonEncontrado);
						int puesto=vagon.buscarPasajero(pasajero.getIdRegistro());
						System.out.println("Se encuentra en el puesto"+ puesto);
						}
					}
				}
		} catch (Exception e){
			e.printStackTrace();
		}finally {

			return contarVagones;
			}
	}

	//limite
	public boolean vagonesPermitidosPersona(int vagon) {
		boolean vagonesPermitidos=false;
		try {
			if(vagon<=26) {
				vagonesPermitidos=true;
			}
			return vagonesPermitidos;	
		}catch (Exception e){
            e.printStackTrace();
        }finally{
            return vagonesPermitidos; 
        }	
	}


}
