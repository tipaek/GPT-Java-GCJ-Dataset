import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = sc.nextInt();
        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < cases; i++) {
            int matrixSize = sc.nextInt();
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int j = 0; j < matrixSize; j++) {
                for (int k = 0; k < matrixSize; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int j = 0; j < matrixSize; j++) {
                trace += matrix[j][j];

                if (hasDuplicates(matrix[j])) {
                    duplicateRows++;
                }

                int[] colArray = new int[matrixSize];
                for (int k = 0; k < matrixSize; k++) {
                    colArray[k] = matrix[k][j];
                }

                if (hasDuplicates(colArray)) {
                    duplicateCols++;
                }
            }

            results.add(String.format("%d %d %d", trace, duplicateRows, duplicateCols));
        }

        sc.close();

        for (int i = 0; i < cases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results.get(i));
        }
    }

    private static boolean hasDuplicates(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}