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
public class Item {
    
    //Atributos da classe Item
    protected String nome;
    protected int quantidadeEstoque;
    protected double valorAtual;
    
    
    //Funções
    public boolean possuiEmEstoque () {
        return false;
    }
    
    public void addItemPedido (ItemPedido itemPedido) {
        
    }
    
    public void removerItemPedido (ItemPedido itemPedido) {
        
    }
}
