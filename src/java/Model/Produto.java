/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Carlos Eduardo
 */
public class Produto {
    private int idproduto;
    private String nomeproduto;
    private double valorproduto;
    private int qte;
    
    public Produto(){
        
    }

    public Produto(int idproduto, String nomeproduto, double valorproduto, int qte) {
        this.idproduto = idproduto;
        this.nomeproduto = nomeproduto;
        this.valorproduto = valorproduto;
        this.qte = qte;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public double getValorproduto() {
        return valorproduto;
    }

    public void setValorproduto(double valorproduto) {
        this.valorproduto = valorproduto;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
