/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Alumno;
import Persistencia.Conexion;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USURIO
 */
public class InscripcionData {
     private Connection con = null;
     private Alumno alum;
     private MateriaData materiaData;
     private AlumnoData alumnoData;
     
    
    public InscripcionData(){
        con = Conexion.getConectar();
        this.alumnoData = new AlumnoData();
    this.materiaData = new MateriaData();
    }
    
    public void agregarInscripcion(Inscripcion ins){
        String sql = "INSERT INTO Inscripcion(nota, id_alumno, id_materia) VALUES (?, ?, ?)";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ins.getNota());
            ps.setInt(2, ins.getAlumno().getId_alumno());
            ps.setInt(3, ins.getMateria().getId_materia());
            
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
    
    public void actualizarNota(int idAlumno, int idMateria, int NewNota){
          String sql = "UPDATE inscripcion SET nota=? WHERE id_alumno= ? and id_materia= ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, NewNota);
             ps.setInt(2, idAlumno);
             ps.setInt(3, idMateria);
            
             int filas = ps.executeUpdate();
             if(filas>0){
                 JOptionPane.showMessageDialog(null, "nota actualizada");
             }
             ps.close();
             
             
             
             
             
             
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al actualizar nota");
         }
          
        
        
        
    }
    
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        String sql = "DELETE from inscripcion where id_alumno = ? AND id_materia = ?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
                     ps.setInt(1, idAlumno);
                     ps.setInt(2, idMateria);
                    int filas = ps.executeUpdate();
                    if (filas>0){
                        JOptionPane.showMessageDialog(null, "Inscripcion Borrada");
                    }
                    ps.close();
                     
                     } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder al borrar la inscripcion");
         }
        
        
    }
    
    public List<Inscripcion> obtenerInscripciones(){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
                String sql = "SELECT * FROM inscripcion" ;
         
         try {
             PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion insc = new Inscripcion();
                insc.setId_inscripto(rs.getInt("id_inscripcion"));
                Alumno alu = alumnoData.buscarAlumno(rs.getInt("id_alumno"));
                Materia mat = materiaData.buscarMateriaPorId(rs.getInt("id_materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getInt("nota"));
                
                inscripciones.add(insc);
                
                
                
                
            }
                     ps.close();
                     
                     
                     
                     
                     } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al obtener materias");
         }
        
        
        
       return inscripciones; 
        
    }
    
    public List<Inscripcion> obtenerInscripcioneID(int id){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        
                String sql = "SELECT id_inscripcion, id_alumno, materia.id_materia, materia.nombre, nota FROM inscripcion JOIN materia ON (inscripcion.id_materia = materia.id_materia) WHERE id_alumno = ?;";
         
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Inscripcion insc = new Inscripcion();
                insc.setId_inscripto(rs.getInt("id_inscripcion"));
                Alumno alu = alumnoData.buscarAlumno(rs.getInt("id_alumno"));
                Materia mat = materiaData.buscarMateriaPorId(rs.getInt("id_materia"));
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getInt("nota"));
                
                inscripciones.add(insc);
                
                
                
                
            }
                     ps.close();
                     
                     
                     
                     
                     } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al obtener materias");
         }
        
        
        
       return inscripciones; 
        
    }
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno){
        ArrayList <Materia> materiasCursadas = new ArrayList<>();
       String sql = "SELECT inscripcion.id_materia, nombre, anio, materia.estado FROM inscripcion,"
               + " materia WHERE inscripcion.id_materia = materia.id_materia"
               + " AND inscripcion.id_alumno = ?;";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Materia materia= new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
               
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));
                materiasCursadas.add(materia);
                
                
                
            }
             
             ps.close();
             
             
             
         } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "error al obtener materias cursadas");
         }
        
        
        return materiasCursadas;
    }//funcionando
    
    public List<Materia> obtenerMateriasNoCursadas(int idAlumno){ 
        ArrayList <Materia> materiasNoCursadas = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1 AND id_materia not in "
                + "(SELECT id_materia FROM inscripcion WHERE id_alumno = ?)";
               
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idAlumno);
             ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Materia materia= new Materia();
                materia.setId_materia(rs.getInt("id_materia"));
                
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getBoolean("estado"));
                materiasNoCursadas.add(materia);
                
                
            }
            }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "error al obtener materias NO cursadas");
                    }
       
        return materiasNoCursadas;
    } //funcionando
    
   public List<Alumno>obtenerAlumnosMateria(int idMateria){
       ArrayList<Alumno>alumnosMaterias = new ArrayList<>();
       
      String sql = "SELECT a.id_alumno, dni, nombre, apellido, fecha_nacimiento, a.estado "
               + "FROM inscripcion i, alumno a WHERE i.id_alumno = a.id_alumno AND i.id_materia = ? AND a.estado = 1";
       
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idMateria);
                     
            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
             Alumno alumno = new Alumno();
             alumno.setId_alumno(rs.getInt("id_alumno"));
             alumno.setApellido(rs.getString("apellido"));
             alumno.setNombre(rs.getString("nombre"));
             alumno.setFecha_nacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
             alumno.setEstado(rs.getBoolean("estado"));
             alumnosMaterias.add(alumno);
             
         }
            ps.close();
                     } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "error al obtener alumnos por materia");
         }
       
       return alumnosMaterias;
   }
           
           
    
}
