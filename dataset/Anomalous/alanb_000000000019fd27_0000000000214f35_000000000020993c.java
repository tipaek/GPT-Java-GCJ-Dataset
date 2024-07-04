import java.io.*;
import java.util.*;

public class Vest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scan.nextInt();
            int trace = 0;
            int rows = 0;
            int cols = 0;
            int[][] matrix = new int[n][n];
            HashSet<Integer> uniqueElements = new HashSet<>();

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = scan.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }

                uniqueElements.clear();
                for (int k = 0; k < n; k++) {
                    uniqueElements.add(matrix[j][k]);
                }
                if (uniqueElements.size() < n) {
                    rows++;
                }
            }

            for (int j = 0; j < n; j++) {
                uniqueElements.clear();
                for (int k = 0; k < n; k++) {
                    uniqueElements.add(matrix[k][j]);
                }
                if (uniqueElements.size() < n) {
                    cols++;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rows + " " + cols);
        }
    }
}