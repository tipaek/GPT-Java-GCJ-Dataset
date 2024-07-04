import java.util.Scanner;

public class Vestigium {
    private int N;
    private int[][] matrix;
    private int[] rowDuplicates, colDuplicates;
    private int traceSum;

    public Vestigium() {
        N = 0;
        traceSum = 0;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of N:");
        N = scanner.nextInt();
        scanner.close();
    }

    public void process() {
        matrix = new int[N][N];
        rowDuplicates = new int[N];
        colDuplicates = new int[N];

        // Fill the matrix with random values between 1 and N
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 1 + (int) (Math.random() * N);
            }
        }

        // Calculate the trace of the matrix
        for (int i = 0; i < N; i++) {
            traceSum += matrix[i][i];
        }

        // Check for duplicate values in rows
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                if (seen[matrix[i][j]]) {
                    rowDuplicates[i] = 1;
                    break;
                }
                seen[matrix[i][j]] = true;
            }
        }

        // Check for duplicate values in columns
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[N + 1];
            for (int j = 0; j < N; j++) {
                if (seen[matrix[j][i]]) {
                    colDuplicates[i] = 1;
                    break;
                }
                seen[matrix[j][i]] = true;
            }
        }
    }

    public void output() {
        // Print the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        // Print the trace sum
        System.out.print("Trace: " + traceSum + "\t");

        // Print the rows with duplicates
        System.out.print("Rows with duplicates: ");
        for (int i = 0; i < N; i++) {
            if (rowDuplicates[i] == 1) {
                System.out.print(i + "\t");
            }
        }

        // Print the columns with duplicates
        System.out.print("Columns with duplicates: ");
        for (int i = 0; i < N; i++) {
            if (colDuplicates[i] == 1) {
                System.out.print(i + "\t");
            }
        }
    }

    public static void main(String[] args) {
        Vestigium vestigium = new Vestigium();
        vestigium.input();
        vestigium.process();
        vestigium.output();
    }
}