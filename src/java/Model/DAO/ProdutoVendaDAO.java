/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;
import Model.Cliente;
import Model.Venda;
import Model.Produto;
import Model.ProdutoVenda;
import util.ConectaDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author Carlos Eduardo
 */
public class ProdutoVendaDAO {
    
    public boolean insereProdutoVenda(ProdutoVenda pv) throws ClassNotFoundException{
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            System.out.println("ID Venda: " + pv.getFkvenda().getIdvenda()); 
            System.out.println("ID Produto: " + pv.getFkproduto().getIdproduto()); 
            System.out.println("Quantidade Vendida: " + pv.getQteprodvenda()); 
            System.out.println("Preço Unitário: " + pv.getPrecounitario());
            String sql = "INSERT INTO produto_venda(id_fkvenda, id_fkproduto, qte_prodvenda, preco_unitario) VALUES(" + pv.getFkvenda().getIdvenda() 
                    + ", " + pv.getFkproduto().getIdproduto() + ", " + pv.getQteprodvenda() + ", " + pv.getPrecounitario() + ");";
            stmt.executeUpdate(sql);
            
            String updateProdutoSql = "UPDATE produto SET qte = qte - ? WHERE id_produto = ?;"; 
            try (
                PreparedStatement updateStmt = conexao.prepareStatement(updateProdutoSql)) { 
                updateStmt.setInt(1, pv.getQteprodvenda()); 
                updateStmt.setInt(2, pv.getFkproduto().getIdproduto()); 
                updateStmt.executeUpdate(); 
            }
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
    
    public boolean deletaProdutoVenda(ProdutoVenda pv) throws ClassNotFoundException{
        Connection conexao = null;
        try {
            conexao = ConectaDB.conectar();
            Statement stmt = conexao.createStatement();
            String sql = "delete from produto_venda where id_produtovenda = " + pv.getIdprodutovenda() + ";";
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
    
    public List<ProdutoVenda> consultaProdutosVendidos() throws ClassNotFoundException {
            Connection conexao = null;
            List<ProdutoVenda> produtosVendidos = new ArrayList<>();
            try {
                conexao = ConectaDB.conectar();
                Statement stmt = conexao.createStatement();
                String sql = "SELECT v.id_venda, v.id_fkcliente, c.nome, v.data_venda, v.valortotal, " +
                             "pv.id_produtovenda, pv.id_fkproduto, p.nomeproduto, pv.qte_prodvenda, pv.preco_unitario " +
                             "FROM venda v " +
                             "JOIN cliente c ON v.id_fkcliente = c.id_cliente " +
                             "JOIN produto_venda pv ON v.id_venda = pv.id_fkvenda " +
                             "JOIN produto p ON pv.id_fkproduto = p.id_produto";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    ProdutoVenda prodVenda = new ProdutoVenda();
                    prodVenda.setIdprodutovenda(rs.getInt("id_produtovenda"));
                    Venda v1 = new Venda();
                    v1.setIdvenda(rs.getInt("id_venda"));
                    Cliente c1 = new Cliente();
                    c1.setIdcliente(Integer.parseInt(rs.getString("id_fkcliente")));
                    c1.setNomecliente(rs.getString("nome"));
                    v1.setFkcliente(c1);
                    v1.setData(rs.getDate("data_venda"));
                    v1.setValortotal(rs.getDouble("valortotal"));
                    prodVenda.setFkvenda(v1);

                    Produto produto = new Produto();
                    produto.setIdproduto(rs.getInt("id_fkproduto"));
                    produto.setNomeproduto(rs.getString("nomeproduto"));
                    prodVenda.setFkproduto(produto);

                    prodVenda.setQteprodvenda(rs.getInt("qte_prodvenda"));
                    prodVenda.setPrecounitario(rs.getDouble("preco_unitario"));
                    produtosVendidos.add(prodVenda);
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e);
                return null;
            } finally {
                if (conexao != null) {
                    try { conexao.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
            return produtosVendidos;
        }
    
    public List<ProdutoVenda> consultaProdutosVendidosPorCliente(Cliente c) throws ClassNotFoundException {
            Connection conexao = null;
            List<ProdutoVenda> produtosVendidos = new ArrayList<>();
            try {
                conexao = ConectaDB.conectar();

                String sql = "SELECT v.id_venda, v.id_fkcliente, c.nome, v.data_venda, v.valortotal, " +
                             "pv.id_produtovenda, pv.id_fkproduto, p.nomeproduto, pv.qte_prodvenda, pv.preco_unitario " +
                             "FROM venda v " +
                             "JOIN cliente c ON v.id_fkcliente = c.id_cliente " +
                             "JOIN produto_venda pv ON v.id_venda = pv.id_fkvenda " +
                             "JOIN produto p ON pv.id_fkproduto = p.id_produto " +
                             "WHERE v.id_fkcliente = ?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, c.getIdcliente());
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    ProdutoVenda prodVenda = new ProdutoVenda();
                    prodVenda.setIdprodutovenda(rs.getInt("id_produtovenda"));
                    Venda v1 = new Venda();
                    v1.setIdvenda(rs.getInt("id_venda"));
                    Cliente c1 = new Cliente();
                    c1.setIdcliente(rs.getInt("id_fkcliente"));
                    c1.setNomecliente(rs.getString("nome"));
                    v1.setFkcliente(c1);
                    v1.setData(rs.getDate("data_venda"));
                    v1.setValortotal(rs.getDouble("valortotal"));
                    prodVenda.setFkvenda(v1);

                    Produto produto = new Produto();
                    produto.setIdproduto(rs.getInt("id_fkproduto"));
                    produto.setNomeproduto(rs.getString("nomeproduto"));
                    prodVenda.setFkproduto(produto);

                    prodVenda.setQteprodvenda(rs.getInt("qte_prodvenda"));
                    prodVenda.setPrecounitario(rs.getDouble("preco_unitario"));
                    produtosVendidos.add(prodVenda);
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e);
            } finally {
                if (conexao != null) {
                    try { conexao.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
            return produtosVendidos;
        }

}
