<%-- 
    Document   : alterado
    Created on : 29 de nov. de 2024, 11:30:53
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Produto"%>
<%@page import = "Model.DAO.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Altera Produto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Altera</h1>
        <%
            int idprod = Integer.parseInt(request.getParameter("idproduto"));
            String nomeprod = request.getParameter("nomeprod");
            double valor = Double.parseDouble(request.getParameter("valorprod"));
            int qte = Integer.parseInt(request.getParameter("qteprod"));
            
            Produto p1 = new Produto();
            p1.setIdproduto(idprod);
            p1.setNomeproduto(nomeprod);
            p1.setValorproduto(valor);
            p1.setQte(qte);
            
            ProdutoDAO pdao = new ProdutoDAO();
            
            if(pdao.alteraProduto(p1)){
                out.println("Registro alterado com sucesso!");
            }
            else{
                out.println("Erro, não foi possível alterar o registro!");
            }
        %>
        <br><br>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
