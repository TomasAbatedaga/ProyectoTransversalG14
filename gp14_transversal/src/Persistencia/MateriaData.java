/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alumno;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abate
 */
public class MateriaData {
    private Connection con = null;
    
    public MateriaData(){
        con = Conexion.getConectar();
    }
    
    public void agregarMateria(Materia m){
        
        String sql = "INSERT INTO materia(nombre, anio, estado) VALUES (?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setBoolean(3, m.isEstado());
            
            int registros = ps.executeUpdate();
            System.out.println(registros);
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                m.setId_materia(rs.getInt(1));
                System.out.println("Alta Exitosa");
            } else{
                System.out.println("No se pudo obtener el id");
            }
        } catch (SQLException ex) {
            System.out.println("Error de conexion: " + ex);
        }    
    }
    
    public List<Materia> listarMaterias(){
        Materia m = null;
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * from materia";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                materias.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error de conexion: " + ex);
        }   
        return materias;
    }
    
    public Materia buscarMateriaPorNombre (String nombre){
        Materia m = null;
        String sql = "SELECT * FROM materia WHERE nombre = ?";
        PreparedStatement ps;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                }
            System.out.println(m.toString());
        } catch (SQLException ex) {
            System.out.println("No existe esa materia" + ex);
        }
        return m;
    }
    
    public Materia buscarMateriaPorId (int id){
        Materia m = null;
        String sql = "SELECT * FROM materia WHERE id_materia = ?";
        PreparedStatement ps;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, m.getId_materia());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                m = new Materia();
                m.setId_materia(rs.getInt("id_materia"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getBoolean("estado"));
                }
            System.out.println(m.toString());
        } catch (SQLException ex) {
            System.out.println("No existe esa materia" + ex);
        }
        return m;
    }
    
    public void actualizarMateria (Materia m){
        
        String sql = "UPDATE materia SET nombre=?, anio=?, estado=? WHERE nombre=?";
        
        try{
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, m.getNombre());
           ps.setInt(2, m.getAnio());
           ps.setBoolean(3, m.isEstado());
           ps.executeUpdate();
           ps.close();
           System.out.println("Materia actualizada correctamente");
        } catch (SQLException ex) {
           System.out.println("Error de actualizacion " + ex);
        }
    }
    
    public void eliminarMateria(int id){
        
        String sql = "DELETE FROM materia WHERE id_materia=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia eliminada exitosamente");
        } catch (SQLException ex) {
            System.out.println("Error al borrar la materia" + ex);
        }
    }
    
    public void altaLogica(Materia m){
        
        String sql = "UPDATE materia SET estado=1 WHERE id_materia=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getId_materia());
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia dada de alta correctamente");
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion " + ex);
        }
    }
    
    public void bajaLogica(Materia m){
        
        String sql = "UPDATE materia SET estado=0 WHERE id_materia=?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getId_materia());
            ps.executeUpdate();
            ps.close();
            System.out.println("Materia dada de baja correctamente");
        } catch (SQLException ex) {
            System.out.println("Error de actualizacion " + ex);
        }
    }
    
}
