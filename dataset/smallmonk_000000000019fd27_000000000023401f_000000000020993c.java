
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int matrixSize = in.nextInt();

            List<Integer> matrixVal = new ArrayList<>(matrixSize * matrixSize);
            for (int row = 1; row <= matrixSize; row++) {
                for (int col = 1; col <= matrixSize; col++) {
                    matrixVal.add(in.nextInt());
                }
            }

            int trace = calculateTrace(matrixVal, matrixSize);
            int rowDuplicate = checkDuplicate(matrixVal, matrixSize, true);
            int colDuplicate = checkDuplicate(matrixVal, matrixSize, false);

            System.out.println("Case #" + i + ": " + trace + " " + rowDuplicate + " " + colDuplicate);
        }
    }

    public static int calculateTrace(List<Integer> matrix, int matrixSize) {
        int trace = 0;
        for (int row = 0; row < matrixSize; row++) {
            trace += matrix.get(row + row * matrixSize);
        }
        return trace;
    }

    public static int checkDuplicate(List<Integer> matrix, int matrixSize, boolean checkRow) {
        int duplicate = 0;

        List<Integer> count = new ArrayList<>(matrixSize);
        for (int row = 0; row < matrixSize; row++) {
            count.add(0);
        }
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                count.set(col, 0);
            }
            for (int col = 0; col < matrixSize; col++) {
                final int val;
                if (checkRow) {
                    val = matrix.get(col + row * matrixSize);
                } else {
                    val = matrix.get(row + col * matrixSize);
                }
                count.set(val - 1, count.get(val - 1) + 1);
            }
            for (int col = 0; col < matrixSize; col ++) {
                if (count.get(col) > 1) {
                    duplicate++;
                    break;
                }
            }
        }

        return duplicate;
    }
}