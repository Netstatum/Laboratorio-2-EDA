class ArbolNombres{
	/*Esta clase implementa un Arbol binario de busqueda (ABB) ordenado con
	 * respecto a los nombres de medicamento y nombres de compuesto.
	 * Ordena alfabeticamente los nodos*/

	private Nodo raiz;

	//Metodos publicos

	ArbolNombres()
	{
		raiz=null;
	}
	
	/*Agrega el nodo arbol
	 * ARGUMENTOS:
	 * 	nodo: Un nodo que se quiera agregar al arbol*/
	public void Agregar(Nodo nodo)
	{
		agregar_medicamento(this.raiz, nodo);
		agregar_compuesto(this.raiz, nodo);
	}


	public Nodo Buscar(String cadena)
	{
		return buscar(this.raiz, cadena);
	}

	//Metodos privados
	
	/*Agrega un elemento al arbol comparando con el nombre del compuesto
	 * Si compareTo da un valor menor que la raiz actual entonces nos vamos
	 * por la izquierda, si devuelve un valor mayor nos vamos por la
	 * derecha. Si son iguales (retorno de compareTo==0) entonces lo que
	 * queremos hacer es modificar el compuesto, asi que reemplazamos la
	 * raiz con el nodo que nos dan.*/
	private static void agregar_compuesto(Nodo raiz, Nodo nodo)
	{
		if(raiz==null)
		{
			raiz=nodo;
			//ya que no hay nada al final de nodo, inicializamos izq
			//y der en caso que no se haya hecho antes
			nodo.izq=null;
			nodo.der=null;
		}else{

			int comparacion=raiz.nombre_compuesto.compareTo(nodo.nombre_compuesto);
			if(comparacion<0)
			{
				//izquierda
				agregar_compuesto(raiz.izq, nodo);
			}else if(comparacion>0){
				//derecha
				agregar_compuesto(raiz.der, nodo);
			}else{
				//encontramos el mismo compuesto...lo
				//modificamos?
				//TODO
			}
		}
	}

	/*Agrega un elemento al arbol comparando con el nombre del medicamento
	 * Si compareTo da un valor menor que la raiz actual entonces nos vamos
	 * por la izquierda, si devuelve un valor mayor nos vamos por la
	 * derecha. Si son iguales (retorno de compareTo==0) entonces lo que
	 * queremos hacer es modificar el compuesto, asi que reemplazamos la
	 * raiz con el nodo que nos dan.*/
	private static void agregar_medicamento(Nodo raiz, Nodo nodo)
	{
		if(raiz==null)
		{
			raiz=nodo;
			//ya que no hay nada al final de nodo, inicializamos izq
			//y der en caso que no se haya hecho antes
			nodo.izq=null;
			nodo.der=null;
		}else{

			int comparacion=raiz.nombre_medicamento.compareTo(nodo.nombre_medicamento);

			if(comparacion<0)
			{
				//izquierda
				agregar_medicamento(raiz.izq, nodo);
			}else if(comparacion>0){
				//derecha
				agregar_medicamento(raiz.der, nodo);
			}else{
				//encontramos el mismo medicamento...lo
				//modificamos?
				//TODO
			}
		}
	}


	private static Nodo buscar(Nodo raiz, String cadena)
	{
		int compuesto=raiz.nombre_compuesto.compareTo(nodo);
		int medicamento=raiz.nombre_medicamento.compareTo(nodo);

		if(compuesto==0 || medicamento==0)
		{
			return Nodo;
		}else{
		}
	}

}
