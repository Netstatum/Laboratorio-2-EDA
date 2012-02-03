/**Esta clase se encarga de leer y escribir en un archivo*/

import java.util.Vector;
import java.io.*;

class Fichero{
	
	/**Nombre el fichero a leer o escribir*/
	String nombre;
	String contenido;
	Serializar serializar;

	/**Inicia la clase para leer y escribir en el archivo por defecto
	 * "database.txt"*/
	Fichero()throws IOException
	{
		this.nombre="database.txt";
		this.Leer();
	}

	/**Inicia la clase para leer y escribir en el archivo dado
	 * @param fichero Archivo en el cual vamos a leer y escribir*/
	Fichero(File fichero)throws IOException
	{
		this.nombre=fichero.getPath();
		this.Leer();
	}

	/**Escribe los nodos que hay en el arbol dado en el archivo
	 * @param arbol Un arbol de ArbolNombres de donde se obtendran los nodos*/
	public void Escribir(ArbolNombres arbol)throws IOException
	{
		FileWriter fichero=new FileWriter(this.nombre);
		fichero.write((new Serializar(arbol.Nodos())).Serializacion().toCharArray());
		fichero.close();
	}

	/**Lee el archivo y crea un ArbolNombres a partir del contenido
	 * @return El arbol creado a partir del archivo*/
	public void Leer()throws IOException
	{
		byte[] buffer = new byte[(int) new File(this.nombre).length()];
		FileInputStream f = new FileInputStream(this.nombre);
		f.read(buffer);
		this.contenido=new String(buffer);

		this.serializar=new Serializar(this.contenido);

	}

	/**Lee el archivo y crea un ArbolNombres a partir del contenido
	 * @return El arbol creado a partir del archivo*/
	public ArbolNombres ArbolNombres()
	{
		return new ArbolNombres(this.serializar.Nodos());
	}
	
	/**@return Devuelve un ArbolSintomas a partir del fichero leido*/
	public ArbolSintomas ArbolSintomas()
	{
		if(serializar==null)
		{
			System.out.println("Hola");
		}
		return this.serializar.ArbolSintomas();
	}
}
