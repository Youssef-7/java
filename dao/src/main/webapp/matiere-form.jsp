<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Gestion des Matières</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
            <div>
                <a href="#" class="navbar-brand"> Gestion Matière </a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listMatieres" class="nav-link">Matières</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <form action="${matiere != null ? 'updateMatiere' : 'insertMatiere'}" method="post">
                    <caption>
                        <h2>
                            <c:choose>
                                <c:when test="${matiere != null}">
                                    Modifier Matière
                                </c:when>
                                <c:otherwise>
                                    Ajouter Nouvelle Matière
                                </c:otherwise>
                            </c:choose>
                        </h2>
                    </caption>
                    <c:if test="${matiere != null}">
                        <input type="hidden" name="id" value="<c:out value='${matiere.id}' />" />
                    </c:if>
                    <fieldset class="form-group">
                        <label>Nom</label>
                        <input type="text" value="<c:out value='${matiere.nom}' />" class="form-control" name="nom" required="required">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Enregistrer</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
