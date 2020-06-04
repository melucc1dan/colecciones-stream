package com.stream.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Curso {

    private String nombre;
    private int cupo;
    private double notaAprobado;
    private List<Inscripcion> inscripciones;

    public Curso(String nombre, int cupo, double notaAprobado) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.notaAprobado = notaAprobado;
        this.inscripciones = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public double getNotaAprobado() {
        return notaAprobado;
    }

    public void setNotaAprobado(double notaAprobado) {
        this.notaAprobado = notaAprobado;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void agregarInscripcion(Inscripcion i) {
        inscripciones.add(i);
    }

    @Override
    public String toString() {
        return "Curso{" + "nombre=" + nombre + ", cupo=" + cupo + ", notaAprobado=" + notaAprobado + '}';
    }

    public double notaPromedio() {
        return inscripciones.stream()
                .mapToDouble(x -> x.getNota())
                .average().orElse(0);
    }

    //Iteracion en orden aleatorio, propiedad de Map
    public void listToMap() {
        inscripciones.stream()
                .collect(Collectors.toMap(p -> p.getAlumno().getAlias(), s -> s.getAlumno()))
                .forEach((x, y) -> System.out.println("Clave: " + x + " Valor: " + y + " "));

    }

    //Lista la Inscripcion de los alumnos aprobados, ordenados de mayor a menor, según el valor de la nota
    public void alumnosAprobados() {

        /*el lugar del peek() en el Stream demuestra la propiedad de las operaciones intermedias filter() y sorted(), que se dividen entre sin estado y con estado
          las primeras no retienen el elemento, por lo que recorre todo el stream, filtra y luego continúa con demás bloques.
            A comparación del peek() continuo a sored()
         */
        inscripciones.stream()
                .filter(s -> s.getNota() >= this.getNotaAprobado()).peek(s -> System.out.println("Filtrado de notas: " + s.getNota()))
                .sorted().peek(s -> System.out.println("Ordena las notas: " + s.getNota())).map(s -> s.getAlumno())
                .forEach(System.out::println);
    }

    //Lista la cantidad de veces que las notas se repiten
    public Map<Double, Long> contadorNotas() {

        Map<Double, Long> map = inscripciones.stream()
                .map(s -> s.getNota())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map;
    }

    //Retorna la cantidad de alumnos aprobados    
    public int cantidadDesaprobados() {
        return (int) inscripciones.stream()
                .filter(s -> s.getNota() < this.getNotaAprobado())
                .count();
    }

    //La inversión se efectua teniendo en cuenta el valor de ls notas (de menor a mayor), el fin es el uso de reverseOrder().
    public void invertirArreglo() {
        inscripciones.stream()
                .sorted(Collections.reverseOrder())
                .map(j -> j.getAlumno().getNombre())
                .forEach(System.out::println);
    }
}
