package com.stream.collection;

public class Inscripcion implements Comparable{
    
    private Alumno alumno;
    private Curso curso;
    private double nota;

    public Inscripcion(Alumno alumno, Curso curso, double nota) {
        this.alumno = alumno;
        this.curso = curso;
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "alumno=" + alumno + ", curso=" + curso + ", nota=" + nota + '}';
    }

    @Override
    public int compareTo(Object o) {
        Inscripcion i = (Inscripcion) o;
        if(getNota()>i.getNota()){
            return -1;
        }
        return 1;
    }
    
    
    
    
    
    
}
