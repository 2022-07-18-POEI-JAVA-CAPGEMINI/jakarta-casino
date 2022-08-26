package com.poe.poe20220718.casino;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/casino")
public class CasinoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException
    {
        Random random = new Random();
        int nombreADeviner = random.nextInt(10)+1;
        
        int tentativesRestantes = 3;
        request.getSession().setAttribute("tentativesRestantes", tentativesRestantes);
        
        Integer credit = (Integer)request.getSession().getAttribute("credit");
        if(credit == null) {
            // On démarre de zéro, le joueur n'a jamais joué encore !
            credit = 100;
        }
        request.getSession().setAttribute("credit", credit);
        
        // Combien le joueur a misé en début de partie
        Integer mise = (Integer)request.getSession().getAttribute("mise");
        
        
        
        request.getSession().setAttribute("nombreADeviner", nombreADeviner);
        
        request.getRequestDispatcher("WEB-INF/casino.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException
     {
         // valeur du input du form HTML reçu dans la requete HTTP
         String miseString = request.getParameter("mise");
         
         // On est train de jouer
         if(miseString == null) {  
         
            String nombreJoueurString = request.getParameter("nombreJoueur");
            int nombreJoueur = Integer.parseInt(nombreJoueurString);

            int nombreADeviner = (int)request.getSession().getAttribute("nombreADeviner");

            int tentativesRestantes = (int)request.getSession().getAttribute("tentativesRestantes");
            tentativesRestantes = tentativesRestantes - 1;
            request.getSession().setAttribute("tentativesRestantes", tentativesRestantes);

            
            if(nombreJoueur == nombreADeviner) {
                Integer credit = (Integer)request.getSession().getAttribute("credit");
                // ATTENTION : ajouter un try/catch ?
                Integer mise = (Integer)request.getSession().getAttribute("mise");
                credit = credit + mise;
                request.getSession().setAttribute("credit", credit);
                request.getSession().setAttribute("mise", null);
                request.getSession().setAttribute("tentativesRestantes", 3);
            }
            if(tentativesRestantes == 0 && nombreJoueur != nombreADeviner){
                Integer credit = (Integer)request.getSession().getAttribute("credit");
                // ATTENTION : ajouter un try/catch ?
                Integer mise = (Integer)request.getSession().getAttribute("mise");
                // attention : crédit ne doit pas être inférieur à zéro !
                credit = credit - mise;
                request.getSession().setAttribute("credit", credit);
                request.getSession().setAttribute("mise", null);
                request.getSession().setAttribute("tentativesRestantes", 3);
            }
            

            request.setAttribute("nombreJoueur", nombreJoueur);
            
         }
         // On est en train de miser
         else {
             // ATTENTION : ajouter un try/catch ?
              Integer mise = Integer.parseInt(miseString);
             request.getSession().setAttribute("mise", mise);
         }
         
         request.getRequestDispatcher("WEB-INF/casino.jsp").forward(request, response);
    }
}
