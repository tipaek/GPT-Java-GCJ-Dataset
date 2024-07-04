import java.util.*;

public class Prob1 {
    public static void main(String[] args) {
        try {
            // Your main logic here
        } catch (Exception e) {
            System.exit(0);
        }
    }

    public static void countRows(int[][] array, int n) throws Exception {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean duplicateFound = false;
            for (int j = 0; j < n && !duplicateFound; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (array[i][j] == array[i][k]) {
                        count++;
                        duplicateFound = true;
                        break;
                    }
                }
            }
        }
        System.out.print(" " + count);
    }

    public static void countCols(int[][] array, int n) throws Exception {
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean duplicateFound = false;
            for (int j = 0; j < n && !duplicateFound; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (array[j][i] == array[k][i]) {
                        count++;
                        duplicateFound = true;
                        break;
                    }
                }
            }
        }
        System.out.print(" " + count);
    }
}