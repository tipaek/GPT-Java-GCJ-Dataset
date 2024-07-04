import java.util.*;
import java.io.*;

class Solution {
public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int totalTestCount = in.nextInt();

        for (int i = 1; i <= totalTestCount; i++) {
            in.nextLine();
            int size = in.nextInt();
            int matrix[][] = getMatrix(size, in);
            vestigium(i, matrix, size);
        }
    }

    public static void vestigium(int testNumber, int[][] matrix, int size) {
        int trace = 0;
        int dupRow = 0;
        int dupCol = 0;

        for (int diagonal = 0; diagonal < size; diagonal++) {
            trace = trace + matrix[diagonal][diagonal];

            if (existRowDuplicate(matrix, diagonal, size)) dupRow++;
            if (existColDuplicate(matrix, diagonal, size)) dupCol++;
        }


        System.out.println("Case #" + testNumber + ": " + trace + " " + dupRow + " " + dupCol);
    }

    public static boolean existRowDuplicate(int[][] matrix, int rowId, int size) {

        Set<Integer> rowSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int element = matrix[rowId][i];

            if (rowSet.contains(element)) return true;
            else rowSet.add(element);

        }
        return false;

    }

    public static boolean existColDuplicate(int[][] matrix, int colId, int size) {
        Set<Integer> colSet = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int element = matrix[i][colId];
            if (colSet.contains(element)) return true;
            else colSet.add(element);
        }
        return false;
    }

    public static int[][] getMatrix(int size, Scanner in) {
        int[][] matrix = new int[size][size];
        for (int r = 0; r < size; r++) {
            in.nextLine();
            for (int c = 0; c < size; c++) {
                matrix[r][c] = in.nextInt();
            }

        }
        return matrix;
    }
}