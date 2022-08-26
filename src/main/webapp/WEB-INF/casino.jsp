<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Casino</title>
    </head>
    <body>
        <h1>Casino</h1>
        
        <p>Nombre à deviner: ${nombreADeviner} </p>
        
        <c:if test="${nombreADeviner == nombreJoueur}">
            <p>Vous avez gagné !</p>
        </c:if> 
        <c:if test="${nombreADeviner > nombreJoueur}">
            <p>Trop petit !</p>
        </c:if>
        <c:if test="${nombreADeviner < nombreJoueur}">
            <p>Trop grand !</p>
        </c:if> 
        
         <form action="casino" method="POST">
            <br />
            <label for="mot">Choissez un nombre pour jouer (min 1, max 10):</label>
            <input type="text" name="nombreJoueur" id="nombreJoueur" />
            <br />
            <input type="submit" value="Jouer" />
        </form>
    </body>
</html>
