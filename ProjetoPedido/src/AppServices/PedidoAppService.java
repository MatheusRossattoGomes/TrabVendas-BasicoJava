package AppServices;

import Classes.Cliente;
import Classes.Pedido;
import Classes.Funcionario;
import Classes.ItemPedido;
import ProjecaoMista.ProjecaoPedido;
import Repositories.ClienteRepository;
import Repositories.PedidoRepository;
import Repositories.FuncionarioRepository;
import java.io.IOException;
import java.util.ArrayList;

public class PedidoAppService extends AppService {

    public PedidoAppService() {
    }

    public static void AddPedido(Pedido p, ArrayList<ItemPedido> itensPedidos) throws IOException {
        PedidoRepository repository = new PedidoRepository();
        ItemPedidoAppService ipa = new ItemPedidoAppService();
        ArrayList<ItemPedido> itens = ItemPedidoAppService.GetAll();

        if (p.getId() != -1) {
            ArrayList<Pedido> pedidos = repository.GetAll();
            for (Pedido pe : pedidos) {
                if (pe.getId() == p.getId()) {
                    pe.setIdCliente(p.getIdCliente());
                    pe.setDataPedido(p.getDataPedido());
                    pe.setIdFuncionario(p.getIdFuncionario());
                    pe.setStatusPedido(p.getStatusPedido());
                    pe.setValorPedido(p.getValorPedido());
                }
            }
            for (ItemPedido i : itensPedidos) {
                for (ItemPedido it : itens) {
                    if (it.getId() == i.getId()) {
                        it.setIdItem(i.getIdItem());
                        it.setIdPedido(i.getIdPedido());
                        it.setQuantidade(i.getQuantidade());
                        it.setValorItem(i.getValorItem());
                    }
                }
            }

            ipa.SaveAll(itens);
            repository.SaveAll(pedidos);
        } else {
            repository.AddOne(p);
            for (ItemPedido i : itensPedidos) {
                ipa.AddItemPedido(i);
            }
        }
        repository.Close();
    }

    public static ArrayList<ProjecaoPedido> GetGrid() throws IOException {
        PedidoRepository pr = new PedidoRepository();

        ArrayList<Pedido> pedidos = pr.GetAll();
        ArrayList<ProjecaoPedido> projecao = new ArrayList<ProjecaoPedido>();

        for (Pedido p : pedidos) {
            ClienteRepository cr = new ClienteRepository();
            FuncionarioRepository fr = new FuncionarioRepository();
            Cliente c = cr.GetOne(p.getIdCliente());
            Funcionario f = fr.GetOne(p.getIdFuncionario());
            ProjecaoPedido pp = new ProjecaoPedido(p.getId(), p.getValorPedido(), p.getDataPedido(), p.getStatusPedido(), c.getNome(), f.getNome(), p.getIdCliente(), p.getIdFuncionario());
            projecao.add(pp);
            cr.Close();
            fr.Close();
        }

        pr.Close();

        return projecao;
    }

    public static void Delete(Pedido i) throws IOException {
        PedidoRepository repository = new PedidoRepository();
        Pedido remove = i;
        ArrayList<Pedido> clientes = repository.GetAll();
        ItemPedidoAppService.DeletePeloPedido(i.getId());
        for (Pedido it : clientes) {
            if (it.getId() == i.getId()) {
                remove = it;
            }
        }

        clientes.remove(remove);
        repository.SaveAll(clientes);

        repository.Close();
    }

    public static Pedido StringToPedido(String s) throws IOException {
        PedidoRepository repository = new PedidoRepository();
        Pedido i = repository.StringToPedido(s);
        return i;
    }

    public static ArrayList<Pedido> GetAll() throws IOException {
        PedidoRepository repository = new PedidoRepository();
        ArrayList<Pedido> i = repository.GetAll();
        repository.Close();
        return i;
    }

//    public static Pedido StringToPedidoGrid(String linha) {
//        String[] ls = linha.split("  |  ");
//        long id = Long.parseLong(ls[0]);
//
//        String[] ds = ls[8].split("-");
//
//        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
//        Pedido c = new Pedido(id, ls[2], ls[4], ls[6], date, ls[10]);
//        return c;
//    }
}
