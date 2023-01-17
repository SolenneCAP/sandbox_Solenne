import java.sql.*;
import java.util.ArrayList;


/**
 * Services d'accès à la base de données.
 */
public class DataServices {
    
    private String url = "jdbc:mysql://localhost:3306/accenture";
    private String user = "root";
    private String passwd = "root";
    private String driver = "com.mysql.cj.jdbc.Driver";

    private String formaterNom(String nom, String prenom){
        return prenom + " " + nom;
    }

    public ArrayList<String> getAllApprenants(){
        ArrayList<String> promo = new ArrayList<String>();

        Connection con = null;
        Statement st = null;
        ResultSet rs= null;

        try{
            con = DriverManager.getConnection(url, user, passwd);
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM apprenant");

        	// Stocker les enregistrements pour mise à disposition des clients
            while(rs.next()) {  
                String nom = new String(rs.getString(2)); 
                String prenom = new String(rs.getString(3));
                promo.add(formaterNom(nom, prenom));        
             }              
        }catch(Exception e){
            System.err.println("Exception: " + e.getMessage()); 
        }finally{
            try { 
                if(rs != null) rs.close(); 
                if(st != null) st.close(); 
                if(con != null) con.close(); 
            }catch (SQLException e) { 

            }            
        }

        return promo;
    }
}
