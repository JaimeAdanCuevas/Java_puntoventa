/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author JaimeAdan
 */
public class Conexion {
    
    private String db = "system_ventas";
    private String user = "root";
    private String password = "Iliana12";
    private String urlMysql = "jdbc:mysql://localhost/" + db;
    private String urlSql = "jdbc:sqlserver://localhost:1433;databaseName="+db+";integratedSecurity=true;";
    private Connection conn = null;
    private Connection conn2 = null;
    
    public Conexion(){
        
        try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(this.urlMysql, this.user, this.password);
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn2 = DriverManager.getConnection(urlSql);

             if(conn != null){
                 System.out.println("Conexion a la base de datos " + this.db + "...... Listo");
             }
             if(conn2 != null){
                 System.out.println("Conexion a la base de datos " + this.db + "...... Listo");
             }
             
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
      
    }

    public Connection getConn() {
        return conn;
    }

    public Connection getConn2() {
        return conn2;
    }
    
    
    
    
    
}
