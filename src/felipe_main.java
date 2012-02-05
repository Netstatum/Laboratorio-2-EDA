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
		
		arbol.BuscarMedicamento("Chimmy Cherry");

	}
}
