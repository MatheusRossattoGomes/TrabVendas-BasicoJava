package Repositories;

import Classes.ItemPedido;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
        this.file = new File("ItemPedidoRepository.txt");
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

    public void SaveAll(ArrayList<ItemPedido> itensPedidos) throws IOException {
        for (ItemPedido ip : itensPedidos) {
            this.buferedWriter.write(ip.toString());
            this.buferedWriter.newLine();
        }
    }

    public ItemPedido StringToItemPedido(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        ItemPedido ip = new ItemPedido(id, Double.parseDouble(ls[1]), Integer.parseInt(ls[2]), Long.parseLong(ls[3]), Long.parseLong(ls[4]));
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
