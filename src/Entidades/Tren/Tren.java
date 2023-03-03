package Entidades.Tren;
import Entidades.Personas.Pasajero;
import Listas.LinkedList;
import Listas.LinkedListNode;


public class Tren {

	String idTren;
	static int cantidadVagones=26; // son 40 vagones pero dos vagones de persona generan uno de carga 26/2=12 y 26+13=39 vagones ocupados
	
	LinkedList<Vagon> vagonesTren= new LinkedList(idTren);

	public Tren(String idTren ) {
		this.idTren=idTren;
	}

	
	public String getIdTren() {
		return idTren;
	}
	public void setIdTren(String idTren) {
		this.idTren = idTren;
	}
	
	public boolean añadirVagon(Vagon vagon) {// se añaden los vagones al tren
		boolean vagones=false;
		try {
			if(vagonesTren.size()<cantidadVagones) {
				vagonesTren.add(vagon);
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
	
	public boolean vagonInicial() {
		boolean vagones=false;
		try {
			if(vagonesTren.isEmpty()) {
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

	public int buscarVagon(Vagon vagon) {
		Boolean pasajeroEnVagon=false;
		int contarVagones=0;
		try {
			LinkedListNode<Pasajero> vagonAux=new LinkedListNode();
			vagonAux=vagonesTren.head;
			while(pasajeroEnVagon=true){
				while (vagonAux!=null){
					if (vagonAux.getObject().equals(vagon)) {
						pasajeroEnVagon=true;
						return contarVagones;
					}else {
						contarVagones++;
						vagonAux=vagonAux.getNext();
					}
				}

			}

		}catch (Exception e){
            e.printStackTrace();
        }finally {
        	return contarVagones;
        }
	}


	@SuppressWarnings("finally")
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
