package Classes;

import java.time.LocalDate;

public class Funcionario extends PessoaAbstrac {

    //Atributos da classe Funcionario
    private double Salario;

    public Funcionario(long id, String nome, String cpf, String telefone, LocalDate dataNasc, double Salario) {
        super(id, nome, cpf, telefone, dataNasc);
        this.Salario = Salario;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
    
    public String toStringBanco(){
        return super.toString() + ", " + this.Salario;
    }
    
    public String toStringGrid(){
        return super.toStringGrid() + "  |  " + this.Salario;
    }
}
