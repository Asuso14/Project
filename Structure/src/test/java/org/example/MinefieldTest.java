package org.example;
import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class MinefieldTest extends TestCase {

    @Test
    public void testCasoDePrueba() {
        //No hay nada que probar, la lógica esta en las otras funciones.
    }

    @Test
    public void testUserChain() { //Este es el ingreso de cadena, no puede fallar aquí, si falla sera en
        //CheckNumbericFormat.
    }

    @Test
    public void testUserNumericValues() {//Este es el que sigue de CheckNumericFormat, se testea ahí
    }

    @Test
    public void testCheckNumericFormat() {
        int[] intArray = new int[2];
        String[] stringArray = {"abc", "100"};
        boolean resultInvalid = Minefield.CheckNumericFormat(intArray, 0, stringArray);
        assertTrue(resultInvalid);

        String[] stringArray2 = {"1000","1"};
        resultInvalid = Minefield.CheckNumericFormat(intArray, 0, stringArray2);
        assertTrue(resultInvalid);

        String[] stringArray3 = {"10","10"};
        boolean resultValid = Minefield.CheckNumericFormat(intArray,0,stringArray3);
        assertFalse(resultValid);
    }

    @Test
    public void testCheckUserChainEntry() {
        String row = "*-*-*";
        boolean result = Minefield.CheckUserChainEntry(row, 5);

        String invalidRow = "*--*";
        boolean invalidResult = Minefield.CheckUserChainEntry(invalidRow, 5);

        String invalidRow2 = "* -*";
        boolean invalidResult2 = Minefield.CheckUserChainEntry(invalidRow2, 5);

        String invalidRow3 = "*a-2";
        boolean invalidResult3 = Minefield.CheckUserChainEntry(invalidRow3, 5);

        String invalidRow4 = " ";
        boolean invalidResult4 = Minefield.CheckUserChainEntry(invalidRow4, 5);

        String invalidRow5 = "*--***";
        boolean invalidResult5 = Minefield.CheckUserChainEntry(invalidRow5, 5);
        assertTrue(result);
        assertFalse(invalidResult);
        assertFalse(invalidResult2);
        assertFalse(invalidResult3);
        assertFalse(invalidResult4);
        assertFalse(invalidResult5);
    }

    @Test
    public void testDefineRow() {//No hay mucho mas que testear.
        // Porque las otras funciones corrigen los posibles errores antes...
        String[][] cube = new String[1][5];
        String input = "*-*-*";
        String[] result = Minefield.DefineRow(cube, 0, input, 5);
        assertArrayEquals(new String[]{"*", "-", "*", "-", "*"}, result);
    }

    @Test
    public void testTotalCounts() {
        String[][] cube = {
                {"*", "*", "*", "*", "*"},
                {"*", "-", "-", "-", "*"},
                {"*", "-", "*", "-", "*"},
                {"*", "-", "-", "-", "*"},
                {"*", "*", "*", "*", "*"}};
        assertEquals(4,Minefield.TotalCounts(cube));
    }

    @Test
    public void testCheckTheMines() {
        String[][] miniCube = {
                {"*", "*", "*"},
                {"*", "-", "*"},
                {"*", "*", "*"},
        };
        int[] mainPos = {1, 1};
        boolean result = Minefield.CheckTheMines(miniCube, mainPos);
        assertTrue(result);
    }

    @Test
    public void testCreateSubMatrix() {//No hay mucho mas que testear.
        // Porque las otras funciones corrigen los posibles errores antes...
        String[][] cube = {
                {"*", "*", "*", "*"},
                {"*", "-", "-", "*"},
                {"*", "-", "-", "*"},
                {"*", "*", "*", "*"},
        };
        int[] pos = {1, 3, 1, 3};
        String[][] result = Minefield.CreateSubMatrix(cube, pos);
        String[][] expected = {
                {"-", "-"},
                {"-", "-"},
        };
        assertArrayEquals(expected, result);
    }
}