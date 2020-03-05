package ub.info.prog2.HuayllasMiguelDiCore.model;

import ub.info.prog2.utils.InFileList;
import java.util.Scanner;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class LlistaFitxers implements InFileList, Serializable {
    //Creamos el ArrayList inicialmente con espacio para 100
    ArrayList<FitxerMultimedia> ficheros;
    int totalSize;

    //Creo los 2 constructores
    public LlistaFitxers(int i) {
        totalSize = i;
        ficheros = new ArrayList<FitxerMultimedia>(totalSize);
    }

    public LlistaFitxers() {
        totalSize = 100;
        ficheros = new ArrayList<FitxerMultimedia>(totalSize);
    }

    @Override
    public int getSize() {
        return ficheros.size();
    }

    public void addFitxer(File file) {// throws ReproException { ADDED
        if (file.exists()) {
            if (!ficheros.contains(file)) {
                Scanner sc = new Scanner(System.in);
                FitxerMultimedia temp;
                System.out.println("\nDo you want to add an author? Y/N\n");
                String answer = sc.next();
                if (answer.equals("Y") || answer.equals("y") ){
                    System.out.println("\nWright their name in one word\n");
                    String a = sc.next();
                    temp = new FitxerMultimedia(file.getAbsolutePath(), a);
                }else
                   temp = new FitxerMultimedia(file.getAbsolutePath());
                ficheros.add(temp);
                System.out.println("\nFile "+temp+" added correctly\n");
            } else
                System.out.println("\nFile already present\n");
        } else
            System.out.println("\nError 404, file not found\n");
    }

    public void removeFitxer(File file) {
        //Aqui tendremos que usar una comparacion entre ficheros y cuando hallermos
        // el que pasamos ppor parametro lo eliminamos
        if (file.exists()) {
            if (ficheros.contains(file)) {
                int x = 0;
                while((!ficheros.get(x).getAbsolutePath().equals(file.getAbsolutePath())) && x < ficheros.size())  //Només volem comparar els paths, no els autors (File no te atributs autor), per tant no utiliyzarem el metode de FitxerMultimedia
                     x++;
                FitxerMultimedia temp = ficheros.get(x);
                ficheros.remove(temp);
                System.out.println("\nFile deleted correctly\n");
            }
        } else
            System.out.println("\nError 404, file not found\n");
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
        for (int y = 0; y < ficheros.size(); y++){
            FitxerMultimedia currentFile = ficheros.get(y);
            temp.append((y + 1) + ".  " + currentFile.getNomFitxer() + " by " + 
                    currentFile.getAutor() + ".\nLast modified: " + 
                    currentFile.getUltimaModificacio() + " with full path of " +
                    currentFile.getAbsolutePath() + "\n");
        }
        String returnString = temp.toString();
        return returnString;
    }
}
//    C://Users//Test//Desktop//P2-1920-EnunciatLliurament1.pdf