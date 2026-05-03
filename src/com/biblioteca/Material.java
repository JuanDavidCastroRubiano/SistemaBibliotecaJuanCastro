package com.biblioteca;

public abstract class Material implements Catalogable {

    protected String codigo;
    protected String titulo;
    protected int anio;
    protected boolean disponible;

    public Material(String codigo, String titulo, int anio, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = disponible;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public abstract String getTipo();

    public void mostrarInfo() {
        String estado = disponible ? "Disponible" : "Prestado";
        System.out.println("[" + getTipo() + "] " + titulo + " (" + anio + ") - " + estado);
    }
}