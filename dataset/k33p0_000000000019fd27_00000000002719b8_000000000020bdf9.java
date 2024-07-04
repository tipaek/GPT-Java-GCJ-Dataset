import java.util.*;
import java.io.*;
public class Solution {
    public static String formSchedule(int[] start, int[] end) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> rank = new HashMap<>();
        int[] partners = new int[]{-1, -1}; // 0, 1 => C, J respectively
        int[] order = new int[start.length];
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < start.length; i++) {
            map.put(start[i], end[i]);
            rank.put(end[i], i);
        }

        int count = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        int timing;
        int s = 0; //start index
        int e = 0; //end index
        boolean put;
        
        for (int i = 0; i < 2 * start.length; i++) {
            if (s == start.length) {
                timing = end[e];
                e++;
                put = false;
                count--;
            } else if (start[s] < end[e]) {
                timing = start[s];    
                s++;
                put = true;
                count++;
            } else {
                timing = end[e];
                e++;
                put = false;
                count--;
            }
            
            if (count > 2) {
                return "IMPOSSIBLE";
            }

            if (put) {
                int endTiming = map.get(timing);
                int pos = rank.get(endTiming);
                if (partners[0] == -1) {
                    //assign to first
                    partners[0] = pos; //store rank
                } else {
                    partners[1] = pos;
                    order[pos] = 1; //assign order to print

                }
            } else {
                if (partners[0] == rank.get(timing)) {
                    partners[0] = -1; // remove task from 1st 
                } else {
                    partners[1] = -1;
                }
            }
        }
        // print output
        for (int i = 0; i < order.length; i++) {
            if (order[i] == 0) {
                output.append("C");
            } else {
                output.append("J");
            }
        }

        return output.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int tasks = in.nextInt();
            int[] start = new int[tasks];
            int[] end = new int[tasks];
            for (int j = 0; j < tasks; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                start[j] = x;
                end[j] = y;
            }
            System.out.println("Case #" + i + ": " + formSchedule(start, end));
        }
    }
}
