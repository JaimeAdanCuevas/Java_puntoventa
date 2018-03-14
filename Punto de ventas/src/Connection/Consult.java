/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Models.Clientes;
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
public class Consult extends Conexion {
    private QueryRunner QR = new QueryRunner();
    private List<Clientes>cliente;
    
    public List<Clientes> clientes(){
        try {
            cliente = (List<Clientes>) QR.query(getConn(), "Select *from clientes", new BeanListHandler(Clientes.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
        
        return cliente;
    }
    
    public void insert(String sql, Object[] data){
        final QueryRunner qr = new QueryRunner(true);
        try {
            qr.insert(getConn(), sql, new ColumnListHandler(), data);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
    }
    
    /**
     * @return ******************************************///sqlserver
    
     public List<Clientes> clientes2(){
        try {
            cliente = (List<Clientes>) QR.query(getConn2(), "Select *from clientes", new BeanListHandler(Clientes.class));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error : " + ex);
        }
        
        return cliente;
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
