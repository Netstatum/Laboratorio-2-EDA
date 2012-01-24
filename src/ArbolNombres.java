/**Esta clase implementa un Árbol binario de búsqueda (ABB) ordenado con
 * respecto a los nombres de medicamento y nombres de compuesto.*/

import java.util.Vector;

class ArbolNombres{

	/**@brief Apunta a la raíz principal de donde salen todos los nodos.
	 * La parte izquierda de este nodo apunta a los nombres de los
	 * medicamentos. La parte derecha apunta a los nombres de los compuestos*/
	private Nodo raiz;

	/**Inicializa un árbol ABB sin ningún nodo*/
	ArbolNombres()
	{
		raiz=new Nodo();
	}
	
	/**Agrega el nodo al árbol ABB
	 *@param nodo Un nodo que se quiera agregar al árbol ABB*/
	public void Agregar(Nodo nodo)
	{
		if(this.raiz.izq==null && this.raiz.der==null)
		{
			this.raiz.izq=nodo;
			this.raiz.der=nodo;
		}
		this.agregar_medicamento(this.raiz.izq, nodo);
		this.agregar_compuesto(this.raiz.der, nodo);
	}

	/**Busca la cadena en el árbol ABB considerando que cadena es un
	 * compuesto, si cadena es un medicamento entonces también se va a
	 * buscar como si fuera uno, pero luego de ver si es un compuesto
	 *@param cadena El string a buscar en el arbol ABB. Se ignoran las mayusculas*/
	public Nodo BuscarCompuesto(String cadena)
	{
		if(this.raiz==null)
		{
			return null;
		}else{
			Nodo nodo=this.buscar_compuesto(this.raiz.der, cadena);
			if(nodo==null)
			{
				//no encontramos la cadena ingresada como si
				//fuera un compuesto. Tal vez un medicamento?
				return this.buscar_medicamento(this.raiz.izq, cadena);
			}else{
				return nodo;
			}
		}
	}

	public Vector<Nodo> Nodos()
	{
		Vector<Nodo> vector=new Vector();
		this.Nodo(vector, this.raiz.izq);
		return vector;
	}

	/**Busca la cadena en el árbol ABB considerando a cadena como el nombre
	 * de un medicamento
	 *@param cadena El string a buscar en el árbol ABB. Se ignoran las mayusculas*/
	public Nodo BuscarMedicamento(String cadena)
	{
		if(this.raiz==null)
		{
			return null;
		}else{
			Nodo nodo=this.buscar_medicamento(this.raiz.izq, cadena);
			if(nodo==null)
			{
				//no encontramos la cadena ingresada como si
				//fuera un compuesto. Tal vez un medicamento?
				return this.buscar_compuesto(this.raiz.der, cadena);
			}else{
				return nodo;
			}
		}
	}


	//Métodos privados
	
	/**Agrega un elemento al árbol comparando con el nombre del compuesto
	 *@param raiz raíz del árbol ABB en el que queremos agregar el nodo
	 *@param nodo el nodo a agregar al árbol ABB*/
	private void agregar_compuesto(Nodo raiz, Nodo nodo)
	{
		int comparacion=raiz.nombre_compuesto.compareToIgnoreCase(nodo.nombre_compuesto);
		if(comparacion<0)
		{
			//Vemos si podemos agregar el nodo a la izquierda
			if(raiz.izq==null)
			{
				//agregamos el nodo
				raiz.izq=nodo;
			}else{
				//seguimos buscando por un nodo vació
				agregar_compuesto(raiz.izq, nodo);
			}
		}else if(comparacion>0){
			//vemos si podemos agregar el nodo a la derecha
			if(raiz.der==null)
			{
				raiz.der=nodo;
			}else{
				agregar_compuesto(raiz.der, nodo);
			}
		}else{
			//encontramos el mismo compuesto...lo
			//modificamos?
			//TODO
			
		}
	}

	/**@brief Agrega un elemento al árbol comparando con el nombre del medicamento.
	 *@param raiz la raíz del árbol ABB en el que queremos agregar el nodo
	 *@param nodo: el nodo a agregar al árbol ABB*/
	private void agregar_medicamento(Nodo raiz, Nodo nodo)
	{
		int comparacion=raiz.nombre_medicamento.compareToIgnoreCase(nodo.nombre_medicamento);

		if(comparacion<0)
		{
			//izquierda
			if(raiz.izq==null)
			{
				raiz.izq=nodo;
			}else{
				agregar_medicamento(raiz.izq, nodo);
			}
		}else if(comparacion>0){
			//derecha
			if(raiz.der==null)
			{
				raiz.der=nodo;
			}else{
				agregar_medicamento(raiz.der, nodo);
			}
		}else{
			//encontramos el mismo medicamento...lo
			//modificamos?
			//TODO
		}
	}

	/**Busca la cadena asumiendo que es un compuesto en el árbol binario dado 
	 * @param raiz Raíz del árbol binario en donde buscar la cadena.
	 * @param cadena Un string a buscar en el árbol binario se ignoran las
	 * mayusculas
	 * */
	private Nodo buscar_compuesto(Nodo raiz, String cadena)
	{
		if(raiz==null)
		{
			//No encontramos el compuesto dado
			return null;
		}else{
			int compuesto=raiz.nombre_compuesto.compareToIgnoreCase(cadena);

			if(compuesto==0)
			{
				//encontramos el nodo 
				return raiz;
			}else{
				//No hemos encontrado el nodo, debemos ver por que
				//camino nos vamos. El camino izquierdo es para los
				//valores negativos y el derecho para los positivos

				if(compuesto<0)
				{
					return buscar_compuesto(raiz.izq, cadena);
				}else{
					return buscar_compuesto(raiz.der, cadena);
				}
			}
		}
	}

	/**Busca la cadena asumiendo que es un compuesto en el árbol binario dado 
	 * @param raiz Raíz del árbol binario en donde buscar la cadena.
	 * @param cadena Un string a buscar en el árbol binario. Se ignoran las
	 * mayusculas
	 * */
	private Nodo buscar_medicamento(Nodo raiz, String cadena)
	{
		if(raiz==null)
		{
			//No encontramos el medicamento dado
			return null;
		}else{
			int medicamento=raiz.nombre_medicamento.compareToIgnoreCase(cadena);

			if(medicamento==0)
			{
				//encontramos el nodo 
				return raiz;
			}else{
				//No hemos encontrado el nodo, debemos ver por que
				//camino nos vamos. El camino izquierdo es para los
				//valores negativos y el derecho para los positivos

				if(medicamento<0)
				{
					return buscar_medicamento(raiz.izq, cadena);
				}else{
					return buscar_medicamento(raiz.der, cadena);
				}
			}
		}
	}

	private void Nodo(Vector<Nodo> vector, Nodo raiz)
	{
		if(raiz==null)
		{
			return;
		}else{
			if(!vector.contains(raiz))
			{
				vector.add(raiz);
			}
			this.Nodo(vector, raiz.izq);
			this.Nodo(vector, raiz.der);
		}
	}
}
