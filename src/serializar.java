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


	/**Convierte los nodos en un string para poder escribir en un archivo
	 * Sigue el siguiente formato:
	 * nombre_medicamento = NOMBRE_MEDICAMENTO (Opcional)
	 * nombre_compuesto = NOMBRE_COMPUESTO 
	 * sintomas = sintoma1,sintoma2,sintoma3
	 *
	 * Acepta comentarios con #*/
	private void serializar()
	{
		int i, j;
		String c;
		Nodo nodo;

		for(i=0;i<this.nodos.size();i++)
		{
			c="";
			nodo=this.nodos.elementAt(i);

			c+="nombre_medicamento = "+nodo.getNombreMedicamento()+"\n";
			c+="nombre_compuesto = "+nodo.getNombreCompuesto();
			
			if(nodo.getSintomas().size()>0)
			{
				c+="\nsintomas = ";
				for(j=0;j<nodo.getSintomas().size();j++)
				{
					c+=nodo.getSintomas().elementAt(j)+",";
				}
			}
			c+="\n\n";
			this.cadena+=c;
		}
	}

	/**A partir de un string crea los nodos correspondientes*/
	private void des_serializar()
	{
		String []bloques=this.cadena.split("\n\n");
		String []lineas;
		this.nodos=new Vector();
		Nodo nodo;

		int i, j;

		for(i=0;i<bloques.length;i++)
		{
			lineas=bloques[i].split("\n");
			nodo=crear(lineas);
			if(nodo!=null)
			{
				this.nodos.add(nodo);
			}
		}
	}

	
	/**Crea un nodo a partir de las lineas dadas
	 * @param lineas Un array de String de las lineas a ser interpretadas
	 * para ser convertidas en un objeto nodo*/
	private Nodo crear(String []lineas)
	{
		Nodo nodo=new Nodo();
		String []asignacion;
		String variable, valor;
		int i;
		for(i=0;i<lineas.length;i++)
		{
			asignacion=lineas[i].split("=");
			if(asignacion.length==2) //valido
			{
			
				//eliminamos los espacios en blanco al final y
				//al principio de la cadena
				variable=asignacion[0].trim();
				valor=asignacion[1].trim();

				if(variable.equalsIgnoreCase("nombre_medicamento"))
				{
					nodo.setNombreMedicamento(asignacion[1]);

				}else if(variable.equalsIgnoreCase("nombre_compuesto")){

					nodo.setNombreCompuesto(asignacion[1]);

				}else if(variable.equalsIgnoreCase("sintomas")){

					crear_sintomas(valor, nodo);

				}else{
					//no valido
					return null;
				}
			}else{
				return null;
			}
		}

		return nodo;
	}

	/**Lee los sintomas desde el string valor en donde estan separados por
	 * comas y las agrega al nodo dado
	 * @param valor String que contiene a los sintomas separados por comas:
	 * vomitos,mareos,etc
	 * @param nodo Nodo al cual se va a agregar los sintomas*/
	private void crear_sintomas(String valor, Nodo nodo)
	{
		int i;
		String []valores=valor.split(",");

		for(i=0;i<valores.length;i++)
		{
			if(valores[i]!=null)
			{
				nodo.AgregarSintoma(valores[i].trim());
			}
		}
	}
}
