/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import etu1993.framework.annotation.UrlMap;


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
    
    @UrlMap(path= "/karama")
    public double realKarama(double a, double b){
        double val = a + b;
        return val;
    }
 
    
}
