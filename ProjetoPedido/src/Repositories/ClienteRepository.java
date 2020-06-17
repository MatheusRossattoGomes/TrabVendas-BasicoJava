package Repositories;

import Classes.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ClienteRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public ClienteRepository() throws IOException {
        this.file = new File("ClienteRepository.txt");
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

    public void SaveAll(ArrayList<Cliente> clientes) throws IOException {
        for (Cliente c : clientes) {
            this.buferedWriter.write(c.toString());
            this.buferedWriter.newLine();
        }
    }

    public Cliente StringToCliente(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        Date date = new Date(ls[4]);
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
