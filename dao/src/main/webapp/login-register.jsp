<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Inscription et Connexion</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center">Connexion</h2>
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <div class="form-group">
                        <label for="pseudo">Pseudo</label>
                        <input type="text" class="form-control" id="pseudo" name="pseudo" required>
                    </div>
                    <div class="form-group">
                        <label for="motDePasse">Mot de passe</label>
                        <input type="password" class="form-control" id="motDePasse" name="motDePasse" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Connexion</button>
                    <button type="button" class="btn btn-link" id="showRegister">Créer un compte</button>
                </form>

                <h2 class="text-center" id="registerTitle" style="display: none;">Inscription</h2>
                <form action="${pageContext.request.contextPath}/register" method="post" id="registerForm" style="display: none;">
                    <div class="form-group">
                        <label for="pseudoRegister">Pseudo</label>
                        <input type="text" class="form-control" id="pseudoRegister" name="pseudo" required>
                    </div>
                    <div class="form-group">
                        <label for="motDePasseRegister">Mot de passe</label>
                        <input type="password" class="form-control" id="motDePasseRegister" name="motDePasse" required>
                    </div>
                    <button type="submit" class="btn btn-success">Inscription</button>
                    <button type="button" class="btn btn-link" id="showLogin">Se connecter</button>
                </form>
            </div>
        </div>
    </div>

    <script>
        document.getElementById("showRegister").addEventListener("click", function() {
            document.getElementById("registerForm").style.display = "block";
            document.getElementById("registerTitle").style.display = "block";
            this.style.display = "none";
        });

        document.getElementById("showLogin").addEventListener("click", function() {
            document.getElementById("registerForm").style.display = "none";
            document.getElementById("registerTitle").style.display = "none";
            document.getElementById("showRegister").style.display = "inline";
        });
    </script>
</body>
</html>
