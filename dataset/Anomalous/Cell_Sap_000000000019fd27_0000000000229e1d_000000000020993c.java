import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int diagonalSum = 0, rowRepeats = 0, colRepeats = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                    if (row == col) {
                        diagonalSum += matrix[row][col];
                    }
                }
            }

            int[] countArray = new int[101]; // Assuming values are between 1 and 100

            for (int row = 0; row < n; row++) {
                Arrays.fill(countArray, 0);
                for (int col = 0; col < n; col++) {
                    countArray[matrix[row][col]]++;
                    if (countArray[matrix[row][col]] > 1) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int col = 0; col < n; col++) {
                Arrays.fill(countArray, 0);
                for (int row = 0; row < n; row++) {
                    countArray[matrix[row][col]]++;
                    if (countArray[matrix[row][col]] > 1) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + diagonalSum + " " + rowRepeats + " " + colRepeats);
        }

        sc.close();
    }
}