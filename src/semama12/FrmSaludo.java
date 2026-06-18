package semama12;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class FrmSaludo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmSaludo.class.getName());
    private DefaultListModel modelo= new DefaultListModel();
    
    public FrmSaludo() {
        initComponents();
      
         jTextField1.requestFocus();
         
        //Tamaño personalizado y posición centro.
        setSize(500,400);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
        setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);

        //Tamaño de toda la pantalla y posición centro.
        //setSize(pantalla.width, pantalla.height);
        //setLocation(0,0);
        
        //Posición personalizada
        //setLocation(600,300);
        
        getContentPane().setBackground(Color.cyan);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jbtnEliminar = new javax.swing.JButton();
        jbtnAgregar = new javax.swing.JButton();
        jbtnLimpiar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jtxtPromedio = new javax.swing.JTextField();
        jtxtSuma = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setModel(modelo);
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jList1.addListSelectionListener(this::jList1ValueChanged);
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 100, 140));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 170, -1));

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(this::jbtnEliminarActionPerformed);
        getContentPane().add(jbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 170, -1));

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(this::jbtnAgregarActionPerformed);
        getContentPane().add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 170, -1));

        jbtnLimpiar.setText("Limpiar");
        jbtnLimpiar.addActionListener(this::jbtnLimpiarActionPerformed);
        getContentPane().add(jbtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 170, -1));

        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(this::jbtnSalirActionPerformed);
        getContentPane().add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 170, -1));

        jtxtPromedio.setEditable(false);
        getContentPane().add(jtxtPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 170, -1));

        jtxtSuma.setEditable(false);
        getContentPane().add(jtxtSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 170, -1));

        jLabel1.setText("Promedio:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        jLabel2.setText("Número:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel3.setText("Suma:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void CalculoSumaPromedio ()
    {
  double suma = 0;
    int cantidad = modelo.size();

    for (int i = 0; i < cantidad; i++) {
        suma += Double.parseDouble(modelo.get(i).toString());
    }

    double promedio = (cantidad == 0) ? 0 : suma / cantidad;

    DecimalFormat df = new DecimalFormat("#.##");
    //XDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD

    jtxtSuma.setText(df.format(suma));
    jtxtPromedio.setText(df.format(promedio));
    }
    
    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        // TODO add your handling code here:
        
        /*
            Obtener el elemento seleccionado de la lista
            y escribirlo en el campo de texto y boton
        */
        //String nombre=jList1.getSelectedValue();
        //jTextField1.setText(nombre);
        //jbtnEliminar.setText(nombre);
               
    }//GEN-LAST:event_jList1ValueChanged

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        // TODO add your handling code here:
        int i=jList1.getSelectedIndex();
        if(i!=-1)
        {
            modelo.removeElementAt(i);
            CalculoSumaPromedio();
            jTextField1.requestFocus();
        }
        else
            JOptionPane.showMessageDialog(null, "No se ha seleccionado elemento");
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        // TODO add your handling code here:
        
          String numero = jTextField1.getText().trim();

    if(numero.isEmpty())
    {
        JOptionPane.showMessageDialog(null, "No se ha ingresado elemento");
        jTextField1.requestFocus();
        return;
    }

    try
    {
        Double.parseDouble(numero); // Validar que sea número

        modelo.addElement(numero);
        CalculoSumaPromedio();

        jTextField1.setText("");
        jTextField1.requestFocus();
    }
    catch(NumberFormatException e)
    {
        JOptionPane.showMessageDialog(
                null,
                "Solo se permiten números",
                "Error",
                JOptionPane.ERROR_MESSAGE);

        jTextField1.requestFocus();
        jTextField1.selectAll();
    }

        
       
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimpiarActionPerformed
        // TODO add your handling code here:
        modelo.removeAllElements();
        CalculoSumaPromedio();
          jTextField1.setText("");
          jTextField1.requestFocus();
    }//GEN-LAST:event_jbtnLimpiarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

      public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmSaludo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnLimpiar;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JTextField jtxtPromedio;
    private javax.swing.JTextField jtxtSuma;
    // End of variables declaration//GEN-END:variables
}
