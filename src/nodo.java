import java.util.Vector;

class Nodo{
	/**El nombre del medicamento que se encuentra en este nodo*/
	private String nombre_medicamento;

	/**El nombre del compuesto que se encuentra en este nodo*/
	private String nombre_compuesto;

	/**Vector que contiene los síntomas del compuesto o medicamento que se
	 * encuentra en este nodo*/
	private Vector<String> sintomas;

	/**Nodos hijos de este nodo*/
	private Nodo izq, der;

	/**Inicia un nuevo nodo con los argumentos dados
	 * @param nombre_medicamento El nombre del medicamento que contendrá el
	 * nodo
	 * @param nombre_compuesto El nombre del compuesto que contendra en nodo
	 * @param sintomas Un array de los posibles síntomas que pueda tener el
	 * ingerir este medicamento o compuesto o sustancia*/
	Nodo(String nombre_medicamento, String nombre_compuesto)
	{
		this.inicializar(nombre_medicamento, nombre_compuesto);
	}

	/**Inicia un nuevo nodo vació*/
	Nodo()
	{
		this.inicializar(null, null);
	}

	/**Se encarga de inicializar las variables de acuerdo a los argumentos
	 * dados
	 * @param nombre_medicamento El nombre del medicamento que contendrá el
	 * nodo
	 * @param nombre_compuesto El nombre del compuesto que contendrá en nodo*/
	void inicializar(String nombre_medicamento, String nombre_compuesto)
	{

		this.nombre_medicamento=nombre_medicamento;
		this.nombre_compuesto=nombre_compuesto;
		this.sintomas=sintomas;

		this.izq=null;
		this.der=null;
		this.sintomas=new Vector();
	}

	/**Agrega un nuevo sintoma a la lista de sintomas de este compuesto.
	 * @param cadena Nombre del sintoma a agregar*/
	public void AgregarSintoma(String cadena)
	{
		this.sintomas.add(cadena);
	}

	/**Reemplaza los sintomas actuales por los sintomas dados como argumento
	 * @param sintomas Los nuevos sintomas de este nodo*/
	public void AgregarSintoma(Vector<String> sintomas)
	{
		this.sintomas=sintomas;
	}

	/**Cambia el nombre de este medicamento por la cadena dada
	 * @param nombre El nuevo nombre del medicamento*/
	public void setNombreMedicamento(String nombre)
	{
		this.nombre_medicamento=nombre;
	}

	/**Cambia el nombre de este compuesto por la cadena dada
	 * @param nombre El nuevo nombre del compuesto*/
	public void setNombreCompuesto(String nombre)
	{
		this.nombre_compuesto=nombre;
	}

	/**@return El nombre del medicamento de este nodo*/
	public String getNombreMedicamento()
	{
		return this.nombre_medicamento;
	}

	/**@return El nombre del compuesto de este nodo*/
	public String getNombreCompuesto()
	{
		return this.nombre_compuesto;
	}

	/**Asigna como nodo hijo izquierdo el nodo dado
	 * @param nodo El nodo a asignar en el subarbol izquierdo*/
	public void setNodoIzq(Nodo nodo)
	{
		this.izq=nodo;
	}

	/**Asigna como nodo hijo derecho el nodo dado
	 * @param nodo El nodo a asignar en el subarbol derecho*/
	public void setNodoDer(Nodo nodo)
	{
		this.der=nodo;
	}

	/**@return Devuelve el nodo del subarbol derecho*/
	public Nodo getNodoDer()
	{
		return this.der;
	}

	/**@return Devuelve el nodo del subarbol izquierdo*/
	public Nodo getNodoIzq()
	{
		return this.izq;
	}

	/**@return Devuelve un vector de strings con los sintomas de este nodo*/
	public Vector<String> getSintomas()
	{
		return this.sintomas;
	}
}
