import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int matrixSize = sc.nextInt();
            Matrix matrix = new Matrix(matrixSize, sc);
            matrix.getOutput(i + 1);
        }
    }
}

class Matrix {

    int[][] matrix;

    Matrix(int matrixSize, Scanner sc) {
        matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private int getTrace() {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum = sum + matrix[i][i];
        }
        return sum;
    }

    private int getRepeatedInRow() {
        int numberOfRepeated = 0;
        int matrixSize = matrix.length;
        for (int i = 0; i < matrixSize; i++) {
            int[] row = matrix[i];
            Set<Integer> rowSet = Arrays.stream(row)
                .boxed()
                .collect(Collectors.toSet());
            if (rowSet.size() != matrixSize) {
                numberOfRepeated++;
            }
        }
        return numberOfRepeated;
    }

    private int getRepeatedInColumn() {
        int numberOfRepeated = 0;
        int matrixSize = matrix.length;
        for (int i = 0; i < matrixSize; i++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int j = 0; j < matrixSize; j++) {
                columnSet.add(matrix[j][i]);
            }
            if (columnSet.size() != matrixSize) {
                numberOfRepeated++;
            }
        }
        return numberOfRepeated;
    }

    void getOutput(int caseNumber) {
        System.out.println("Case #" + caseNumber + ": " + getTrace() + " " + getRepeatedInRow() + " " + getRepeatedInColumn());
    }
}