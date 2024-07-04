import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();

        for (byte testCase = 0; testCase < totalTestCases; testCase++) {
            byte matrixSize = scanner.nextByte();
            byte[][] matrix = new byte[matrixSize][matrixSize];
            int trace = 0;
            byte rowDuplicates = 0;
            byte columnDuplicates = 0;

            for (byte row = 0; row < matrixSize; row++) {
                boolean[] rowCheck = new boolean[matrixSize + 1];
                boolean rowFlag = false;
                for (byte col = 0; col < matrixSize; col++) {
                    byte value = scanner.nextByte();
                    if (rowCheck[value] && !rowFlag) {
                        rowDuplicates++;
                        rowFlag = true;
                    } else {
                        rowCheck[value] = true;
                    }
                    if (row == col) {
                        trace += value;
                    }
                    matrix[row][col] = value;
                }
            }

            for (byte col = 0; col < matrixSize; col++) {
                boolean[] colCheck = new boolean[matrixSize + 1];
                boolean colFlag = false;
                for (byte row = 0; row < matrixSize; row++) {
                    byte value = matrix[row][col];
                    if (colCheck[value] && !colFlag) {
                        columnDuplicates++;
                        colFlag = true;
                    } else {
                        colCheck[value] = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase + 1, trace, rowDuplicates, columnDuplicates);
        }
    }
}