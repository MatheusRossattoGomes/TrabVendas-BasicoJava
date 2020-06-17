package Classes;

import java.util.ArrayList;

public class Item {

    //Atributos da classe Item
    private long id;
    private String nome;
    private int quantidadeEstoque;
    private double valorAtual;
    private ArrayList<ItemPedido> itensPedidos;

    public Item(long id ,String nome, int quantidadeEstoque, double valorAtual) {
        this.id =id;
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.valorAtual = valorAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public boolean possuiEmEstoque() {
        if (this.quantidadeEstoque > 0) {
            return true;
        }
        return false;
    }

    public boolean possuiEmEstoqueSuficienteParaPedido(int numItens) {
        if (this.quantidadeEstoque - numItens >= 0) {
            return true;
        }
        return false;
    }

    public void addItemPedido(ItemPedido itemPedido) {
        this.itensPedidos.add(itemPedido);
    }

    public void removerItemPedido(ItemPedido itemPedido) {
        this.itensPedidos.remove(itemPedido);
    }

    @Override
    public String toString() {
        return this.nome + ", "
                + this.quantidadeEstoque + ", "
                + this.valorAtual;
    }
}
