/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Carlos Eduardo
 */
public class Venda {
    
    private int idvenda;
    private Cliente fkcliente;
    private Date data;
    private double valortotal;
    private List<ProdutoVenda> produtosvendidos;
    
    public Venda(){
        
    }

    public Venda(int idvenda, Cliente fkcliente, Date data, double valortotal, List<ProdutoVenda> produtosvendidos) {
        this.idvenda = idvenda;
        this.fkcliente = fkcliente;
        this.data = data;
        this.valortotal = valortotal;
        this.produtosvendidos = produtosvendidos;
    }

    public List<ProdutoVenda> getProdutosvendidos() {
        return produtosvendidos;
    }

    public void setProdutosvendidos(List<ProdutoVenda> produtosvendidos) {
        this.produtosvendidos = produtosvendidos;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public Cliente getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(Cliente fkcliente) {
        this.fkcliente = fkcliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
    
}
