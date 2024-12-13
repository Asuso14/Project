package org.example;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * author Nacho
 * Versión 1.0
 * This class is going to reproduce the game of the Minefield,
 * is not completed at all. Is a small version for the aceptaelreto.com web.
 */
public class Minefield {

    public static Scanner entry = new Scanner(System.in);

    public static boolean casoDePrueba() {//leer caso de prueba

        int[] Minefield = new int[2];
        String[] temp = UserChain();

        if (temp.length != 2){
            return true;
        }
        for (int i = 0; i < Minefield.length; i++){

            boolean status = CheckNumericFormat(Minefield,i,temp);
            if (status){
                return true;
            }else {
                Minefield[i] = UserNumericValues(Minefield,temp,i);
            }
        }
        System.out.println(Arrays.toString(Minefield));

        if (Minefield[0] <= 0 || Minefield[1] <= 0)//es el caso que marca el final
        return false;
        else {
            // CÓDIGO PRINCIPAL AQUÍ
            return true;
        }
    } // casoDePrueba

    public static String[] UserChain (){
        String chain = entry.nextLine();
        return chain.split(" ");
    }

    public static int UserNumericValues(int [] Cube, String[] temp, int pos){
            return Cube[pos] = Integer.parseInt(temp[pos]);
    }

    public static boolean CheckNumericFormat(int[] IntValue ,int IntPos , String[] ValueToCheck){
        boolean status;
        try {
            IntValue[IntPos] = Integer.parseInt(ValueToCheck[IntPos]);
            status = false;
        }catch (InputMismatchException | NumberFormatException error){
            status = true;
        }
        return status;
    }

    public static void main(String[] args) {

        while (casoDePrueba()) {

        }
    } // main
}// class solution