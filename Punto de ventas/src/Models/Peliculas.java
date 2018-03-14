/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author JaimeAdan
 */
public class Peliculas {
    
    private int IdPelicula;
    private String ID;
    private String Descripcion;
    private String precioUni;
    private String precioMay;
    private String Sala;
    private String Categoria;

    public Peliculas() {
        
    }

   /* public Peliculas(int IdPelicula, String ID, String Descripcion, String precioUni, String precioMay, String Sala, String Categoria) {
        this.IdPelicula = IdPelicula;
        this.ID = ID;
        this.Descripcion = Descripcion;
        this.precioUni = precioUni;
        this.precioMay = precioMay;
        this.Sala = Sala;
        this.Categoria = Categoria;
    }*/

    public int getIdPelicula() {
        return IdPelicula;
    }

    public void setIdPelicula(int IdPelicula) {
        this.IdPelicula = IdPelicula;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(String precioUni) {
        this.precioUni = precioUni;
    }

    public String getPrecioMay() {
        return precioMay;
    }

    public void setPrecioMay(String precioMay) {
        this.precioMay = precioMay;
    }

    public String getSala() {
        return Sala;
    }

    public void setSala(String Sala) {
        this.Sala = Sala;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
    
    
}
