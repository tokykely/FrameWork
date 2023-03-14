/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1993.framework.classes;

import etu1993.framework.annotation.UrlMap;

/**
 *
 * @author toky
 */
public class Fiara {
    String marque;
    double nombre;
    double achat;

    public Fiara(String marque, Double nombre, Double achat) {
        this.marque = marque;
        this.nombre = nombre;
        this.achat = achat;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getNombre() {
        return nombre;
    }

    public void setNombre(Double nombre) {
        this.nombre = nombre;
    }

    public double getAchat() {
        return achat;
    }

    public void setAchat(Double achat) {
        this.achat = achat;
    }
    
    @UrlMap(path = "/isany")
    public double nbrActuel(double a, double b){
        double val = a + b;
        setNombre(val);
        setAchat(0.0);
        return val;
            
    }
}
