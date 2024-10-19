/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author DELL
 */
public class User {
    public String nomU,pass,role;
    public User (String nomU,String pass,String role){
        this.nomU=nomU;
        this.pass=pass;
        this.role=role;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
