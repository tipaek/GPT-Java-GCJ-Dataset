import java.util.*;

public class Solution {

    public static String schedule(int[] startTs, int[] endTs) {

        for (int j = 1; j < startTs.length; j++) {
            int startVal = startTs[j];
            int endVal = endTs[j];
            int i = j - 1;
            while (i >= 0 && startTs[i] > startVal) {
                startTs[i + 1] = startTs[i];
                endTs[i + 1] = endTs[i];
                i = i - 1;
            }
            startTs[i + 1] = startVal;
            endTs[i + 1] = endVal;
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
