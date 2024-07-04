import java.util.*;

public class Vestigium {

    public static void main(String[] args) {
        try {
            // Main logic can be added here
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static void countRows(int[][] array, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (rowSet.contains(array[i][j])) {
                    count++;
                    break;
                }
                rowSet.add(array[i][j]);
            }
        }
        System.out.print(" " + count);
    }

    public static void countCols(int[][] array, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (colSet.contains(array[j][i])) {
                    count++;
                    break;
                }
                colSet.add(array[j][i]);
            }
        }
        System.out.print(" " + count);
    }
}