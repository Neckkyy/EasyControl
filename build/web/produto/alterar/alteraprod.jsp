<%-- 
    Document   : alteraprod
    Created on : 29 de nov. de 2024, 11:25:29
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Produto"%>
<%@page import = "Model.DAO.ProdutoDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Alterar</h1>
        <%
            int id = Integer.parseInt(request.getParameter("idprod"));
            
            Produto p1 = new Produto();
            
            p1.setIdproduto(id);
            ProdutoDAO pdao = new ProdutoDAO();
            if(pdao.consultaProdutoID(p1) != null){
        %>
        <form method="post" action="alterado.jsp">
                <div class="mb-3">
                  <label for="alteraid" class="form-label">Id do Produto:</label>
                  <input type="text" class="form-control" id="idprod" name="idproduto" value="<%= p1.getIdproduto() %>" readonly="true" style="width: 200px;">
                </div>
                <div class="mb-3">
                  <label for="alteranome" class="form-label">Nome do Produto:</label>
                  <input type="text" class="form-control" id="nomeprod" name="nomeprod" value="<%= p1.getNomeproduto() %>" maxlength="30" style="width: 200px;">
                </div>
                <div class="mb-3">
                  <label for="alteravalor" class="form-label">Valor do Produto:</label>
                  <input type="text" class="form-control" id="valorprod" name="valorprod" value="<%= p1.getValorproduto()%>" maxlength="30" style="width: 200px;">
                </div>
                <div class="mb-3">
                  <label for="alteraqte" class="form-label">Quantidade do Produto:</label>
                  <input type="text" class="form-control" id="qteprod" name="qteprod" value="<%= p1.getQte()%>" maxlength="30" style="width: 200px;">
                </div>
                  <button type="submit" class="btn btn-primary">Salvar!</button>
                </form>
                <br>
        <%
            }else
            {
               out.println("Registro não encontrado!!!");
            }
        %>
            <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
