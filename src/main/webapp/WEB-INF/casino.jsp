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
        
        <p>Crédit: ${credit}</p>
        <p>Mise: ${mise}</p>
        
        <c:if test="${mise == null}">
              <c:if test="${nombreADeviner == nombreJoueur}">
                <p>Vous avez gagné !</p>        
            </c:if>  
            <c:if test="${nombreADeviner > nombreJoueur}">
                <p>Trop petit !</p>
            </c:if>
            <c:if test="${nombreADeviner < nombreJoueur}">
                <p>Trop grand !</p>
            </c:if> 
                
                
            <p>Combien voulez-vous miser ?</p>
             <form action="casino" method="POST">
                    <label for="mise">Montant de la mise:</label>
                    <input type="number" name="mise" id="mise" required/>
                    <br />
                    <input type="submit" value="Miser" />
            </form>
            
           
        </c:if>
        
        <c:if test="${mise != null}">
           
             <c:if test="${nombreADeviner == nombreJoueur}">
                <p>Vous avez gagné !</p>
                <a href="casino">Nouvelle partie</a>
            </c:if>  
            <c:if test="${nombreADeviner > nombreJoueur}">
                <p>Trop petit !</p>
            </c:if>
            <c:if test="${nombreADeviner < nombreJoueur}">
                <p>Trop grand !</p>
            </c:if> 

              <c:if test="${tentativesRestantes == 0 && nombreADeviner != nombreJoueur}">
                  <p>Vous avez utilisé tous les essais. La partie est terminée !</p>
                  <a href="casino">Nouvelle partie</a>
              </c:if>
              <c:if test="${tentativesRestantes != 0 && nombreADeviner != nombreJoueur}">
                  <p>Nombre à deviner: ${nombreADeviner} </p>

                  <p>Nombre de tentatives restantes: ${tentativesRestantes} </p>

                  <c:if test="${nombreADeviner != nombreJoueur}">
                      <form action="casino" method="POST">
                          <br />
                          <label for="mot">Choissez un nombre pour jouer (min 1, max 10):</label>
                          <input type="number" name="nombreJoueur" id="nombreJoueur" required/>
                          <br />
                          <input type="submit" value="Jouer" />
                     </form>
                  </c:if> 
              </c:if>
            
        </c:if>  
            
       
        
        
       
         
    </body>
</html>
