package org.example;

public class Main {
    public static void main(String[] args) {

        int [] values;
        String[][] MinesSearch;
        System.out.println("--------- BIENVENIDO AL BUSCA MINAS ---------");
        values = Functions.UserEntry();
        MinesSearch = Functions.GenerateBoard(values[0],values[1]);
    }
}
