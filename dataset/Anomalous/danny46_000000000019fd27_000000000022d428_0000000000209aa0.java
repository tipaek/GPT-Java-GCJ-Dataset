import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            String result = solve(N, K);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    public static String solve(int N, int K) {
        if (K % N == 0) {
            StringBuilder result = new StringBuilder("POSSIBLE");
            int quotient = K / N;
            int[][] matrix = new int[N][N];

            for (int i = 0, offset = 0; i < N; i++) {
                matrix[i][i] = quotient;
                if (i + 1 == quotient) {
                    continue;
                }

                offset++;
                for (int j = 0; j < N; j++) {
                    matrix[j][(j + offset) % N] = i + 1;
                }
            }

            for (int i = 0; i < N; i++) {
                result.append('\n');
                for (int j = 0; j < N; j++) {
                    result.append(matrix[i][j]);
                }
            }

            return result.toString();
        } else {
            return "IMPOSSIBLE";
        }
    }
}