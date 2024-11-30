<%-- 
    Document   : consultavalor
    Created on : 29 de nov. de 2024, 11:12:40
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
        <title>Consultar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Consultar</h1>
        <%
            double valor = Double.parseDouble(request.getParameter("valorprod"));
            
            Produto p1 = new Produto();
            
            p1.setValorproduto(valor);
            
            ProdutoDAO pdao = new ProdutoDAO();
            List<Produto> listaproduto = new ArrayList<>();
            
            if(pdao.consultaProdutoValor(p1) == null){
                out.println("Registro não encontrado!");
            }
            else{
                listaproduto = pdao.consultaProdutoValor(p1);
                
                int registro = 0;
                out.println("<br>Produtos<br>");
        %>
        <table class="table table-striped" style="width: 100%"; border="1">
            <tr>
                <th>#</th>
                <th>Id.</th>
                <th>Nome</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
        <%   
            for( int i = 0; i <= listaproduto.size()-1; i++){       
        %> 
              <tr>
                <td><%= registro+1 %> </td>
                <td><%= listaproduto.get(i).getIdproduto() %></td>
                <td><%= listaproduto.get(i).getNomeproduto() %></td>
                <td><%= listaproduto.get(i).getValorproduto() %></td>
                <td><%= listaproduto.get(i).getQte() %></td>
            </tr> 
        <%
                registro++;                           
            }
        %>
        </table>
        <%                                                     
            out.println("<b>Registros: </b>" + registro + "<br>");
            }
        %>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
