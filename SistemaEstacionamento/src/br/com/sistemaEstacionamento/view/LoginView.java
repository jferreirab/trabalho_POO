package br.com.sistemaEstacionamento.view;

import javax.swing.JOptionPane;
import br.com.sistemaEstacionamento.control.UsuarioControl;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginView extends javax.swing.JFrame {

    private UsuarioControl usuarioControl;

    public LoginView() throws NoSuchAlgorithmException {
        try {
            usuarioControl = new UsuarioControl();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        
    }
    
     public UsuarioControl getUsuarioControl() {
        return usuarioControl;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JToggleButton();
        lblImagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Estacionamento");
        setPreferredSize(new java.awt.Dimension(500, 350));
        setResizable(false);
        getContentPane().setLayout(null);

        lblLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("Login:");
        getContentPane().add(lblLogin);
        lblLogin.setBounds(140, 220, 60, 22);

        lblSenha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(130, 260, 70, 22);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${usuarioControl.usuario.login}"), txtlogin, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });
        getContentPane().add(txtlogin);
        txtlogin.setBounds(200, 220, 110, 30);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${usuarioControl.usuario.senha}"), txtSenha, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        getContentPane().add(txtSenha);
        txtSenha.setBounds(200, 260, 110, 30);

        btnOk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk);
        btnOk.setBounds(320, 230, 59, 50);

        lblImagemFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaEstacionamento/view/bakcground.jpg"))); // NOI18N
        lblImagemFundo.setMaximumSize(null);
        lblImagemFundo.setMinimumSize(null);
        getContentPane().add(lblImagemFundo);
        lblImagemFundo.setBounds(0, 0, 500, 304);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtloginActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            if (usuarioControl.realizarLogin()){
                MenuView menuView = new MenuView();
                menuView.setVisible(true);
                dispose();
            }
            else
            {
                txtSenha.setText("");
                JOptionPane.showMessageDialog(this, true, "Usuário ou senha inválido(s)!", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOkActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginView().setVisible(true);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnOk;
    private javax.swing.JLabel lblImagemFundo;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtlogin;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
