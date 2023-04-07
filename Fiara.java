
import etu1993.framework.annotation.UrlMap;
import etu1993.framework.ModelView;
import java.util.Vector;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
    public Fiara(){}
    public Fiara( String nom,  double prenom, double salaire) {
     
        this.marque = nom;
        this.nombre = prenom;
        this.achat= salaire;
    }
    
    @UrlMap(path = "/isany")
    public ModelView nbrActuel(double a, double b){
        ModelView modelView = new ModelView("fiara.jsp");
        double val = a + b;
        setNombre(val);
        setAchat(0.0);
        return modelView;
            
    }
    public Vector<Fiara> lists(){
        Fiara sof1 = new Fiara("MERCO",2,21);
        Fiara sof2 = new Fiara("ASTON",3,2);
        Vector<Fiara> list = new Vector<>();
        list.add(sof1);
        list.add(sof2);
        return list;
    }

}
