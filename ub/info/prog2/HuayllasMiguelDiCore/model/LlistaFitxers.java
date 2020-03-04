package ub.info.prog2.HuayllasMiguelDiCore.model;

import org.w3c.dom.ls.LSOutput;
import ub.info.prog2.utils.InFileList;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LlistaFitxers implements InFileList, Serializable {
    //Creamos el ArrayList inicialmente con espacio para 100
    ArrayList<File> ficheros;
    int totalSize;

    //Creo los 2 constructores
    public LlistaFitxers(int i) {
        totalSize = i;
        ficheros = new ArrayList<File>(totalSize);
    }

    public LlistaFitxers() {
        totalSize = 100;
        ficheros = new ArrayList<File>(totalSize);
    }

    @Override
    public int getSize() {
        return ficheros.size();
    }

    public void addFitxer(File file) {// throws ReproException { ADDED
        if (file.exists()) {
            if (!ficheros.contains(file)) {
                ficheros.add(file);
                System.out.println("\nFile "+file+" added correctly\n");
            } else
                System.out.println("\nFile already present\n");
        } else
            System.out.println("\nError 404, file not found\n");
    }

    public void removeFitxer(File file) {
        //Aqui tendremos que usar una comparacion entre ficheros y cuando hallermos
        // el que pasamos ppor parametro lo eliminamos
        ficheros.remove(file);
        System.out.println("\nFile deleted correctly\n");
    }

    @Override
    //Retorna la posicion del ArrayList
    public File getAt(int i) {
        return ficheros.get(i);
    }

    @Override
    public void clear() {
        ficheros.clear();
    }

    @Override
    public boolean isFull() {
        //Creo te daba error porque el total size es 100 mientras el size() era menor
        if (ficheros.size() < totalSize)
            return false;
        return true;
    }


    public String toString() { // ADDED
        StringBuffer temp = new StringBuffer("");
        for (int y = 0; y < ficheros.size(); y++)
            temp.append((y + 1) + ".  " + ficheros.get(y).getName() + "\n");
        String returnString = temp.toString();
        return returnString;
    }

}
