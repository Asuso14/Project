package org.example;

import java.util.Scanner;

public class ex1 {

    static Scanner entry = new Scanner(System.in);
    public static void casoDePrueba() {
        String goodword = "colgadas";
        String badword = "colgantes";
            String word = entry.next();
            if (goodword.equalsIgnoreCase(word)){
                System.out.println("Bien");
            }
            if (badword.equalsIgnoreCase(word)){
                System.out.println("Mal");
            }

    } // casoDePrueba

    public static void main(String[] args) {

        int numCasos = entry.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    } // main
}
