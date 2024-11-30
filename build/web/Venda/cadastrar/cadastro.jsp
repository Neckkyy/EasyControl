<%-- 
    Document   : venda
    Created on : 29 de nov. de 2024, 22:17:10
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Venda"%>
<%@page import = "Model.Cliente"%>
<%@page import = "Model.Produto"%>
<%@page import = "Model.ProdutoVenda"%>
<%@page import = "Model.DAO.ProdutoVendaDAO"%>
<%@page import = "Model.DAO.ProdutoDAO"%>
<%@page import = "Model.DAO.ClienteDAO"%>
<%@page import = "Model.DAO.VendaDAO"%>

<%@page import = "java.sql.Date"%>
<%@page import = "java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Venda</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Cadastro</h1>
        <%
            int idcliente = Integer.parseInt(request.getParameter("idcliente"));
            String dtvenda = (request.getParameter("datavenda"));
            int qte = Integer.parseInt(request.getParameter("qteprod"));
            int idprod = Integer.parseInt(request.getParameter("idprod"));
            SimpleDateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd");
            
            java.util.Date utilDate = dtformat.parse(dtvenda);
            
            Date sqldt = new Date(utilDate.getTime());
            
            double precounitario;
            double valortotal;
            
            Cliente c1 = new Cliente();
            c1.setIdcliente(idcliente);
            ClienteDAO cdao = new ClienteDAO();
            
            Produto p1 = new Produto();
            p1.setIdproduto(idprod);
            ProdutoDAO pdao = new ProdutoDAO();
            
            Venda v1 = new Venda();
            VendaDAO vdao = new VendaDAO();
            
            ProdutoVenda pv1 = new ProdutoVenda();
            ProdutoVendaDAO pvdao = new ProdutoVendaDAO();
            
            if(cdao.consultaClienteID(c1) != null){
                if(pdao.consultaProdutoID(p1) != null){
                    if(p1.getQte() >= qte){
                        precounitario = p1.getValorproduto();
                        valortotal = precounitario * qte;

                        v1.setFkcliente(c1);
                        v1.setData(sqldt);
                        v1.setValortotal(valortotal);
                        
                        if(vdao.insereVenda(v1)){
                            int idvenda = vdao.getUltimoIdVenda();
                            v1.setIdvenda(idvenda);
                            pv1.setFkvenda(v1);
                            pv1.setFkproduto(p1);
                            pv1.setQteprodvenda(qte);
                            pv1.setPrecounitario(precounitario);
                            if(pvdao.insereProdutoVenda(pv1)){
                                out.println("Registro inserido!");
                            }
                            else{
                                out.println("Não foi possível cadastrar a venda do produto");
                            }
                        }
                        else{
                            out.println("Não foi possível cadastrar a venda");
                        }
                    }
                    else{
                        out.println("Não há essa quantidade de produtos no estoque...");
                    }
                }
                else{
                    out.println("Não foi possível encontrar esse registro de produto...");
                }
            }
            else{
                out.println("Não foi possível encontrar esse registro de cliente...");
            }
        %>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
