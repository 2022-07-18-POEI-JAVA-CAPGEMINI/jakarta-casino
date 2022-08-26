package com.poe.poe20220718.casino;

import java.io.IOException;
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
        
       request.getRequestDispatcher("WEB-INF/casino.jsp").forward(request, response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws IOException, ServletException
     {
      
//        String nouveauMot = request.getParameter("mot");
//       
//        // String phrase = request.getParameter("phrase");
//        String phrase = (String)request.getSession().getAttribute("phrase");
//        if(phrase == null){
//            phrase = "";
//        }
//        
//        String nouvellePhrase = phrase + " " + nouveauMot;
//        
//        request.getSession().setAttribute("phrase", nouvellePhrase);
//        request.setAttribute("phrase", nouvellePhrase);
//        
//       request.getRequestDispatcher("WEB-INF/phrasemagique.jsp").forward(request, response);
    }
}
