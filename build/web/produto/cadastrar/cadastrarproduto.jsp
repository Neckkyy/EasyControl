<%-- 
    Document   : cadastrarproduto
    Created on : 29 de nov. de 2024, 10:02:06
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Produto"%>
<%@page import = "Model.DAO.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Cadastro Produto</h1>
        <%
            String nomeprod = request.getParameter("nomeproduto");
            double preco = Double.parseDouble(request.getParameter("valorprod"));
            int qte = Integer.parseInt(request.getParameter("qteprod"));
            
            Produto p1 = new Produto();
            p1.setNomeproduto(nomeprod);
            p1.setValorproduto(preco);
            p1.setQte(qte);
            
            ProdutoDAO pdao = new ProdutoDAO();
            
            if(pdao.insereProduto(p1)){
                out.println("Registro inserido!");
            }
            else{
                out.println("Não foi possível inserir no Banco de dados");
            }
        %>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
