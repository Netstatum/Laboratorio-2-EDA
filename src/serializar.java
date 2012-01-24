import java.util.Vector;

class Serializar{

	String cadena;
	Vector<Nodo> nodos;

	Serializar(String cadena)
	{
		this.cadena=cadena;
		this.nodos=new Vector();
		this.des_serializar();
	}

	Serializar(Vector<Nodo> nodos)
	{
		this.nodos=nodos;
		this.cadena=new String();
		this.serializar();
	}


	public String Serializacion()
	{
		return cadena;
	}

	public Vector<Nodo> Nodos()
	{
		return this.nodos;
	}


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

	private void des_serializar()
	{

	}

}
