import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];

            Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> arr[a][0]));
            for (int k = 0; k < n; k++) {
                arr[k] = new int[2];
                arr[k][0] = in.nextInt();
                arr[k][1] = in.nextInt();
                queue.offer(k);
            }

            char[] res = new char[n];
            int cameronLast = 0;
            int jamieLast = 0;

            boolean possible = true;
            for (int k = 0; k < n; k++) {
                int num = queue.poll();
                int[] curr = arr[num];
                if (cameronLast > curr[0] && jamieLast > curr[0]) {
                    possible = false;
                    break;
                }

                if (cameronLast <= curr[0]) {
                    res[num] = 'C';
                    cameronLast = curr[1];
                } else {
                    res[num] = 'J';
                    jamieLast = curr[1];
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
                continue;
            }

            StringBuilder order = new StringBuilder();
            for (int k = 0; k < n; k++) {
                order.append(res[k]);
            }

            System.out.println("Case #" + i + ": " + order.toString());
        }
    }
}