 
package gp14_transversal;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import Persistencia.AlumnoData;
import Persistencia.Conexion;
import Persistencia.InscripcionData;
import Persistencia.MateriaData;
import Vista.MenuPrincipal;
import java.time.LocalDate;
import java.time.Month;


public class Gp14_transversal {

   
    public static void main(String[] args) {
        MenuPrincipal.main(args);
        

        Alumno daniel = new Alumno(12121212, "Rodriguez", "Daniel", LocalDate.of(1994,Month.SEPTEMBER,12), true);
        Alumno facundo = new Alumno(44444444, "Calderon", "Facundo", LocalDate.of(1992,Month.NOVEMBER,04), true);
        Alumno tomas = new Alumno(77667766, "Abatedaga", "Tomas", LocalDate.of(1991,Month.OCTOBER,01), true);
        Alumno lucas = new Alumno(88998899, "Zarate", "Luquitas", LocalDate.of(2001,Month.MAY,02), true);
        Alumno fernando = new Alumno( 44554455, "Suarez", "Fernando", LocalDate.of(1982,Month.FEBRUARY,27), true);
        
        /*AlumnoData operacionesAlumnos = new AlumnoData();
       operacionesAlumnos.agregarAlumno(fernando);
        MateriaData materiaData = new MateriaData();
        Materia materia = new Materia("Matematica", 2024, false);
        Materia materia2 = new Materia("Matematica", 2025, false);
        materiaData.agregarMateria(materia); */
        
        
        InscripcionData datain = new InscripcionData();
        for(Alumno m: datain.obtenerAlumnosMateria(3) ){
            System.out.println(m);
        }
        
                 
        
        
    }
    
}
