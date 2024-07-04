import java.util.*;
import java.io.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numberOfCases = in.nextInt();

        int matrix[][];


        for (int i = 1; i <= numberOfCases; ++i) {

            int matrixSize = in.nextInt();

            matrix = new int[matrixSize][matrixSize];
            int rowsWithRepeatedNumbers = 0;
            int columnsWithRepeatedNumbers = 0;

            int diagonal = 0;
            List<Integer> row = new ArrayList<Integer>();
            ArrayList<Integer>[] columns = new ArrayList[matrixSize];

            for (int q = 0; q < matrixSize; q++) {
                columns[q] = new ArrayList<Integer>();
            }

            for (int m = 0; m < matrixSize; m++) {


                for (int n = 0; n < matrixSize; n++) {
                    int input = in.nextInt();

                    // DIAGONAL
                    if (m == n) diagonal += input;

                    // ROWS
                    if (row.indexOf(input) == -1) row.add(input);

                    // COLUMNS
                    if (columns[n] != null) {
                        if (columns[n].indexOf(input) == -1) {
                            columns[n].add(input);
                        } else {
                            columns[n] = null;
                            columnsWithRepeatedNumbers++;
                        };
                    }

                }

                if (row.size() < matrixSize)  rowsWithRepeatedNumbers++;
                row.clear();
            }

            /*
            System.out.println("Diagonal: " + diagonal);
            System.out.println("rowsWithRepeatedNumbers: " + rowsWithRepeatedNumbers);
            System.out.println("columnsWithRepeatedNumbers: " + columnsWithRepeatedNumbers );




            for (int j = 0; j < matrixSize ; j++) {
                System.out.print("\n");
                for (int k = 0; k < matrixSize ; k++) {
                    System.out.print(matrix[j][k]+" ");
                }
            }
             */

            System.out.println("Case #" + i + ": " + diagonal + " " + rowsWithRepeatedNumbers + " " + columnsWithRepeatedNumbers);
        }
    }
}