/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author aymen
 */
public class vehicule {
    public String matricule,modele,couleur,type,anneedemodele,puissance,carburant,etat;
    public float coutParjour,CouParkilo;
    public vehicule(String matricule,String modele,String couleur,String type,String anneedemodele,String puissance,String carburant,String etat,float coutParjour,float CouParkilo){
    this.matricule = matricule;
    this.CouParkilo = CouParkilo;
    this.anneedemodele = anneedemodele;
    this.carburant = carburant;
    this.couleur = couleur;
    this.coutParjour = coutParjour;
    this.etat = etat;
    this.modele = modele;
    this.puissance = puissance;
    this.type = type;
    }
}
