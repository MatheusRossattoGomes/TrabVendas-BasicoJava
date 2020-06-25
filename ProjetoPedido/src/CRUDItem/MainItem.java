package CRUDItem;

import AppServices.ItemAppService;
import Classes.Item;
import ViewsCompartilhadas.Menu;
import ViewsCompartilhadas.SelecioneUmItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class MainItem extends javax.swing.JFrame {

    ArrayList<Item> itens;
    DefaultTableModel model;

    public MainItem() throws IOException {
        initComponents();
        this.itens = this.GetGrid();
        this.Grid();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Inserir = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Deletar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        X = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Inserir.setText("Inserir");
        Inserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Inserir(evt);
            }
        });

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar(evt);
            }
        });

        Deletar.setText("Deletar");
        Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Deletar(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Itens");

        X.setText("X");
        X.addActionListener(new java.awt.event.ActionListener() {
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
        grid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(grid);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(X))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Inserir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Editar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Deletar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inserir)
                    .addComponent(Editar)
                    .addComponent(Deletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Inserir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inserir
        try {
            InserirEditar inserir = new InserirEditar();
            inserir.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MainItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Inserir

    private void Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar
        try {
            Item ia = this.GetItem();
            if (ia != null) {
                InserirEditar inserir = new InserirEditar(ia);
                inserir.setVisible(true);
                this.setVisible(false);
            } else {
                SelecioneUmItem i = new SelecioneUmItem();
                i.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Editar

    private void Deletar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Deletar
        try {
            Item i = this.GetItem();
            ItemAppService.Delete(i);
            MainItem main = new MainItem();
            main.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MainItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Deletar

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Sair

    private Item GetItem() {
        int i = this.grid.getSelectedRow();
        long id = Long.parseLong(this.grid.getModel().getValueAt(i, 0).toString());
        String nome = this.grid.getModel().getValueAt(i, 1).toString();
        int qte = Integer.parseInt(this.grid.getModel().getValueAt(i, 2).toString());
        double v = Double.parseDouble(this.grid.getModel().getValueAt(i, 3).toString());
        return new Item(id, nome, qte - 1, v);
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
            java.util.logging.Logger.getLogger(MainItem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainItem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainItem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainItem.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainItem().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(MainItem.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Deletar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Inserir;
    private javax.swing.JButton X;
    private javax.swing.JTable grid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
