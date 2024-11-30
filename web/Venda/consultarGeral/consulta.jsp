<%-- 
    Document   : consulta
    Created on : 30 de nov. de 2024, 14:40:06
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import ="Model.ProdutoVenda"%>
<%@page import ="Model.DAO.ProdutoVendaDAO"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta!</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Consulta!</h1>
        <%
            ProdutoVendaDAO pvdao = new ProdutoVendaDAO();
            List<ProdutoVenda> listaprodvenda = new ArrayList<>();
            
            listaprodvenda = pvdao.consultaProdutosVendidos();
            
            int registro = 0;
            out.println("<br>Vendas:<br>");
        %>
        <table class="table table-striped" style="width: 100%"; border="1">
            <tr>
                <th>#</th>
                <th>Id venda.</th>
                <th>Id cliente</th>
                <th>Nome cliente</th>
                <th>data</th>
                <th>valor total</th>
                <th>Id produto-venda</th>
                <th>Id Produto</th>
                <th>Nome produto</th>
                <th>Quantidade</th>
                <th>Preco Unit.</th>
            </tr>
            
        <%   
            for( int i = 0; i <= listaprodvenda.size()-1; i++){                
                //Minha tabela - DT/TR/...
        %> 
        
        <tr>
                <td><%= registro+1 %> </td>
                <td><%= listaprodvenda.get(i).getFkvenda().getIdvenda() %></td>
                <td><%= listaprodvenda.get(i).getFkvenda().getFkcliente().getIdcliente()%></td>
                <td><%= listaprodvenda.get(i).getFkvenda().getFkcliente().getNomecliente()%></td>
                <td><%= listaprodvenda.get(i).getFkvenda().getData() %></td>
                <td><%= listaprodvenda.get(i).getFkvenda().getValortotal() %></td>
                <td><%= listaprodvenda.get(i).getIdprodutovenda() %></td>
                <td><%= listaprodvenda.get(i).getFkproduto().getIdproduto() %></td>
                <td><%= listaprodvenda.get(i).getFkproduto().getNomeproduto() %></td>
                <td><%= listaprodvenda.get(i).getQteprodvenda() %></td>
                <td><%= listaprodvenda.get(i).getPrecounitario() %></td>
            </tr> 
        <%
                registro++;                           
            }
        %>
        </table>
        <%                                                     
            out.println("<b>Registros: </b>" + registro + "<br>");
        %>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
