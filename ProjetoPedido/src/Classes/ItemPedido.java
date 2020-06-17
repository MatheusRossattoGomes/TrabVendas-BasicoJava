package Classes;

public class ItemPedido {

    //Atributos da classe ItemPedido
    private long id;
    private double valorItem;
    private int quantidade;
    private long idPedido;
    private long idItem;
    private Pedido pedido;
    private Item item;

    public ItemPedido(long id, double valorItem, int quantidade, long idPedido, long idItem) {
        this.id = id;
        this.valorItem = valorItem;
        this.quantidade = quantidade;
        this.idPedido = idPedido;
        this.idItem = idItem;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }
}
