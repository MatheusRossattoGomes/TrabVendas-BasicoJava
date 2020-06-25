/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDPedido;

import AppServices.ItemAppService;
import AppServices.ItemPedidoAppService;
import Classes.Item;
import Classes.ItemPedido;
import ProjecaoMista.ProjecaoPedido;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rossa
 */
public class AddItensPedido extends javax.swing.JFrame {

    ProjecaoPedido pedido;
    ArrayList<Item> itens;
    ArrayList<ItemPedido> itensPedidos;
    long id;

    private AddItensPedido() throws IOException {
        initComponents();
        this.itens = this.GetGrid();
        this.Grid();
    }

    public AddItensPedido(ProjecaoPedido p) throws IOException {
        initComponents();
        this.itens = this.GetGrid();
        this.pedido = p;
        this.id = -1;
        this.Grid();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Itens do pedido");

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salvar(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar(evt);
            }
        });

        jButton3.setText("X");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sair(evt);
            }
        });

        grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        grid.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(grid);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cancelar))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvar)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        InserirEditarPedido i;
        try {
            i = new InserirEditarPedido(this.pedido);
            i.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(AddItensPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Sair

    private void Salvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salvar
        InserirEditarPedido i;
        
        try {
            ArrayList<ItemPedido> ips = new ArrayList<ItemPedido>();

            for (Item it : this.GetItens()) {
                ItemPedido ip = new ItemPedido(this.id, it.getValorAtual(), it.getQuantidadeEstoque(), it.getNome(), this.pedido.id, it.getId());
                ips.add(ip);
            }

            i = new InserirEditarPedido(ips, this.pedido);
            i.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(AddItensPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Salvar

    private void Cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar
        InserirEditarPedido i;
        try {
            i = new InserirEditarPedido(this.pedido);
            i.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(AddItensPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Cancelar

    private ArrayList<Item> GetItens(){
        int i[] = grid.getSelectedRows();
        ArrayList<Item> itens = new ArrayList<Item>();
        for(int value : i){
          long id = Long.parseLong(this.grid.getModel().getValueAt(value, 0).toString());
            String nome = this.grid.getModel().getValueAt(value, 1).toString();
            int qte = Integer.parseInt(this.grid.getModel().getValueAt(value, 2).toString());
            double v = Double.parseDouble(this.grid.getModel().getValueAt(value, 3).toString());
            itens.add(new Item(id, nome, qte - 1, v));
        }             

        return itens;
    }
    
    private void Grid() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Quanidade");
        model.addColumn("Valor");

        this.grid.setModel(model);
        for (Item p : this.itens) {
            Object obj[] = {p.getId(), p.getNome(), p.getQuantidadeEstoque(), p.getValorAtual()};
            model.addRow(obj);
        }
    }

    private ArrayList<Item> GetGrid() throws IOException {
        return ItemAppService.GetGrid();
    }

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
            java.util.logging.Logger.getLogger(AddItensPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItensPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItensPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItensPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AddItensPedido().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(AddItensPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Salvar;
    private javax.swing.JTable grid;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
