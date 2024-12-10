package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Functions {
    public static Scanner entry = new Scanner(System.in);

    public static int[] UserEntry(){

        int [] UserEntry = new int[2];
        try {
            System.out.println("Inserta el número de columnas: ");
            UserEntry [0] = entry.nextInt();
            System.out.println("Inserta el número de filas: ");
            UserEntry [1] = entry.nextInt();
            for (int i : UserEntry){
                if (i >= 1000 || i <= 0){
                    System.out.println("No has ingresado un número válido...");
                    System.exit(2);
                }
            }

        }catch (InputMismatchException error){
            System.out.println("No has ingresado un número...");
            System.exit(1);
        }
        return UserEntry;
    }

    public static String[][] GenerateBoard(int column, int row){

        String[][] Board = new String[row][column];
        
        return Board;
    }

}
