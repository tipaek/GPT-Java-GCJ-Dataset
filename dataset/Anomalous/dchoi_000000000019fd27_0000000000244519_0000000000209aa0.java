import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            if (isPossible(N, K)) {
                System.out.println("Case #" + test_case + ": POSSIBLE");
                printMatrix(N, K);
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int N, int K) {
        List<Integer> possibleTraces = new ArrayList<>();
        int sum = 0;
        for (int n = 1; n <= N; n++) {
            sum += n;
            possibleTraces.add(n * N);
        }
        if (N > 2) {
            possibleTraces.add(sum);
        }
        return possibleTraces.contains(K);
    }

    private static void printMatrix(int N, int K) {
        int sum = (N * (N + 1)) / 2;
        if (K == sum) {
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    int num = (i + j) % N;
                    num = num == 0 ? N : num;
                    System.out.print(num + (j < N ? " " : ""));
                }
                System.out.println();
            }
        } else {
            int start = K / N;
            for (int i = 0; i < N; i++) {
                int rowStart = (i == 0) ? start : start + (N - i);
                rowStart = rowStart == 0 ? N : rowStart;
                for (int j = 0; j < N; j++) {
                    int num = (rowStart + j) % N;
                    num = num == 0 ? N : num;
                    System.out.print(num + (j < N ? " " : ""));
                }
                System.out.println();
            }
        }
    }
}