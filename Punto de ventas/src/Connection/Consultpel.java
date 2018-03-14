/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Models.Peliculas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author JaimeAdan
 */
public class Consultpel extends Conexion{
    private QueryRunner QR = new QueryRunner();
    private List<Peliculas>pelicula;
    
    public List<Peliculas> peliculas(){
        try {
            pelicula = (List<Peliculas>) QR.query(getConn(), "Select *from peliculas", new BeanListHandler(Peliculas.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
        
        return pelicula;
    }
    
    public void insert(String sql, Object[] data){
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.insert(getConn(), sql, new ColumnListHandler(), data);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
    }
    
    
    public List<Peliculas> Consultpel2(){
        try {
            pelicula = (List<Peliculas>) QR.query(getConn2(), "Select *from peliculas", new BeanListHandler(Peliculas.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
        
        return pelicula;
    }
    
    public void insert2(String sql, Object[] data){
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.insert(getConn2(), sql, new ColumnListHandler(), data);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
    }
    
    
}
