import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter T");
        int t = sc.nextInt();

        while (t > 0) {
            System.out.println("Enter N");
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            // Reading matrix input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate trace (sum of diagonal elements)
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Calculate number of rows with duplicate elements
            int rowDuplicates = 0;
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowDuplicates++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Calculate number of columns with duplicate elements
            int colDuplicates = 0;
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        colDuplicates++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Print results
            System.out.println("Trace: " + trace);
            System.out.println("Row Duplicates: " + rowDuplicates);
            System.out.println("Column Duplicates: " + colDuplicates);

            t--;
        }

        sc.close();
    }
}