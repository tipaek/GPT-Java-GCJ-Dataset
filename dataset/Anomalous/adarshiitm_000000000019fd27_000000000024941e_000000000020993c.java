package codejam.jam2020.qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vestigium {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            System.out.print("Case #" + ks + ":");
            solve(input);
        }
    }

    private static void solve(Scanner input) {
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        int rowCount = countDuplicates(matrix, n, true);
        int colCount = countDuplicates(matrix, n, false);

        System.out.println(" " + trace + " " + rowCount + " " + colCount);
    }

    private static int countDuplicates(int[][] matrix, int n, boolean isRow) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int value = isRow ? matrix[i][j] : matrix[j][i];
                if (set.contains(value)) {
                    count++;
                    break;
                }
                set.add(value);
            }
        }
        return count;
    }
}