package Classes;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class PessoaAbstrac {

    protected long id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected LocalDate dataNasc;
    protected ArrayList<Pedido> pedidos;

    public PessoaAbstrac(long id, String nome, String cpf, String telefone, LocalDate dataNasc) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
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

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void addPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }

    @Override
    public String toString(){
        return this.id + ", "
                + this.nome + ", "
                + this.cpf + ", "
                + this.telefone + ", "
                + this.dataNasc;
    }
    
    public String toStringGrid(){
        return this.id + "  |  "
                + this.nome + "  |  "
                + this.cpf + "  |  "
                + this.telefone + "  |  "
                + this.dataNasc;
    }
}
