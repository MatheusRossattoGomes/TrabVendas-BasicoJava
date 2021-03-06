package CRUDPedido;

import AppServices.PedidoAppService;
import Classes.Pedido;
import Classes.StatusPedidoEnum;
import ProjecaoMista.ProjecaoPedido;
import ViewsCompartilhadas.Menu;
import ViewsCompartilhadas.SelecioneUmItem;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class MainPedido extends javax.swing.JFrame {

    ArrayList<ProjecaoPedido> pedidos;
    DefaultTableModel model;

    public MainPedido() throws IOException {
        initComponents();
        this.pedidos = this.GetGrid();
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
        jLabel1.setText("Pedidos");

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Inserir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Editar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Deletar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(X, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inserir)
                    .addComponent(Editar)
                    .addComponent(Deletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Inserir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Inserir
        InserirEditarPedido inserir;
        try {
            inserir = new InserirEditarPedido();
            inserir.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MainPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_Inserir

    private void Editar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar
         try {
            ProjecaoPedido pp = this.GetProjecaoPedido();
            if (pp != null) {
                InserirEditarPedido inserir = new InserirEditarPedido(pp);
                inserir.setVisible(true);
                this.setVisible(false);
            } else {
                SelecioneUmItem i = new SelecioneUmItem();
                i.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Editar

    private void Deletar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Deletar
        try {
            Pedido p = this.GetPedido();
            PedidoAppService.Delete(p);
            MainPedido main = new MainPedido();
            main.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MainPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Deletar

    private void Sair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sair
        Menu m = new Menu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Sair

    private Pedido GetPedido(){
        int i = this.grid.getSelectedRow();
        long id = Long.parseLong(this.grid.getModel().getValueAt(i, 0).toString());
        double valorPedido = Double.parseDouble(this.grid.getModel().getValueAt(i, 3).toString());
        LocalDate dataPedido = PedidoAppService.ConverteData(this.grid.getModel().getValueAt(i, 4).toString());
        String status =this.grid.getModel().getValueAt(i, 5).toString();
        StatusPedidoEnum statusPedido = StatusPedidoEnum.fromInteger(StatusPedidoEnum.StringInt(status));
        long idCliente = Long.parseLong(this.grid.getModel().getValueAt(i, 6).toString());
        long idFuncionario = Long.parseLong(this.grid.getModel().getValueAt(i, 7).toString());
        
        
        return new Pedido(id, valorPedido, dataPedido, statusPedido, idCliente, idFuncionario);
    }
    
    private ProjecaoPedido GetProjecaoPedido() {
        int i = this.grid.getSelectedRow();
        long id = Long.parseLong(this.grid.getModel().getValueAt(i, 0).toString());
        String nomeCliente = this.grid.getModel().getValueAt(i, 1).toString();
        String nomeFuncionario = this.grid.getModel().getValueAt(i, 2).toString();
        double valorPedido = Double.parseDouble(this.grid.getModel().getValueAt(i, 3).toString());
        LocalDate dataPedido = PedidoAppService.ConverteData(this.grid.getModel().getValueAt(i, 4).toString());
        String status =this.grid.getModel().getValueAt(i, 5).toString();
        StatusPedidoEnum statusPedido = StatusPedidoEnum.fromInteger(StatusPedidoEnum.StringInt(status));
        long idCliente = Long.parseLong(this.grid.getModel().getValueAt(i, 6).toString());
        long idFuncionario = Long.parseLong(this.grid.getModel().getValueAt(i, 7).toString());
        
        
        return new ProjecaoPedido(id, valorPedido, dataPedido, statusPedido, nomeFuncionario, nomeCliente, idCliente, idFuncionario);
    }

    private void Grid() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Cliente");
        model.addColumn("Fucnionário");
        model.addColumn("Valor");
        model.addColumn("Data do pedido");
        model.addColumn("Status do pedido");
        model.addColumn("IdCliente");
        model.addColumn("IdFuncionario");

        this.grid.setModel(model);
        for (ProjecaoPedido p : this.pedidos) {
            Object obj[] = {p.id, p.nomeCliente, p.nomeFuncionario, p.valorPedido, p.dataPedido, p.statusPedido.toString(), p.idCliente, p.idFuncionario};
            model.addRow(obj);
        }
    }

    private ArrayList<ProjecaoPedido> GetGrid() throws IOException {
        return PedidoAppService.GetGrid();
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
            java.util.logging.Logger.getLogger(MainPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainPedido().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainPedido.class.getName()).log(Level.SEVERE, null, ex);
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
