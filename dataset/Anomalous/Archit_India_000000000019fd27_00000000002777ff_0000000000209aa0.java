import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] M = new int[N][N];
            
            // Fill the matrix with values
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    M[j][k] = (j + k) % N + 1;
                }
            }
            
            int trace = 0;
            for (int j = 0; j < N; j++) {
                trace += M[j][j];
            }
            
            if (trace == K) {
                printResult(i, "POSSIBLE", M);
            } else {
                boolean found = false;
                for (int j = 0; j < N - 1 && !found; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int newTrace = trace - M[j][j] - M[k][k] + M[j][k] + M[k][j];
                        if (newTrace == K) {
                            // Swap rows j and k
                            int[] temp = M[j];
                            M[j] = M[k];
                            M[k] = temp;
                            printResult(i, "POSSIBLE", M);
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    printResult(i, "IMPOSSIBLE", null);
                }
            }
        }
    }

    private static void printResult(int caseNumber, String result, int[][] matrix) {
        System.out.println("Case #" + caseNumber + ": " + result);
        if ("POSSIBLE".equals(result) && matrix != null) {
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}