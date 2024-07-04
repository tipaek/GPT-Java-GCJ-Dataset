import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int tasks = in.nextInt();
            int[] j = new int[1440];
            int[] c = new int[1440];
            char[] res = new char[tasks];

            PriorityQueue<Task> queue = new PriorityQueue<>();
            for (int k = 0; k < tasks; k++) queue.add(new Task(in.nextInt(),in.nextInt(), k));

            boolean IMPOSSIBLE = false;
            while (!queue.isEmpty()){
                Task current = queue.poll();
                if (IMPOSSIBLE) continue;
                if (free(j, current.start, current.end)) {
                    fill(j, current.start, current.end);
                    res[current.index] = 'J';
                }
                else if(free(c, current.start, current.end)) {
                    fill(c, current.start, current.end);
                    res[current.index] = 'C';
                } else {
                    IMPOSSIBLE = true;
                }
            }
            String answer = new String(res);
            if (IMPOSSIBLE) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            else System.out.println("Case #" + (i+1) + ": " + answer);
        }
    }

    private static void fill(int[] j, int start, int stop) {
        for (int i = start; i < stop; i++) {
            j[i]++;
        }
    }

    private static boolean free(int[] j, int start, int stop) {
        for (int i = start; i < stop; i++) {
            if (j[i] != 0) return false;
        }
        return true;
    }

    private static class Task implements Comparable<Task>{
        int index;
        int start;
        int end;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Task o) {
            if (this.start == o.start) return 0;
            if (this.start > o.start) return 1;
            return -1;
        }
    }
}
