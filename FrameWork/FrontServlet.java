/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu1993.framework.servlet;
import etu1993.framework.annotation.*;
import etu1993.framework.ModelView;
import etu1993.framework.Mapping;
import exception.UrlInconue;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import etu1993.framework.Mapping;
import etu1993.framework.annotation.UrlMap;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;import exception.UrlInconue;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    @Override
    public void init() throws ServletException{
        String[] classeNames = {"classes.Fiara.java","classes.Chauffeur.java"};
        HashMap<String, Mapping> mappingurl = new HashMap<>();
        for(String classeName : classeNames){
            Class<?> classe =null;
            try{
                classe = Class.forName(classeName);
                }

            catch(ClassNotFoundException ex){
                Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null,ex);
            }
            Method[] methods = classe.getDeclaredMethods();
            for (Method metHod : methods){
                    UrlMap url = metHod.getAnnotation(UrlMap.class);
                    if (url != null){
                        Class<?> conteneurClass = metHod.getDeclaringClass();
                        /*this.setMethod(method.getName());
                        this.setAnnotation(annotation.toString());
                        this.setClasses(conteneurClass.getName());*/
                        Mapping mapping = new Mapping(conteneurClass.getName(),metHod.getName());
                        mappingurl.put(url.path(), mapping);
                    }
            }
        }
          this.setMappingUrls(mappingurl);
    }
        
    public ModelView check(String url) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, UrlInconue, InstantiationException{
        if(this.getMappingUrls().containsKey(url)){
            String classname = this.getMappingUrls().get(url).getClassname();
            String methode = this.getMappingUrls().get(url).getMethod();
            Class<?> classe = Class.forName(classname);
            Method method = classe.getDeclaredMethod(methode);
            Object objet = classe.newInstance();
            ModelView mv = (ModelView)method.invoke(objet);
            return mv;
        }else{
            throw new UrlInconue();
        }
    }
    


protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String url = request.getServletPath();
        ModelView mv;
        try {
            mv = this.check(url);
            RequestDispatcher dispatcher = request.getRequestDispatcher(mv.getView());
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UrlInconue ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}

/*
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        this.hashmappingUrls();
        try (PrintWriter out = response.getWriter()) {
          
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> URL : " + request.getServletPath() + "</h1>");
            
            out.println("<h1> Method: " + this.getMethod() + "</h1>");
            out.println("<h1> Annotation: " + this.getAnnotation() + "</h1>");
            out.println("<h1> Annotation: " + this.getClasses() + "</h1>");
            
            out.println("<h1> Annotation: " + this.getMappingUrls().get("/karama").getMethod() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

*/



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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
                processRequest(request, response);            
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
           
                processRequest(request, response);
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