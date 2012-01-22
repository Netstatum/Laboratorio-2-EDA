class Nodo{
	String nombre_medicamento, nombre_compuesto;

	String []sintomas;

	Nodo izq, der;


	Nodo(String nombre_medicamento, String nombre_compuesto, String []sintomas)
	{
		this.nombre_medicamento=nombre_medicamento;
		this.nombre_compuesto=nombre_compuesto;
		this.sintomas=sintomas;

		this.izq=null;
		this.der=null;
	}
}
