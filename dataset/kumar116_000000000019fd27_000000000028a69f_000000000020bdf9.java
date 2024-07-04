import java.util.*;

public class Solution {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String schedule(int[] startTs, int[] endTs) {

        for (int i = 0; i < startTs.length - 1; i++) {
            for (int j = 0; j < startTs.length - i - 1; j++) {
                if (startTs[j] > startTs[j + 1]) {
                    swap(startTs, j, j + 1);
                    swap(endTs, j, j + 1);
                }
            }
        }

        Queue<String> queue = new LinkedList<String>();
        int endC, endJ;
        endC = endJ = Integer.MIN_VALUE;

        for (int i = 0; i < startTs.length; i++) {
            if (endC == Integer.MIN_VALUE || startTs[i] >= endC) {
                endC = endTs[i];
                queue.add("C");
            } else if (endJ == Integer.MIN_VALUE || startTs[i] >= endJ) {
                endJ = endTs[i];
                queue.add("J");
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
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

            System.out.println("Case #" + (i + 1) + ": " + schedule(startTs, endTs));
        }
    }
}
