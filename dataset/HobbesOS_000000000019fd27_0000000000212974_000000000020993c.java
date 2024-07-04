import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < numCases; i++) {
            int matrixSize = scanner.nextInt();
            matrix = new int[matrixSize][matrixSize];
            scanner.nextLine();
            // Populates the matrix
            for(int line = 0; line < matrixSize; line++) {
                String input = scanner.nextLine();
                input = input.replaceAll("\\s+","");
                char[] row = input.toCharArray();
                for(int index = 0; index < row.length; index++) {
                    matrix[line][index] = Character.getNumericValue(row[index]);
                }
            }
            int trace = calculateTrace();
            int repeatedElementRows = repeatedElementRows();
            int repeatedElementCols = repeatedElementCols();

            System.out.println("Case #" + (i + 1)  + ": " + trace + " " + repeatedElementRows + " " + repeatedElementCols);
        }
    }

    public static int calculateTrace() {
        int trace = 0;
        int row = 0;
        int column = 0;
        while(row < matrix.length && column < matrix.length) {
            trace += matrix[row][column];
            row++;
            column++;
        }
        return trace;
    }
    
    public static int repeatedElementRows() {
        boolean isRepeatedElement = false;
        int repeatedElementRows = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int colOne = 0; colOne < matrix.length; colOne++) {
                for(int colTwo = 0; colTwo < matrix.length; colTwo++) {
                    if(colOne != colTwo) {
                        if(matrix[row][colOne] == matrix[row][colTwo]) {
                            isRepeatedElement = true;
                        }
                    }
                }
            }
            if(isRepeatedElement) {
                isRepeatedElement = false;
                repeatedElementRows++;
            }
        }
        return repeatedElementRows;
    }

    public static int repeatedElementCols() {
        boolean isRepeatedElement = false;
        int repeatedElementCols = 0;
        for(int col = 0; col < matrix.length; col++) {
            for(int rowOne = 0; rowOne < matrix.length; rowOne++) {
                for(int rowTwo = 0; rowTwo < matrix.length; rowTwo++) {
                    if(rowOne != rowTwo) {
                        if(matrix[rowOne][col] == matrix[rowTwo][col]) {
                            isRepeatedElement = true;
                        }
                    }
                }
            }
            if(isRepeatedElement) {
                isRepeatedElement = false;
                repeatedElementCols++;
            }
        }
        return repeatedElementCols;
    }
}
