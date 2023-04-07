
<%@page import="java.util.Vector"%>
<%@page import="java.util.Map"%>
<%@page import="test.Emp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listes des Chauffeurs</h1>
        <% 
            String cle = (String)request.getAttribute("cle");
            Vector employer = (Vector)request.getAttribute(cle);
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Vaika</th>
                   
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < employer.size(); i++) { %>
                    <tr>
                   
                        <td><% out.print(((Emp)employer.get(i)).getNom()); %></td>
                        <td><% out.print(((Emp)employer.get(i)).getVaika()); %></td>
                       
                    </tr>
                <% } %>
            </tbody>
        </table>

    </body>
</html>
