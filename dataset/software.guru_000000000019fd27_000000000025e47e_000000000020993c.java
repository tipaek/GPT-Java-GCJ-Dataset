import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanner.nextInt();
        for (int tc = 1; tc <= numberOfTestCases; tc++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] row = scanner.next().split(" ");
                for (int j = 0; j < row.length; j++) {
                    matrix[i][j] = Integer.parseInt(row[j]);
                }
            }

            int diagonal = 0;
            for (int i = 0; i < n; i++) {
                diagonal += matrix[i][i];
            }
            Set<Integer> set = new HashSet<>();
            int repeatedRows = 0;
            for (int i = 0; i < n; i++) {
                set.clear();
                for (int j = 0; j < n; j++) {
                    if (set.contains(matrix[i][j])) {
                        repeatedRows++;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                    }
                }
            }
            int repeatedColumns = 0;
            for (int j = 0; j < n; j++) {
                set.clear();
                for (int i = 0; i < n; i++) {
                    if (set.contains(matrix[i][j])) {
                        repeatedColumns++;
                        break;
                    } else {
                        set.add(matrix[i][j]);
                    }
                }
            }
            System.out.println("Case #" + tc + ": " + diagonal + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}