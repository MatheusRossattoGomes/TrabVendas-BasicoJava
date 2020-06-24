package AppServices;

import Classes.ItemPedido;
import Repositories.ItemPedidoRepository;
import java.io.IOException;
import java.util.ArrayList;

public class ItemPedidoAppService {

    public static void AddItemPedido(ItemPedido c) throws IOException {
        ItemPedidoRepository repository = new ItemPedidoRepository();
        if (c.getId() != -1) {
            ArrayList<ItemPedido> clientes = repository.GetAll();
            for (ItemPedido ipv : clientes) {
                if (ipv.getId() == c.getId()) {
                    ipv.setIdItem(c.getIdItem());
                    ipv.setIdPedido(c.getIdPedido());
                    ipv.setNomeItem(c.getNomeItem());
                    ipv.setQuantidade(c.getQuantidade());
                    ipv.setValorItem(c.getValorItem());
                }
            }
            repository.SaveAll(clientes);
        } else {
            repository.AddOne(c);
        }
        repository.Close();
    }

    public static void Delete(ItemPedido i) throws IOException {
        ItemPedidoRepository repository = new ItemPedidoRepository();
        ItemPedido remove = i;
        ArrayList<ItemPedido> clientes = repository.GetAll();
        for (ItemPedido it : clientes) {
            if (it.getId() == i.getId()) {
                remove = it;
            }
        }

        clientes.remove(remove);
        repository.SaveAll(clientes);

        repository.Close();
    }

    public static void SaveAll(ArrayList<ItemPedido> itens) throws IOException {
        ItemPedidoRepository repository = new ItemPedidoRepository();
        repository.SaveAll(itens);
        repository.Close();
    }

    public static ArrayList<ItemPedido> GetGrid() throws IOException {
        ArrayList<ItemPedido> i = new ArrayList<ItemPedido>();
        ItemPedidoRepository repository = new ItemPedidoRepository();
        i = repository.GetAll();
        repository.Close();
        return i;
    }

    public static ItemPedido StringToItemPedido(String s) throws IOException {
        ItemPedidoRepository repository = new ItemPedidoRepository();
        ItemPedido i = repository.StringToItemPedido(s);
        return i;
    }

    public static ArrayList<ItemPedido> GetAll() throws IOException {
        ItemPedidoRepository repository = new ItemPedidoRepository();
        ArrayList<ItemPedido> i = repository.GetAll();
        repository.Close();
        return i;
    }

//    public static ItemPedido StringToItemPedidoGrid(String linha) {
//        String[] ls = linha.split("  |  ");
//        long id = Long.parseLong(ls[0]);
//
//        String[] ds = ls[8].split("-");
//
//        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
//        ItemPedido c = new ItemPedido(id, ls[2], ls[4], ls[6], date, ls[10]);
//        return c;
//    }
}
