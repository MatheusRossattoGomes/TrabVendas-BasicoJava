package Repositories;

import Classes.Item;
import Classes.Item;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ItemRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public ItemRepository() throws IOException {
        this.file = new File("ItemRepository.txt");
        this.buferedReader = new BufferedReader(new FileReader(this.file));
        this.buferedWriter = new BufferedWriter(new FileWriter(this.file, true));
    }
    
    public ArrayList<Item> GetAll() throws IOException {
        ArrayList<Item> result = new ArrayList<Item>();
        String linha;
        Item i;
        while ((linha = this.buferedReader.readLine()) != null) {
            i = this.StringToItem(linha);
            result.add(i);
        }
        return result;
    }

    public void SaveAll(ArrayList<Item> itens) throws IOException {
        for (Item i : itens) {
            this.buferedWriter.write(i.toString());
            this.buferedWriter.newLine();
        }
    }

    public Item StringToItem(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        Item i = new Item(id, ls[1], Integer.parseInt(ls[2]), Double.parseDouble(ls[3]));
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
