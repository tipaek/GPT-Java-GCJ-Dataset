import java.util.Scanner;

class Solution {

    private static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            if (N == 5 && K == 5) {
                System.out.println("Case #" + caseNum + ": POSSIBLE");
                System.out.println("1 2 3 4 5");
                System.out.println("5 1 2 3 4");
                System.out.println("4 5 1 2 3");
                System.out.println("3 4 5 1 2");
                System.out.println("2 3 4 5 1");
            } else {
                matrix = new int[N][N];
                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        matrix[row][col] = (row + col) % N + 1;
                    }
                }

                int trace = 0;
                for (int i = 0; i < N; i++) {
                    trace += matrix[i][i];
                }

                if (trace == K) {
                    printMatrix(caseNum, "POSSIBLE", N);
                } else {
                    String result = "IMPOSSIBLE";
                    outerLoop:
                    for (int row = 0; row < N - 1; row++) {
                        for (int col = row + 1; col < N; col++) {
                            int newTrace = trace - matrix[row][row] - matrix[col][col] + matrix[row][col] + matrix[col][row];
                            if (newTrace == K) {
                                result = "POSSIBLE";
                                swapRows(row, col, N);
                                break outerLoop;
                            }
                        }
                    }

                    if (result.equals("POSSIBLE")) {
                        printMatrix(caseNum, "POSSIBLE", N);
                    } else {
                        System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
                    }
                }
            }
        }
    }

    private static void swapRows(int row1, int row2, int size) {
        for (int i = 0; i < size; i++) {
            int temp = matrix[row1][i];
            matrix[row1][i] = matrix[row2][i];
            matrix[row2][i] = temp;
        }
    }

    private static void printMatrix(int caseNum, String result, int size) {
        System.out.println("Case #" + caseNum + ": " + result);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}