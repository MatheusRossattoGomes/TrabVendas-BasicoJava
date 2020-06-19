package Classes;

import java.time.LocalDate;

public class Cliente extends PessoaAbstrac {

    //Atribotos da Class Cliente
    private String endereco;

    public Cliente(long id, String nome, String cpf, String telefone, LocalDate dataNasc, String endereco) {
        super(id, nome, cpf, telefone, dataNasc);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", " + this.endereco;
    }
    
    public String toStringGrid(){
        return super.toStringGrid() + "  |  " + this.endereco;
    }
}
