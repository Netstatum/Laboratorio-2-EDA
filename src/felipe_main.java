/**Archivo de prueba, no es parte del codigo*/
import java.io.*;
import java.util.*;

public class felipe_main{

	public static void main(String[] args)throws IOException, ArbolNombres_NoEncontrado
	{

		Fichero f=new Fichero();

		f.Leer();


		ArbolNombres arbol=f.ArbolNombres();
		ArbolSintomas arbol_sintomas=f.ArbolSintomas();

		f.Escribir(arbol);
	
		Vector<Snodo> snodos=arbol_sintomas.VSnodos();

		for(int i=0;i<snodos.size();i++)
		{
			for(int j=0;j<snodos.elementAt(i).getNombreCompuestos().size();j++)
			{
				//System.out.println(snodos.elementAt(i).getNombreCompuestos().elementAt(j));
			}
		}


		Vector<String> sintomas=new Vector();

		sintomas.add("Vomitos");

		try{
			Vector <String> mejor=arbol_sintomas.mejorSolucion(arbol_sintomas.BuscarSintoma(sintomas));

			if(mejor.size()!=0)
			{
				Nodo nodo=arbol.BuscarCompuesto(mejor.elementAt(0));
				System.out.println(nodo.getNombreCompuesto());
			}else{
				System.out.println("no se encontro");
			}


		}catch(ArbolSintomasNoEncontrado e){
			System.out.println("No encontrado");
		}


		arbol.BuscarCompuesto("Letras");

	}
}
