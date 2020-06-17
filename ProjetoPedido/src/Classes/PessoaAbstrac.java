package Classes;

import java.util.ArrayList;
import java.util.Date;

public abstract class PessoaAbstrac {

    protected long id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected Date daraNasc;
    protected ArrayList<Pedido> pedidos;

    public PessoaAbstrac(long id, String nome, String cpf, String telefone, Date daraNasc) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.daraNasc = daraNasc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDaraNasc() {
        return daraNasc;
    }

    public void setDaraNasc(Date daraNasc) {
        this.daraNasc = daraNasc;
    }

    public void addPedido(Pedido pedido) {

    }

    public void removerPedido(Pedido pedido) {

    }

}
