import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 0, n = 0;

        // Input test cases
        while (true) {
            System.out.println("Enter Test cases between 1 and 100");
            t = sc.nextInt();
            if (t >= 1 && t <= 100) {
                break;
            }
        }

        for (int l = 1; l <= t; l++) {
            // Input matrix dimension
            while (true) {
                System.out.println("Enter N between 2 and 100");
                n = sc.nextInt();
                if (n >= 2 && n <= 100) {
                    break;
                }
            }

            int[][] matrix = new int[n][n];

            // Input matrix values
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.println("Enter value at " + i + " row and " + j + " Column between 1 and " + n);
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0, r_same = 0, c_same = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate rows with repeated values
            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (rowCheck[matrix[i][j]]) {
                        r_same++;
                        break;
                    }
                    rowCheck[matrix[i][j]] = true;
                }
            }

            // Calculate columns with repeated values
            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    if (colCheck[matrix[j][i]]) {
                        c_same++;
                        break;
                    }
                    colCheck[matrix[j][i]] = true;
                }
            }

            System.out.println(trace + " " + r_same + " " + c_same);
        }
    }
}