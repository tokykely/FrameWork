/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu1993;

import java.util.HashMap;

/**
 *
 * @author mitantsoa
 */
public class ModelView {
    String view ;
    HashMap<String, Object> data ;
    
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public HashMap<String, Object> getData() {
        return data;
    }
    
    public ModelView(){
        data = new HashMap<>();
    }
    
    public void addItem(String key, Object value){
        data.put(key, value);
    }
    
    
    
}
