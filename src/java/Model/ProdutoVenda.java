/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Carlos Eduardo
 */
public class ProdutoVenda {
    private int idprodutovenda;
    private Venda fkvenda;
    private Produto fkproduto;
    private int qteprodvenda;
    private double precounitario;
    
    public ProdutoVenda(){
        
    }

    public ProdutoVenda(int idprodutovenda, Venda fkvenda, Produto fkproduto, int qteprodvenda, double precounitario) {
        this.idprodutovenda = idprodutovenda;
        this.fkvenda = fkvenda;
        this.fkproduto = fkproduto;
        this.qteprodvenda = qteprodvenda;
        this.precounitario = precounitario;
    }

    public int getIdprodutovenda() {
        return idprodutovenda;
    }

    public void setIdprodutovenda(int idprodutovenda) {
        this.idprodutovenda = idprodutovenda;
    }

    public Venda getFkvenda() {
        return fkvenda;
    }

    public void setFkvenda(Venda fkvenda) {
        this.fkvenda = fkvenda;
    }

    public Produto getFkproduto() {
        return fkproduto;
    }

    public void setFkproduto(Produto fkproduto) {
        this.fkproduto = fkproduto;
    }

    public int getQteprodvenda() {
        return qteprodvenda;
    }

    public void setQteprodvenda(int qteprodvenda) {
        this.qteprodvenda = qteprodvenda;
    }

    public double getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(double precounitario) {
        this.precounitario = precounitario;
    }
    
}
