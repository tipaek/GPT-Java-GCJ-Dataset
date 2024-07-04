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
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            // Read the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Check for row repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (seen[arr[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            // Check for column repeats
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (seen[arr[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    seen[arr[i][j]] = true;
                }
            }

            System.out.println("Trace: " + trace);
            System.out.println("Row Repeats: " + rowRepeats);
            System.out.println("Column Repeats: " + colRepeats);

            t--;
        }

        sc.close();
    }
}