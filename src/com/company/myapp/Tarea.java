package com.company.myapp;

public class Tarea {
    private int id;
    private String nombre;
    private String descripcion;
    private String responsable;
    private Estado estado;

    public Tarea(String nombre, String responsable, Estado estado) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.estado = estado;
        this.descripcion = "";
    }

    public Tarea(String nombre, String descripcion, String responsable, Estado estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.estado = estado;
    }

    public Tarea(int id, String nombre, String descripcion, String responsable, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.responsable = responsable;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
