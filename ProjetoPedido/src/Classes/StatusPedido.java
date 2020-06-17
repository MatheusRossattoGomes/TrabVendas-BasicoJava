package Classes;

public enum StatusPedido {

    cancelado(-1),
    aceito(-2),
    entregue(-3),
    aCaminho(-4),
    preparando(-5);

    public int status;

    StatusPedido(int valor) {
        status = valor;
    }
    
    public int getIntStatus() {
        return status;
    }
}
