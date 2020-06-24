package CRUDPedido;

import AppServices.ClienteAppService;
import AppServices.FuncionarioAppService;
import AppServices.ItemPedidoAppService;
import AppServices.PedidoAppService;
import Classes.ItemPedido;
import Classes.StatusPedidoEnum;
import Classes.Cliente;
import Classes.Funcionario;
import Classes.Pedido;
import ProjecaoMista.ProjecaoPedido;
import ViewsCompartilhadas.SelecioneUmItem;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InserirEditarPedido extends javax.swing.JFrame {

    ProjecaoPedido pedido;
    ArrayList<ItemPedido> itensPedidos;
    long id;
    Cliente cliente;
    long idFuncionario;
    String nomeFuncionario;
    StatusPedidoEnum status;

    public InserirEditarPedido() throws IOException {
        initComponents();
        DataComboStatus();
        DataComboCliente();
        DataComboFuncionario();
        this.id = -1;
    }

    public InserirEditarPedido(ProjecaoPedido pedido) throws IOException {
        initComponents();
        DataComboStatus();
        DataComboCliente();
        DataComboFuncionario();
        ProjectPedido(pedido);
    }

    public InserirEditarPedido(ArrayList<ItemPedido> itensPedidos, ProjecaoPedido pedido) throws IOException {
        initComponents();
        DataComboStatus();
        DataComboCliente();
        DataComboFuncionario();
        this.itensPedidos = itensPedidos;
        ProjectPedido(pedido);
    }

    public void DataComboStatus() {
        for (StatusPedidoEnum s : StatusPedidoEnum.values()) {
            this.comboStatus.addItem(s);
        }
    }

    public void DataComboCliente() throws IOException {
        ClienteAppService app = new ClienteAppService();
        ArrayList<Cliente> clientes = app.GetAll();
        for (Cliente c : clientes) {
            this.comboCliente.addItem(c);
        }
    }

    public void DataComboFuncionario() throws IOException {
        FuncionarioAppService app = new FuncionarioAppService();
        ArrayList<Funcionario> funcionarios = app.GetAll();
        for (Funcionario f : funcionarios) {
            this.comboFuncionario.addItem(f);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboFuncionario = new javax.swing.JComboBox<>();
        AddItens = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        Salvar = new javax.swing.JButton();
        Valor = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        Data = new javax.swing.JLabel();
        data = new javax.swing.JTextField();
        statusLabel = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Funcionario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Cadastro de pedidos");

        comboCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cliente(evt);
            }
        });

        comboFuncionario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Funcionario(evt);
            }
        });

        AddItens.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddItens.setText("Adicionar itens");
        AddItens.setActionCommand("AddItens");
        AddItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItens(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Itens:");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar(evt);
            }
        });

        Salvar.setText("Salvar");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salvar(evt);
            }
        });

        Valor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Valor.setText("Valor do pedido:");

        Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Data.setText("Data do pedido:");

        statusLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusLabel.setText("Status do pedido:");

        comboStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboStatus.setAutoscrolls(true);
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Status(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Salvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cancelar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Data)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(data))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel7)
                                        .addComponent(Valor))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboFuncionario, 0, 229, Short.MAX_VALUE)
                                            .addComponent(AddItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(valor)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(statusLabel)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Valor)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Data)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddItens)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Salvar))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        comboStatus.getAccessibleContext().setAccessibleName("");
        comboStatus.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar
        try {
            MainPedido main;
            main = new MainPedido();
            main.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(InserirEditarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Cancelar

    private void Salvar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salvar
        try {
            PedidoAppService pa = new PedidoAppService();
            if(this.itensPedidos == null){
                SelecioneUmItem i = new SelecioneUmItem();
                i.setVisible(true);
                return;
            }
            pa.AddPedido(this.GetPedido(), this.itensPedidos);
            MainPedido main;
            main = new MainPedido();
            main.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(InserirEditarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Salvar

    private void AddItens(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItens
        try {
            AddItensPedido add;
            add = new AddItensPedido(this.GetProjecaoPedido());
            add.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(InserirEditarPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AddItens

    private void Cliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cliente
        Cliente c = (Cliente) this.comboCliente.getSelectedItem();
        this.cliente = c;
    }//GEN-LAST:event_Cliente

    private void Funcionario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Funcionario
        Funcionario f = (Funcionario) this.comboFuncionario.getSelectedItem();
        this.idFuncionario = f.getId();
        this.nomeFuncionario = f.getNome();
    }//GEN-LAST:event_Funcionario

    private void Status(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Status
        StatusPedidoEnum s = (StatusPedidoEnum) this.comboStatus.getSelectedItem();
        this.status = s;
    }//GEN-LAST:event_Status

    private void ProjectPedido(ProjecaoPedido p) throws IOException {
        this.pedido = p;
        Cliente c = ClienteAppService.GetOne(p.idCliente); 
        this.id = p.id;
        this.valor.setText("" + p.valorPedido);
        this.data.setText(p.dataPedido == null ? "" : p.dataPedido.toString());
        this.comboStatus.setSelectedItem(p.statusPedido);
        this.comboCliente.setSelectedItem(c);
        this.comboStatus.setSelectedItem(p.idFuncionario);
    }

    private Pedido GetPedido() {
        double v = Double.parseDouble(this.valor.getText());
        LocalDate date = PedidoAppService.ConverteData(this.data.getText());
        Pedido p = new Pedido(this.id, v, date, this.status, this.cliente.getId(), this.idFuncionario);
        return p;
    }

    private ProjecaoPedido GetProjecaoPedido() {
        String valorS = this.valor.getText().equals("") ? "0" : this.valor.getText();
        String dataS = this.data.getText().equals("") ? null : this.data.getText();

        double v = Double.parseDouble(valorS);
        LocalDate date = PedidoAppService.ConverteData(dataS);
        ProjecaoPedido p = new ProjecaoPedido(this.id, v, date, this.status, this.nomeFuncionario, this.cliente.getNome(),  this.cliente.getId(), this.idFuncionario);
        return p;
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
            java.util.logging.Logger.getLogger(InserirEditarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirEditarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirEditarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirEditarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InserirEditarPedido().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InserirEditarPedido.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItens;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Data;
    private javax.swing.JButton Salvar;
    private javax.swing.JLabel Valor;
    private javax.swing.JComboBox<Cliente> comboCliente;
    private javax.swing.JComboBox<Funcionario> comboFuncionario;
    private javax.swing.JComboBox<StatusPedidoEnum> comboStatus;
    private javax.swing.JTextField data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
