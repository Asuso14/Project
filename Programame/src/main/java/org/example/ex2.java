package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ex2 {

    public static Scanner entry = new Scanner(System.in);

    public static boolean casoDePrueba() {
        String letters = entry.next();
        if (!entry.hasNext())
            return false;
        else {
            if (letters.length() > 200){
                System.exit(1);
            }
            boolean status = true;
            String[] vector = letters.split("");
            Arrays.sort(vector);
            for (int i = 0;i<vector.length;i++){
                int count = 0;
                for (int j = 0;j<vector.length;j++){
                    if (vector[i].equalsIgnoreCase(vector[j])){
                        count++;
                    }
                }
                if (vector.length % 2 == 0){
                    if (count > vector.length/2){
                        System.out.println("NO");
                        status = false;
                        break;
                    }
                }else {
                    if (count > vector.length/2 + 1){
                        System.out.println("NO");
                        status = false;
                        break;
                    }
                }
            }
            if (status){
                System.out.println("SI");
            }
            return true;
        }
    } // casoDePrueba

    public static void main(String[] args) {
        while (casoDePrueba()) {

        }
    } // main
}
