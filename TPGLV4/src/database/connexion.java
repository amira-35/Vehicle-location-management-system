/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


//import Utilisateur_Client.Connection;
import java.sql.*;
import java.util.Objects;
import javax.swing.table.TableModel;


/**
 *
 * @author DELL
 */
public class connexion {

    
   
        
           
            
        String lien = "jdbc:mysql://localhost:3306/projet_gl"; //hada le lien yeji standard brk mor 3306 LE Nom BDD
        String user = "root";
        String pass = "11102001Blida";    

        void connexion () throws SQLException{
            Connection myConn =  DriverManager.getConnection(lien ,user , pass);
        }
        //les utiliqateurs
        public boolean VerifierNomUtilisateur(String nomU) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from users where NomUtilisateur = '"+nomU+"'";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if ( myRs.next()){
                return true;
            }
            else {
              
                return false;
                
            }
            
            
        } 
        public boolean VerifierMotDePasse(String nomU , String pass) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
             Connection myConn ;
            String req ="select * from users where NomUtilisateur = '"+nomU+"'and Password ='"+pass+"'";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                User uti = new User(myRs.getString(1),myRs.getString(2),myRs.getNString(3));
                return true;
                
            }
            else {
                return false;
            }
            
            
        } 
        public int countUsers() throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from users;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        } 
        public String ReturnRole(String nomU , String pass) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select Role from users where NomUtilisateur = '"+nomU+"'and Password ='"+pass+"'";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                return myRs.getString(1);
                
            }
            else {
                return "Erreur";
            }
        
        }  
        public String[][]  AfficherLaBase(int nombreUsers) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
             Connection myConn ;
             String [][] Mat = new String [nombreUsers][3];
            String req ="select * from users;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){
                
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                
                i++;
               
                
            }
            return Mat ;
            
            
        }
        public boolean  Ajouter_Utilisateur(User U) throws SQLException{
             Connection myConn ;
             String sql = "insert into users(NomUtilisateur,Password,Role)" + "values(?,?,?);";
                 myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
             PreparedStatement var = myConn.prepareStatement(sql);
             var.setString(1,U.nomU);
             var.setString(2,U.pass);
             var.setString(3,U.role);
             var.execute();
             myConn.close();
             return true;
            
          
        
            // 1. Get a connection to database
        }
        public boolean ModifierUtilisateur(User u,String Utilisateur) throws SQLException{
            Connection myConn ;
            String sql = "UPDATE users SET NomUtilisateur=?,Password=?,Role=? WHERE NomUtilisateur ='"+ Utilisateur +"';";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setString(1, u.nomU);
            preparedStmt.setString(2, u.pass);
            preparedStmt.setString(3, u.role);
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }
        }
        public User GetUser(String NomUtilisateur) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
             Connection myConn ;
            String req ="select * from users where NomUtilisateur = '"+ NomUtilisateur +"';";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                User TEmp = new User(myRs.getString(1),myRs.getString(2),myRs.getNString(3));
                return TEmp;
                
            }
           User TEmP = new User("erreur","erreur","erreur");
           return TEmP;
        }
        public boolean SuppUser(String NomUtu) throws SQLException{
            Connection myConn ;
            String sql = "DELETE FROM users WHERE NomUtilisateur =?;";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setString(1, NomUtu);
            preparedStmt.execute();
            myConn.close();
            return true;
        }
        // les vehicules
        
        public boolean VerfierMatricule(String matricule) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from vehicule where matricule = '"+matricule+"'";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if ( myRs.next()){
                return true;
            }
            else {
              
                return false;
                
            }
                    
        }
        public int countVehicules() throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from vehicule;";
            myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        }
        public String[][] AfficherVehicule(int nombreVehicuel) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nombreVehicuel][10];
            String req ="select * from vehicule;";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){
                
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);
                Mat [i][6]=myRs.getString(7);
                Mat [i][7]=myRs.getString(8);
                Mat [i][8]=myRs.getString(9);
                Mat [i][9]=myRs.getString(10);
                i++;
            }
            return Mat ;
        }
        public boolean  Ajouter_Vehicule(vehicule V) throws SQLException{
             Connection myConn ;
             String sql = "INSERT INTO vehicule (matricule, modele, couleur, type, anneemodele, puissance, carburant, etat, coutparjour, coutparkilo)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
             PreparedStatement var = myConn.prepareStatement(sql);
             var.setString(1,V.matricule);
             var.setString(4,V.type);
             var.setString(5,V.anneedemodele);
             var.setFloat(9,V.coutParjour);
             var.setFloat(10,V.CouParkilo);
             var.setString(3,V.couleur);
             var.setString(6,V.puissance);
             var.setString(2,V.modele);
             var.setString(7,V.carburant);
             var.setString(8,V.etat);
             var.execute();
             myConn.close();
             return true;
        }
        public boolean ModifierVehicuel(vehicule v,String matricule) throws SQLException{
            Connection myConn ;
            String sql = "UPDATE vehicule SET matricule=?,modele=?,couleur=?,type=?,anneemodele=?,puissance=?,carburant=?,etat=?,coutparjour=?,coutparkilo=? WHERE matricule ='"+ matricule +"';";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setString(1, v.matricule);
            preparedStmt.setString(4, v.type);
            preparedStmt.setString(5, v.anneedemodele);
            preparedStmt.setFloat(9, v.coutParjour);
            preparedStmt.setFloat(10, v.CouParkilo);
            preparedStmt.setString(3, v.couleur);
            preparedStmt.setString(6, v.puissance);
            preparedStmt.setString(2, v.modele);
            preparedStmt.setString(7, v.carburant);
            preparedStmt.setString(8, v.etat);
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }
        }
        public vehicule GetVehicul(String matriucle) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from vehicule where matricule = '"+matriucle+"';";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                vehicule TEmp = new vehicule(myRs.getString(1),myRs.getString(2),
                        myRs.getString(3),myRs.getString(4),myRs.getString(5),
                        myRs.getString(6),myRs.getString(7),myRs.getString(8),
                        myRs.getFloat(9),myRs.getFloat(10));
                return TEmp;
            }
           vehicule TEmP = null;
           return TEmP;
        }
        public boolean SuppVehi(String matricule) throws SQLException{
            Connection myConn ;
            String sql = "DELETE FROM vehicule WHERE matricule =?;";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setString(1, matricule);
            preparedStmt.execute();
            myConn.close();
            return true;
        }
        //les clients
    public boolean VerifierClient(String idclient) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from client where permis = '"+idclient+"'";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if ( myRs.next()){
                return true;
            }
            else {
              
                return false;
                
            }
            
            
        } 
    public int countClients() throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from client;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        } 
    public String[][] AfficherClient(int nombreClients) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nombreClients][6];
            String req ="select * from client;";
            myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){
                
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);
              
              
                i++;
            }
            return Mat ;
        }
    public boolean  Ajouter_Client(Client V) throws SQLException{
             Connection myConn ;
             String sql = "INSERT INTO client ( permis, prenom, nom, genre, adresse,telephone)" + " VALUES (?, ?, ?, ?, ?, ?);";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
             PreparedStatement var = myConn.prepareStatement(sql);
            
             var.setString(1,V.permis);
             var.setString(2,V.prenom);
             var.setString(3,V.nom);
             var.setString(4,V.genre);
             var.setString(5,V.adresse);
             var.setString(6,V.telephone);
             var.execute();
             myConn.close();
             //idclient, permis, prenom, nom, genre, adresse,email,telephone
             return true;
        }
    public boolean ModifierClient(Client v,String idclient) throws SQLException{
            Connection myConn ;
            String sql = "UPDATE client SET permis=?,prenom=?,nom=?,genre=?,adresse=?,telephone=? WHERE permis ='"+ idclient +"';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
         
            preparedStmt.setString(1, v.permis);
            preparedStmt.setString(2, v.prenom);
            preparedStmt.setString(3, v.nom);
            preparedStmt.setString(4, v.genre);
            preparedStmt.setString(5, v.adresse);
          
            preparedStmt.setString(6,v.telephone);
          
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }
        }
    public Client GetClient(String idclient) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from client where permis = '"+idclient+"';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                Client TEmp = new Client(myRs.getString(1),myRs.getString(2),
                        myRs.getString(3),myRs.getString(4),myRs.getString(5),
                        myRs.getString(6));
                return TEmp;
            }
           Client TEmP = null;
           return TEmP;
        }
    public boolean SuppClient(String idclient) throws SQLException{
            Connection myConn ;
            String sql = "DELETE FROM client WHERE permis=?;";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setString(1, idclient);
            preparedStmt.execute();
            myConn.close();
            return true;
        }
    public String[] Selectionner_client(String Client_id) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [] Mat = new String[3];
            String req ="select permis,nom,prenom from client WHERE permis ='"+ Client_id +"';";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                Mat [0]=myRs.getString(1);
                Mat [1]=myRs.getString(2);
                Mat [2]=myRs.getString(3);
            }
            return Mat ;
    }
    //vehicule
    public String [] Selectionner_Vehicule(String matriucle) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select matricule,modele,type from vehicule where matricule = '"+matriucle+"';";
             myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                String [] Temp = new String[3];
                Temp [0]=myRs.getString(1);
                Temp [1]=myRs.getString(2);
                Temp [2]=myRs.getString(3);
                return Temp;
            }
           String [] Temp = {"null;","null;","null;"};
           return Temp;
        }
    //reservation
   public String[][] AfficherResev(int nombreClients) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nombreClients][6];
            String req ="select * from reservation;";
                    myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){ 
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);

                i++;
            }
            return Mat ;
        }
   public int countReserv() throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from reservation;";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        }
   public boolean AjouterReserv(reservation v) throws SQLException{
             Connection myConn ;
          
             String sql = "INSERT INTO reservation (dure, ddebut, dfin, matricule,permis)" + " VALUES (?, ?, ?, ?, ?);";
             myConn =  DriverManager.getConnection(this.lien,this.user, this.pass);
             PreparedStatement var = myConn.prepareStatement(sql);
             var.setInt(1,v.dure);
             var.setString(2,v.dd);
             var.setString(3,v.df);
             var.setString(4,v.matricule);
             var.setString(5,v.permis);
             var.execute();
             myConn.close();
            
             return true;
   }
   public boolean SuppResr(int id) throws SQLException{
            Connection myConn ;
            String sql = "DELETE FROM reservation WHERE nresrv =?;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setInt(1, id);
            preparedStmt.execute();
            myConn.close();
            return true;
        }
   public String [] Selectionner_Reserv(int id) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select nresrv,dure,matricule,permis from reservation where nresrv = '"+id+"';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                String [] Temp = new String[4];
                Temp [0]=myRs.getString(1);
                Temp [1]=myRs.getString(2);
                Temp [2]=myRs.getString(3);
                Temp [3]=myRs.getString(4);
                return Temp;
            }
           String [] Temp = {"null;","null;","null;","null;"};
           return Temp;
   }
     public reservation getReserv(int id) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from reservation where nresrv = "+Integer.toString(id)+";";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                reservation TEmp = new reservation(myRs.getInt(1),myRs.getInt(2),
                        myRs.getString(3),myRs.getString(4),myRs.getString(5),
                        myRs.getString(6));
                return TEmp;
            }
           reservation TEmP = null;
           return TEmP;
   }
   public boolean Modier_Reserv(reservation v) throws SQLException{
           Connection myConn ;
            String sql = "UPDATE reservation SET dure=?,ddebut=?,dfin=?,matricule=?,permis=? WHERE nresrv ="+ Integer.toString(v.id)+";";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
             reservation tempo=getReserv(v.id);
             ChangerEtatV(tempo.matricule,"disponible");
             
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            
         
            preparedStmt.setInt(1, v.dure);
            preparedStmt.setString(2, v.dd);
            preparedStmt.setString(3, v.df);
            preparedStmt.setString(4, v.matricule);
            preparedStmt.setString(5, v.permis);
            ChangerEtatV(v.matricule,"reservé");
            
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }  
   }
   // changer l'etat de vehicule losqu'elle devient reservé
   public boolean ChangerEtatV(String matricule,String etat) throws SQLException{
            Connection myConn ;
            String sql = "UPDATE vehicule SET etat='"+ etat + "' WHERE matricule ='"+ matricule +"';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }
   }
 
   // fonction qui affiche les vehicule réservé 
   public String[][] AfficherVehicule2(int nombreVehicuel) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nombreVehicuel][10];
            String req ="select * from vehicule WHERE etat='disponible';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){
                
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);
                Mat [i][6]=myRs.getString(7);
                Mat [i][7]=myRs.getString(8);
                Mat [i][8]=myRs.getString(9);
                Mat [i][9]=myRs.getString(10);
                i++;
            }
            return Mat ;
        }
   public int countVehicules2() throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from vehicule WHERE etat='disponible';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        }
   public String [] Selectionner_Vehicule_2(String matriucle) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select matricule,modele,coutparjour from vehicule where matricule = '"+matriucle+"';";
                myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                String [] Temp = new String[3];
                Temp [0]=myRs.getString(1);
                Temp [1]=myRs.getString(2);
                Temp [2]=myRs.getString(3);
                return Temp;
            }
           String [] Temp = {"null;","null;","null;"};
           return Temp;
        }
  // contrat 
   public boolean AjouterContrat(Contrat v) throws SQLException{
             Connection myConn ;
             String sql = "INSERT INTO contrat (dc, ds, dr, tpaiment,typconrat,nresrv,Kilo,observation)" + " VALUES (?, ?, ?, ?, ?, ?, ?,?);";
                 myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
             PreparedStatement var = myConn.prepareStatement(sql);
             var.setString(1,v.dc);
             var.setString(2,v.ds);
             var.setString(3,v.dr);
             var.setString(4,v.typeP);
             var.setString(5,v.typeC);
             var.setInt(6, v.nreserv);
             var.setFloat(7, v.kilod);
             var.setString(8, v.obs);
             var.execute();
             myConn.close();
             return true;
   }
   public String[][] AfficherContart(int nombreClients) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nombreClients][8];
            String req ="select ncont,dc, ds, dr, tpaiment,typconrat,nresrv,Kilo from contrat;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){ 
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);
                Mat [i][6]=myRs.getString(7);
                Mat [i][7]=myRs.getString(8);
                i++;
            }
            return Mat ;
        }
   public int countCountart() throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from contrat;";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        } 
   public String[] SelectionnerContrat(String nContrat) throws SQLException {
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from contrat where ncont = "+ nContrat +";";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                String [] Temp = new String[9];
                Temp [0]=myRs.getString(1);
                Temp [1]=myRs.getString(2);
                Temp [2]=myRs.getString(3);
                Temp [3]=myRs.getString(4);
                Temp [4]=myRs.getString(5);
                Temp [5]=myRs.getString(6);
                Temp [6]=myRs.getString(7);
                Temp [7]=myRs.getString(8);
                Temp [8]=myRs.getString(9);
                return Temp;
            }
           String [] Temp = {"null;","null;","null;","null;","null;","null;","null;","null;","null;"};
           return Temp;
    }

    public boolean SuppContrat(int ncont) throws SQLException {
        Connection myConn ;
            String sql = "DELETE FROM contrat WHERE ncont =?;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setInt(1, ncont);
            preparedStmt.execute();
            myConn.close();
            return true;
    }
    public boolean ModifierContrat(Contrat v) throws SQLException {
       Connection myConn ;
            String sql = "UPDATE contrat SET dc=?,ds=?,dr=?,tpaiment=? ,typconrat=? ,nresrv=?,Kilo=?,observation=? WHERE ncont ="+ Integer.toString(v.ncontrat)+";";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
          
             
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            
         
            preparedStmt.setString(1, v.dc);
            preparedStmt.setString(2, v.ds);
            preparedStmt.setString(3, v.dr);
            preparedStmt.setString(4, v.typeP);
            preparedStmt.setString(5, v.typeC);
               preparedStmt.setInt(6, v.nreserv);
                  preparedStmt.setFloat(7, v.kilod);
                     preparedStmt.setString(8, v.obs);
  
            
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }  
    }
    //Facture
    public String [] Selection_Contrat(String idCont) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select ncont,nresrv,Kilo,tpaiment from contrat where ncont = "+ idCont +";";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
              myStmt=myConn.createStatement();
              myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                String [] Temp = new String[4];
                Temp [0]=myRs.getString(1);
                Temp [1]=myRs.getString(2);
                Temp [2]=myRs.getString(3);
                Temp [3]=myRs.getString(4);
                return Temp;
            }
           String [] Temp = {"null;","null;","null;","null;"};
           return Temp; 
    }
    public String [] Selectionner_Vehicule_3(String matriucle) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select modele,coutparjour,coutparkilo from vehicule where matricule = '"+matriucle+"';";
             myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                String [] Temp = new String[4];
                Temp [0]=myRs.getString(1);
                Temp [1]=myRs.getString(2);
                Temp [2]=myRs.getString(3);
                Temp [3]=matriucle;
                return Temp;
            }
           String [] Temp = {"null;","null;","null;","null;"};
           return Temp;
        }
    public boolean AjouterFacture(facture v) throws SQLException{
             Connection myConn ;
          
             String sql = "INSERT INTO facture (lieu, datef, kilof,montant,nc,observation)" + " VALUES ( ?, ?, ?, ?,?,?);";
             myConn =  DriverManager.getConnection(this.lien,this.user, this.pass);
             PreparedStatement var = myConn.prepareStatement(sql);
             var.setString(1,v.lieu);
             var.setString(2,v.datefacture);
             var.setFloat(3,v.kilofin);
             var.setFloat(4,v.montant);
             var.setInt(5,v.nc);
            var.setString(6,v.obs);
             var.execute();
             myConn.close();
            
             return true;
   }
    public boolean ModifierFacture(facture v) throws SQLException {
       Connection myConn ;
            String sql = "UPDATE facture SET lieu=?,datef=?,kilof=?,montant=? ,nc=?,observation=? WHERE nfact ="+ Integer.toString(v.nfacture)+";";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
          
             
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            
         
            preparedStmt.setString(1, v.lieu);
            preparedStmt.setString(2, v.datefacture);
            preparedStmt.setFloat(3, v.kilofin);
            preparedStmt.setFloat(4, v.montant);
            preparedStmt.setString(6, v.obs);
               preparedStmt.setInt(5, v.nc);
                  
  
            
            int i = preparedStmt.executeUpdate();
            myConn.close();
            if(i==1){
                return true;
            }
            else{
            return false;
            }  
    }
    public boolean SuppFacture(int nfact) throws SQLException {
        Connection myConn ;
            String sql = "DELETE FROM facture WHERE nfact =?;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            preparedStmt.setInt(1, nfact);
            preparedStmt.execute();
            myConn.close();
            return true;
    }
    public String [][] Afficher_Des_Factures(int nbrFacture) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nbrFacture][8];
            String req ="Select f.nfact,f.lieu,f.datef,f.montant,f.nc,r.permis,cl.nom,cl.prenom from facture f,contrat c,client cl,reservation r where f.nc = c.ncont and c.nresrv = r.nresrv and cl.permis = r.permis;";
               myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
           int i=0;
            while (myRs.next()){ 
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);
                Mat [i][6]=myRs.getString(7);
                Mat [i][7]=myRs.getString(8);
                i++;
            }
            return Mat ;
        }
    
    public int CountFactures() throws SQLException{ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select count(*) from facture;";
             myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            
           
            myStmt=myConn.createStatement();
             
            myRs=myStmt.executeQuery(req);
           
            if (myRs.next()){
                
                return myRs.getInt(1);
                
            }
            else {
              
                return 0;
                
            }
            
            
        }
    public facture getFacture(String id) throws SQLException{
            ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String req ="select * from facture where nfact = "+ id +";";
            myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(req);
            if (myRs.next()){
                facture TEmp = new facture(myRs.getInt(1),myRs.getString(2),
                        myRs.getString(3),myRs.getFloat(4),myRs.getFloat(5),
                        myRs.getInt(6),myRs.getString(7));
                return TEmp;
            }
           facture TEmP = null;
           return TEmP;
    
    }
    public void ContratTermine(int ncont, String etat) throws SQLException{
         Connection myConn ;
            String sql = "UPDATE contrat SET typconrat='"+ etat + "' WHERE ncont ='"+ ncont +"';";
             myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            PreparedStatement preparedStmt = myConn.prepareStatement(sql);
            int i = preparedStmt.executeUpdate();
            myConn.close();
        
    }
    public String [][]  AfficherV(int nombreVehicuel, String type, String modele ,String datef) throws SQLException{//'%"+modele+"%'
        
        
         ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
            String [][] Mat = new String [nombreVehicuel][10];
           String sql="select * from vehicule v LEFT join reservation r on v.matricule=r.matricule where v.type ='"+type+"' and v.modele like '%"+modele+"%' and (v.etat='disponible' or r.dfin < '"+datef+"');";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(sql);
           int i=0;
            while (myRs.next()){
                
                Mat [i][0]=myRs.getString(1);
                Mat [i][1]=myRs.getString(2);
                Mat [i][2]=myRs.getString(3);
                Mat [i][3]=myRs.getString(4);
                Mat [i][4]=myRs.getString(5);
                Mat [i][5]=myRs.getString(6);
                Mat [i][6]=myRs.getString(7);
                Mat [i][7]=myRs.getString(8);
                Mat [i][8]=myRs.getString(9);
                Mat [i][9]=myRs.getString(10);
                i++;
            }
            return Mat ;
    }
    
    public int countvehicule(String type, String modele ,String datef) throws SQLException{
        
         ResultSet myRs;
            Statement myStmt ; 
            Connection myConn ;
                String sql="select count(*) from vehicule v LEFT join reservation r on v.matricule=r.matricule where v.type ='"+type+"' and v.modele like '%"+modele+"%' and (v.etat = 'disponible' or r.dfin < '"+datef+"');";
              myConn =  DriverManager.getConnection(this.lien,this.user , this.pass);
            myStmt=myConn.createStatement();
            myRs=myStmt.executeQuery(sql);
           int i=0;
            if (myRs.next()){
            return myRs.getInt(1);
                        
            }
               return 0;
        
    }    
     

}
          
          
        
      
          
        
    

