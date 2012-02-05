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

		Vector<String> sintomas=new Vector();

		sintomas.add("LOLCOde");

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
