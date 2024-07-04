import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void calcVestigium() {
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Boolean> rowMap = new HashMap<>();
            boolean rowHasDuplicate = false;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
                if (rowMap.containsKey(matrix[i][j]) && !rowHasDuplicate) {
                    rowDuplicates++;
                    rowHasDuplicate = true;
                }
                rowMap.put(matrix[i][j], true);
                if (i == j) {
                    trace += matrix[i][j];
                }
            }
        }

        for (int j = 0; j < n; j++) {
            HashMap<Integer, Boolean> colMap = new HashMap<>();
            boolean colHasDuplicate = false;
            for (int i = 0; i < n; i++) {
                if (colMap.containsKey(matrix[i][j]) && !colHasDuplicate) {
                    colDuplicates++;
                    colHasDuplicate = true;
                }
                colMap.put(matrix[i][j], true);
            }
        }

        System.out.println(trace + " " + rowDuplicates + " " + colDuplicates);
    }

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            calcVestigium();
        }
    }
}