package ub.info.prog2.HuayllasMiguelDiCore.model;

import ub.info.prog2.utils.InFile;

import java.io.File;
import java.util.Date;
import java.util.Calendar;

public class FitxerMultimedia extends File implements InFile {
    //Esta subclase de File sera el que usemos para gestionar los ficheros del reprodutor
    String author;

    public FitxerMultimedia(String path) {
        super(path);
        this.author = "Desconocido";

    }

    public FitxerMultimedia(String path, String author) {
        super(path);
        this.author = author;
    }


    //Object obj hace referenci al tipo generico de objetos lo usamos porque el usuario puede pasar cualquier cosa
    public boolean equals(Object obj) {
        //Sea cualquiera el objeto si esta vacio(solo incializado) devolver false
        if (obj == null) return false;
        //Creamos un objeto del tipo que vamos a comparar
        FitxerMultimedia other = null;
        //Comprobamos que el objeto pasado sea del tipo que queremos
        if (obj instanceof FitxerMultimedia)
            //Hacemos un alias a dicho objeto
            other = (FitxerMultimedia) obj;
        //finalmente hacemos la comparacion
        return this.getAutor().equals(other.getAutor()) && super.equals(other);


    }

    @Override
    public Date getUltimaModificacio() {
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
        return fecha;
    }

    @Override
    public String getCamiAbsolut() {
        return getAbsolutePath();
    }

    @Override
    public String getNomFitxer() {
        return getName();
    }

    @Override
    public String getAutor() {
        return this.author;
    }


    @Override
    public void setAutor(String s) {
        this.author = s;

    }
    
    public String toString(){
    return this.getCamiAbsolut();}
}