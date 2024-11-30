<%-- 
    Document   : consultaid
    Created on : 29 de nov. de 2024, 10:44:08
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Produto"%>
<%@page import = "Model.DAO.ProdutoDAO"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Consulta</h1>
        <%
            int idproduto = Integer.parseInt(request.getParameter("idprod"));
            
            Produto p1 = new Produto();
            p1.setIdproduto(idproduto);
            
            ProdutoDAO pdao = new ProdutoDAO();
            List<Produto> listaproduto = new ArrayList<>();
            
            if(pdao.consultaProdutoID(p1)!= null){
                out.println("<br>Consulta realizada!");
        %>
            <table class="table table-striped" style="width: 100%"; border="1">
            <tr>
                <th>Id.</th>
                <th>Nome</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
            <tr>
                <td><%= p1.getIdproduto() %></td>
                <td><%= p1.getNomeproduto() %></td>
                <td><%= p1.getValorproduto() %></td>
                <td><%= p1.getQte() %></td>
            </tr> 
            </table>
        <%
            }
            else{
                out.println("Registro não encontrado!");
            }
        %>
        <br>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
