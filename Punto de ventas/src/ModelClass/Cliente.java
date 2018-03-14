/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelClass;

import Connection.Consult;
import Models.Clientes;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JaimeAdan
 */
public class Cliente extends Consult{
   // private Consult consult = new Consult();
    private DefaultTableModel modelo;
    private List<Clientes> cliente, clienteFilter;
    private int IdCliente;
    private String Id;
    private String sql;
    private Object[] object;
    
    public void insertCliente(String ID, String Nombre, String Apellido, String Direccion, String Telefono){
        sql = "Insert into clientes(ID,Nombre,Apellido,Direccion,Telefono)" + "Values(?,?,?,?,?)";
        
        object = new Object[]{ID,Nombre,Apellido,Direccion,Telefono};
        insert(sql, object);
        insert2(sql, object);
        cliente = clientes();
        cliente.forEach(item ->{
        IdCliente = item.getIdCliente();
        Id = item.getID();
    });
        
        sql = "Insert into reportes_clientes(IdCliente,SaldoActual, FechaActual, UltimoPago, FechaPago,ID)" + "Values(?,?,?,?,"
                + "?,?)";
        
        object = new Object[]{IdCliente, "$0.00", "Sin fecha","0.00", "Sin fecha", Id};
        insert(sql, object);
        insert2(sql, object);
    }
    
    public List<Clientes> getClientes(){
        return clientes();
    }
    
    public void searchCliente(JTable table, String campo, int num_registro, int reg_por_pagina){
        String [] registros = new String[6];
        String [] titulos = {"Id", "ID", "Nombre", "Apellido", "Direccion", "Telefono"};
        modelo = new DefaultTableModel(null, titulos);
        cliente = clientes();
        if(campo.equals("")){
            clienteFilter = cliente.stream()
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }else{
            clienteFilter = cliente.stream()
                    .filter(C -> C.getID().startsWith(campo) || C.getNombre().startsWith(campo) 
                    || C.getApellido().startsWith(campo))
                    .skip(num_registro).limit(reg_por_pagina)
                    .collect(Collectors.toList());
        }
        
        clienteFilter.forEach(item ->{
            registros[0] = String.valueOf(item.getIdCliente());
            registros[1] = String.valueOf(item.getID());
            registros[2] = String.valueOf(item.getNombre());
            registros[3] = String.valueOf(item.getApellido());
            registros[4] = String.valueOf(item.getDireccion());
            registros[5] = String.valueOf(item.getTelefono());
            modelo.addRow(registros);
        });
        table.setModel(modelo);
        table.setRowHeight(30);
    }
    
}
