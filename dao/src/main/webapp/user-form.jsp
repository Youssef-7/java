<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management App</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: purple">
            <div>
                <a href="#" class="navbar-brand"> Gestion Utilisateur </a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form action="${user != null ? 'update' : 'insert'}" method="post">
                    <caption>
                        <h2>
                            <c:choose>
                                <c:when test="${user != null}">
                                    Modifier Utilisateur
                                </c:when>
                                <c:otherwise>
                                    Ajouter utilisateur
                                </c:otherwise>
                            </c:choose>
                        </h2>
                    </caption>
                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>
                    <fieldset class="form-group">
                        <label>Nom</label>
                        <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="pseudo" required="required">
                    </fieldset>
                    <c:if test="${user == null}">
                        <fieldset class="form-group">
                            <label>Mot de passe</label>
                            <input type="password" class="form-control" name="mot_de_passe" required="required">
                        </fieldset>
                    </c:if>
                    <button type="submit" class="btn btn-success">Sauvegarder</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
