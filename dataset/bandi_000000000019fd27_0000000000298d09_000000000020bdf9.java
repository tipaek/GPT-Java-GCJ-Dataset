import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int k = in.nextInt();
            int[][] intervals = new int[k][2];

            for (int j = 0; j < k; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }

            String ans = "Case #"+i+": ";
            System.out.println(ans + minMeetingRooms(intervals));
        }
    }

    private static String minMeetingRooms(int[][] intervals) {
        String seq = "";
        int ct = 0;
        int jt = 0;
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;

        if (intervals.length == 0)
            return "IMPOSSIBLE";

        if (intervals.length == 1)
            return "C";

        for (int[] itv : intervals) {



            if (heap.isEmpty()) {
                seq = seq.concat("C");
                ct = itv[1];
                count++;
                heap.offer(itv[1]);
            }

            else {



                if (itv[0] >= heap.peek()) {
                    if (ct <= itv[0]) {
                        seq = seq.concat("C");
                        ct = itv[1];
                    }
                    else if (jt <= itv[0]){
                        seq = seq.concat("J");
                        jt = itv[1];
                    }
                    heap.poll();
                }

                else {
                    if(jt == 0){
                        seq = seq.concat("J");
                        jt = itv[1];
                    }

                    if(ct == 0){
                        seq = seq.concat("C");
                        ct = itv[1];
                    }

                    count++;

                    if (count > 2)
                        return "IMPOSSIBLE";


                }



                heap.offer(itv[1]);
            }
        }


        return seq;
    }
}
