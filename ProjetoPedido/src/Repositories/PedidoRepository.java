package Repositories;

import Classes.Pedido;
import Classes.Pedido;
import Classes.StatusPedidoEnum;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class PedidoRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public PedidoRepository() throws IOException {
        new FileOutputStream("Arqs\\PedidoRepository.txt", true).close();
        this.file = new File("Arqs\\PedidoRepository.txt");
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
    public void AddOne(Pedido i) throws IOException {
        i.setId(this.GetProxId());
        this.buferedWriter.append(i.toString());
        this.buferedWriter.newLine();
    }

    public void SaveAll(ArrayList<Pedido> pedidos) throws IOException {
        this.Clear();
        for (Pedido p : pedidos) {
            this.buferedWriter.write(p.toString());
            this.buferedWriter.newLine();
        }
    }
    
    private void Clear() throws FileNotFoundException, IOException{
        new FileOutputStream("Arqs\\PedidoRepository.txt", false).close();
    }

    public long GetProxId() throws IOException {
        String ultimo = "";
        String line = "";
        while (line != null) {
            line = buferedReader.readLine();
            if (line != null) {
                ultimo = line;
            }
        }
        if (ultimo == "") {
            return 0;
        }
        String[] ls = ultimo.split(", ");
        long i = Long.parseLong(ls[0]);

        return i + 1;
    }

    public Pedido StringToPedido(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        long idC = Long.parseLong(ls[4]);
        long idF = Long.parseLong(ls[5]);
        
        String[] ds = ls[2].split("-");
        
        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
        Pedido i = new Pedido(id, Integer.parseInt(ls[1]), date, StatusPedidoEnum.fromInteger(Integer.parseInt(ls[3])), idC, idF);
        return i;
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
