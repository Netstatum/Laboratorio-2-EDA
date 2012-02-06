/**Esta clase se encarga de leer y escribir en un archivo*/

import java.util.Vector;
import java.io.*;

class Fichero{
	
	/**Nombre el fichero a leer o escribir*/
	String nombre;

	/**Inicia la clase para leer y escribir en el archivo por defecto
	 * "database.txt"*/
	Fichero()
	{
		this.nombre="database.txt";
	}

	/**Inicia la clase para leer y escribir en el archivo dado
	 * @param fichero Archivo en el cual vamos a leer y escribir*/
	Fichero(File fichero)
	{
		this.nombre=fichero.getPath();
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
	public ArbolNombres Leer()throws IOException
	{
		byte[] buffer = new byte[(int) new File(this.nombre).length()];
		FileInputStream f = new FileInputStream(this.nombre);
		f.read(buffer);
		String contenido=new String(buffer);

		Serializar serializar=new Serializar(contenido);
		return new ArbolNombres(serializar.Nodos());
	}
}
