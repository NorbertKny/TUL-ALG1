/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg08_sequence;

import java.util.Scanner;

/**
 *
 * @author Norbik
 */
public class SequenceAritmGeom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int num, d;
        double q;
        boolean isAritm = true;
        boolean isGeom = true;
        
        do{                                                                     //cykly pokud user input <=0
        System.out.println("Zadej delku posloupnosti [pocet cisel ktery je vetsi nez nula] (smysl to ma pro 3 a vice cisel)");
            while (!sc.hasNextInt()) {                                          //pokud dalsi user input(num) neni cislo,
                System.out.println("To neni cislo!");                           //napis zpravu
                System.out.println("Zadej delku posloupnosti [pocet cisel ktery je vetsi nez nula] (smysl to ma pro 3 a vice cisel)");
                sc.next();                                                      //a ptej se na novy input (pote co num scanner nebylo cislo,
            }                                                                   // sc.next pozada o user input a pokud splnuje parametry
        num = sc.nextInt();                                                     // vrati input z aktivniho scanneru
        }while (num <= 0);                                                      // v tomto pripade num scanneru a vrati input do num)
                                                                                
        int array[] = new int[num];                                             //pole o velikosti num
        
        System.out.println("Zadej " + num + " cisel.");
        System.out.println("HINT: pokud jsi napsal spatnou delku posloupnosti, muzes program ukoncit napsanim 'abort'");
        for (int i = 0 ; i < array.length; i++ ) {
           if (sc.hasNext("abort")){
                System.out.println("Program ukoncen!");
                System.exit(0);
           }  
           if (!sc.hasNextInt()){                                               //pokud je v posloupnosti neco jineho nez cislo, ukonci program
                System.out.println("Toto neni posloupnost!");
                System.exit(0);
           } 
           array[i] = sc.nextInt();
        }
        
        //chybovy stav
        if (num == 1){                                                          //pokud user nezada posloupnost, ukonci program
            System.out.println("Toto neni posloupnost!");
            System.exit(0);
        }
        
        ///**aritm posloupnost**************************************************
        //skok (diference)
        d = array[1] - (array[0]);
        //overeni skoku (diference) u vsech prvku
        for (int i = 1; i < array.length; i++) {
            if ((array[i] - (array[i-1])) != d) {
                isAritm = false;
            }
        }
        
        System.out.println((isAritm)?("Posloupnost je aritmeticka"):("Posloupnost neni aritmeticka"));
        ///*********************************************************************
        
        ///**geom posloupnost***************************************************
        //nasobek (kvocient)
        q = array[1] / (double)(array[0]);
        //overeni nasobku (kvocientu) u vsech prvku
        for (int j = 1; j < array.length; j++) {
            if ((array[j] / (double)(array[j-1])) != q) {
                isGeom = false;
            }
        }
        System.out.println((isGeom)?("Posloupnost je geometricka"):("Posloupnost neni geometricka"));
        ///*********************************************************************
    }
}