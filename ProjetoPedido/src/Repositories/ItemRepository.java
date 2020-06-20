package Repositories;

import Classes.Item;
import Classes.Item;
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

public class ItemRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public ItemRepository() throws IOException {
        new FileOutputStream("Arqs\\ItemRepository.txt", true).close();
        this.file = new File("Arqs\\ItemRepository.txt");
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
    
    public void AddOne(Item i) throws IOException {
        i.setId(this.GetProxId());
        this.buferedWriter.append(i.toString());
        this.buferedWriter.newLine();
    }

    public void SaveAll(ArrayList<Item> itens) throws IOException {
        this.Clear();
        for (Item i : itens) {
            this.buferedWriter.write(i.toString());
            this.buferedWriter.newLine();
        }
    }
    
    private void Clear() throws FileNotFoundException, IOException{
        new FileOutputStream("Arqs\\ItemRepository.txt", false).close();
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
