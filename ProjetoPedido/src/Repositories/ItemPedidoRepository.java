package Repositories;

import Classes.ItemPedido;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ItemPedidoRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public ItemPedidoRepository() throws IOException {
        new FileOutputStream("Arqs\\ItemPedidoPedidoRepository.txt", true).close();
        this.file = new File("Arqs\\ItemPedidoPedidoRepository.txt");
        this.buferedReader = new BufferedReader(new FileReader(this.file));
        this.buferedWriter = new BufferedWriter(new FileWriter(this.file, true));
    }
    
    public ArrayList<ItemPedido> GetAll() throws IOException {
        ArrayList<ItemPedido> result = new ArrayList<ItemPedido>();
        String linha;
        ItemPedido itemP;
        while ((linha = this.buferedReader.readLine()) != null) {
            itemP = this.StringToItemPedido(linha);
            result.add(itemP);
        }
        return result;
    }

    public void AddOne(ItemPedido i) throws IOException {
        i.setId(this.GetProxId());
        this.buferedWriter.append(i.toString());
        this.buferedWriter.newLine();
    }

    public void SaveAll(ArrayList<ItemPedido> itens) throws IOException {
        this.Clear();
        for (ItemPedido i : itens) {
            this.buferedWriter.write(i.toString());
            this.buferedWriter.newLine();
        }
    }
    
    private void Clear() throws FileNotFoundException, IOException{
        new FileOutputStream("Arqs\\ItemPedidoRepository.txt", false).close();
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

    public ItemPedido StringToItemPedido(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        ItemPedido ip = new ItemPedido(id, Double.parseDouble(ls[1]), Integer.parseInt(ls[2]),ls[3], Long.parseLong(ls[4]), Long.parseLong(ls[5]));
        return ip;
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
