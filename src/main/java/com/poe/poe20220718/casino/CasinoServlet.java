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
        
        request.getSession().setAttribute("nombreADeviner", nombreADeviner);
        
        request.getRequestDispatcher("WEB-INF/casino.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException
     {
        String nombreJoueurString = request.getParameter("nombreJoueur");
        int nombreJoueur = Integer.parseInt(nombreJoueurString);
         
        int nombreADeviner = (int)request.getSession().getAttribute("nombreADeviner");
        
        int tentativesRestantes = (int)request.getSession().getAttribute("tentativesRestantes");
        tentativesRestantes = tentativesRestantes - 1;
        request.getSession().setAttribute("tentativesRestantes", tentativesRestantes);
        
        
        request.setAttribute("nombreJoueur", nombreJoueur);
        request.getRequestDispatcher("WEB-INF/casino.jsp").forward(request, response);
    }
}
