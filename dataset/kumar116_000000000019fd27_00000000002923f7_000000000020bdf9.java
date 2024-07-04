import java.util.*;

public class Solution {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String schedule(int[] startTs, int[] endTs, int N) {

        int[] order = new int[N];
        for (int i = 0; i < N; i++) {
            order[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (startTs[j] > startTs[j + 1]) {
                    swap(startTs, j, j + 1);
                    swap(endTs, j, j + 1);
                    swap(order, j, j + 1);
                }
            }
        }

        String[] answer = new String[N];
        int endC, endJ;
        endC = endJ = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (startTs[i] >= endC) {
                endC = endTs[i];
                answer[i] = "C";
            } else if (startTs[i] >= endJ) {
                endJ = endTs[i];
                answer[i] = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (order[j] > order[j + 1]) {
                    swap(order, j, j + 1);
                    swap(answer, j, j + 1);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {

            int N = scanner.nextInt();
            int[] startTs = new int[N];
            int[] endTs = new int[N];

            for (int n = 0; n < N; n++) {
                startTs[n] = scanner.nextInt();
                endTs[n] = scanner.nextInt();
            }

            System.out.println("Case #" + (i + 1) + ": " + schedule(startTs, endTs, N));
        }
    }
}
