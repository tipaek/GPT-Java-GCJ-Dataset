import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        int caseNumber = 1;

        while (testCases-- > 0) {
            boolean isPossible = false;
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int targetSum = Integer.parseInt(tokenizer.nextToken());

            for (int offset = 1; offset <= N; offset++) {
                int sum = 0;

                for (int i = 0; i < N; i++) {
                    int value = (i + i + offset) % N;
                    if (value == 0) {
                        value = N;
                    }
                    sum += value;
                }

                if (sum == targetSum) {
                    System.out.println("Case #" + caseNumber + ": POSSIBLE");
                    printMatrix(N, offset);
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                for (int i = 1; i <= N; i++) {
                    int sum = i * N;

                    if (sum == targetSum) {
                        System.out.println("Case #" + caseNumber + ": POSSIBLE");
                        printMatrixWithIncrement(N, i);
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

    private static void printMatrix(int N, int offset) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int value = (i + j + offset) % N;
                if (value == 0) {
                    value = N;
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void printMatrixWithIncrement(int N, int startValue) {
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
            value = (value - 1) % N;
            System.out.println();
        }
    }
}