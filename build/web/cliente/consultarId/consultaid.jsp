<%-- 
    Document   : consultaid
    Created on : 28 de nov. de 2024, 20:39:39
    Author     : Carlos Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Cliente"%>
<%@page import = "Model.DAO.ClienteDAO"%>

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
            int idcliente = Integer.parseInt(request.getParameter("idcliente"));
            
            Cliente c1 = new Cliente();
            c1.setIdcliente(idcliente);
            
            ClienteDAO cdao = new ClienteDAO();
            List<Cliente> listacliente = new ArrayList<>();
            
            if(cdao.consultaClienteID(c1) != null){
                out.println("<br>Consulta realizada!");
        %>
            <table class="table table-striped" style="width: 100%"; border="1">
            <tr>
                <th>Id.</th>
                <th>Nome</th>
                <th>Endereco</th>
            </tr>
            <tr>
                <td><%= c1.getIdcliente()%></td>
                <td><%= c1.getNomecliente()%></td>
                <td><%= c1.getEndereco()%></td>
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
