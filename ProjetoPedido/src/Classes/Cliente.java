package Classes;

import java.util.Date;

public class Cliente extends PessoaAbstrac {

    //Atribotos da Class Cliente
    private String endereco;

    public Cliente(long id, String nome, String cpf, String telefone, Date daraNasc, String endereco) {
        super(id, nome, cpf, telefone, daraNasc);
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
}
