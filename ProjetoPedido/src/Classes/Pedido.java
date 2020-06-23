package Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    //Atributos da classe Pedido;
    private long id;
    private double valorPedido;
    private LocalDate dataPedido;
    private StatusPedidoEnum statusPedido;
    private long idCliente;
    private long idFuncionario;
    private ArrayList<ItemPedido> itensPedidos;

    public Pedido(long id, double valorPedido, LocalDate dataPedido, StatusPedidoEnum statusPedido, long idCliente, long idFuncionario) {
        this.id = id;
        this.valorPedido = valorPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValorPedido() {
        return valorPedido;
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedidoEnum getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedidoEnum statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        this.itensPedidos.add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        this.itensPedidos.remove(itemPedido);
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public String toString() {
        return this.id + ", "
                + this.valorPedido + ", "
                + this.dataPedido + ", "
                + this.statusPedido.getIntStatus() + ", "
                + this.idCliente + ", "
                + this.idFuncionario;
    }
}
