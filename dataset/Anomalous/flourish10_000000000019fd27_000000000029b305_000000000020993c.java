import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = getNumberOfTestCases(scanner);

        if (T > 1 && T < 100) {
            int[] k = new int[T], r = new int[T], c = new int[T];

            for (int t = 0; t < T; t++) {
                System.out.println("========= Matrix " + (t + 1) + " =========");
                int N = getMatrixSize(scanner);

                if (N > 2 && N < 100) {
                    int[][] M = readMatrix(scanner, N);
                    printMatrix(M, N);

                    k[t] = calculateDiagonalSum(M, N);
                    r[t] = calculateRowDuplicates(M, N);
                    c[t] = calculateColumnDuplicates(M, N);
                } else {
                    System.out.println("Size of matrix should be more than 2 and less than 100");
                }
            }

            printResults(T, k, r, c);
        } else {
            System.out.println("Number of test cases should be more than 1 and less than 100");
        }
    }

    private static int getNumberOfTestCases(Scanner scanner) {
        System.out.print("Enter number of test cases >> ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Number of test cases is not a valid integer");
            return 0;
        }
    }

    private static int getMatrixSize(Scanner scanner) {
        System.out.print("Enter size of the matrix >> ");
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Size of array is not a valid integer");
            return 0;
        }
    }

    private static int[][] readMatrix(Scanner scanner, int N) {
        int[][] M = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("Enter value of M[" + (i + 1) + "," + (j + 1) + "] = ");
                M[i][j] = scanner.nextInt();
            }
        }
        return M;
    }

    private static void printMatrix(int[][] M, int N) {
        for (int[] row : M) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static int calculateDiagonalSum(int[][] M, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += M[i][i];
        }
        return sum;
    }

    private static int calculateRowDuplicates(int[][] M, int N) {
        int rowDuplicates = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[101]; // assuming values are between 1 and 100
            for (int j = 0; j < N; j++) {
                if (seen[M[i][j]]) {
                    rowDuplicates++;
                    break;
                }
                seen[M[i][j]] = true;
            }
        }
        return rowDuplicates;
    }

    private static int calculateColumnDuplicates(int[][] M, int N) {
        int columnDuplicates = 0;
        for (int i = 0; i < N; i++) {
            boolean[] seen = new boolean[101]; // assuming values are between 1 and 100
            for (int j = 0; j < N; j++) {
                if (seen[M[j][i]]) {
                    columnDuplicates++;
                    break;
                }
                seen[M[j][i]] = true;
            }
        }
        return columnDuplicates;
    }

    private static void printResults(int T, int[] k, int[] r, int[] c) {
        System.out.println("Output");
        for (int t = 0; t < T; t++) {
            System.out.println("Case #" + (t + 1) + ": " + k[t] + " " + r[t] + " " + c[t]);
        }
    }
}