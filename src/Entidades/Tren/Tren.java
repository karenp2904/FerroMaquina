package Entidades.Tren;
import Listas.LinkedList;


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

	public Vagon buscarVagon(Vagon vagon) {
		Vagon vagonEncontrado=null;
		try {
			vagonEncontrado=(Vagon) vagonesTren.nodeOf(vagon);
		}catch (Exception e){
            e.printStackTrace();
        }finally {
        	return vagonEncontrado;
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
