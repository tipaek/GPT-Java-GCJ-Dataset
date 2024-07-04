import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Oleg Cherednik
 * @since 04.04.2020
 */
public class Solution {

    public static void main(String... args) throws IOException {
        try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int total = scan.nextInt();

            for (int i = 0; i < total; i++) {
                int n = scan.nextInt();
                int[][] matrix = new int[n][n];
                boolean[] arr = new boolean[n + 1];

                int k = 0;
                int r = 0;
                int c = 0;

                for (int row = 0; row < n; row++) {
                    Arrays.fill(arr, false);
                    boolean duplicates = false;

                    for (int col = 0; col < n; col++) {
                        matrix[row][col] = scan.nextInt();

                        if (row == col)
                            k += matrix[row][col];

                        if (arr[matrix[row][col]])
                            duplicates = true;
                        else
                            arr[matrix[row][col]] = true;
                    }

                    if (duplicates)
                        r++;
                }

                for (int col = 0; col < n; col++) {
                    Arrays.fill(arr, false);
                    boolean duplicates = false;

                    for (int row = 0; row < n; row++) {
                        if (arr[matrix[row][col]])
                            duplicates = true;
                        else
                            arr[matrix[row][col]] = true;
                    }

                    if (duplicates)
                        c++;
                }

                System.out.format("Case #%d: %d %d %d\n", i + 1, k, r, c);
            }
        }
    }

}