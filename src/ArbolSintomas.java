/** @class ArbolSintomas :
	Esta clase implementa un ?rbol binario de b?squeda (ABB) ordenado respecto a los sintomas.
	Los siguientes parametros representan los atributos de la clase:
	@param raiz : Snodo raiz del Arbol ABB
*/

import java.util.Vector;

class ArbolSintomas{
	private Snodo raiz;
	
	/**Incializa el ArbolSintomas con una raiz nula*/
	public ArbolSintomas(){
		raiz = new Snodo();
	}
	
	/**Inicializa el ArbolSintomas con una lista de snodos
		@param snodos : Los nodos a agregar recursivamente
	*/
	public ArbolSintomas(Vector<Snodo> snodos){
		raiz=new Snodo();
		this.agregarSnodo(snodos);
	}
	
	/**Agrega un nodo al arbol, si no existen Snodos o mas bien, si el nodo raiz no tiene datos asignados
	entonces el Snodo a agregar ser? la raiz.
	Despues de agregar el Snodola funcion AVL verificara que el arbol tenga una estructura AVL,
	de no ser asi AVL intentara arreglarlo
	@param snodo : Snodo que se desea agregar al Arbol ABB
	*/
	public void agregarSnodo(Snodo snodo){	
		if(this.raiz.getSintoma()=="none"){
			this.raiz.igualar(snodo);
		}else{
			this.raiz.igualar(this.agregarSintoma(this.raiz,snodo));
		}
                
		this.raiz.igualar(AVLAS.AVLArbolSintomas(this.raiz));
	}
	
	/**Agrega una serie de snodos de forma recursiva
		@param snodos : lista de nodos a agregar
	*/
	public void agregarSnodo(Vector<Snodo> snodos){		
		for(int i=0;i<snodos.size();i++)
		{
			this.agregarSnodo(snodos.elementAt(i));
		}			
	}
	
	/**Agrega el snodo al lugar correspondiente segun un orden alfabetico dado por el nombre del sintoma,
	Si ambos sintomas son iguales se reemplaza el actual por el nuevo
	@param raiz : nodo actual en el que se evalua a que lado quedara el Snodo
	@param snodo : Snodo que se desea agregar
	*/
	private Snodo agregarSintoma(Snodo raiz, Snodo snodo){
		int comparacion=raiz.getSintoma().compareToIgnoreCase(snodo.getSintoma());
		
		if(comparacion<0){
			if(raiz.getSnodoIzq()==null){
				raiz.setSnodoIzq(snodo);
			}else{
				raiz.setSnodoIzq(agregarSintoma(raiz.getSnodoIzq(),snodo));
			}
		}else if(comparacion>0){
			if(raiz.getSnodoDer()==null){
				raiz.setSnodoDer(snodo);
			}else{
				raiz.setSnodoDer(agregarSintoma(raiz.getSnodoDer(),snodo));
			}
		}else{
			snodo.reemplazar(raiz);		
			raiz.limpiar();
			return snodo;
		}
		
		return raiz;
	}
	
	/**Permite crear una lista (vector) con todos los snodos del arbol
		@return Devuelve un vector de todos los snodos que se encuentran en este arbol
	*/
	public Vector<Snodo> VSnodos()
	{
		Vector<Snodo> vector=new Vector();
		//debemos recorrer ambas partes del arbol ya que un nodo puede
		//no tener un compuesto o puede no tener un medicamento.

		//debemos agregar el nodo raiz tambien al vector
		vector.add(this.raiz);
		this.VSnodo(vector, this.raiz.getSnodoIzq());
		this.VSnodo(vector, this.raiz.getSnodoDer());
		return vector;
	}

	/**Agrega todos los snodos del árbol al vector dado como argumento
	   @param vector : El vector que contendrá a los snodos del árbol
	   @param raiz : La raíz inicial de un árbol que contenga snodos
	*/
	private void VSnodo(Vector<Snodo> vector, Snodo raiz)
	{
		if(raiz==null)
		{
			return;
		}else{
			if(!vector.contains(raiz))
			{
				vector.add(raiz);
			}
			this.VSnodo(vector, raiz.getSnodoIzq());
			this.VSnodo(vector, raiz.getSnodoDer());
		}
	}

	/**Elmina el nodo del arbol si no se encuentra lanza la excepcion ArbolSintomasNoEncontrado	   
		@param snodo : El Snodo a eliminar del arbol*/
	public void eliminar(Snodo snodo)
	{
		eliminar(this.raiz, snodo);
	}
	
	/**Elimina el nodo dado del arbol
	   @param raiz : La raiz del arbol del cual se va a eliminar el nodo
	   @param snodo : El Snodo que se quiere eliminar del arbol
	*/
	private void eliminar(Snodo raiz, Snodo snodo)
	{
		Snodo subarbol_der = new Snodo();
                Snodo subarbol_izq = new Snodo();
		if(raiz!=null)
		{
			if(raiz.getSnodoIzq()==snodo)
			{
				subarbol_der.igualar(raiz.getSnodoIzq().getSnodoDer());
				subarbol_izq.igualar(raiz.getSnodoIzq().getSnodoIzq());
				raiz.setSnodoIzq(null);
				//debemos volver a agregar los elementos al arbol
				Vector<Snodo> Snodos=new Vector();

				this.VSnodo(Snodos, subarbol_der);
				this.agregarSnodo(Snodos);

				Snodos=new Vector();

				this.VSnodo(Snodos, subarbol_izq);
				this.agregarSnodo(Snodos);

			}else{
				this.eliminar(raiz.getSnodoIzq(), snodo);
			}

			if(raiz.getSnodoDer()==snodo)
			{
				subarbol_der.igualar(raiz.getSnodoDer().getSnodoDer());
				subarbol_izq.igualar(raiz.getSnodoDer().getSnodoIzq());
				raiz.setSnodoDer(null);
				//debemos volver a agregar los elementos al arbol
				Vector<Snodo> Snodos=new Vector();

				this.VSnodo(Snodos, subarbol_der);
				this.agregarSnodo(Snodos);

				Snodos=new Vector();

				this.VSnodo(Snodos, subarbol_izq);
				this.agregarSnodo(Snodos);
			}else{
				this.eliminar(raiz.getSnodoDer(), snodo);
			}
		}
	}	

	/**Busca un sintoma según la cadena dada, retornando asi el nodo encontrado, si no se encuentra se enviara un exception
	  @param cadena : El string a buscar en el árbol ABB. Se ignoran las mayúsculas
	  @return El nodo encontrado*/
	public Snodo BuscarSintoma(String cadena)throws ArbolSintomasNoEncontrado{
		if(this.raiz==null)
		{
			throw new ArbolSintomasNoEncontrado("No hay ningún nodo en la base de datos");
		}else{
			try{			
				return this.BuscarSintoma(this.raiz, cadena);
			}catch(ArbolSintomasNoEncontrado e){
				System.out.println("No se encontró "+cadena+" en la base de datos");
                return null;
			}
		}
	}
	
	public Vector<Snodo> BuscarSintoma(Vector<String> sintomas){
		Vector<Snodo> snodos = new Vector();
	
		for(int i=0;i<sintomas.size();i++)
		{
			snodos.add(this.BuscarSintoma(sintomas.elementAt(i)));
		}
		
		return snodos;		
	}

	/**Busca la cadena asumiendo que es un compuesto en el árbol binario dado, si no se encuentra entonces se lanza una excepción
		ArbolSintomasNoEncontrado
	   @param raiz Raíz del árbol binario en donde buscar la cadena.
	   @param cadena Un string a buscar en el árbol binario se ignoran las mayúsculas
	*/
	private Snodo BuscarSintoma(Snodo raiz, String cadena)throws ArbolSintomasNoEncontrado
	{
		if(raiz==null)
		{
			//No encontramos el compuesto dado
			throw new ArbolSintomasNoEncontrado("No se encontró "+cadena+" en la base de datos");
		}else{
			int compuesto=raiz.getSintoma().compareToIgnoreCase(cadena);

			if(compuesto==0)
			{
				//encontramos el nodo 
				return raiz;
			}else{
				//No hemos encontrado el Snodo, debemos ver por que
				//camino nos vamos. El camino izquierdo es para los
				//valores negativos y el derecho para los positivos

				if(compuesto<0)
				{
					return BuscarSintoma(raiz.getSnodoIzq(), cadena);
				}else{
					return BuscarSintoma(raiz.getSnodoDer(), cadena);
				}
			}
		}
	}
	
	/** Esta funcion recive un vector de snodos de diferentes sintomas, el proposito es encontrar la(s)
		enfermedades que más se repiten, ya que estas son las mejores candidatos de lo que tiene en paciente.
		Mediante un algoritmo de comparación crea un vector con los compuestos más repetidos
		@param snodos : vector que contiene todos los snodos
		@return Vector<String> el cual contiene todos los compuestos que mejor describen esa enfermedad
	*/
	public Vector<String> mejorSolucion(Vector<Snodo> snodos){
		Vector<String> all,repetido,mejores;
		Vector<int> repeticiones;
		String comparador;
		int repetidor,i,j;
		
		/** Se inicializan los vectores
			@param all : lista completa de compuestos
			@param repetido : lista de compuestos repetidos
			@param repeticiones : numero de veces que se repite cada compuesto con posiciones correspondientes
			@param mejores : lista de mejores candidatos de compuestos
		*/
		all = new Vector();
		repetido = new Vector();
		repeticiones = new Vector();
		mejores = new Vector();
		
		
		//Se agregan todos los compuestos a un solo vector, no importa si se repiten
		for(i=0;i<snodos.size();i++){
			for(j=0;j<snodos.elementAt(i).nombre_compuestos.size();j++){
				all.add(snodos.elementAt(i).nombre_compuestos.elementAt(j));
			}			
		}
		
		//Se comparan los elementos del vector con todos los que le proceden para contar cuantas veces es repetido
		for(i=0;i<all.size();i++){
		
			comparador = all.elementAt(i);
			repetidor = 1;
			
			//Si el vector repetido no contiene al elemento ha comparar
			if(!repetido.contains(comparador)){
				for(j=i+1;j<all.size();j++){
					//Se suma la veces que se repite
					if(all.elementAt(j).equalIgnoreCase(comparador)){
						repetidor++;
					}
				}
				
				//Si se repite se añaden correspondientemente los datos a sus vectores
				if(repetidor>1){
					repetido.add(comparador);
					repeticiones.add(repetidor);
				}
			}
		}
		
		//Si existen compuestos repetidos
		if(!repetido.isEmpty()){
		
			comparador = repetido.elementAt(0);
			repetidor = repeticiones.elementAt(0);
			
			//Se compara el numero de repeticiones con los demas en el vector
			for(j=1;j<repeticiones.size();j++){
				//Si hay uno con mas repeticiones se reemplaza y el vector mejores se vacia
				if(repeticiones.elementAt(j)>repetidor){
					comparador = repetido.elementAt(j);
					repetidor = repeticiones.elementAt(j);
					mejores.clear();
				//Si hay unos con la misma cantidad de repeticiones se añada al array mejores
				}else if(repeticiones.elementAt(j)==repetidor){
					mejores.add(repetido.elementAt(j);
				}
			}

			//El elemento comparador es el ultimo en agregarse al vector
			mejores.add(comparador);
			
		}else{
			//Si no hay repeticiones entonces el vector all contiene los mejores candidatos
			return all;
		}
		
		//Se retorna el vector con los mejores
		return mejores;
	}
	
}

/**@class ArbolSintomasNoEncontrado : 
	Clase de excepción para lanzar en caso de no encontrar un Snodo
*/
class ArbolSintomasNoEncontrado extends Exception{

	ArbolSintomasNoEncontrado(String mensaje)
	{
		super(mensaje);
	}

	ArbolSintomasNoEncontrado()
	{
		super();
	}
}
