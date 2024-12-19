package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nacho
 * @Version 1.0
 * This class is going to reproduce the game of the Minefield,
 * is not completed at all. Is a small version for the aceptaelreto.com web.
 * @see <a> href= "https://aceptaelreto.com/problem/statement.php?id=176" - Campo de minas</a>
 */
public class Minefield {

    public static Scanner entry = new Scanner(System.in);

    /**
     * Esta es la clase la cual sera llamada por el Main. Hasta que nos de status false,
     * que ahi acabara el programa (Es el codigo principal)
     */
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
            System.out.println(TotalCounts(Minefield));
            return true;
        }
    } // casoDePrueba

    /**
     * Esta funcion nos solicita que ingresemos una linea.
     *
     * @return Nos devuelve un vector, seprado por " ".
     */
    public static String[] UserChain (){
        String chain = entry.nextLine();
        return chain.split(" ");
    }

    /**
     * Esta funcion se encarga de asignar un valor de un vector String a otro vector Int.
     * (Definimos cada vector arriba).
     *
     * @param Cube Vector int , en el cual vamos a ingresar el parametro que se nos pasa.
     * @param temp Vector String, el cual vamos a convertir y ingresar en Cube.
     * @param pos Definimos la posicion para ambos vectores (Ya que usaremos la misma).
     */
    public static int UserNumericValues(int [] Cube, String[] temp, int pos){
            return Cube[pos] = Integer.parseInt(temp[pos]);
    }

    /**
     * Esta funcion va a comprobar si el valor de la linea ingresada por el usuario es numerico o
     * no y si es menor que 1000.
     *
     * @param IntValue Este es el vector int al cual vamos a intentar ingresar el supuesto numero.
     * @param ValueToCheck Este es el vector String el cual se ingresara (si se puede) en el vector int.
     * @param IntPos Esta es la posicion que hay que comparar tanto de IntValue como de ValueToCheck.
     * @return Nos devolvera el estado de la funcion. Si no lo ha podido convertir
     * o es mayor de 1000 (false). Si es correcto el formato (true).
     */
    public static boolean CheckNumericFormat(int[] IntValue ,int IntPos , String[] ValueToCheck){
        boolean status = false;
        try {
            IntValue[IntPos] = Integer.parseInt(ValueToCheck[IntPos]);
            if (IntValue[IntPos] > 1000){status = true;}
        }catch (InputMismatchException | NumberFormatException error){
            status = true;
        }
        return status;
    }

    /**
     * Esta funcion comprueba el formato de la linea ingresada por el usuario.
     * Tiene formato especifico si no se cumple devuelve false.
     *
     * @param Row Es la linea previamente ingresada por el usuario.
     * @param LargeOfLine Este parametro indica el largo que tiene que tener la linea ingresada por el usuario.
     * @return Especifica el resultado de la validacion de la cadena del usuario.
     */
    public static boolean CheckUserChainEntry(String Row, int LargeOfLine){
        boolean status;
        status = Row.matches("^[*-]{"+ LargeOfLine +"}$");
        return status;
    }

    /**
     * Esta función sirve para definir una de las Row de la matriz, directamente. Verifica que su formato
     * es el correcto. Una vez este validada, va a generar un vector que se ingresa en la matriz.
     *
     * @param Cube Esta es la matriz que hemos generado. El cual esta vacio y hay que rellenar con los datos
     * ingresados por el usuario.
     * @param row Este parametro indica la Row que estamos referenciando. Y la cual vamos a editar.
     * @param UserRow Linea ingresada por el usuario (String).
     * @param Large Longitud de la matriz (Columnas).
     * @return Devuelve un vector, para asociar los valores a la matriz.
     */
    public static String[] DefineRow(String[][] Cube, int row, String UserRow, int Large){
        int tries = 0;
        while (!CheckUserChainEntry(UserRow,Large)){
            if (tries == 5){
                System.exit(2);
            }
            UserRow = entry.next();
            tries++;
        }
        String []FinalRow = UserRow.split("");
        System.arraycopy(FinalRow,0,Cube[row],0,Large);
        return Cube[row];
    }

    /**
     * Esta función sirve para una vez definido el contenido de la matriz. Esta función va a recorrerla,
     * y en cada uno de los parametros "-". Va a realizar una matriz de 9 (Alrededores de la posicion).
     * Y comprueba si el numero de minas alrededor de esta. Si es 6 o más. Se agrega 1 a total. Para definir
     * el resultado.
     * @param Cube Es la matriz, a la cual vamos a acceder para comprobar las posiciones.
     * @return Devuelve el numero de "-" que estan rodeados por 6 minas o mas "*".
     */
    public static int TotalCounts(String[][] Cube){
        int total = 0;
        for (int i =0;i<Cube.length;i++){

            if (i == 0 || i == Cube.length -1){
                continue;
            }

            for (int j =  0;j<Cube[0].length;j++){

                if (j == 0 || j == Cube[0].length - 1 || Cube[i][j].equals("*")){
                    continue;
                }
                int[] temp = {Math.max(i - 1, 0), Math.min(i + 2, Cube.length), Math.max(j - 1, 0), Math.min(j + 2, Cube[0].length)};
                int[] Poss_temp = {i-temp[0],j-temp[2]};
                String [][] SubMatrix = CreateSubMatrix(Cube,temp);
                boolean status = CheckTheMines(SubMatrix, Poss_temp);
                if (status){
                    total++;
                }
            }
        }
        return total;
    }

    /**
     * Esta funcion va a comprobar de una matriz reducida de la matriz Main. El numero de minas que rodean a
     * nuestra posicion central.
     * @param MiniCube Matriz reducida de matriz origen. Tiene los datos de esta ya integrados.
     * @param MainPoss Posicion la cual estamos comrprobando su entorno (minas que le rodean).
     * @return Si el programa, al recorrer toda la matriz. Ha entontrado 6 o mas minas (true), sino (false).
     */
    public static boolean CheckTheMines(String[][] MiniCube, int[] MainPoss){
        int count = 0;
        for (int i = 0;i<MiniCube.length;i++){
            for (int j=0;j<MiniCube[0].length;j++){
                if (i == MainPoss[0] && j == MainPoss[1]){
                    continue;
                }
                if (MiniCube[i][j].equals("*")){
                    count++;
                }
            }
        }
        return count>=6;
    }

    /**
     * Esta funcion sirve para definir una Matriz simplificada de la matriz principal.
     * Con esto nos quedamos con los parametros que rodean nuestro parametro central.
     * @param Cube La matriz principal, la cual va a ser copiada en la nueva matriz mas
     * reducida. La necesitamos para ingresar los datos en la nueva.
     * @param Poss Son las posiciones que queremos meter en la nueva matriz, esto se refiere
     * al rango de la matriz original que vamos a seleccionar.
     * @return Nos devuelve la Matriz simplicada con los valores de las posiciones indicadas.
     */
    public static String[][] CreateSubMatrix(String[][] Cube, int [] Poss){

        String[][] SubMatrix = new String[Poss[1]-Poss[0]][Poss[3]-Poss[2]];
        for (int i = Poss[0];i< Poss[1];i++){
            for (int j = Poss[2];j<Poss[3];j++){
                SubMatrix[i - Poss[0]][j - Poss[2]] = Cube[i][j];
            }
        }
        return SubMatrix;
    }

    /**
     * Es el main de la clase, que referencia a casoDePrueba.
     */
    public static void main(String[] args) {
        while (casoDePrueba()) {
        }
    } // main
}// class solution