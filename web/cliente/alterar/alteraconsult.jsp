
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import = "Model.Cliente"%>
<%@page import = "Model.DAO.ClienteDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar informações</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h3>Alterar informações!</h3>
        <%
            int id = Integer.parseInt(request.getParameter("idcliente"));
            Cliente c1 = new Cliente();
            c1.setIdcliente(id);
            ClienteDAO cdao = new ClienteDAO();
            if(cdao.consultaClienteID(c1) != null){
            %>
                <form method="post" action="alterado.jsp">
                <div class="mb-3">
                  <label for="alteraid" class="form-label">Id do Cliente:</label>
                  <input type="text" class="form-control" id="idclientealt" name="idcli" value="<%= c1.getIdcliente() %>" readonly="true" style="width: 200px;">
                </div>
                <div class="mb-3">
                  <label for="alteranome" class="form-label">Nome do Cliente:</label>
                  <input type="text" class="form-control" id="nmcliente" name="nomecliente" value="<%= c1.getNomecliente()%>" maxlength="30" style="width: 200px;">
                </div>
                <div class="mb-3">
                  <label for="alteraend" class="form-label">Endereço do Cliente::</label>
                  <input type="text" class="form-control" id="endcliente" name="endereco" value="<%= c1.getEndereco()%>" maxlength="30" style="width: 200px;">
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
