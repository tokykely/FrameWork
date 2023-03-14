/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu1993.framework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import etu1993.framework.Mapping;
import etu1993.framework.annotation.UrlMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author toky
 */
@WebServlet(name = "FrontServlet", urlPatterns = {"/"})
public class FrontServlet extends HttpServlet {

        HashMap<String,Mapping> MappingUrls;
        String method;
        String annotation;
        String classes;

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> MappingUrls) {
        this.MappingUrls = MappingUrls;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
        
    public void hashmappingUrls() throws ClassNotFoundException{
        String[] classeNames = {"etu1993.framework.classes.Fiara","etu1993.framework.classes.Chauffeur"};
        HashMap<String, Mapping> mappingurl = new HashMap<>();
        for(String classeName : classeNames){
            Class<?> classe = Class.forName(classeName);
            Method[] methods = classe.getDeclaredMethods();
            for (Method method : methods){                   
                    UrlMap url = method.getAnnotation(UrlMap.class);
                    if (url != null){
                        Class<?> conteneurClass = method.getDeclaringClass();
                        /*this.setMethod(method.getName());
                        this.setAnnotation(annotation.toString());
                        this.setClasses(conteneurClass.getName());*/
                        Mapping mapping = new Mapping(conteneurClass.getName(),method.getName());
                        mappingurl.put(url.path(), mapping);
                    }
            }
        }
          this.setMappingUrls(mappingurl);
    }
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        this.hashmappingUrls();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + request.getServletPath() + "</h1>");
            /*
            out.println("<h1> Method: " + this.getMethod() + "</h1>");
            out.println("<h1> Annotation: " + this.getAnnotation() + "</h1>");
            out.println("<h1> Annotation: " + this.getClasses() + "</h1>");
            */
            out.println("<h1> Annotation: " + this.getMappingUrls() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}