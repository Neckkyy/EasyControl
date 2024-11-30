/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;
import Model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaDB;

/**
 *
 * @author Carlos Eduardo
 */
public class ClienteDAO {
    
    public boolean insereCliente(Cliente c1) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "insert into cliente(nome, endereco) values('" + c1.getNomecliente() + "', '" 
                    + c1.getEndereco() + "');";
            //execução do comando
            stmt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return false;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean deletaCliente(Cliente c1) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "delete from cliente where id_cliente = " + c1.getIdcliente() + ";";
            //execução do comando
            stmt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return false;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public boolean alteraCliente(Cliente c1) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "update cliente set nome = '" + c1.getNomecliente() + "', endereco = '" 
                    + c1.getEndereco()+ "' where id_cliente = " + c1.getIdcliente();
            //execução do comando
            stmt.executeUpdate(sql);
            return true;
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return false;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public List consultaClienteNome(Cliente c1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaCliente = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from cliente where nome like '%" + c1.getNomecliente() + "%';";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                Cliente cres = new Cliente();
                cres.setIdcliente(Integer.parseInt(rs.getString("id_cliente")));
                cres.setNomecliente(rs.getString("nome"));
                cres.setEndereco(rs.getString("endereco"));
                listaCliente.add(cres);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaCliente;
            }
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return null;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public List consultaClienteEndereco(Cliente c1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaCliente = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from cliente where endereco like '%" + c1.getEndereco() + "%';";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                Cliente cres = new Cliente();
                cres.setIdcliente(Integer.parseInt(rs.getString("id_cliente")));
                cres.setNomecliente(rs.getString("nome"));
                cres.setEndereco(rs.getString("endereco"));
                listaCliente.add(cres);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaCliente;
            }
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return null;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public List consultaClienteID(Cliente c1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaCliente = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from cliente where id_cliente = '" + c1.getIdcliente() + "';";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                c1.setIdcliente(Integer.parseInt(rs.getString("id_cliente")));
                c1.setNomecliente(rs.getString("nome"));
                c1.setEndereco(rs.getString("endereco"));
                listaCliente.add(c1);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaCliente;
            }
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return null;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    public List consultaClientes() throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaCliente = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from cliente;";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                Cliente cres = new Cliente();
                cres.setIdcliente(Integer.parseInt(rs.getString("id_cliente")));
                cres.setNomecliente(rs.getString("nome"));
                cres.setEndereco(rs.getString("endereco"));
                listaCliente.add(cres);
                registro ++;
            }
            
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaCliente;
            }
        }
        catch(SQLException e){
            System.out.println("Erro:" + e);
            return null;
        }
        finally{
            if(conexao != null){
                try{
                    conexao.close();
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
