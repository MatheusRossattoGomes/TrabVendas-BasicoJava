/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Dark
 */
public class Funcionario extends PessoaAbstrac {
    
    //Atributos da classe Funcionario
    private double Salario;
    
    
    //funções abstratas erdadas da classe PessoaAbstrac
    @Override
    public void addPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
