import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int caseNumber = 1;

        while (t-- > 0) {
            boolean isPossible = false;
            StringTokenizer str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int k = Integer.parseInt(str.nextToken());

            for (int offset = 1; offset <= N; offset++) {
                int sum = calculateSum(N, offset);
                if (sum == k) {
                    printPossibleCase(caseNumber, N, offset);
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                for (int i = 1; i <= N; i++) {
                    int sum = i * N;
                    if (sum == k) {
                        printPossibleCase(caseNumber, N, i, true);
                        isPossible = true;
                        break;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
    }

    private static int calculateSum(int N, int offset) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int x = (i + i + offset) % N;
            if (x == 0) {
                x = N;
            }
            sum += x;
        }
        return sum;
    }

    private static void printPossibleCase(int caseNumber, int N, int offset) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = (i + j + offset) % N;
                if (x == 0) {
                    x = N;
                }
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void printPossibleCase(int caseNumber, int N, int startValue, boolean isLinear) {
        System.out.println("Case #" + caseNumber + ": POSSIBLE");
        int value = startValue;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int result = value % N;
                if (result == 0) {
                    value = N;
                } else {
                    value = result;
                }
                System.out.print(value + " ");
                value++;
            }
            value = (value - 1) % N == 0 ? N : (value - 1) % N;
            System.out.println();
        }
    }
}