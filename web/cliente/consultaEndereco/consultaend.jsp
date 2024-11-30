
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
        <h1>Resultado</h1>
        <%
            String endereco = request.getParameter("endereco");
            
            Cliente c1 = new Cliente();
            
            c1.setEndereco(endereco);
            
            ClienteDAO cdao = new ClienteDAO();
            
            List<Cliente> listacliente = new ArrayList<>();
            
            if(cdao.consultaClienteEndereco(c1) == null){
                out.println("Registro não encontrado!");
            }
            else{
                listacliente = cdao.consultaClienteEndereco(c1);
                int registro = 0;
                out.println("<br>Clientes:<br>");
        %>
        <table class="table table-striped" style="width: 100%"; border="1">
            <tr>
                <th>#</th>
                <th>Id.</th>
                <th>Nome</th>
                <th>Endereco</th>
            </tr>
        <%   
            for( int i = 0; i <= listacliente.size()-1; i++){       
        %> 
              <tr>
                <td><%= registro+1 %> </td>
                <td><%= listacliente.get(i).getIdcliente()%></td>
                <td><%= listacliente.get(i).getNomecliente()%></td>
                <td><%= listacliente.get(i).getEndereco()%></td>
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
