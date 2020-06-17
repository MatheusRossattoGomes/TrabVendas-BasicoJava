package Classes;

import java.util.Date;

public class Funcionario extends PessoaAbstrac {

    //Atributos da classe Funcionario
    private double Salario;

    public Funcionario(long id, String nome, String cpf, String telefone, Date daraNasc, double Salario) {
        super(id, nome, cpf, telefone, daraNasc);
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
        return super.toString() + ", " + this.Salario;
    }
}
