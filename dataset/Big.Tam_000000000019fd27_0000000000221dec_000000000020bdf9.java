import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            int intervalNum = in.nextInt();
            int[][] intervals = new int[intervalNum][2];
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for(int i = 0; i < intervalNum; i++)
            {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();

                pq.offer(new int[]{intervals[i][0], intervals[i][1], i});
            }

            int cEnd = -1, jEnd = -1;
            char[] res = new char[intervalNum];
            boolean impossible = false;
            while (!pq.isEmpty())
            {
                int[] curr = pq.poll();
                if(curr[0] >= cEnd) {
                    res[curr[2]] = 'C';
                    cEnd = curr[1];
                }
                else if(curr[0] >= jEnd)
                {
                    res[curr[2]] = 'J';
                    jEnd = curr[1];
                }
                else {
                    impossible = true;
                    break;
                }
            }


            System.out.println("Case #" + index + ": " + (impossible ? "IMPOSSIBLE": String.valueOf(res)));
        }
    }
}