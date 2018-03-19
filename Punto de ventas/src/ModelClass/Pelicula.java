/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import Connection.Consultpel;
import Models.Peliculas;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
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
    
    public void insertPelicula(String Nombre, String ID, String Descripcion, String precioUni, String precioMay, String Sala, String Categoria){
        sql = "Insert into peliculas(Nombre,ID,Descripcion,precioUni,precioMay,Sala,Categoria)" + "Values(?,?,?,?,?,?,?)";
        
        object = new Object[]{Nombre,ID,Descripcion,precioUni,precioMay,Sala,Categoria};
        insert(sql, object);
        insert2(sql, object);
        pelicula = peliculas();
        pelicula.forEach(item ->{
        IdPelicula = item.getId_Pelicula();
        Id = item.getID();
    });
    
}
    
    public List<Peliculas> getPelicula(){
        return peliculas();
    }
    
    public void searchPelicula(JTable table, String campo, int num_registro, int reg_por_pagina){
        String [] registros = new String[8];
        String [] titulos = {"Id","Nombre","CodigoPelicula" ,"Descripcion", "precioUni", "precioMay", "Sala", "Categoria"};
        modelo = new DefaultTableModel(null, titulos);
        pelicula = peliculas();
        if(campo.equals("")){
            peliculaFilter = pelicula.stream()
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }else{
            peliculaFilter = pelicula.stream()
                    .filter(C -> C.getID().startsWith(campo) || C.getDescripcion().startsWith(campo) 
                    || C.getPrecioUni().startsWith(campo))
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }
        
        peliculaFilter.forEach(item ->{
            registros[0] = String.valueOf(item.getId_Pelicula());
            registros[1] = item.getNombre();
            registros[2] = String.valueOf(item.getID());
            registros[3] = String.valueOf(item.getDescripcion());
            registros[4] = String.valueOf(item.getPrecioUni());
            registros[5] = String.valueOf(item.getPrecioMay());
            registros[6] = String.valueOf(item.getSala());
            registros[7] = String.valueOf(item.getCategoria());
            modelo.addRow(registros);
        });
        table.setModel(modelo);
        table.setRowHeight(30);
    }
    
}
