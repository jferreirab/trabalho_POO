/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemaEstacionamento.view;

/**
 *
 * @author jferr
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        cadastroMenu = new javax.swing.JMenu();
        clienteMenuItem = new javax.swing.JMenuItem();
        corVeiculoMenuItem = new javax.swing.JMenuItem();
        marcaVeiculoMenuItem = new javax.swing.JMenuItem();
        modeloVeiculoMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        atividadesMenu = new javax.swing.JMenu();
        entradaSaidaMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Estacionamento");
        setLocationByPlatform(true);

        cadastroMenu.setMnemonic('f');
        cadastroMenu.setText("Cadastros");

        clienteMenuItem.setMnemonic('o');
        clienteMenuItem.setText("Cliente");
        clienteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(clienteMenuItem);

        corVeiculoMenuItem.setMnemonic('a');
        corVeiculoMenuItem.setText("Cor Veiculo");
        corVeiculoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                corVeiculoMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(corVeiculoMenuItem);

        marcaVeiculoMenuItem.setMnemonic('x');
        marcaVeiculoMenuItem.setText("Marca Veiculo");
        marcaVeiculoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcaVeiculoMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(marcaVeiculoMenuItem);

        modeloVeiculoMenuItem.setText("Modelo Veiculo");
        modeloVeiculoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modeloVeiculoMenuItemActionPerformed(evt);
            }
        });
        cadastroMenu.add(modeloVeiculoMenuItem);

        jMenuItem1.setText("Tabela de Preços");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        cadastroMenu.add(jMenuItem1);

        menuBar.add(cadastroMenu);

        atividadesMenu.setMnemonic('e');
        atividadesMenu.setText("Atividades");
        atividadesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atividadesMenuActionPerformed(evt);
            }
        });

        entradaSaidaMenuItem.setMnemonic('t');
        entradaSaidaMenuItem.setText("Registra Entrada e Saida");
        entradaSaidaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaSaidaMenuItemActionPerformed(evt);
            }
        });
        atividadesMenu.add(entradaSaidaMenuItem);

        menuBar.add(atividadesMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marcaVeiculoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcaVeiculoMenuItemActionPerformed
        MarcaVeiculoView marcaVeiculoView = new MarcaVeiculoView();
        this.desktopPane.add(marcaVeiculoView);
        marcaVeiculoView.setVisible(true);
    }//GEN-LAST:event_marcaVeiculoMenuItemActionPerformed

    private void clienteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteMenuItemActionPerformed
        ClienteView clienteView = new ClienteView();
        this.desktopPane.add(clienteView);
        clienteView.setVisible(true);
    }//GEN-LAST:event_clienteMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
         MovimentacaoView registraEntradaSaidaView = new MovimentacaoView();
        this.desktopPane.add(registraEntradaSaidaView);
        registraEntradaSaidaView.setVisible(true);
                
    }                                                   

    private void corVeiculoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_corVeiculoMenuItemActionPerformed
       CorVeiculoView corVeiculoView = new  CorVeiculoView();
       this.desktopPane.add(corVeiculoView);
       corVeiculoView.setVisible(true);
    }//GEN-LAST:event_corVeiculoMenuItemActionPerformed

    private void modeloVeiculoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modeloVeiculoMenuItemActionPerformed
        ModeloVeiculoView modeloVeiculoView = new ModeloVeiculoView();
        this.desktopPane.add(modeloVeiculoView);
        modeloVeiculoView.setVisible(true);
    }//GEN-LAST:event_modeloVeiculoMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TabelaPrecoView tabelaPrecoView = new TabelaPrecoView();
        this.desktopPane.add(tabelaPrecoView);
        tabelaPrecoView.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void atividadesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atividadesMenuActionPerformed

    }//GEN-LAST:event_atividadesMenuActionPerformed

    private void entradaSaidaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaSaidaMenuItemActionPerformed
        MovimentacaoView registraEntradaSaidaView = new MovimentacaoView();
        this.desktopPane.add(registraEntradaSaidaView);
        registraEntradaSaidaView.setVisible(true);
    }//GEN-LAST:event_entradaSaidaMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu atividadesMenu;
    private javax.swing.JMenu cadastroMenu;
    private javax.swing.JMenuItem clienteMenuItem;
    private javax.swing.JMenuItem corVeiculoMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem entradaSaidaMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem marcaVeiculoMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem modeloVeiculoMenuItem;
    // End of variables declaration//GEN-END:variables

}
