/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import etu1993.framework.annotation.UrlMap;
import etu1993.framework.*;
import etu1993.framework.ModelView;
import java.util.Vector;


public class Chauffeur {
    String nom;
    double vaika;
    double karama;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getVaika() {
        return vaika;
    }

    public void setVaika(double vaika) {
        this.vaika = vaika;
    }

    public double getKarama() {
        return karama;
    }

    public void setKarama(double karama) {
        this.karama = karama;
    }
    public Chauffeur( String nom,  double prenom, double salaire) {
     
        this.nom = nom;
        this.vaika = prenom;
        this.karama = salaire;
    }



    public Chauffeur(){}
    @UrlMap(path= "/karama")
    public ModelView realKarama(double a, double b){
        ModelView modelView = new ModelView("chauffeur.jsp");
        double val = a + b;
        return modelView;
    }
     public Vector<Chauffeur> lists(){
        Chauffeur sof1 = new Chauffeur("BERA",3.0,23432);
        Chauffeur sof2 = new Chauffeur("RIM",4.0,600000);
        Vector<Chauffeur> list = new Vector<>();
        list.add(sof1);
        list.add(sof2);
        return list;
    }
 
    
}
