/**Archivo de prueba, no es parte del codigo*/
import java.io.*;
import java.util.*;

public class felipe_main{

	public static void main(String[] args)throws IOException, ArbolNombres_NoEncontrado
	{
		
		Fichero f=new Fichero();

		f.Leer();

		ArbolNombres arbol=f.ArbolNombres();
		
		arbol.BuscarCompuesto("Aspirina");

		ArbolSintomas sintomas=f.ArbolSintomas();

		Vector<Snodo> nodos=sintomas.VSnodos();

		int i;
		for(i=0;i<nodos.size();i++)
		{
			System.out.println(nodos.elementAt(i).getSintoma());
		}

		try{
			sintomas.BuscarSintoma("vomitos");
			
		}catch(ArbolSintomasNoEncontrado e){
			//System.out.println("UPS");
		}

	}
}
