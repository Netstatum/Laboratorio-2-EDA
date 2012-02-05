/**Archivo de prueba, no es parte del codigo*/
import java.io.*;
import java.util.*;

public class felipe_main{

	public static void main(String[] args)throws IOException, ArbolNombres_NoEncontrado
	{
		
		Fichero f=new Fichero();

		f.Leer();


		ArbolNombres arbol=f.ArbolNombres();
		ArbolSintomas arbols=f.ArbolSintomas();

		f.Escribir(arbol);

		Vector<Nodo> nodos=arbol.Nodos();

		
		arbol.BuscarCompuesto("Letras");

	}
}
