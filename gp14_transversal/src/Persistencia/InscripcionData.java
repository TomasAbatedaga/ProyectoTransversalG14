/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alumno;
import Modelo.Inscripcion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author USURIO
 */
public class InscripcionData {
     private Connection con = null;
     private Alumno alum;
    
    public InscripcionData(){
        con = Conexion.getConectar();
    }
    
    public void agregarInscripcion(Inscripcion ins){
        String sql = "INSERT INTO Inscripcion(nota, id_alumno, id_materia) VALUES (?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ins.getNota());
            ps.setInt(2, ins.getId_alumno());
            ps.setInt(3, ins.getId_materia());
            
            int registros = ps.executeUpdate();
            System.out.println(registros);
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                ins.setId_inscripto(rs.getInt(1));
                System.out.println("Alta Exitosa");
            } else{
                System.out.println("No se pudo obtener el id");
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion: " + ex);
        }    
    }
    
    
   public void inscribir(){
       
       
       
       
       
   }
    
    public void anular(){
        
        
        
        
        
    }
    
    
    
    
    
    
    
}
