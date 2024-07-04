import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1*/

/*2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2*/

/*2 1 3
1 3 2
1 2 3*/
public class Solution {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numCases; i++) {
            int matrixSize = Integer.parseInt(scanner.nextLine());
            int matrix[][] = new int[matrixSize][matrixSize];
            String rowNumbers[];
            for(int row = 0; row < matrixSize; row++) {
                String holder = scanner.nextLine();
                rowNumbers = holder.split( " ");
                for(int col = 0; col < matrixSize; col++) {
                    matrix[row][col] = Integer.parseInt(rowNumbers[col]);
                }
            }

            int trace = calculateMatrixTrace(matrixSize, matrix);
            int repeatedInRows = countRepeatedInRows(matrixSize, matrix);
            int repeatedInCols = countRepeatedInCols(matrixSize, matrix);

            System.out.println("Case #" + (i + 1) + ":" + " " + trace + " " + repeatedInRows + " " + repeatedInCols);
        }
    }

    static int calculateMatrixTrace(int matrixSize, int matrix[][]) {
        int matrixTrace = 0;
        for(int i = 0; i < matrixSize; i++) {
            matrixTrace += matrix[i][i];

        }

        return matrixTrace;
    }

    static int countRepeatedInCols(int matrixSize, int matrix[][]) {
        int repeatedInCols = 0;
        List<Integer> numbersInCols = new ArrayList<>();
        for(int col = 0; col < matrixSize; col++) {
            for(int row = 0; row < matrixSize; row++) {
                int currentNumber = matrix[row][col];
                if (row != 0 && numbersInCols.contains(currentNumber))  {
                    repeatedInCols += 1;
                    break;
                }
                numbersInCols.add(matrix[row][col]);
            }
            numbersInCols.clear();
        }

        return repeatedInCols;
    }

    static int countRepeatedInRows(int matrixSize, int matrix[][]) {
        int repeatedInRows = 0;
        List<Integer> numbersInRows = new ArrayList<>();
        for(int row = 0; row < matrixSize; row++) {
            for(int col = 0; col < matrixSize; col++) {
                int currentNumber = matrix[row][col];
                if (col != 0 && numbersInRows.contains(currentNumber))  {
                    repeatedInRows += 1;
                    break;
                }
                numbersInRows.add(matrix[row][col]);
            }
            numbersInRows.clear();
        }
        return repeatedInRows;
    }

}
