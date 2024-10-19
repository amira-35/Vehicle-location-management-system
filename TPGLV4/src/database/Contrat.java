/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.text.ParseException;

/**
 *
 * @author aymen
 */
public class Contrat {
    public String dc,typeP,typeC,dr,ds,obs;
    public int ncontrat,nreserv;
    public float kilod;

    public Contrat(int nreserv,String dc,String ds,String dr,String typeP,String typeC,float kilod,String obs) throws ParseException{
        
        this.dc = dc;
        this.dr = dr;
        this.ds = ds;
        this.nreserv = nreserv;
        this.typeC = typeC;
        this.typeP = typeP;
        this.kilod = kilod;
        this.obs=obs;
    }
     public Contrat(int ncontrat,int nreserv,String dc,String ds,String dr,String typeP,String typeC,float kilod,String obs) throws ParseException{
        this.ncontrat=ncontrat;
        this.dc = dc;
        this.dr = dr;
        this.ds = ds;
        this.nreserv = nreserv;
        this.typeC = typeC;
        this.typeP = typeP;
        this.kilod = kilod;
        this.obs=obs;
    }
}
