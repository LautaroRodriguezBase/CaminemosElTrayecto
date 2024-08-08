/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iset.caminemoseltrayecto.visual;

import com.iset.caminemoseltrayecto.CaminemosElTrayecto;
import com.iset.caminemoseltrayecto.modelos.Alumno;
import com.iset.caminemoseltrayecto.modelos.Curso;
import java.util.ArrayList;

/**
 *
 * @author lauti
 */
public class AlumnoFrame extends javax.swing.JFrame {
    private Curso cursosD[];
    private Alumno alumno;
    /**
     * Creates new form UserFrame
     */
    public AlumnoFrame(Alumno alumno) {
        this.alumno = alumno;
        this.setTitle("Bienvenido " + this.alumno.getNombre() + " " + this.alumno.getApellido());
        
        //No entiendo por que no puedo hacer (Curso[])CaminemosElTrayecto.verCursosDisponibles(alumno).toArray()
        //Por esto: Funciona -> Integer nums[] = lista.toArray(new Integer[lista.size()]);
        cursosD = new Curso[CaminemosElTrayecto.verCursosDisponibles(alumno) == null? 1 : CaminemosElTrayecto.verCursosDisponibles(alumno).size() + 1];//(Curso[])
        cursosD[0] = null;
        if(cursosD.length > 1){
            for(int i = 1; i < cursosD.length; i++){
                cursosD[i] = CaminemosElTrayecto.verCursosDisponibles(alumno).get(i-1);
            }   
        }

        initComponents();
        
        taCursosInscriptos.setText(obtenerListaCursos(CaminemosElTrayecto.verCursosInscriptos(alumno)));
        taCursosAprobados.setText(obtenerListaCursos(CaminemosElTrayecto.verCursosAprobados(alumno)));
    
        taNoticias.setText(
            taNoticias.getText() + "\n" +
            (alumno.getEstado() == Sancionable.SANCIONADO?
                "Usted está sancionado":
                ""
            )
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lSubtituloSancionar1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taCursosInscriptos = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taCursosAprobados = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lSubtituloSancionar = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbCursosDisponibles = new javax.swing.JComboBox<>();
        bAgregarmeCurso = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lSubtituloSancionar2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taNoticias = new javax.swing.JTextArea();
        bSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lSubtituloSancionar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lSubtituloSancionar1.setForeground(new java.awt.Color(255, 255, 255));
        lSubtituloSancionar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSubtituloSancionar1.setText("Listados de Cursos");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cursos Inscriptos:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cursos Aprobados:");

        taCursosInscriptos.setEditable(false);
        taCursosInscriptos.setColumns(10);
        taCursosInscriptos.setLineWrap(true);
        taCursosInscriptos.setRows(20);
        taCursosInscriptos.setTabSize(4);
        taCursosInscriptos.setWrapStyleWord(true);
        jScrollPane3.setViewportView(taCursosInscriptos);

        taCursosAprobados.setEditable(false);
        taCursosAprobados.setColumns(10);
        taCursosAprobados.setLineWrap(true);
        taCursosAprobados.setRows(30);
        taCursosAprobados.setTabSize(4);
        taCursosAprobados.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taCursosAprobados);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lSubtituloSancionar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSubtituloSancionar1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lSubtituloSancionar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lSubtituloSancionar.setForeground(new java.awt.Color(255, 255, 255));
        lSubtituloSancionar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSubtituloSancionar.setText("Inscripción a Curso Nuevo");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Curso Disponibles:");

        cbCursosDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(cursosD));
        cbCursosDisponibles.setSelectedItem(cursosD[0]);

        bAgregarmeCurso.setText("Inscribir");
        bAgregarmeCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarmeCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lSubtituloSancionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bAgregarmeCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(cbCursosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSubtituloSancionar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbCursosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bAgregarmeCurso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        lSubtituloSancionar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lSubtituloSancionar2.setForeground(new java.awt.Color(255, 255, 255));
        lSubtituloSancionar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSubtituloSancionar2.setText("Noticias");

        taNoticias.setEditable(false);
        taNoticias.setColumns(10);
        taNoticias.setLineWrap(true);
        taNoticias.setRows(30);
        taNoticias.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taNoticias);

        bSalir.setText("Cerrar Sesión");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(lSubtituloSancionar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(bSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lSubtituloSancionar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bSalir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        if(evt.getSource() == bSalir){
            this.setVisible(false);
            CaminemosElTrayecto.goLogIn();
        }
    }//GEN-LAST:event_bSalirActionPerformed

    private void bAgregarmeCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarmeCursoActionPerformed
        if(evt.getSource() == bAgregarmeCurso){
            Curso cSelec = (Curso) cbCursosDisponibles.getSelectedItem();
            if(cSelec != null){
                CaminemosElTrayecto.addAlumnoAlCurso(alumno, cSelec);
                taNoticias.setText("Te has inscripto al curso " + cSelec.toString());
                taCursosInscriptos.setText(obtenerListaCursos(CaminemosElTrayecto.verCursosInscriptos(alumno)));
            }else{
                taNoticias.setText("Debes seleccionar un curso para inscribirte");
            }
        }
    }//GEN-LAST:event_bAgregarmeCursoActionPerformed

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
            java.util.logging.Logger.getLogger(AlumnoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlumnoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlumnoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlumnoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            private Alumno alumno;
            public void run() {
                new AlumnoFrame(this.alumno).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarmeCurso;
    private javax.swing.JButton bSalir;
    private javax.swing.JComboBox<Curso> cbCursosDisponibles;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lSubtituloSancionar;
    private javax.swing.JLabel lSubtituloSancionar1;
    private javax.swing.JLabel lSubtituloSancionar2;
    private javax.swing.JTextArea taCursosAprobados;
    private javax.swing.JTextArea taCursosInscriptos;
    private javax.swing.JTextArea taNoticias;
    // End of variables declaration//GEN-END:variables

    private String obtenerListaCursos(ArrayList<Curso> cur){
        String listC = "";

        for(Curso c : cur){
            listC += c.toString() + "\n";
        }

        return listC;
    } 
}
