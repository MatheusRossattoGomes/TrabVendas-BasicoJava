package Repositories;

import Classes.Cliente;
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
import java.util.Date;

public class ClienteRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public ClienteRepository() throws IOException {
        new FileOutputStream("Arqs\\ClienteRepository.txt", true).close();
        this.file = new File("Arqs\\ClienteRepository.txt");
        this.buferedReader = new BufferedReader(new FileReader(this.file));
        this.buferedWriter = new BufferedWriter(new FileWriter(this.file, true));
    }

    public ArrayList<Cliente> GetAll() throws IOException {
        ArrayList<Cliente> result = new ArrayList<Cliente>();
        String linha;
        Cliente cliente;
        while ((linha = this.buferedReader.readLine()) != null) {
            cliente = this.StringToCliente(linha);
            result.add(cliente);
        }
        return result;
    }

    public void AddOne(Cliente cliente) throws IOException {
        cliente.setId(this.GetProxId());
        this.buferedWriter.append(cliente.toString());
        this.buferedWriter.newLine();
    }

    public void SaveAll(ArrayList<Cliente> clientes) throws IOException {
        this.Clean();
        for (Cliente c : clientes) {
            this.buferedWriter.write(c.toString());
            this.buferedWriter.newLine();
        }
    }
    
    private void Clean() throws FileNotFoundException, IOException{
        new FileOutputStream("Arqs\\ClienteRepository.txt", false).close();
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

    public Cliente StringToCliente(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);

        String[] ds = ls[4].split("-");

        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
        Cliente c = new Cliente(id, ls[1], ls[2], ls[3], date, ls[5]);
        return c;
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
