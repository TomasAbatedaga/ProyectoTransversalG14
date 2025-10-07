/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author abate
 */
public class Inscripcion {
    private int id_inscripto;
    private int nota;
    private int id_alumno;
    private int id_materia;

    public Inscripcion(int id_inscripto, int nota, int id_alumno, int id_materia) {
        this.id_inscripto = -1;
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public Inscripcion() {
    }

    public Inscripcion(int nota, int id_alumno, int id_materia) {
        this.nota = nota;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }
    

    public int getId_inscripto() {
        return id_inscripto;
    }

    public void setId_inscripto(int id_inscripto) {
        this.id_inscripto = id_inscripto;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_inscripto=" + id_inscripto + ", nota=" + nota + ", id_alumno=" + id_alumno + ", id_materia=" + id_materia + '}';
    }
    
    
    
    
    
}
