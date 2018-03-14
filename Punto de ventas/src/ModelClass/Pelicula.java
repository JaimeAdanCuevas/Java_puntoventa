/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import Connection.Consultpel;
import Models.Peliculas;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JaimeAdan
 */
public class Pelicula extends Consultpel{
    private DefaultTableModel modelo;
    private List<Peliculas> pelicula, peliculaFilter;
    private int IdPelicula;
    private String Id;
    private String sql;
    private Object[] object;
    
    public void insertPelicula(String ID, String Descripcion, String precioUni, String precioMay, String Sala, String Categoria){
        sql = "Insert into peliculas(ID,Descripcion,precioUni,precioMay,Sala,Categoria)" + "Values(?,?,?,?,?,?)";
        
        object = new Object[]{ID,Descripcion,precioUni,precioMay,Sala,Categoria};
        insert(sql, object);
        insert2(sql, object);
        pelicula = peliculas();
        pelicula.forEach(item ->{
        IdPelicula = item.getIdPelicula();
        Id = item.getID();
    });
    
}
    
    public List<Peliculas> getProductos(){
        return peliculas();
    }
    
}
