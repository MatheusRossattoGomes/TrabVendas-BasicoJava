package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {

    //Atributos da classe Pedido;
    private long id;
    private double valorPedido;
    private Date dataPedido;
    private StatusPedido statusPedido;
    private ArrayList<ItemPedido> itensPedidos;

    public Pedido(long id, double valorPedido, Date dataPedido, StatusPedido statusPedido) {
        this.id = id;
        this.valorPedido = valorPedido;
        this.dataPedido = dataPedido;
        this.statusPedido = statusPedido;
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

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
    
    public void addItemPedido(ItemPedido itemPedido) {
        this.itensPedidos.add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        this.itensPedidos.remove(itemPedido);
    }
}
