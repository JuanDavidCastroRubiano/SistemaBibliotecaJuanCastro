package com.biblioteca;

import java.util.*;

public class SistemaBiblioteca {

    private Map<String, Material> catalogo = new HashMap<>();
    private Map<String, List<String>> listaEspera = new HashMap<>();
    private Set<String> miembros = new HashSet<>();

    // ---------------------------
    // CATÁLOGO (HashMap)
    // ---------------------------
    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {
        for (Material m : catalogo.values()) {
            m.mostrarInfo();
        }
    }

    // ---------------------------
    // LISTA DE ESPERA (ArrayList)
    // ---------------------------
    public void agregarEspera(String codigoMaterial, String usuario) {
        listaEspera.putIfAbsent(codigoMaterial, new ArrayList<>());
        listaEspera.get(codigoMaterial).add(usuario);
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> lista = listaEspera.get(codigoMaterial);

        if (lista != null && !lista.isEmpty()) {
            return lista.remove(0);
        }
        return null;
    }

    // ---------------------------
    // MEMBRESÍAS (HashSet)
    // ---------------------------
    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}