/**Esta clase implementa metodos para convertir objetos Nodo a un string que
 * pueda ser escrito en un archivo y el proceso inverso*/
import java.util.Vector;

class Serializar{

	/**Cadena que representa la version imprimible de los objetos Nodo*/
	private String cadena;

	/**Los nodos obtenidos del string dado en el constructor*/
	private Vector<Nodo> nodos;

	/**Constructor a partir de un String
	 * @param cadena Cadena que contiene los objetos a ser interpretados*/
	Serializar(String cadena)
	{
		this.cadena=cadena;
		this.nodos=new Vector();
		this.des_serializar();
	}

	/**Constructor a partir de un vector de nodos
	 * @param nodos Un vector con los nodos a ser pasados a un string*/
	Serializar(Vector<Nodo> nodos)
	{
		this.nodos=nodos;
		this.cadena=new String();
		this.serializar();
	}


	/**@return Devuelve una cadena representando los objetos del vector nodo
	 * dado en el constructor*/
	public String Serializacion()
	{
		return cadena;
	}

	/**@return Devuelve un vector con los nodos que se lograron obtener de
	 * un string dado en el constructor*/
	public Vector<Nodo> Nodos()
	{
		return this.nodos;
	}


	/**Convierte los nodos en un string para poder escribir en un archivo*/
	private void serializar()
	{
		int i, j;
		String c;
		Nodo nodo;

		for(i=0;i<this.nodos.size();i++)
		{
			c="";
			nodo=this.nodos.elementAt(i);

			c+=nodo.nombre_medicamento+"\n";
			c+=nodo.nombre_compuesto+"\n";
			
			for(j=0;j<nodo.sintomas.size();j++)
			{
				c+="\t"+nodo.sintomas.elementAt(j)+"\n";
			}
			c+="\n";
			this.cadena+=c;
		}
	}

	/**A partir de un string crea los nodos correspondientes*/
	private void des_serializar()
	{

	}

}
