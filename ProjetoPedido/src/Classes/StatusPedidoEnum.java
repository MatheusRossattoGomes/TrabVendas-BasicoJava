package Classes;

public enum StatusPedidoEnum {

    cancelado(-1),
    aceito(-2),
    entregue(-3),
    aCaminho(-4),
    preparando(-5);

    public int status;

    StatusPedidoEnum(int valor) {
        status = valor;
    }

    public int getIntStatus() {
        return status;
    }

    public static StatusPedidoEnum fromInteger(int x) {
        switch (x) {
            case -1:
                return cancelado;
            case -2:
                return aceito;
            case -3:
                return entregue;
            case -4:
                return aCaminho;
            case -5:
                return preparando;
        }
        return null;
    }

    @Override
    public String toString() {
        switch (status) {
            case -1:
                return "Cancelado";
            case -2:
                return "Aceito";
            case -3:
                return "Entregue";
            case -4:
                return "A caminho";
            case -5:
                return "Preparando";
        }
        return "";
    }
}

