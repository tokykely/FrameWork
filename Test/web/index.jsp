<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Save Employer</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Insertion Employer</h1>
        <form action="emp-save" method="post">
            <label for="id">id</label>
            <input type="text" name="id"><br/>
            <label for="id_dept">id_dept</label>
            <input type="text" name="id_dept"><br/>
            <label for="nom">nom</label>
            <input type="text" name="nom"><br/>
            <label for="prenom">prenom</label>
            <input type="text" name="prenom"><br/>
            <label for="salaire">Salaire</label>
            <input type="number" name="salaire"><br/>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
