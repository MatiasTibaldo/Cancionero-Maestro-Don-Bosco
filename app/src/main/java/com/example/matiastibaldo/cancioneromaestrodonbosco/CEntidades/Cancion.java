package com.example.matiastibaldo.cancioneromaestrodonbosco.CEntidades;

/**
 * Created by Matias Tibaldo on 15/1/2018.
 */

public class Cancion {
    private String nombre;
    private int pagina;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

     public Cancion(String nombre, int pagina){
        this.nombre = nombre;
        this.pagina= pagina;
    }

}
