package com.biblioteca;

public class Main {
    public static void main(String[] args) {

        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // ---------------------------
        // CREAR MATERIALES
        // ---------------------------
        Libro libro1 = new Libro("L1", "Cien años de soledad", 1967, false,"Gabriel García Márquez", "978-0307474728");

        Libro libro2 = new Libro("L2", "El Principito", 1943, true,"Antoine de Saint-Exupéry", "978-0156012195");

        Revista revista1 = new Revista("R1", "National Geographic en Español", 2024, false,250, "Ciencia");

        Revista revista2 = new Revista("R2", "Muy Interesante", 2024, true,420, "Ciencia y cultura");

        // ---------------------------
        // REGISTRAR EN CATÁLOGO
        // ---------------------------
        sistema.registrarMaterial(libro1);
        sistema.registrarMaterial(libro2);
        sistema.registrarMaterial(revista1);
        sistema.registrarMaterial(revista2);

        System.out.println("\n--- CATÁLOGO ---");
        sistema.mostrarCatalogo();

        // ---------------------------
        // BUSCAR MATERIAL
        // ---------------------------
        System.out.println("\n--- BÚSQUEDA ---");
        Material encontrado = sistema.buscarMaterial("L1");

        if (encontrado != null) {
            encontrado.mostrarInfo();
        } else {
            System.out.println("Material no encontrado");
        }

        // Buscar uno que no existe
        Material noExiste = sistema.buscarMaterial("X1");

        if (noExiste != null) {
            noExiste.mostrarInfo();
        } else {
            System.out.println("Material no encontrado (correcto)");
        }

        // ---------------------------
        // LISTA DE ESPERA
        // ---------------------------
        System.out.println("\n--- LISTA DE ESPERA ---");

        // Marcar libro como prestado
        libro1.disponible = false;

        sistema.agregarEspera("L1", "Juan");
        sistema.agregarEspera("L1", "Danna");
        sistema.agregarEspera("L1", "Carlos");

        System.out.println("Siguiente en espera: " + sistema.siguienteEnEspera("L1"));
        System.out.println("Siguiente en espera: " + sistema.siguienteEnEspera("L1"));

        // ---------------------------
        // MEMBRESÍAS
        // ---------------------------
        System.out.println("\n--- MEMBRESÍAS ---");

        System.out.println("Registrar Juan: " + sistema.registrarMiembro("Juan"));
        System.out.println("Registrar Danna: " + sistema.registrarMiembro("Danna"));
        System.out.println("Registrar Juan otra vez: " + sistema.registrarMiembro("Juan"));

        System.out.println("¿Juan tiene membresía?: " + sistema.tieneMembresia("Juan"));
        System.out.println("¿Pedro tiene membresía?: " + sistema.tieneMembresia("Pedro"));
    }
}