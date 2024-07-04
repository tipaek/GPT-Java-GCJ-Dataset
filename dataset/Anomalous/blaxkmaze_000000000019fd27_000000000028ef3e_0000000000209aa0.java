import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String POSSIBLE = "POSSIBLE";
    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static int[][] solutionMatrix;

    private static boolean isPossible(int N, int trace) {
        if (N == 0 || trace > N * N || trace < N) {
            return false;
        }

        int total = N * (N + 1) / 2;
        if (trace % N != 0 && total != trace) return false;

        boolean reverse = trace % N != 0;
        solutionMatrix = new int[N][N];

        int traceNum = trace / N;
        int start = 1;
        for (int i = 0; i < N; i++) {
            if (start == traceNum) start++;
            solutionMatrix[i][i] = traceNum;

            int x = 0, y = i + 1;
            while (x < N && y < N) {
                solutionMatrix[x++][y++] = start;
            }
            x = N - i - 1;
            y = 0;
            while (x < N && y < N && x > 0) {
                solutionMatrix[x++][y++] = start;
            }
            start++;
        }

        if (reverse) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N / 2; j++) {
                    swap(solutionMatrix[i], j, N - 1 - j);
                }
            }
        }

        return true;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int N = scanner.nextInt();
            int trace = scanner.nextInt();
            boolean result = isPossible(N, trace);
            
            StringBuilder output = new StringBuilder();
            output.append("Case #").append(i).append(": ").append(result ? POSSIBLE : IMPOSSIBLE);
            System.out.println(output);

            if (result) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        System.out.print(solutionMatrix[x][y]);
                        if (y < N - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }
}