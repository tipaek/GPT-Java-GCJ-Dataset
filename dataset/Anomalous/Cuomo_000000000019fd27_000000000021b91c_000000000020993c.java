import java.io.*;
import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[n][n];
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < n; i++) {
                String[] rowInput = scanner.nextLine().split(" ");
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    int value = Integer.parseInt(rowInput[j]);
                    matrix[i][j] = value;
                    if (i == j) {
                        trace += value;
                    }
                    if (!rowSet.add(value)) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", testCase, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}