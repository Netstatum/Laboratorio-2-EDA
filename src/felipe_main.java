/**Archivo de prueba, no es parte del codigo*/
import java.io.*;
import java.util.*;

public class felipe_main{

	public static void main(String[] args)throws IOException, ArbolNombres_NoEncontrado
	{
		
		Fichero f=new Fichero();

		f.Leer();


		ArbolNombres arbol=f.ArbolNombres();

		f.Escribir(arbol);

		Vector<Nodo> nodos=arbol.Nodos();

		for(int i=0;i<nodos.size();i++)
		{
			//System.out.println(nodos.elementAt(i).getNombreCompuesto());
		}
		
		arbol.BuscarCompuesto("Letras");

	}
}
