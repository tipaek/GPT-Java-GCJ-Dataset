
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            final int activities = in.nextInt();
            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(ints -> {
                return ints[0];
            }));
            for (int i1 = 0; i1 < activities; i1++) {
                int start = in.nextInt();
                int end = in.nextInt();
                int[] pair = {start, end, i1};
                queue.add(pair);
            }
            int lastJ = 0;
            int lastC = 0;
            final char[] schedule = new char[activities];
            boolean hasResult = true;
            while (!queue.isEmpty()) {
                int[] ac = queue.poll();
                if (ac[0] >= lastC) {
                    schedule[ac[2]] = 'C';
                    lastC = ac[1];
                } else if (ac[0] >= lastJ) {
                    schedule[ac[2]] = 'J';
                    lastJ = ac[1];
                } else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    hasResult = false;
                    break;
                }
            }
            if (hasResult) {
                System.out.println("Case #" + i + ": " + new String(schedule));
            }
        }
    }
}
