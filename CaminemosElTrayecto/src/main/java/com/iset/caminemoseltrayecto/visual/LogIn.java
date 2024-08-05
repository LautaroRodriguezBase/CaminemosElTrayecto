package com.iset.caminemoseltrayecto.visual;

import com.iset.caminemoseltrayecto.CaminemosElTrayecto;
import com.iset.caminemoseltrayecto.modelos.UsuarioNoExisteException;
import java.awt.Color;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * @author lucas
 * @author lrbase
 */
public class LogIn extends javax.swing.JFrame implements ActionListener, KeyListener{

    public LogIn(){
        setTitle("Bienvenido");
        initComponents();
        this.setLocationRelativeTo(null);

        btnIngresar.addActionListener(this);
        tfUserPass.addKeyListener(this);
        
        Border borderWhite = BorderFactory.createLineBorder(Color.decode("#ffffff"));
        tfUserName.setBorder(borderWhite);
        tfUserPass.setBorder(borderWhite);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lUsuario = new javax.swing.JLabel();
        lContrasena = new javax.swing.JLabel();
        tfUserName = new javax.swing.JTextField();
        tfUserPass = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        lMsjDeIngreso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lUsuario.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        lUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lUsuario.setText("Usuario");

        lContrasena.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        lContrasena.setForeground(new java.awt.Color(0, 0, 0));
        lContrasena.setText("Contraseña");

        tfUserName.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        tfUserName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUserName.setToolTipText("Ingrese su usuario");

        tfUserPass.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        tfUserPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUserPass.setToolTipText("Ingrese su contraseña");

        btnIngresar.setLabel("Ingresar");

        lMsjDeIngreso.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lMsjDeIngreso.setForeground(new java.awt.Color(0, 0, 0));
        lMsjDeIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(btnIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(lUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(lContrasena)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMsjDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(lUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUserPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addGap(18, 18, 18)
                .addComponent(lMsjDeIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lContrasena;
    private javax.swing.JLabel lMsjDeIngreso;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JTextField tfUserName;
    private javax.swing.JTextField tfUserPass;
    // End of variables declaration//GEN-END:variables
    
    void ingresar() throws IOException, ClassNotFoundException{
        Border borderRed = BorderFactory.createLineBorder(Color.decode("#ff0000"));
        String tfU = tfUserName.getText();
        String tfP = tfUserPass.getText();
        
        // teoricamente todo esto deberia estar en un TRY CATCH
        if(!(tfU.equals("")) && !(tfP.equals(""))){
            try{
                if(CaminemosElTrayecto.ingresar(tfU, tfP)){
                    this.setVisible(false);
                }
            }catch(UsuarioNoExisteException userNotFound){
                lMsjDeIngreso.setText(userNotFound.toString());
                tfUserName.requestFocusInWindow();
                tfUserName.setBorder(borderRed);
                tfUserPass.setBorder(borderRed);
            }
        }else{
            lMsjDeIngreso.setText("No puedes tener campos vacios.");
            tfUserName.requestFocusInWindow();
            tfUserName.setBorder(borderRed);
            tfUserPass.setBorder(borderRed);
        }
    }
    
    // Acciones de botones
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnIngresar){
            try {
                ingresar();
            } catch (IOException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Acciones de teclas
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                Border borderGrey = BorderFactory.createLineBorder(Color.decode("#444444"));
                tfUserName.setBorder(borderGrey);
                tfUserPass.setBorder(borderGrey);
                break;
            case KeyEvent.VK_ENTER:
            {
                try {
                    ingresar();
                } catch (IOException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }

}