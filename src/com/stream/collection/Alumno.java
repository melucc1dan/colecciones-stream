package com.stream.collection;

public class Alumno {
    
    private String alias;
    private String nombre;
    private int edad;

    public Alumno(String alias, String nombre, int edad) {
        this.alias = alias;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "alias=" + alias + ", nombre=" + nombre + ", edad=" + edad + '}';
    }
    
    
    
}
