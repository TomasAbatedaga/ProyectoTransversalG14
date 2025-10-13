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
   private Alumno alumno;
    private Materia materia;

    public Inscripcion(int id_inscripto, int nota, Alumno alumno, Materia materia) {
        this.id_inscripto = -1;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion(int nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Inscripcion() {
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

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id_inscripto=" + id_inscripto + ", nota=" + nota + ", alumno=" + alumno + ", materia=" + materia + '}';
    }
}
