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

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += arr[i][i];
            }

            // Check for row repetitions
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[arr[i][j]]) {
                        rowRepeats++;
                        break;
                    }
                    rowCheck[arr[i][j]] = true;
                }
            }

            // Check for column repetitions
            for (int j = 0; j < n; j++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    if (colCheck[arr[i][j]]) {
                        colRepeats++;
                        break;
                    }
                    colCheck[arr[i][j]] = true;
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