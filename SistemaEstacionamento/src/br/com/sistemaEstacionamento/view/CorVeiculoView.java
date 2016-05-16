package br.com.sistemaEstacionamento.view;

import br.com.sistemaEstacionamento.control.CorVeiculoControl;
import br.com.sistemaEstacionamento.util.ValidacaoCampoException;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class CorVeiculoView extends javax.swing.JInternalFrame {

    private final CorVeiculoControl corVeiculoControl;
    
    public CorVeiculoView() {
        corVeiculoControl = new CorVeiculoControl();
        initComponents();
    }

    public CorVeiculoControl getCorVeiculoControl() {
        return corVeiculoControl;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        pnlBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        pnlCampos = new javax.swing.JPanel();
        lbnCodigo = new javax.swing.JLabel();
        lbnCor = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        pnlTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDados = new javax.swing.JTable();

        setClosable(true);
        setTitle("Cadastro - Cores Veículos");

        pnlBotoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaEstacionamento/view/iconeNovo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaEstacionamento/view/iconeSalvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaEstacionamento/view/iconeExcluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistemaEstacionamento/view/iconePesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCampos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnCodigo.setText("Código:");

        lbnCor.setText("Cor Veículo:");
        lbnCor.setPreferredSize(null);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${corVeiculoControl.corVeiculo.codigo}"), txtCodigo, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${corVeiculoControl.corVeiculo.cor}"), txtCor, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbnCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTabela.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${corVeiculoControl.corVeiculosTabela}");
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, eLProperty, tblDados);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigo}"));
        columnBinding.setColumnName("Codigo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cor}"));
        columnBinding.setColumnName("Cor");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${corVeiculoControl.corVeiculoSelecionado}"), tblDados, org.jdesktop.beansbinding.BeanProperty.create("selectedElement"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(tblDados);

        javax.swing.GroupLayout pnlTabelaLayout = new javax.swing.GroupLayout(pnlTabela);
        pnlTabela.setLayout(pnlTabelaLayout);
        pnlTabelaLayout.setHorizontalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pnlTabelaLayout.setVerticalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTabelaLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        corVeiculoControl.novo();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            corVeiculoControl.salvar();
            JOptionPane.showMessageDialog(this,"Cor Veiculo salvo com Sucesso:",
                        "Informação",JOptionPane.INFORMATION_MESSAGE);
        } catch (ValidacaoCampoException | HeadlessException e) {
            JOptionPane.showMessageDialog(this,"Erro no Sistema:"+e.getMessage(),
                    "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        corVeiculoControl.excluir();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       corVeiculoControl.pesquisar();
    }//GEN-LAST:event_btnPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbnCodigo;
    private javax.swing.JLabel lbnCor;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JTable tblDados;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
