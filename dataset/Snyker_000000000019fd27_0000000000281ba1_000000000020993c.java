import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int whereAmI = 0;
        int currentMatrice = -1;
        int numberOfTest = -1;

        int[][][] matrices = new int[0][0][0];
        int exceed = -1;
        int row = 0;
        int col = 0;

        while (scan.hasNext()) {
            String line = scan.next();

            if (line.equalsIgnoreCase("stop"))
                break;

            try {
                if (whereAmI == 0) {
                    numberOfTest = Integer.parseInt(line);
                    whereAmI++;
                    matrices = new int[numberOfTest][0][0];
                } else {
                    if (whereAmI == 1 && currentMatrice < numberOfTest) {
                        int rowCol = Integer.parseInt(line);
                        currentMatrice++;
                        matrices[currentMatrice] = new int[rowCol][rowCol];

                        whereAmI++;
                        exceed = rowCol;
                    } else {
                        int inCol = Integer.parseInt(line);
                        matrices[currentMatrice][row][col] = inCol;

                        col++;
                        if(col >= exceed) {
                            col = 0;
                            row++;
                            if (row >= exceed) {
                                row = 0;
                                whereAmI--;
                                if(currentMatrice+1 >= numberOfTest)
                                    break;
                            }
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur de parse :shrug:");
            }

        }

        scan.close();

        for (int i = 0; i < matrices.length; i++) {
            display(matrices[i], i);
        }
    }

    static void display(int[][] ints, int index) {
        StringBuilder stringBuilder = new StringBuilder();

        //Calc diag
        int diag = 0;
        for (int i = 0; i < ints.length; i++) {
            int number = ints[i][i];
            diag += number;
        }
        stringBuilder.append(diag).append(" ");

        //Multiple of row

        //Ligne
        int rowFind = 0;
        nextRow:
        for (int i = 0; i < ints.length; i++) {
            //Colonne
            for (int j = 0; j < ints[i].length; j++) {
                int number = ints[i][j];
                for (int k = j+1; k < ints[i].length; k++) {
                    int off = ints[i][k];
                    if(number == off) {
                        rowFind++;
                        continue nextRow;
                    }
                }
            }
        }
        stringBuilder.append(rowFind).append(" ");

        //Multiple of column

        //Ligne
        int colFind = 0;
        nextCol:
        for (int i = 0; i < ints.length; i++) {
            //Colonne
            for (int j = 0; j < ints[i].length; j++) {
                int number = ints[j][i];
                for (int k = j+1; k < ints[i].length; k++) {
                    int off = ints[k][i];
                    if(number == off) {
                        colFind++;
                        continue nextCol;
                    }
                }
            }
        }
        stringBuilder.append(colFind);

        System.out.println(String.format("Case #%d: %s", index+1, stringBuilder.toString()));
    }
}