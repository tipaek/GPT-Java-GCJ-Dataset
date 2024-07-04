import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            int N = sc.nextInt();
            sc.nextLine();

            int[][] matrix = readMatrix(N);
            int trace = calculateTrace(matrix, N);
            int rowDuplicates = countRowDuplicates(matrix, N);
            int colDuplicates = countColumnDuplicates(matrix, N);

            System.out.println("Case #" + test + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static int[][] readMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != size) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicateCount = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                colSet.add(matrix[j][i]);
            }
            if (colSet.size() != size) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
}