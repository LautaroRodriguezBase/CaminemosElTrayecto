/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iset.caminemoseltrayecto.visual;

import com.iset.caminemoseltrayecto.CaminemosElTrayecto;
import com.iset.caminemoseltrayecto.modelos.Docente;
import com.iset.caminemoseltrayecto.modelos.Curso;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
/**
 *
 * @author lauti
 */
public class DocenteFrame extends javax.swing.JFrame implements ActionListener{

    private Docente docente;//Probablemente Final
    private final Border borderRed = BorderFactory.createLineBorder(Color.decode("#ff0000"));//deneria ser static
    private Curso cursosD[] = null;//no se por que es cursosD
    /**
     * Creates new form DocenteFrame
     */
    public DocenteFrame(Docente docente) throws IOException, ClassNotFoundException {
        this.docente = docente;
        this.setTitle("Bienvenido " + this.docente.getApellido() + ", " + this.docente.getNombre());
        
        cursosD = getCursosTotales();

        initComponents();
        
        taNoticias.setText(
            taNoticias.getText() + "\n" +
            (docente.getEstado() == Sancionable.SANCIONADO?
                "Usted está sancionado":
                ""
            )
        );
        
        bCrearCurso.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lTitleDocente = new javax.swing.JLabel();
        bCrearCurso = new javax.swing.JButton();
        cbCursosPrevios1 = new javax.swing.JComboBox<>();
        cbCursosPrevios2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfNombreCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        bSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taNoticias = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lTitleDocente.setText("Docente");

        bCrearCurso.setText("Add Curso");

        cbCursosPrevios1.setModel(new javax.swing.DefaultComboBoxModel<>(cursosD));
        cbCursosPrevios1.setSelectedItem(cursosD[0]);

        cbCursosPrevios2.setModel(new javax.swing.DefaultComboBoxModel<>(cursosD));
        cbCursosPrevios2.setSelectedItem(cursosD[0]);

        jLabel1.setText("Curso Nuevo");

        tfNombreCurso.setText("Nombre");
        tfNombreCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreCursoActionPerformed(evt);
            }
        });

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        taDescripcion.setText("Descripcion");
        jScrollPane1.setViewportView(taDescripcion);

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        jLabel2.setText("Noticias");

        taNoticias.setEditable(false);
        taNoticias.setColumns(20);
        taNoticias.setRows(5);
        taNoticias.setText("Aquí verá las noticias.");
        taNoticias.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(taNoticias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lTitleDocente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 872, Short.MAX_VALUE)
                        .addComponent(bSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tfNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(bCrearCurso)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbCursosPrevios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbCursosPrevios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTitleDocente)
                    .addComponent(bSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bCrearCurso))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(cbCursosPrevios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbCursosPrevios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 323, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreCursoActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        if(evt.getSource() == bSalir){
            this.setVisible(false);
            CaminemosElTrayecto.goLogIn();
        }
    }//GEN-LAST:event_bSalirActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DocenteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DocenteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DocenteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DocenteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {//Dudo que se ejecute
            private Docente docente;
            public void run() {
                try {
                    new DocenteFrame(this.docente).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(DocenteFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DocenteFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrearCurso;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<Curso> cbCursosPrevios1;
    private javax.swing.JComboBox<Curso> cbCursosPrevios2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lTitleDocente;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTextArea taNoticias;
    private javax.swing.JTextField tfNombreCurso;
    // End of variables declaration//GEN-END:variables
    public Curso[] getCursosTotales() throws IOException, ClassNotFoundException{
        Curso [] cursosT = new Curso[((CaminemosElTrayecto.getCursos() == null)? 1 : CaminemosElTrayecto.getCursos().size() + 1)];
        cursosT[0] = null;

        if(cursosT.length > 1){
            for(int i = 1; i < cursosT.length; i++){
                cursosT[i] = CaminemosElTrayecto.getCursos().get(i-1);
            }
        }
        return cursosT;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bCrearCurso){
            Curso [] cursosPrevios = {null, null};
            if(cbCursosPrevios1.getSelectedItem() != null){
                cursosPrevios[0] = (Curso)cbCursosPrevios1.getSelectedItem();
            }
            if(cbCursosPrevios2.getSelectedItem() != null){
                cursosPrevios[1] = (Curso)cbCursosPrevios2.getSelectedItem();
            }

            try {
                System.out.println("try");
                Curso cursoNuevo = new Curso(tfNombreCurso.getText(), taDescripcion.getText(), this.docente, cursosPrevios);
                CaminemosElTrayecto.addCurso(this.docente, cursoNuevo);
                
                Curso cursosT[] = getCursosTotales();
                cbCursosPrevios1.setModel(new javax.swing.DefaultComboBoxModel<>(cursosT));
                cbCursosPrevios2.setModel(new javax.swing.DefaultComboBoxModel<>(cursosT));
                System.out.println("Fin try");
            } catch (IOException ex) {
                tfNombreCurso.setText("Error");
                tfNombreCurso.setBorder(borderRed);
                Logger.getLogger(DocenteFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DocenteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
