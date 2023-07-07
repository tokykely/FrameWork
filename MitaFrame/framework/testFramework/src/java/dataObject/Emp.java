/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dataObject;

import etu1993.FileUpload;
import etu1993.ModelView;
import etu1993.framework.myAnnotation.MethodAnnotation;
import java.io.File;

/**
 *
 * @author mita
 */
public class Emp {
    String nom;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }   
    
    public Emp(String nom){
        setNom(nom);
    }
    
    public Emp(){}
    
    @MethodAnnotation(url = "appelMoi")
    public ModelView callMe(){
        ModelView mv = new ModelView();
        mv.setView("testView.jsp");
        Emp[]emps = {new Emp("Jean"), new Emp("Jeanne")};
        mv.addItem("empList", emps);
        return mv;
    }
    
    @MethodAnnotation(url = "empSave")
    public ModelView save(){
        ModelView mv = new ModelView();
        mv.setView("formEmp.jsp");
        System.out.println("nom "+this.getNom());
        return mv;
    }
    
    
    @MethodAnnotation(url = "empSave")
    public ModelView save(int id){
        ModelView mv = new ModelView();
        mv.setView("formEmp.jsp");
        System.out.println("id "+id);
        return mv;
    }
    
    @MethodAnnotation(url = "empSave")
    public ModelView save(String nom){
        ModelView mv = new ModelView();
        mv.setView("formEmp.jsp");
        System.out.println("nom+++"+nom);
        return mv;
    }
    
    @MethodAnnotation(url = "showArray")
    public ModelView show(int[]noms){
        ModelView mv = new ModelView();
        mv.setView("formArray.jsp");
        for(int nom : noms){
            System.out.println(nom);
        }
        return mv;
    }
    
    
    
}
