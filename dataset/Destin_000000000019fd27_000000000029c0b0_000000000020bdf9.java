import java.util.*;
import java.lang.reflect.Array;

public class Solution {
    public static String parentingPartnering(int[][] intervals) {
        int n = intervals.length;
        char[] ca = new char[n];
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(5, (a,b) -> a[1] - b[1]);
        int count = 0;
        for (int i = 0; i< n; i++) {
            int[] itv = intervals[i];
            if (heap.isEmpty()) {
                count++;
            } else {
                if (itv[0] >= (int)Array.get(heap.peek(), 1)) {
                    heap.poll();
                } else {
                    count++;
                    if (count > 2) {
                        return "IMPOSSIBLE";
                    }
                }
            }
            if (heap.isEmpty()) {
                ca[itv[2]] = 'C';
            } else {
                ca[itv[2]] = (ca[(int)Array.get(heap.peek(), 2)] == 'C') ? 'J' : 'C';
            }
            heap.offer(itv);
        }
        return new String(ca);
    }
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = Integer.valueOf(s.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = s.nextInt();
            int[][] intervals = new int[N][3];
            for (int n = 0; n < N; n++) {
                intervals[n][0] = s.nextInt();
                intervals[n][1] = s.nextInt();
                intervals[n][2] = n;
            }
            String res = parentingPartnering(intervals);
            String result = "Case #" + t + ": " + res;
            System.out.println(result);
        }
    }
}