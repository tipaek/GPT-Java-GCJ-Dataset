import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // String input = generateInput(1000,50);
        // System.out.print(input);
        // Scanner in = new Scanner(input);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int tasks = in.nextInt();
            int[] j = new int[1440];
            int[] c = new int[1440];
            StringBuilder result = new StringBuilder();
            boolean IMPOSSIBLE = false;
            PriorityQueue<Task> queue = new PriorityQueue<>();
            for (int k = 0; k < tasks; k++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                queue.add(new Task(start,stop));
            }
            while (!queue.isEmpty()){
                // if (IMPOSSIBLE) continue;
                Task current = queue.poll();
                int start = current.start;
                int stop = current.end;
                if (free(j, start, stop)) {
                    fill(j, start, stop);
                    result.append("J");
                }
                else if(free(c, start, stop)) {
                    fill(c, start, stop);
                    result.append("C");
                } else {
                    IMPOSSIBLE = true;
                }
            }
            if (IMPOSSIBLE) System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
            else System.out.println("Case #" + (i+1) + ": " + result.toString());

            // System.out.println(Arrays.toString(j));
            // System.out.println(Arrays.toString(c));
        }
    }

    private static void fill(int[] j, int start, int stop) {
        for (int i = start; i < stop; i++) {
            j[i]++;
        }
    }

    private static boolean free(int[] j, int start, int stop) {
        // System.out.println(start + " " + stop);
        for (int i = start; i < stop; i++) {
            // System.out.println(i);
            if (j[i] != 0) return false;
        }
        return true;
    }

    private static class Task implements Comparable<Task>{
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task o) {
            if (this.start == o.start) return 0;
            if (this.start > o.start) return 1;
            return -1;
        }
    }

    public static String generateInput (int n, int c) {
        Random random = new Random();
        StringBuilder input = new StringBuilder();
        input.append(n + "\n");
        for (int i = 0; i < n; i++) {
            input.append(c + "\n");
            for (int j = 0; j < c; j++) {
                int start = random.nextInt(1440);
                int end = random.nextInt(400) + start;
                if (end >= 1440) end = 1440;
                input.append(start + " " + end + "\n");
            }
        }
        return input.toString();
    }
}
