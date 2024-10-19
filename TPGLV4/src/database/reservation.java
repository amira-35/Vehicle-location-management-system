/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.util.Date;

/**
 *
 * @author aymen
 */
public class reservation {
    public int id;
    public int dure;
    public String matricule,permis;
    public String  dd,df;
    public reservation(int dure,String dd, String df,String matricule,String permis){
        this.dure = dure;
        this.dd = dd;
        this.df = df;
        this.matricule = matricule;
        this.permis = permis;
    }
    public reservation(int id,int dure,String dd, String df,String matricule,String permis){
        this.dure = dure;
        this.dd = dd;
        this.df = df;
        this.matricule = matricule;
        this.permis = permis;
        this.id = id;
    }
}
