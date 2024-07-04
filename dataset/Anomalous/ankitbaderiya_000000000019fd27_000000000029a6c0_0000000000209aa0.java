import java.util.Scanner;

class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        if (t >= 1 && t <= 100) {
            for (int x = 0; x < t; x++) {
                int n = scanner.nextInt();
                if (n >= 2 && n <= 50) {
                    int[][] matrix = new int[n][n];
                    for (int j = 0; j < n; j++) {
                        int sum = j + 1;
                        for (int i = 0; i < n; i++) {
                            matrix[i][j] = sum % n + 1;
                            if (sum == n) {
                                sum = 0;
                            }
                            sum++;
                        }
                    }
                    int k = scanner.nextInt();
                    if (k >= n && k <= n * n) {
                        processMatrix(matrix, x + 1, k);
                    }
                }
            }
        }
    }

    private static void processMatrix(int[][] matrix, int caseNumber, int targetTrace) {
        int trace = 0;
        int swapCounter = 0;
        boolean isPossible = false;
        
        while (swapCounter <= matrix.length) {
            trace = calculateTrace(matrix);
            
            if (trace == targetTrace) {
                isPossible = true;
                break;
            } else {
                performSwaps(matrix);
                swapCounter++;
            }
        }
        
        if (isPossible) {
            System.out.println("Case #" + caseNumber + ": POSSIBLE");
            printMatrix(matrix);
        } else {
            System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
        }
    }

    private static int calculateTrace(int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static void performSwaps(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][0];
            matrix[i][0] = matrix[i][i + 1];
            matrix[i][i + 1] = temp;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}