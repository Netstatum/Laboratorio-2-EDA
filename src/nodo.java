import java.util.Vector;

class Nodo{
	private String nombre_medicamento;
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

	public void AgregarSintoma(String cadena)
	{
		this.sintomas.add(cadena);
	}

	public void setNombreMedicamento(String nombre)
	{
		this.nombre_medicamento=nombre;
	}

	public void setNombreCompuesto(String nombre)
	{
		this.nombre_compuesto=nombre;
	}

	public String getNombreMedicamento()
	{
		return this.nombre_medicamento;
	}

	public String getNombreCompuesto()
	{
		return this.nombre_compuesto;
	}

	public void setNodoIzq(Nodo nodo)
	{
		this.izq=nodo;
	}

	public void setNodoDer(Nodo nodo)
	{
		this.der=nodo;
	}


	public Nodo getNodoDer()
	{
		return this.der;
	}

	public Nodo getNodoIzq()
	{
		return this.izq;
	}

	public Vector<String> getSintomas()
	{
		return this.sintomas;
	}
}
