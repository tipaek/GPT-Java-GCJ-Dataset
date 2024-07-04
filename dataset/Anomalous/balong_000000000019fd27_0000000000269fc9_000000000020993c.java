import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        solve(scanner);
    }

    public static void solve(Scanner scanner) {
        int numberOfCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            int size = scanner.nextInt();
            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!colSet.add(matrix[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }
}