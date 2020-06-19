package AppServices;

import Classes.Cliente;
import Repositories.ClienteRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ClienteAppService extends AppService {

    //private static ClienteRepository repository;
    public ClienteAppService() throws IOException {
        //this.repository = new ClienteRepository();
    }

    public static void AddCliente(Cliente c) throws IOException {
        ClienteRepository repository = new ClienteRepository();
        if (c.getId() != -1) { 
            ArrayList<Cliente> clientes = repository.GetAll();
            for(Cliente cl : clientes){
                if(cl.getId() == c.getId()){
                    cl.setNome(c.getNome());
                    cl.setCpf(c.getCpf());
                    cl.setTelefone(c.getTelefone());
                    cl.setDataNasc(c.getDataNasc());
                    cl.setEndereco(c.getEndereco());
                }
            }
            repository.SaveAll(clientes);
        } else {            
            repository.AddOne(c);
        }
            repository.Close();
    }
    
    public static void Delete(Cliente c) throws IOException{
        ClienteRepository repository = new ClienteRepository();
        Cliente remove=c;
            ArrayList<Cliente> clientes = repository.GetAll();
            for(Cliente cl : clientes){
                if(cl.getId() == c.getId()){
                    remove = cl;
                }
            }
            
            clientes.remove(remove);
            repository.SaveAll(clientes);
        
            repository.Close();
    }

    public static ArrayList<Cliente> GetGrid() throws IOException {
        ArrayList<Cliente> cl = new ArrayList<Cliente>();
        ClienteRepository repository = new ClienteRepository();
        cl = repository.GetAll();
        repository.Close();
        return cl;
    }

    public static Cliente StringToCliente(String s) throws IOException {
        ClienteRepository repository = new ClienteRepository();
        Cliente c = repository.StringToCliente(s);
        return c;
    }

    public static Cliente StringToClienteGrid(String linha) {
        String[] ls = linha.split("  |  ");
        long id = Long.parseLong(ls[0]);

        String[] ds = ls[8].split("-");

        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
        Cliente c = new Cliente(id, ls[2], ls[4], ls[6], date, ls[10]);
        return c;
    }
}
