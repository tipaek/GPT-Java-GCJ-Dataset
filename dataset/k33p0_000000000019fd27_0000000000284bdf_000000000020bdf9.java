import java.util.*;
import java.io.*;
public class Solution {
    static class Pair implements Comparable<Pair> {
        private int x;
        private int y;
        private int index;
        
        Pair(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return this.x != other.x ? this.x - other.x : this.y - other.y;
        }
    }

    public static String formSchedule(int[] start, int[] end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(1);    
        int x = -1;
        int y = -1;
        int[] arr = new int[start.length];
        for (int i = 0; i < start.length; i++) {
            pq.add(new Pair(start[i], end[i], i));
        }
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if (x == -1) {
                x = pair.y;
            } else if (y == -1) {
                y = pair.y;
                arr[pair.index] = 1;
            } else {
                if (x <= pair.x) {
                    x = pair.y;
                } else if (y <= pair.x) {
                    y = pair.y;
                    arr[pair.index] = 1;
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                sb.append("C");
            } else {
                sb.append("J");
            }
        }
        return sb.toString();
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
