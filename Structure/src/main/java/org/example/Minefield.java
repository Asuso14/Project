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

        int[] Range = new int[2];
        String[] temp = UserChain();

        if (temp.length != 2){
            return true;
        }
        for (int i = 0; i < Range.length; i++){
            boolean status = CheckNumericFormat(Range,i,temp);
            if (status){
                return true;
            }else {
                Range[i] = UserNumericValues(Range,temp,i);
            }
        }

        if (Range[0] <= 0 || Range[1] <= 0)//es el caso que marca el final
        return false;
        else {

            String[][] Minefield = new String[Range[1]][Range[0]];
            for (int i = 0;i<Minefield.length;i++){
                Minefield[i] = DefineRow(Minefield,i,entry.next(),Range[0]);
            }

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
            status = IntValue[IntPos] > 1000;
        }catch (InputMismatchException | NumberFormatException error){
            status = true;
        }
        return status;
    }

    public static boolean CheckUserChainEntry(String Row, int LargeOfLine){
        boolean status;
        status = Row.matches("[\\d*-]*{"+ LargeOfLine +"}");
        return status;
    }

    public static String[] DefineRow(String[][] Cube, int row, String UserRow, int Large){
        while (!CheckUserChainEntry(UserRow,Large)){
            UserRow = entry.next();
        }
        String []FinalRow = UserRow.split("");
        System.arraycopy(FinalRow,0,Cube[row],0,Large);
        return Cube[row];
    }

    public static int TotalCounts(){
        int total = 0;
        
        return total;
    }

    public static void main(String[] args) {
        while (casoDePrueba()) {
        }
    } // main
}// class solution