package ProjecaoMista;

import Classes.ItemPedido;
import Classes.StatusPedidoEnum;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProjecaoPedido {

    public long id;
    public double valorPedido;
    public LocalDate dataPedido;
    public StatusPedidoEnum statusPedido;
    public String nomeFuncionario;
    public String nomeCliente;    
    public long idCliente;
    public long idFuncionario;

    public ProjecaoPedido(long id, double valorPedido, LocalDate dataPedido, StatusPedidoEnum statusPedido, String nomeFuncionario, String nomeCliente, long idCliente, long idFuncionario) {
        this.id = id;
        this.valorPedido = valorPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.nomeFuncionario = nomeFuncionario;
        this.nomeCliente = nomeCliente;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
    }     

    public String toStringGrid() {
        return this.id + "  |  "
                + this.idCliente + "  |  "
                + "Cliente: " + this.nomeCliente + "  |  "
                + this.idFuncionario + "  |  "
                + "Funcionário: " + this.nomeFuncionario + "  |  "
                + this.valorPedido + "  |  "
                + this.dataPedido + "  |  "
                + this.statusPedido.getIntStatus();
    }
}
