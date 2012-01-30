/** @class AVLA :
    Esta clase abrstracta permite usar un metodo para organizar un arbol ABB de forma AVL cuando se esta implementando un nodo a la vez
	Los siguientes parametros representan los atributos de la clase:
	@param Snodo K1 : Representa un nodo auxiliar
	@param Snodo K2 : Representa un nodo auxiliar
	@param Snodo K3 : Representa un nodo auxiliar
*/

public abstract class AVLAS{
	private static Snodo K1;
	private static Snodo K2;
	private static Snodo K3;
    
	/**Funcion privada que permite realizar la Rotación simple cuando se tiene el caso a la izquierda para el orden AVL
		@param foco : Snodo foco donde ocurre la rotación
		@return K1 : Snodo que ha quedado a la cabeza tras la rotación
	*/
	private static Snodo RSI(Snodo foco){		
		K2.igualar(foco);
		K1.igualar(foco.getSnodoIzq());
		
		K2.setSnodoIzq(K1.getSnodoDer());
		K2.setEquilibrio(K2.calcularEquilibrio());
		
		K1.setSnodoDer(K2);			
		K1.setEquilibrio(K1.calcularEquilibrio());
		
		return K1;
	}
	
	/**Funcion privada que permite realizar la Rotación simple cuando se tiene el caso a la derecha para el orden AVL
		@param foco : Snodo foco donde ocurre la rotación
		@return K1 : Snodo que ha quedado a la cabeza tras la rotación
	*/
	private static Snodo RSD(Snodo foco){		
		K2.igualar(foco);
		K1.igualar(foco.getSnodoDer());

		K2.setSnodoDer(K1.getSnodoIzq());
		K2.setEquilibrio(K2.calcularEquilibrio());

		K1.setSnodoIzq(K2);			
		K1.setEquilibrio(K1.calcularEquilibrio());

		return K1;
	}
	
	/**Funcion privada que permite realizar la Rotación doble cuando se tiene el caso a la izquierda para el orden AVL
		@param foco : Snodo foco donde ocurre la rotación
		@return foco : Snodo que ha quedado a la cabeza tras la rotación
	*/
	private static Snodo RDI(Snodo foco){
		K3.igualar(foco.getSnodoIzq());
		
		K3.igualar(RSD(K3));
		foco.setSnodoIzq(K3);
		
		foco.igualar(RSI(foco));
		
		return foco;
	}
	
	/**Funcion privada que permite realizar la Rotación doble cuando se tiene el caso a la derecha para el orden AVL
		@param foco : Snodo foco donde ocurre la rotación
		@return foco : Snodo que ha quedado a la cabeza tras la rotación
	*/
	private static Snodo RDD(Snodo foco){
		K3.igualar(foco.getSnodoDer());
		
		K3.igualar(RSI(K3));
		foco.setSnodoDer(K3);
		
		foco.igualar(RSD(foco));
		
		return foco;
	}
	
	/**Detecta en que caso se encuentra el desequilibrio para saber si aplicar RSI,RSD,RDI o RDD
		@param foco : Snodo foco donde ocurre la detección
		@return foco : Snodo que ha quedado a la cabeza tras la rotación aplicada
	*/
	private static Snodo detectorCaso(Snodo foco){
		if(foco.getEquilibrio()==-2){
			if(foco.getSnodoIzq().getEquilibrio()==-1){
				foco.igualar(RSI(foco));
			}else if(foco.getSnodoIzq().getEquilibrio()==1){
				foco.igualar(RDI(foco));
			}
		}else if(foco.getEquilibrio()==2){
			if(foco.getSnodoIzq().getEquilibrio()==-1){
				foco.igualar(RDD(foco));
			}else if(foco.getSnodoIzq().getEquilibrio()==1){
				foco.igualar(RSD(foco));
			}
		}	
		return foco;
	}
	
	/**Esta función recive la raiz de un arbol ABB y ordena cada Snodo nuevo ingresado de forma que se cumpla la condición AVL en todo momento.
	Dada la restricción de tiempo para ajustar el LAB este metodo no considera ciertas condiciones por lo que el arbol AVL generado no es perfectamente equilibrado.
	Esto no ocurre en la mayoría de los casos, pero puede lelgar a ocurrir.
		@param foco : raiz desde donde se considera un posible error de equilibrio
	*/
	public static Snodo AVLArbolSintomas(Snodo foco){
		int diferencia=0;
	
		if(foco.getEquilibrio()==-2){
			if(foco.getSnodoIzq().getEquilibrio()%2==0){
				foco.setSnodoIzq(AVLArbolSintomas(foco.getSnodoIzq()));
			}else{
				foco.igualar(detectorCaso(foco));
			}
		}else if(foco.getEquilibrio()==2){	
			if(foco.getSnodoDer().getEquilibrio()%2==0){
				foco.setSnodoDer(AVLArbolSintomas(foco.getSnodoDer()));
			}else{
				foco.igualar(detectorCaso(foco));
			}
		}else{
		
			diferencia = foco.calcularDA();
			
			if(diferencia<0){
				foco.setSnodoIzq(AVLArbolSintomas(foco.getSnodoIzq()));
			}else if(diferencia>0){
				foco.setSnodoDer(AVLArbolSintomas(foco.getSnodoDer()));
			}else{
				if(foco.getSnodoIzq()!=null){
					foco.setSnodoIzq(AVLArbolSintomas(foco.getSnodoIzq()));
				}
				
				if(foco.getSnodoDer()!=null){
					foco.setSnodoDer(AVLArbolSintomas(foco.getSnodoDer()));
				}
			}
		}
		
		return foco;
	}
}
