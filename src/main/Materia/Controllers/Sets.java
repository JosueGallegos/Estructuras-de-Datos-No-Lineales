package main.Materia.Controllers;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
//import java.util.LinkedList;
import java.util.TreeSet;

public class Sets {
    public Sets(){
        construirHashSet();
        System.out.println();
        construirLinkedHashSet();
        System.out.println();
        TreeSet();
        System.out.println();
        construirTreeSetConComportador();
        System.out.println();
     
    }

    //Construcion de mostrar un Hashset
    public void construirHashSet(){
        HashSet<String> conjunto = new HashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana");// duplicado, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");

        System.out.println("HashSet: " + conjunto );

        boolean contieneNaranja = conjunto.contains("Naramja");
        System.out.println("HashSet contiene Naranja "+ contieneNaranja);

        int tamaño = conjunto.size();
        System.out.println("Tamaño del HashSet: " + tamaño);
        


    } 
    //Construcion de mostrar un LinkedHashSet  
    public void construirLinkedHashSet(){
        LinkedHashSet<String> conjunto = new LinkedHashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana");// duplicado, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");

        System.out.println("LinkdeHashSet"+ conjunto) ;


    } 
    //Construcion de mostrar
    public void TreeSet(){
        TreeSet<String> conjunto = new TreeSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana");// duplicado, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");

        System.out.println("TreeSet"+ conjunto) ;

    }

    public void construirTreeSetConComportador(){

        Comparator<String> comparadorOrdenInverso = new Comparator<String>() {
            public int compare (String s1, String s2 ){
                return s2.compareTo(s1);
                //return s1.compareTo(s2); //Alfabeticamente
            }
            
        };
        TreeSet<String> conjunto = new TreeSet<>(comparadorOrdenInverso);
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Manzana");// duplicado, no se añadira
        conjunto.add("Uva");
        conjunto.add("Piña");

        System.out.println("TreeSetConComportador"+ conjunto) ;

    }
}
