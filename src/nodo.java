import java.util.Vector;

class Nodo{
	/**El nombre del medicamento que se encuentra en este nodo*/
	private String nombre_medicamento;

	/**El nombre del compuesto que se encuentra en este nodo*/
	private String nombre_compuesto;

	/**Los procedimientos a seguir para solucionar la intoxicacion con este
	 * medicamento, compuesto o sintomas*/
	private String solucion;

	/**Vector que contiene los síntomas del compuesto o medicamento que se
	 * encuentra en este nodo*/
	private Vector<String> sintomas;

	/**Nodos hijos de este nodo*/
	private Nodo izq, der;

	/**Inicia un nuevo nodo con los argumentos dados
	 * @param nombre_medicamento El nombre del medicamento que contendrá el
	 * nodo
	 * @param nombre_compuesto El nombre del compuesto que contendrá en nodo
	 * @param sintomas Un array de los posibles síntomas que pueda tener el
	 * ingerir este medicamento o compuesto o sustancia
	 * @param solucion La solucion para tratar la intoxcicacion del paciente*/
	Nodo(String nombre_medicamento, String nombre_compuesto, String solucion)
	{
		this.inicializar(nombre_medicamento, nombre_compuesto, solucion);
	}

	/**Inicia un nuevo nodo vació*/
	Nodo()
	{
		this.inicializar(null, null, null);
	}

	/**Se encarga de inicializar las variables de acuerdo a los argumentos
	 * dados
	 * @param nombre_medicamento El nombre del medicamento que contendrá el
	 * nodo
	 * @param nombre_compuesto El nombre del compuesto que contendrá en nodo
	 * @param solucion La solucion para tratar la intoxcicacion del paciente*/
	void inicializar(String nombre_medicamento, String nombre_compuesto, String solucion)
	{

		this.nombre_medicamento=nombre_medicamento;
		this.nombre_compuesto=nombre_compuesto;
		this.sintomas=sintomas;
		this.solucion=solucion;

		this.izq=null;
		this.der=null;
		this.sintomas=new Vector();
	}

	/**Agrega un nuevo síntoma a la lista de síntomas de este compuesto.
	 * @param cadena Nombre del síntoma a agregar*/
	public void AgregarSintoma(String cadena)
	{
		this.sintomas.add(cadena);
	}

	/**Reemplaza los síntomas actuales por los síntomas dados como argumento
	 * @param sintomas Los nuevos síntomas de este nodo*/
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
	 * @param nodo El nodo a asignar en el subárbol izquierdo*/
	public void setNodoIzq(Nodo nodo)
	{
		this.izq=nodo;
	}

	/**Asigna como nodo hijo derecho el nodo dado
	 * @param nodo El nodo a asignar en el subárbol derecho*/
	public void setNodoDer(Nodo nodo)
	{
		this.der=nodo;
	}

	/**@return Devuelve el nodo del subárbol derecho*/
	public Nodo getNodoDer()
	{
		return this.der;
	}

	/**@return Devuelve el nodo del subárbol izquierdo*/
	public Nodo getNodoIzq()
	{
		return this.izq;
	}

	/**@return Devuelve la solucion para tratar la intoxicacion causada por
	 * el compuesto o medicamento de este nodo*/
	public String getSolucion()
	{
		return this.solucion;
	}

	/**Asigna la solucion dada a este nodo
	 * @param solucion La solucion a asignar*/
	public void setSolucion(String solucion)
	{
		this.solucion=solucion;
	}

	/**@return Devuelve un vector de strings con los síntomas de este nodo*/
	public Vector<String> getSintomas()
	{
		return this.sintomas;
	}
}
