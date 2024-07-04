import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int tc = 1; tc <= testCases; tc++) {
            int N = scanner.nextInt();
            int D = scanner.nextInt();
            long[] arr = new long[N];

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextLong();
            }

            Arrays.sort(arr);
            int answer = 0;

            if (D == 2) {
                answer = findAnswerForD2(arr);
            } else if (D == 3) {
                answer = findAnswerForD3(arr, N);
            }

            System.out.println("Case #" + tc + ": " + answer);
        }

        scanner.close();
    }

    private static int findAnswerForD2(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return 0;
            }
        }
        return 1;
    }

    private static int findAnswerForD3(long[] arr, int N) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1] && arr[i] == arr[i + 2]) {
                return 0;
            }
        }

        if (N == 1) {
            return 2;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            long a = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] % a == 0 && a != arr[j]) {
                    return 1;
                }
            }
        }

        return 2;
    }
}