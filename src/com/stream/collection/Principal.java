package com.stream.collection;

import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Alum1", "José", 20);
        Alumno a2 = new Alumno("Alum2", "Mariano", 24);
        Alumno a3 = new Alumno("Alum3", "Lucía", 30);
        Alumno a4 = new Alumno("Alum4", "Jorge", 20);
        Alumno a5 = new Alumno("Alum5", "Carla", 26);
        Alumno a6 = new Alumno("Alum6", "María", 24);
        Alumno a7 = new Alumno("Alum7", "Carlos", 25);
        Curso c1 = new Curso("Economía 101", 10, 7);
        Curso c2 = new Curso("Literatura 202", 10, 7);
        Inscripcion i1 = new Inscripcion(a1, c1, 8);
        Inscripcion i2 = new Inscripcion(a2, c1, 4);
        Inscripcion i3 = new Inscripcion(a3, c1, 10);
        Inscripcion i4 = new Inscripcion(a4, c1, 6);
        Inscripcion i5 = new Inscripcion(a5, c2, 7);
        Inscripcion i6 = new Inscripcion(a6, c2, 7);
        Inscripcion i7 = new Inscripcion(a7, c2, 7);
        Inscripcion i8 = new Inscripcion(a4, c2, 8);
        Colegio col = new Colegio();
   
        List<Inscripcion> inscripciones = Arrays.asList(i1, i2, i3, i4, i5);
        c1.setInscripciones(inscripciones);
        List<Inscripcion> inscripcionesDos = Arrays.asList(i6, i7, i8);
        c2.setInscripciones(inscripcionesDos);
        List<Curso> cursos = Arrays.asList(c1, c2);
        col.setCursos(cursos);
        
        
        System.out.println("Nota promedio del curso "+c1.getNombre()+": "+c1.notaPromedio());
        System.out.println("");
        c1.listToMap();
        System.out.println(" ");
        System.out.println("Alumnos Aprobados:");
        c1.alumnosAprobados();
        System.out.println(" ");
        System.out.print("Contador de notas: ");
        System.out.println(c1.contadorNotas());
        System.out.println("Cantidad de alumnos desaprobados: "+c1.cantidadDesaprobados());
        System.out.println(" ");
        c1.invertirArreglo();
        System.out.println(" ");
        System.out.println("Listado: ");
        col.listTotalAlumnos();
      
    }
}
