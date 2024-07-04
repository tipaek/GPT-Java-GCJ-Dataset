import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int l = 1; l <= t; l++) {
            int n = in.nextInt();
            int[][] m = new int[n][2];
            for (int i = 0; i < n; i++) {
                m[i][0] = in.nextInt();
                m[i][1] = in.nextInt();
            }
            solve(l, n, m);
        }
    }


    public static void solve(int t, int n, int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        char[] name = new char[n];
        for (int i = 0; i < n; i++) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(intervals[i][1]);
            } else {
                if (intervals[i][0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }
                heap.offer(intervals[i][1]);
            }
            name[i] = i % 2 == 0 ? 'J' : 'C';
        }
        String ans = new String(name);
        if (count > 2) {
            ans = "IMPOSSIBLE";
        }
        System.out.println(String.format("Case #%d: %s", t, ans));
    }
}