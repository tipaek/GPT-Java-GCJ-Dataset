import java.util.Scanner;

public class Trace {
    public static void main(String[] args) {
        int[][] ar = new int[100][100];
        int sum = 0;
        int r = 0, c = 0;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        // Reading the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ar[i][j] = scanner.nextInt();
            }
        }

        // Calculating the trace of the matrix
        for (int i = 0; i < n; i++) {
            sum += ar[i][i];
        }

        // Counting consecutive identical elements in rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (ar[i][j] == ar[i][j + 1]) {
                    c++;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (ar[i][j] == ar[i + 1][j]) {
                    r++;
                }
            }
        }

        System.out.print(sum + " ");
        System.out.print(r + " ");
        System.out.println(c);
    }
}