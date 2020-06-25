/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDCliente;

import AppServices.ClienteAppService;
import Classes.Cliente;
import ViewsCompartilhadas.Menu;
import ViewsCompartilhadas.SelecioneUmItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.List;
import java.lang.reflect.Array;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;

public class MainCliente extends javax.swing.JFrame {

    ArrayList<Cliente> clientes;
    DefaultTableModel model;

    public MainCliente() throws IOException {
        initComponents();
        this.clientes = this.GetGrid();
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
                Delete(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel1.setText("Clientes");

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
                        .addComponent(Inserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deletar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(X))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(X))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inserir)
                    .addComponent(Editar)
                    .addComponent(Deletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Inserir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inserir
        try {
            InserirEditar inserir = new InserirEditar();
            inserir.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Inserir

    private void Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar
        try {
            this.GetCliente();
            Cliente c = (Cliente) this.GetCliente();
            if (c != null) {
                InserirEditar inserir = new InserirEditar(c);
                inserir.setVisible(true);
                this.setVisible(false);
            } else {
                SelecioneUmItem i = new SelecioneUmItem();
                i.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Editar

    private void Delete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete
        try {
            Cliente c = this.GetCliente();
            ClienteAppService.Delete(c);
            MainCliente main = new MainCliente();
            main.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Delete

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Sair

    private void Grid() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Telefone");
        model.addColumn("Data de nascimento");
        model.addColumn("Endereço");

        this.model = model;
        this.grid.setModel(model);
        for (Cliente p : this.clientes) {
            Object obj[] = {p.getId(), p.getNome(), p.getCpf(), p.getTelefone(), p.getDataNasc(), p.getEndereco()};
            model.addRow(obj);
        }
    }

    private ArrayList<Cliente> GetGrid() throws IOException {
        return ClienteAppService.GetGrid();
    }

    private Cliente GetCliente() {
        int i = grid.getSelectedRow();
        long id = Long.parseLong(this.grid.getModel().getValueAt(i, 0).toString());
        String nome = this.grid.getModel().getValueAt(i, 1).toString();
        String cpf = this.grid.getModel().getValueAt(i, 2).toString();
        String telefone = this.grid.getModel().getValueAt(i, 3).toString();
        LocalDate date = ClienteAppService.ConverteData(this.grid.getModel().getValueAt(i, 4).toString());
        String endereco = this.grid.getModel().getValueAt(i, 5).toString();

        return new Cliente(id, nome, cpf, telefone, date, endereco);
    }

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
            java.util.logging.Logger.getLogger(MainCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainCliente().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainCliente.class.getName()).log(Level.SEVERE, null, ex);
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
