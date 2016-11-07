import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DBInteraction{
    private Connection con;
    private Statement stmt;
    
    public DBInteraction() throws SQLException{
        String url = "jdbc:mysql://kc-sce-appdb01.kc.umkc.edu/slnz8b";
        String userID = "slnz8b";
        String password = "tZrFLVzffV";
   
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(java.lang.ClassNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }
       
        con = DriverManager.getConnection(url,userID,password);
        stmt = con.createStatement();
        try {
        	ResultSet tempRS = stmt.executeQuery("SELECT question FROM questions;");
        	tempRS.next();
        }
        // table is not present, make it
        catch (SQLException e){
            String sqlCmd = "create table Questions (question_id INT NOT NULL AUTO_INCREMENT, question VARCHAR(264), PRIMARY KEY (question_id));";
            stmt.executeUpdate(sqlCmd);
        }
        try {
        	ResultSet tempRS = stmt.executeQuery("SELECT answer FROM answers;");
        	tempRS.next();
        }
        // table is not present, make it
        catch (SQLException e){
            String sqlCmd = "create table Answers (answer_id INT NOT NULL AUTO_INCREMENT, question_id_fk INT NOT NULL, answer VARCHAR(264), PRIMARY KEY (answer_id));";
            stmt.executeUpdate(sqlCmd);
        }
    }
    
}
	