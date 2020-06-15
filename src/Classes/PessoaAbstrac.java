

package Classes;

/**
 *
 * @author Gustavo Vieira
 */
public abstract class PessoaAbstrac {
    
    protected long id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected date daraNasc;
    
    public abstract void addPedido(Pedido pedido);
    public abstract void removerPedido(Pedido pedido);
    
}
