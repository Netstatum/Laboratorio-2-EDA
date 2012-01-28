/** @class ArbolSintomas :
	Esta clase implementa un Árbol binario de búsqueda (ABB) ordenado respecto a los sintomas.
	Los siguientes parametros representan los atributos de la clase:
	@param raiz : Snodo raiz del Árbol ABB
*/

import java.util.Vector;

class ArbolSintomas{
	private Snodo raiz;
	
	/**Incializa el ÁrbolSintomas con una raiz nula*/
	public ArbolSintomas(){
		raiz = new Snodo();
	}
	
	/**Agrega un nodo al arbol, si no existen Snodos o más bien, si el nodo raiz no tiene datos asignados
	entonces el Snodo a agregar será la raiz.
	Despues de agregar el Snodola funcion AVL verificara que el arbol tenga una estructura AVL,
	de no ser asi AVL intentará arreglarlo
	@param snodo : Snodo que se desea agregar al Arbol ABB
	*/
	public void agregarSnodo(Snodo snodo){	
		if(this.raiz.getSintoma()==null){
			this.raiz = snodo;
		}else{
			this.agregarSintoma(this.raiz,snodo);
		}
		
		AVL(this.raiz);
	}
	
	/**Agrega el snodo al lugar correspondiente segun un orden alfabetico dado por el nombre del sintoma,
	Si ambos sintomas son iguales se reemplaza el actual por el nuevo
	@param raiz : nodo actual en el que se evalua a que lado quedara el Snodo
	@param snodo : Snodo que se desea agregar
	*/
	private void agregarSintoma(Snodo raiz, Snodo snodo){
		int comparacion=raiz.getSintoma().compareToIgnoreCase(snodo.getSintoma());
		
		if(comparacion<0){
			if(raiz.getSnodoIzq()==null){
				raiz.setSnodoIzq(snodo)
			}else{
				agregarSintoma(raiz.getSnodoIzq(),snodo);
			}
		}else if(comparacion>0){
			if(raiz.getSnodoDer()==null){
				raiz.setSnodoDer(snodo)
			}else{
				agregarSintoma(raiz.getSnodoDer(),snodo);
			}
		}else{
			snodo.reemplazar(raiz);			
			raiz.limpiar();
		}
	}
	
	void AVL(Snodo raiz){
		
	}
}