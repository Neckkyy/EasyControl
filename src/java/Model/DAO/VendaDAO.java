/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;
import Model.Venda;
import Model.Cliente;
import Model.ProdutoVenda;
import Model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaDB;
import java.util.Date;
/**
 *
 * @author Carlos Eduardo
 */
public class VendaDAO {

    public boolean insereVenda(Venda v1) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            Date dataAtual = new Date();
            Timestamp datasql = new Timestamp(dataAtual.getTime());
            v1.setData(datasql);
            String sql = "INSERT INTO venda(id_fkcliente, data_venda, valortotal) VALUES(" + v1.getFkcliente().getIdcliente() + ", '" 
                         + v1.getData() + "', '" + v1.getValortotal()+ "');";
            stmt.executeUpdate(sql);
            return true;
        } 
        catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } 
        finally {
            if (conexao != null) {
                try { 
                    conexao.close(); 
                } 
                catch (SQLException e) 
                { 
                    e.printStackTrace(); 
                }
            }
        }
    }
    
    public boolean deletaVenda(Venda v1) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            String sql = "DELETE FROM venda WHERE id_venda = " + v1.getIdvenda()+ ";";
            stmt.executeUpdate(sql);
            return true;
        } 
        catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } 
        finally {
            if (conexao != null) {
                try { 
                    conexao.close(); 
                } 
                catch (SQLException e) { 
                    e.printStackTrace(); 
                }
            }
        }
    }
    
    public int getUltimoIdVenda() throws ClassNotFoundException { 
        Connection conexao = null; 
        int idVenda = -1; 
        try { 
            conexao = ConectaDB.conectar(); 
            String sql = "SELECT MAX(id_venda) as ultimo_id FROM venda"; 
            Statement stmt = conexao.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql); 
            if (rs.next()) { 
            idVenda = rs.getInt("ultimo_id"); 
            } 
            rs.close(); 
            stmt.close(); } 
        catch (SQLException e) { 
            System.out.println("Erro: " + e); 
            } 
        finally { 
            if (conexao != null) { 
                try { conexao.close(); 
                    } 
                catch (SQLException e) { 
                e.printStackTrace(); 
                    } 
                } 
            } 
            return idVenda; 
        } 

    /*public boolean alteraVenda(Venda v1) throws ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            String sql = "UPDATE venda SET valortotal = " + v1.getValortotal()+ " WHERE id_venda = " + v1.getIdvenda() + ";";
            stmt.executeUpdate(sql);
            return true;
        } 
        catch (SQLException e) {
            System.out.println("Erro: " + e);
            return false;
        } 
        finally {
            if (conexao != null) 
            {
                try { 
                    conexao.close(); 
                } 
                catch (SQLException e) { 
                    e.printStackTrace(); 
                }
            }
        }
    }*/
   
        /*private List<ProdutoVenda> consultaProdutosVendidos(int idVenda) throws ClassNotFoundException{
            Connection conexao = null;
            List<ProdutoVenda> produtosVendidos = new ArrayList<>();
            try{
                conexao = ConectaDB.conectar();
                Statement stmt = conexao.createStatement();
                String sql = "SELECT pv.id_produtovenda, pv.id_fkproduto, pv.qte_prodvenda, pv.preco_unitario, " + 
                    "p.nomeproduto, p.valorproduto " + "FROM produto_venda pv " + 
                    "JOIN produto p ON pv.id_fkproduto = p.id_produto " + "WHERE pv.id_fkvenda = ?";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    ProdutoVenda prodVenda = new ProdutoVenda();
                    prodVenda.setIdprodutovenda(rs.getInt("id_produtovenda"));
                    Venda v1 = new Venda();
                    v1.setIdvenda(idVenda);
                    prodVenda.setFkvenda(v1);
                    Produto produto = new Produto();
                    produto.setIdproduto(rs.getInt("id_fkproduto"));
                    produto.setNomeproduto(rs.getString("nomeproduto"));
                    produto.setValorproduto(rs.getDouble("valorproduto"));
                    prodVenda.setFkproduto(produto);
                    prodVenda.setQteprodvenda(rs.getInt("qte_prodvenda"));
                    prodVenda.setPrecounitario(rs.getDouble("preco_unitario"));
                    produtosVendidos.add(prodVenda);
                }
            }
            catch (SQLException e) {
                System.out.println("Erro: " + e);
                return null;
            } 
            finally {
                if (conexao != null) 
                {
                    try { conexao.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
            return produtosVendidos;
        }*/

}
