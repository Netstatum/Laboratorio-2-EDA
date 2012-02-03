/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package grafica;

import java.awt.*;
import javax.swing.*;

import java.io.*;

/**
 *
 * @author Marcial
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		//debemos leer los arboles al inicio

		try{

			Cargando c=new Cargando();
			c.setVisible(true);
			ArbolSintomas arbol_sintomas=null;
			ArbolNombres arbol_nombres=null;

			try{
				Fichero l=new Fichero();
				arbol_sintomas=l.ArbolSintomas();
				arbol_nombres=l.ArbolNombres();
			}catch(IOException e){
				c.setVisible(false);
				JOptionPane.showMessageDialog(null, "Error!, no se puede leer 'database.txt'");
				System.exit(1);
			}

			c.setVisible(false);

			
			Portada disponible =new Portada(arbol_nombres, arbol_sintomas);
			disponible.setVisible(true);
			disponible.setLocationRelativeTo(null);
		}catch(Exception e){
			System.out.println("FALLO GRAVE!");
			e.printStackTrace();
			//reiniciamos la aplicacion
			main(null);
		}


	}
}


