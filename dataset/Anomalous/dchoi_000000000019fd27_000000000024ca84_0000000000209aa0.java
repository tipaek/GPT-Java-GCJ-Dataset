import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            // Determine possible trace values
            List<Integer> possibleTraces = new ArrayList<>();
            int sum = 0;
            for (int n = 1; n <= N; n++) {
                sum += n;
                possibleTraces.add(n * N);
            }
            if (N > 2) {
                possibleTraces.add(sum);
            }

            if (possibleTraces.contains(K)) {
                System.out.println("Case #" + test_case + ": POSSIBLE");

                if (K % N != 0) {
                    printMatrix(N, true);
                    printMatrix(N, false);
                } else {
                    int start = K / N;
                    printMatrixWithStart(N, start);
                }
            } else {
                System.out.println("Case #" + test_case + ": IMPOSSIBLE");
            }
        }
    }

    private static void printMatrix(int N, boolean forward) {
        for (int i = 0; i < N / 2; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                int value = forward ? j + 1 : N - j;
                sb.append(value).append(" ");
            }
            String line = sb.toString().trim();
            int rotationPoint = (line.length() - (i * 4) % line.length()) % line.length();
            String rotated = line.substring(rotationPoint) + line.substring(0, rotationPoint);
            System.out.println(rotated);
        }
    }

    private static void printMatrixWithStart(int N, int start) {
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            int rowStart = (i == 0) ? start : start + (N - i);
            rowStart = rowStart == 0 ? N : rowStart;
            for (int j = 0; j < N; j++) {
                int num = (rowStart + j) % N;
                num = num == 0 ? N : num;
                sb.append(num).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}