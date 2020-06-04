package com.stream.collection;

import java.util.ArrayList;
import java.util.List;

public class Colegio {

    private List<Curso> cursos;

    public Colegio() {
        this.cursos = new ArrayList();
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    /*  Listado total de alumnos en el Colegio. 
        distinct() es utilizado para no repetir
        si un alumno se encuentra inscripto en 
        mas de un curso.                         */
    public void listTotalAlumnos() {
        cursos.stream()
                .flatMap(s -> s.getInscripciones()
                .stream().map(al -> al.getAlumno()))
                .distinct().forEach(System.out::println);
    }

}
