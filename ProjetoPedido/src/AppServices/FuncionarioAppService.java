/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppServices;

import Classes.Funcionario;
import Repositories.FuncionarioRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FuncionarioAppService extends AppService {
    
    //private static ClienteRepository repository;
    public FuncionarioAppService() throws IOException {
        //this.repository = new ClienteRepository();
    }

    public static void AddFuncionario(Funcionario f) throws IOException {
        FuncionarioRepository repository = new FuncionarioRepository();
        if (f.getId() != -1) { 
            ArrayList<Funcionario> funcionarios = repository.GetAll();
            for(Funcionario fl : funcionarios){
                if(fl.getId() == f.getId()){
                    fl.setNome(f.getNome());
                    fl.setCpf(f.getCpf());
                    fl.setTelefone(f.getTelefone());
                    fl.setDataNasc(f.getDataNasc());
                    fl.setSalario(f.getSalario());
                }
            }
            repository.SaveAll(funcionarios);
        } else {            
            //repository.AddOne(f);
        }
            repository.Close();
    }
    
    public static void Delete(Funcionario f) throws IOException{
        FuncionarioRepository repository = new FuncionarioRepository();
        Funcionario remove = f;
            ArrayList<Funcionario> funcionarios = repository.GetAll();
            for(Funcionario fl : funcionarios){
                if(fl.getId() == f.getId()){
                    remove = fl;
                }
            }
            
            funcionarios.remove(remove);
            repository.SaveAll(funcionarios);
        
            repository.Close();
    }

    public static ArrayList<Funcionario> GetGrid() throws IOException {
        ArrayList<Funcionario> fl = new ArrayList<Funcionario>();
        FuncionarioRepository repository = new FuncionarioRepository();
        fl = repository.GetAll();
        repository.Close();
        return fl;
    }

    public static Funcionario StringToFuncionario(String s) throws IOException {
        FuncionarioRepository repository = new FuncionarioRepository();
        Funcionario f = repository.StringToFuncionario(s);
        return f;
    }

    public static Funcionario StringToFuncionarioGrid(String linha) {
        String[] ls = linha.split("  |  ");
        long id = Long.parseLong(ls[0]);

        String[] ds = ls[8].split("-");

        LocalDate date = LocalDate.of(Integer.parseInt(ds[0]), Integer.parseInt(ds[1]), Integer.parseInt(ds[2]));
        Funcionario f = new Funcionario(id, ls[2], ls[4], ls[6], date, ls[10]);
        return f;
    }
}
