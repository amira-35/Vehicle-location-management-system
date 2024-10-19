/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.text.ParseException;
public class facture {
    
    public int nfacture,nc;
    public String lieu,datefacture,obs;
    public float kilofin,montant;
    public facture (int nfacture,String lieu ,String datefacture ,float kilofin,float montant, int nc,String obs ){
        this.datefacture=datefacture;
        this.kilofin=kilofin;
        this.lieu=lieu;
        this.montant=montant;
        this.nc=nc;
        this.nfacture=nfacture;
             this.obs=obs;
    }
      public facture (String lieu ,String datefacture ,float kilofin,float montant, int nc, String obs ){
        this.datefacture=datefacture;
        this.kilofin=kilofin;
        this.lieu=lieu;
        this.montant=montant;
        this.nc=nc;
        this.obs=obs;
        
    }
    
    }
