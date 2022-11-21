package cl.seccion121.proyectospinner;

import java.io.Serializable;

public class Comuna implements Serializable {
    private String nombre;
    private int poblacion;
    private String alcalde;
    private String grupoGSE;
    private float mt2;
    private String direccionMunicipalidad;

    public String getDireccionMunicipalidad() {
        return direccionMunicipalidad;
    }

    public void setDireccionMunicipalidad(String direccionMunicipalidad) {
        this.direccionMunicipalidad = direccionMunicipalidad;
    }

    public String getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
    }

    public String getGrupoGSE() {
        return grupoGSE;
    }

    public void setGrupoGSE(String grupoGSE) {
        this.grupoGSE = grupoGSE;
    }

    public float getMt2() {
        return mt2;
    }

    public void setMt2(float mt2) {
        this.mt2 = mt2;
    }

    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setPoblacion(int nuevaPoblacion){
        poblacion = nuevaPoblacion;
    }

    public int getPoblacion(){
        return poblacion;
    }









}
