/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;
import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaDB;

/**
 *
 * @author Carlos Eduardo
 */
public class ProdutoDAO {
    
    public boolean insereProduto(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "insert into produto(nomeproduto, valorproduto, qte) values('" + p1.getNomeproduto()+ "', " 
                    + p1.getValorproduto() + ", " + p1.getQte() + ");";
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
    
    public boolean deletaProduto(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "delete from produto where id_produto = " + p1.getIdproduto()+ ";";
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
    
    
    public boolean alteraProduto(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Update produto set nomeproduto = '" + p1.getNomeproduto() 
                    + "', valorproduto = " + p1.getValorproduto() 
                    + ", qte = " + p1.getQte() + " where id_produto = " + p1.getIdproduto();
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
    
    public List consultaProdutoNome(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaProdutos = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from produto where nomeproduto like '%" + p1.getNomeproduto() + "%';";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                Produto pres = new Produto();
                pres.setIdproduto(Integer.parseInt(rs.getString("id_produto")));
                pres.setNomeproduto(rs.getString("nomeproduto"));
                pres.setValorproduto(Double.parseDouble(rs.getString("valorproduto")));
                pres.setQte(Integer.parseInt(rs.getString("qte")));
                listaProdutos.add(pres);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaProdutos;
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
    public List consultaProdutoValor(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaProdutos = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from produto where valorproduto = " + p1.getValorproduto()+ ";";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            while(rs.next()){
                Produto pres = new Produto();
                pres.setIdproduto(Integer.parseInt(rs.getString("id_produto")));
                pres.setNomeproduto(rs.getString("nomeproduto"));
                pres.setValorproduto(Double.parseDouble(rs.getString("valorproduto")));
                pres.setQte(Integer.parseInt(rs.getString("qte")));
                listaProdutos.add(pres);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaProdutos;
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
    
    public List consultaProdutoQte(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaProdutos = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from produto where qte = " + p1.getQte()+ ";";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                Produto pres = new Produto();
                pres.setIdproduto(Integer.parseInt(rs.getString("id_produto")));
                pres.setNomeproduto(rs.getString("nomeproduto"));
                pres.setValorproduto(Double.parseDouble(rs.getString("valorproduto")));
                pres.setQte(Integer.parseInt(rs.getString("qte")));
                listaProdutos.add(pres);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaProdutos;
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
    public List consultaProdutoID(Produto p1) throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaProdutos = new ArrayList();
        try{
            //estabelecendo conexão
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            //comando sql
            String sql = "Select * from produto where id_produto = " + p1.getIdproduto()+ ";";
            //execução do comando
            ResultSet rs = stmt.executeQuery(sql);
            //varíavel que armazenará a quantidade de ocorrências no banco
            int registro = 0;
            //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
            while(rs.next()){
                p1.setIdproduto(Integer.parseInt(rs.getString("id_produto")));
                p1.setNomeproduto(rs.getString("nomeproduto"));
                p1.setValorproduto(Double.parseDouble(rs.getString("valorproduto")));
                p1.setQte(Integer.parseInt(rs.getString("qte")));
                listaProdutos.add(p1);
                registro ++;
            }
            //fechando conexão
            conexao.close();
            
            if(registro == 0){
                return null;
            }
            else{
                return listaProdutos;
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
    

    
    public List consultaGeral() throws ClassNotFoundException{
        Connection conexao = null;
        //criação da lista para armazenar os resultados do Select
        List listaproduto = new ArrayList();
            try{
                //estabelecendo conexão
                conexao = ConectaDB.conectar();
                Statement stmt = conexao.createStatement();
                //comando sql
                String sql = "Select * from produto;";
                //execução do comando
                ResultSet rs = stmt.executeQuery(sql);
                //varíavel que armazenará a quantidade de ocorrências no banco
                int registro = 0;
                //Fazendo um loop que criará novas instâncias de Roupas e armazenará em uma lista
                while(rs.next()){
                    Produto pres = new Produto();
                    pres.setIdproduto(Integer.parseInt(rs.getString("id_produto")));
                    pres.setNomeproduto(rs.getString("nomeproduto"));
                    pres.setValorproduto(Double.parseDouble(rs.getString("valorproduto")));
                    pres.setQte(Integer.parseInt(rs.getString("qte")));
                    listaproduto.add(pres);
                    registro ++;
                }

                conexao.close();

                if(registro == 0){
                    return null;
                }
                else{
                    return listaproduto;
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
