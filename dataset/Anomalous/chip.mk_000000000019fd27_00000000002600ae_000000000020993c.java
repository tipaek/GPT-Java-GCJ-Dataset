import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(reader)
        ) {
            scanner.useLocale(Locale.US);
            int testCases = scanner.nextInt();
            
            for (int t = 1; t <= testCases; t++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                
                int diagonalSum = 0;
                for (int i = 0; i < n; i++) {
                    diagonalSum += matrix[i][i];
                }

                int[] occurrence = new int[n];
                int rowDuplicates = 0;
                
                for (int i = 0; i < n; i++) {
                    Arrays.fill(occurrence, 0);
                    for (int j = 0; j < n; j++) {
                        if (++occurrence[matrix[i][j] - 1] > 1) {
                            rowDuplicates++;
                            break;
                        }
                    }
                }
                
                int colDuplicates = 0;
                for (int j = 0; j < n; j++) {
                    Arrays.fill(occurrence, 0);
                    for (int i = 0; i < n; i++) {
                        if (++occurrence[matrix[i][j] - 1] > 1) {
                            colDuplicates++;
                            break;
                        }
                    }
                }

                System.out.printf("Case #%d: %d %d %d%n", t, diagonalSum, rowDuplicates, colDuplicates);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}