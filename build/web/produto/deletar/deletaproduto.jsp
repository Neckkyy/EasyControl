<%-- 
    Document   : deletaproduto
    Created on : 29 de nov. de 2024, 11:42:28
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Produto"%>
<%@page import = "Model.DAO.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleta</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Deletar!</h1>
        
        <%
            int id = Integer.parseInt(request.getParameter("idprod"));
            
            Produto p1 = new Produto();
            p1.setIdproduto(id);
            
            ProdutoDAO pdao = new ProdutoDAO();
            if(pdao.deletaProduto(p1)){
                out.println("Registro excluído!");
            }
            else{
                out.println("Não foi possível encontrar o registro!");
            }
        %>
        <br><br>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
