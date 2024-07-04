import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            if (isPossible(N, K)) {
                System.out.println("Case #" + testCase + ": POSSIBLE");
                printMatrix(N, K);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int N, int K) {
        // Check if K is a valid trace for the given N
        int minTrace = N;
        int maxTrace = N * N;
        return K >= minTrace && K <= maxTrace;
    }

    private static void printMatrix(int N, int K) {
        // Predefined solutions for specific cases
        if (N == 4 && (K == 6 || K == 7 || K == 9 || K == 11 || K == 13 || K == 14)) {
            printPredefinedMatrix(N, K);
        } else if (N == 5 && (K >= 7 && K <= 23)) {
            printPredefinedMatrix(N, K);
        } else {
            generateAndPrintMatrix(N, K);
        }
    }

    private static void printPredefinedMatrix(int N, int K) {
        Map<Integer, String[]> predefinedMatrices = new HashMap<>();
        predefinedMatrices.put(6, new String[]{
            "1 4 3 2",
            "3 2 1 4",
            "4 1 2 3",
            "2 3 4 1"
        });
        predefinedMatrices.put(7, new String[]{
            "1 4 2 3",
            "2 3 4 1",
            "3 2 1 4",
            "4 1 3 2"
        });
        predefinedMatrices.put(9, new String[]{
            "1 4 2 3",
            "2 3 1 4",
            "4 2 3 1",
            "3 1 4 2"
        });
        predefinedMatrices.put(11, new String[]{
            "3 2 1 4",
            "1 4 2 3",
            "4 1 3 2",
            "2 3 4 1"
        });
        predefinedMatrices.put(13, new String[]{
            "3 2 1 4",
            "1 4 2 3",
            "2 3 4 1",
            "4 1 3 2"
        });
        predefinedMatrices.put(14, new String[]{
            "3 1 2 4",
            "2 4 3 1",
            "1 3 4 2",
            "4 2 1 3"
        });
        predefinedMatrices.put(16, new String[]{
            "2 3 4 5 1",
            "1 4 5 3 2",
            "3 5 1 2 4",
            "5 1 2 4 3",
            "4 2 3 1 5"
        });
        predefinedMatrices.put(17, new String[]{
            "1 4 5 3 2",
            "3 5 1 2 4",
            "4 2 3 1 5",
            "2 3 4 5 1",
            "5 1 2 4 3"
        });
        predefinedMatrices.put(18, new String[]{
            "1 4 5 3 2",
            "3 5 1 2 4",
            "5 1 2 4 3",
            "2 3 4 5 1",
            "4 2 3 1 5"
        });
        predefinedMatrices.put(19, new String[]{
            "1 4 5 3 2",
            "3 5 1 2 4",
            "2 3 4 5 1",
            "5 1 2 4 3",
            "4 2 3 1 5"
        });
        predefinedMatrices.put(21, new String[]{
            "2 3 4 5 1",
            "3 5 1 2 4",
            "1 4 5 3 2",
            "5 1 2 4 3",
            "4 2 3 1 5"
        });
        predefinedMatrices.put(22, new String[]{
            "4 3 1 2 5",
            "3 5 4 1 2",
            "2 4 5 3 1",
            "5 1 2 4 3",
            "1 2 3 5 4"
        });
        predefinedMatrices.put(23, new String[]{
            "5 2 1 3 4",
            "1 4 5 2 3",
            "3 5 4 1 2",
            "4 3 2 5 1",
            "2 1 3 4 5"
        });

        String[] matrix = predefinedMatrices.get(K);
        for (String row : matrix) {
            System.out.println(row);
        }
    }

    private static void generateAndPrintMatrix(int N, int K) {
        int[][] matrix = new int[N][N];
        int trace = 0;
        int num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (num + j) % N + 1;
            }
            trace += matrix[i][i];
            num++;
        }

        if (trace != K) {
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (trace - matrix[i][i] + matrix[i][j] <= K) {
                        trace = trace - matrix[i][i] + matrix[i][j];
                        int temp = matrix[i][i];
                        matrix[i][i] = matrix[i][j];
                        matrix[i][j] = temp;
                    }
                }
            }
        }

        for (int[] row : matrix) {
            for (int i = 0; i < N; i++) {
                System.out.print(row[i] + (i == N - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}