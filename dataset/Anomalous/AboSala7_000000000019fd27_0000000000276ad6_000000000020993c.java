import java.util.Scanner;
import java.util.HashMap;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsNum = sc.nextInt();

        for (int test = 1; test <= testsNum; test++) {
            int arraySize = sc.nextInt();
            int[][] matrix = new int[arraySize][arraySize];

            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < arraySize; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < arraySize; i++) {
                if (hasDuplicates(matrix[i])) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < arraySize; j++) {
                int[] col = new int[arraySize];
                for (int i = 0; i < arraySize; i++) {
                    col[i] = matrix[i][j];
                }
                if (hasDuplicates(col)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + test + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }

    private static boolean hasDuplicates(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 1);
        }
        return false;
    }
}