/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Portada.java
 *
 * Created on 28-01-2012, 05:14:43 PM
 */

package grafica;

import java.awt.Dimension;

/**
 *
 * @author Marcial
 */
public class Portada extends javax.swing.JFrame {

	ArbolSintomas arbol_sintomas;
	ArbolNombres arbol_nombres;

	/** Creates new form Portada */
	public Portada(ArbolNombres arbol_nombres, ArbolSintomas arbol_sintomas)
	{
		initComponents();
		this.arbol_sintomas=arbol_sintomas;
		this.arbol_nombres=arbol_nombres;
	}

	public Portada()
	{
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
		// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
		private void initComponents() {

			jDesktopPane1 = new javax.swing.JDesktopPane();
			jLabel1 = new javax.swing.JLabel();
			jButton1 = new javax.swing.JButton();
			jButton2 = new javax.swing.JButton();

			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

			jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo lab 2.jpg"))); // NOI18N
			jLabel1.setBounds(0, 0, 300, 230);
			jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modificar datos.jpg"))); // NOI18N
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
			jButton1.setBounds(70, 250, 160, 30);
			jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

			jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consultar soluciones.jpg"))); // NOI18N
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					jButton2ActionPerformed(evt);
				}
			});
			jButton2.setBounds(60, 300, 190, 30);
			jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
			getContentPane().setLayout(layout);
			layout.setHorizontalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					);
			layout.setVerticalGroup(
					layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					);

			pack();
		}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		Modificar_Datos ventana1 = new Modificar_Datos(this.arbol_nombres, this.arbol_sintomas);
		Dimension dlgSize = ventana1.getPreferredSize();
		Dimension pantalla = getSize();
		Dimension ventana = ventana1.getSize() ;
		ventana1.setLocation((pantalla.width - Modificar_Datos.WIDTH ) / 2 ,(pantalla.height - Modificar_Datos.HEIGHT) / 2);
		ventana1.setLocationRelativeTo(null) ; // CENTRA EL SEGUNDO FRAME EN LA PANTA
		ventana1.pack() ;
		ventana1.setResizable(true) ; // PERMITE REDIMENSIONAR
		ventana1.setVisible(true) ;
	}//GEN-LAST:event_jButton1ActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
		Consultar_Soluciones ventana2 = new Consultar_Soluciones(this.arbol_nombres, this.arbol_sintomas);
		Dimension dlgSize = ventana2.getPreferredSize();
		Dimension pantalla = getSize();
		Dimension ventana = ventana2.getSize() ;
		ventana2.setLocation((pantalla.width - Consultar_Soluciones.WIDTH ) / 2 ,(pantalla.height - Consultar_Soluciones.HEIGHT) / 2);
		ventana2.setLocationRelativeTo(null) ; // CENTRA EL SEGUNDO FRAME EN LA PANTA
		ventana2.pack() ;
		ventana2.setResizable(true) ; // PERMITE REDIMENSIONAR
		ventana2.setVisible(true) ;
	}//GEN-LAST:event_jButton2ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Portada().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JLabel jLabel1;
	// End of variables declaration//GEN-END:variables

}
