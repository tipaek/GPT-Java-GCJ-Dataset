import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();

        for (int l = 1; l <= h; l++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculating the diagonal sum
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            // Counting rows with duplicates
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        rowDuplicates++;
                        break;
                    }
                }
            }

            // Counting columns with duplicates
            int colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (!colSet.add(arr[i][j])) {
                        colDuplicates++;
                        break;
                    }
                }
            }

            // Printing the result
            System.out.println("Case #" + l + ": " + sum + " " + rowDuplicates + " " + colDuplicates);
        }

        sc.close();
    }
}