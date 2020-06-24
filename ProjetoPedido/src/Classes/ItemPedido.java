package Classes;

public class ItemPedido {

    //Atributos da classe ItemPedido
    private long id;
    private double valorItem;
    private int quantidade;
    private String nomeItem;
    private long idPedido;
    private long idItem;
    private Pedido pedido;
    private Item item;

    public ItemPedido(long id, double valorItem, int quantidade, String nomeItem, long idPedido, long idItem) {
        this.id = id;
        this.valorItem = valorItem;
        this.quantidade = quantidade;
        this.nomeItem = nomeItem;
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

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
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

    

    @Override
    public String toString() {
        return this.id + ", "
                + this.valorItem + ", "
                + this.quantidade + ", "
                + this.idPedido + ", "
                + this.idItem;
    }
}
