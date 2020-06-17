package Repositories;

import Classes.Pedido;
import Classes.Pedido;
import Classes.StatusPedido;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PedidoRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public PedidoRepository() throws IOException {
        this.file = new File("PedidoRepository.txt");
        this.buferedReader = new BufferedReader(new FileReader(this.file));
        this.buferedWriter = new BufferedWriter(new FileWriter(this.file, true));
    }
    
    public ArrayList<Pedido> GetAll() throws IOException {
        ArrayList<Pedido> result = new ArrayList<Pedido>();
        String linha;
        Pedido p;
        while ((linha = this.buferedReader.readLine()) != null) {
            p = this.StringToPedido(linha);
            result.add(p);
        }
        return result;
    }

    public void SaveAll(ArrayList<Pedido> pedidos) throws IOException {
        for (Pedido p : pedidos) {
            this.buferedWriter.write(p.toString());
            this.buferedWriter.newLine();
        }
    }

    public Pedido StringToPedido(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        Date date = new Date(ls[2]);        
        Pedido p = new Pedido(id, Double.parseDouble(ls[1]), date, StatusPedido.valueOf(ls[3]));
        return p;
    }

    public BufferedReader getBuferedReader() {
        return buferedReader;
    }

    public BufferedWriter getBuferedWriter() {
        return buferedWriter;
    }

    public void Close() throws IOException {
        this.buferedReader.close();
        this.buferedWriter.close();
    }
}
