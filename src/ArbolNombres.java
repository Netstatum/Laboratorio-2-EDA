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
		if(this.raiz.getNodoIzq()==null && this.raiz.getNodoDer()==null)
		{
			this.raiz.setNodoIzq(nodo);
			this.raiz.setNodoDer(nodo);
		}else{
			this.agregar_medicamento(this.raiz.getNodoIzq(), nodo);
			this.agregar_compuesto(this.raiz.getNodoDer(), nodo);
		}
	}

	/**Busca la cadena en el árbol ABB considerando que cadena es un
	 * compuesto, si cadena es un medicamento entonces también se va a
	 * buscar como si fuera uno, pero luego de ver si es un compuesto, si no
	 * se encuentra se lanza la excepción ArbolNombres_NoEncontrado
	 *@param cadena El string a buscar en el árbol ABB. Se ignoran las mayúsculas
	 *@return El nodo encontrado*/
	public Nodo BuscarCompuesto(String cadena)throws ArbolNombres_NoEncontrado
	{
		if(this.raiz==null)
		{
			throw new ArbolNombres_NoEncontrado("No hay ningún nodo en la base de datos");
		}else{
			Nodo nodo=this.buscar_compuesto(this.raiz.getNodoDer(), cadena);
			if(nodo==null)
			{
				//no encontramos la cadena ingresada como si
				//fuera un compuesto. Tal vez un medicamento?
				return this.buscar_medicamento(this.raiz.getNodoIzq(), cadena);
			}else{
				return nodo;
			}
		}
	}

	public Vector<Nodo> Nodos()
	{
		Vector<Nodo> vector=new Vector();
		this.Nodo(vector, this.raiz.getNodoIzq());
		return vector;
	}

	/**Busca la cadena en el árbol ABB considerando a cadena como el nombre
	 * de un medicamento, si no se encuentra se lanza la excepción
	 * ArbolNombres_NoEncontrado
	 *@param cadena El string a buscar en el árbol ABB. Se ignoran las mayúsculas
	 *@return El nodo encontrado*/
	public Nodo BuscarMedicamento(String cadena)throws ArbolNombres_NoEncontrado
	{
		if(this.raiz==null)
		{
			throw new ArbolNombres_NoEncontrado("No hay nodos en la base de datos");
		}else{
			Nodo nodo=this.buscar_medicamento(this.raiz.getNodoIzq(), cadena);
			if(nodo==null)
			{
				//no encontramos la cadena ingresada como si
				//fuera un compuesto. Tal vez un medicamento?
				return this.buscar_compuesto(this.raiz.getNodoDer(), cadena);
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
		int comparacion=raiz.getNombreCompuesto().compareToIgnoreCase(nodo.getNombreCompuesto());
		if(comparacion<0)
		{
			//Vemos si podemos agregar el nodo a la izquierda
			if(raiz.getNodoIzq()==null)
			{
				//agregamos el nodo
				raiz.setNodoIzq(nodo);
			}else{
				//seguimos buscando por un nodo vació
				agregar_compuesto(raiz.getNodoIzq(), nodo);
			}
		}else if(comparacion>0){
			//vemos si podemos agregar el nodo a la derecha
			if(raiz.getNodoDer()==null)
			{
				raiz.setNodoDer(nodo);
			}else{
				agregar_compuesto(raiz.getNodoDer(), nodo);
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
		int comparacion=raiz.getNombreMedicamento().compareToIgnoreCase(nodo.getNombreMedicamento());

		if(comparacion<0)
		{
			//izquierda
			if(raiz.getNodoIzq()==null)
			{
				raiz.setNodoIzq(nodo);
			}else{
				agregar_medicamento(raiz.getNodoIzq(), nodo);
			}
		}else if(comparacion>0){
			//derecha
			if(raiz.getNodoDer()==null)
			{
				raiz.setNodoDer(nodo);
			}else{
				agregar_medicamento(raiz.getNodoDer(), nodo);
			}
		}else{
			//encontramos el mismo medicamento...lo
			//modificamos?
			//TODO
		}
	}

	/**Busca la cadena asumiendo que es un compuesto en el árbol binario dado,
	 * si no se encuentra entonces se lanza una excepción
	 * ArbolNombres_NoEncontrado
	 * @param raiz Raíz del árbol binario en donde buscar la cadena.
	 * @param cadena Un string a buscar en el árbol binario se ignoran las
	 * mayúsculas
	 * */
	private Nodo buscar_compuesto(Nodo raiz, String cadena)throws ArbolNombres_NoEncontrado
	{
		if(raiz==null)
		{
			//No encontramos el compuesto dado
			throw new ArbolNombres_NoEncontrado("No se encontró "+cadena+" en la base de datos");
		}else{
			int compuesto=raiz.getNombreCompuesto().compareToIgnoreCase(cadena);

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
					return buscar_compuesto(raiz.getNodoIzq(), cadena);
				}else{
					return buscar_compuesto(raiz.getNodoDer(), cadena);
				}
			}
		}
	}

	/**Busca la cadena asumiendo que es un compuesto en el árbol binario
	 * dado, si no encuentra la cadena entonces lanza una excepción
	 * ArbolNombres_NoEncontrado
	 * @param raiz Raíz del árbol binario en donde buscar la cadena.
	 * @param cadena Un string a buscar en el árbol binario. Se ignoran las
	 * mayúsculas
	 * */
	private Nodo buscar_medicamento(Nodo raiz, String cadena)throws ArbolNombres_NoEncontrado
	{
		if(raiz==null)
		{
			//No encontramos el medicamento dado
			throw new ArbolNombres_NoEncontrado("No se encontró "+cadena+" en la base de datos");
		}else{
			int medicamento=raiz.getNombreMedicamento().compareToIgnoreCase(cadena);

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
					return buscar_medicamento(raiz.getNodoIzq(), cadena);
				}else{
					return buscar_medicamento(raiz.getNodoDer(), cadena);
				}
			}
		}
	}

	/**Agrega todos los nodos del árbol al vector dado como argumento
	 * @param vector El vector que contendrá a los nodos del árbol
	 * @param raiz La raíz inicial de un árbol que contenga nodos*/
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
			this.Nodo(vector, raiz.getNodoIzq());
			this.Nodo(vector, raiz.getNodoDer());
		}
	}
}

/**Clase de excepción para lanzar en caso de no encontrar un nodo*/
class ArbolNombres_NoEncontrado extends Exception{

	ArbolNombres_NoEncontrado(String mensaje)
	{
		super(mensaje);
	}

	ArbolNombres_NoEncontrado()
	{
		super();
	}
}
