package Repositories;

import Classes.Funcionario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FuncionarioRepository {

    private File file;
    private BufferedReader buferedReader;
    private BufferedWriter buferedWriter;

    public FuncionarioRepository() throws IOException {
        this.file = new File("FuncionarioRepository.txt");
        this.buferedReader = new BufferedReader(new FileReader(this.file));
        this.buferedWriter = new BufferedWriter(new FileWriter(this.file, true));
    }

    public ArrayList<Funcionario> GetAll() throws IOException {
        ArrayList<Funcionario> result = new ArrayList<Funcionario>();
        String linha;
        Funcionario funcionario;
        while ((linha = this.buferedReader.readLine()) != null) {
            funcionario = this.StringToFuncionario(linha);
            result.add(funcionario);
        }
        return result;
    }

    public void SaveAll(ArrayList<Funcionario> funcionarios) throws IOException {
        for (Funcionario f : funcionarios) {
            this.buferedWriter.write(f.toString());
            this.buferedWriter.newLine();
        }
    }

    public Funcionario StringToFuncionario(String linha) {
        String[] ls = linha.split(", ");
        long id = Long.parseLong(ls[0]);
        
        String[] ds = ls[4].split("-");
        
        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
        Funcionario c = new Funcionario(id, ls[1], ls[2], ls[3], date, Double.parseDouble(ls[5]));
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
