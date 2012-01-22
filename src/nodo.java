class Nodo{
	String nombre_medicamento;
	String nombre_compuesto;

	/**Array que contiene los sintomas del compuesto o medicamento que se
	 * encuentra en este nodo*/
	String []sintomas;

	/**Nodos hijos de este nodo*/
	Nodo izq, der;

	/**Inicia un nuevo nodo con los argumentos dados
	 * @param nombre_medicamento El nombre del medicamento que contendra el
	 * nodo
	 * @param nombre_compuesto El nombre del compuesto que contendra en nodo
	 * @param sintomas Un array de los posibles sintomas que pueda tener el
	 * ingerir este medicamento o compuesto o sustancia*/
	Nodo(String nombre_medicamento, String nombre_compuesto, String []sintomas)
	{
		this.inicializar(nombre_medicamento, nombre_compuesto, sintomas);
	}

	/**Inicia un nuevo nodo vacio*/
	Nodo()
	{
		this.inicializar(null, null, null);
	}

	/**Se encarga de incializar las variables de acuerdo a los argumentos
	 * dados
	 * @param nombre_medicamento El nombre del medicamento que contendra el
	 * nodo
	 * @param nombre_compuesto El nombre del compuesto que contendra en nodo
	 * @param sintomas Un array de los posibles sintomas que pueda tener el
	 * ingerir este medicamento o compuesto o sustancia*/
	void inicializar(String nombre_medicamento, String nombre_compuesto, String []sintomas)
	{

		this.nombre_medicamento=nombre_medicamento;
		this.nombre_compuesto=nombre_compuesto;
		this.sintomas=sintomas;

		this.izq=null;
		this.der=null;
	}

}
