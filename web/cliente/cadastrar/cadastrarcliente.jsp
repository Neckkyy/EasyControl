

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Cliente"%>
<%@page import = "Model.DAO.ClienteDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Cadastrar cliente:</h1>
        <%
            String nomecliente = request.getParameter("nomecliente");
            String enderecocliente = request.getParameter("endcliente");
            
            Cliente c1 = new Cliente();
            c1.setNomecliente(nomecliente);
            c1.setEndereco(enderecocliente);
            
            ClienteDAO cdao = new ClienteDAO();
            
            if(cdao.insereCliente(c1)){
                out.println("Inserção bem sucedida!");
            }
            else{
                out.println("Não foi possível inserir no Banco de Dados");
            }
        %>
        <button type="button" class="btn btn-primary" onclick="window.location.href='../index.html';">Voltar ao Início</button>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
    </body>
</html>
