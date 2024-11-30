/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Carlos Eduardo
 */
public class Cliente {
    private int idcliente;
    private String nomecliente;
    private String endereco;
    
    public Cliente(){
        
    }

    public Cliente(int idcliente, String nomecliente, String endereco) {
        this.idcliente = idcliente;
        this.nomecliente = nomecliente;
        this.endereco = endereco;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
