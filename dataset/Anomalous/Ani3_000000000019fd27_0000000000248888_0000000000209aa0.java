import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String[] input = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int centerValue = k / n;
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int calculatedValue = ((n - row + col) % n) + centerValue;
                    if (calculatedValue > n) {
                        calculatedValue -= n;
                    }
                    matrix[row][col] = calculatedValue;
                    if (row == col) {
                        trace += calculatedValue;
                    }
                }
            }

            if (trace == k) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                for (int[] row : matrix) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }
    }
}