<%-- 
    Document   : deletarcliente
    Created on : 28 de nov. de 2024, 19:52:26
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Cliente"%>
<%@page import = "Model.DAO.ClienteDAO"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deletar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Excluir</h1>
        <%
            int idcliente = Integer.parseInt(request.getParameter("idcliente"));
            
            Cliente c1 = new Cliente();
            
            c1.setIdcliente(idcliente);
            
            ClienteDAO cdao = new ClienteDAO();
            
            if(cdao.deletaCliente(c1)){
                out.println("Cliente removido!");
            }
            else{
                out.println("Não foi possível remover o cliente");
            }
        %>
        <br><br>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
