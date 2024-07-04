import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < N; i++) {
                int[] rowCheck = new int[101];
                boolean rowHasDuplicates = false;
                for (int j = 0; j < N; j++) {
                    int num = scanner.nextInt();
                    matrix[i][j] = num;
                    rowCheck[num]++;
                    if (i == j) {
                        trace += num;
                    }
                    if (rowCheck[num] > 1) {
                        rowHasDuplicates = true;
                    }
                }
                if (rowHasDuplicates) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < N; j++) {
                int[] colCheck = new int[101];
                boolean colHasDuplicates = false;
                for (int i = 0; i < N; i++) {
                    int num = matrix[i][j];
                    colCheck[num]++;
                    if (colCheck[num] > 1) {
                        colHasDuplicates = true;
                    }
                }
                if (colHasDuplicates) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}