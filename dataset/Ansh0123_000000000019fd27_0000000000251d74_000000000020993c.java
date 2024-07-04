import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = getTrace(matrix, size);
            int dupRow = getDuplicateRow(matrix, size);
            int dupCol = getDuplicateCol(matrix, size);

            System.out.println("Case #" + test + ": " + trace + " " + dupRow + " " + dupCol);
        }
    }

    private static int getDuplicateCol(int[][] matrix, int size) {
        int dupCol = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> dupCheck = new HashSet<>();
            boolean dup = false;
            for (int j = 0; j < size; j++) {
                if (!dupCheck.add(matrix[j][i])) {
                    dup = true;
                    break;
                }
            }
            if (dup) {
                dupCol++;
            }
        }
        return dupCol;
    }

    private static int getDuplicateRow(int[][] matrix, int size) {
        int dupRow = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> dupCheck = new HashSet<>();
            boolean dup = false;
            for (int j = 0; j < size; j++) {
                if (!dupCheck.add(matrix[i][j])) {
                    dup = true;
                    break;
                }
            }
            if (dup) {
                dupRow++;
            }
        }
        return dupRow;
    }

    private static int getTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }


}