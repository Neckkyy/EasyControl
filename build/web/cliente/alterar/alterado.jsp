<%-- 
    Document   : alterado
    Created on : 28 de nov. de 2024, 21:56:17
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Cliente"%>
<%@page import = "Model.DAO.ClienteDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Alterar</h1>
        <%
            int id = Integer.parseInt(request.getParameter("idcli"));
            String nome = request.getParameter("nomecliente");
            String end = request.getParameter("endereco");
            
            Cliente c1 = new Cliente();
            c1.setIdcliente(id);
            c1.setNomecliente(nome);
            c1.setEndereco(end);
            ClienteDAO cdao = new ClienteDAO();
            if(cdao.alteraCliente(c1)){
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
