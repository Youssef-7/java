<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    HttpSession currentSession = request.getSession(false);
    if (currentSession == null || currentSession.getAttribute("user") == null) {
        response.sendRedirect("login-register.jsp");
        return;
    }
%>
<html>
<head>
    <title>Matière App</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
            </ul>
            <form class="form-inline ml-auto" action="<%=request.getContextPath()%>/logout" method="post">
                <button class="btn btn-danger" type="submit">Déconnexion</button>
            </form>
        </nav>
    </header>
    <br>
    <div class="row">
        <div class="container">
            <h3 class="text-center">Liste des Utilisateurs</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajouter nouvel utilisateur</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${listUser}">
                        <tr>
                            <td>
                                <c:out value="${user.id}" />
                            </td>
                            <td>
                                <c:out value="${user.name}" />
                            </td>
                            <td>
                                <a href="edit?id=<c:out value='${user.id}' />">Modifier</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Supprimer</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        <h3 class="text-center">Liste des Matières</h2>
        <hr>
        <div class="container text-left">
            <a href="newMatiere" class="btn btn-primary">Ajouter Matière</a>
        </div>
        <br>
        <table class="table table-bordered">
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="matiere" items="${listMatiere}">
                <tr>
                    <td>${matiere.id}</td>
                    <td>${matiere.nom}</td>
                    <td>
                        <a href="editMatiere?id=${matiere.id}" >Modifier</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; 
                        <a href="deleteMatiere?id=${matiere.id}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </div>
</body>
</html>
