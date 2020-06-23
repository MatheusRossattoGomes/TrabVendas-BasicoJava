package AppServices;

import Classes.Cliente;
import Classes.Funcionario;
import Classes.ItemPedido;
import Classes.Pedido;
import ProjecaoMista.ProjecaoPedido;
import Repositories.ClienteRepository;
import Repositories.FuncionarioRepository;
import Repositories.ItemPedidoRepository;
import Repositories.PedidoRepository;
import java.io.IOException;
import java.util.ArrayList;

public class PedidoAppService extends AppService {

    public PedidoAppService() {
    }

    public static ArrayList<ProjecaoPedido> GetGrid() throws IOException {
        PedidoRepository pr = new PedidoRepository();
        ClienteRepository cr = new ClienteRepository();
        FuncionarioRepository fr = new FuncionarioRepository();

        ArrayList<Pedido> pedidos = pr.GetAll();
        ArrayList<ProjecaoPedido> projecao = new ArrayList<ProjecaoPedido>();        

        for (Pedido p : pedidos) {
        Cliente c = cr.GetOne(p.getIdCliente());
        Funcionario f = fr.GetOne(p.getIdFuncionario());
        ProjecaoPedido pp = new ProjecaoPedido(p.getId(), p.getValorPedido(), p.getDataPedido(), p.getStatusPedido(), c.getNome(), f.getNome(), p.getIdCliente(), p.getIdFuncionario());
        projecao.add(pp);
        }      

        pr.Close();
        cr.Close();
        fr.Close();
        
        return projecao;
    }
}
