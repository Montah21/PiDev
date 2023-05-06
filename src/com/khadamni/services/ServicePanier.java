 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.khadamni.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;
import com.khadamni.entities.Categorie;
import com.khadamni.utils.Statics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mouty
 */
public class ServicePanier {
    //singleton
    public static ServicePanier instance = null ;
    private ConnectionRequest req;
    public static ServicePanier getInstance(){
        if (instance == null)
            instance = new ServicePanier();
        return instance ;
        
    }
    public ServicePanier() {
    req = new ConnectionRequest();
    
    }
    public void ajouterCategorie(Categorie categorie){
        String url =Statics.Base_URL+ "addcategoriestJSON/new?libelle="+categorie.getLibelle()+"&quantite="+categorie.getQuantite() ;
        req.setUrl(url);
        req.addResponseListener((e) ->{
            String str = new String(req.getResponseData());
            System.out.println("data =="+str);
           
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        }
    

public ArrayList<Categorie>affichiercategorie() {
ArrayList<Categorie> result = new ArrayList<>();
String url = Statics.Base_URL+"AllCategories";
req.setUrl(url);
req.addResponseListener(new ActionListener<NetworkEvent>(){
    @Override
    public void actionPerformed(NetworkEvent evt) {
    JSONParser jsonp;
    jsonp = new JSONParser();
    
    try {
        Map<String,Object> mapCategories = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
        
        
        List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapCategories.get("root");
    for(Map<String, Object> obj :listOfMaps){
        Categorie c = new Categorie();
        
        float id = Float.parseFloat(obj.get("id").toString());
        String Libelle = obj.get("libelle").toString();
        String Quantite = obj.get("quantite").toString();
        c.setId((int) id);
        c.setLibelle(Libelle);
        c.setQuantite(0);
        result.add(c);
    }
    }catch (Exception ex){
        ex.printStackTrace();
    }
        
    }
    
    
});
        NetworkManager.getInstance().addToQueueAndWait(req);

return result;
}

}






