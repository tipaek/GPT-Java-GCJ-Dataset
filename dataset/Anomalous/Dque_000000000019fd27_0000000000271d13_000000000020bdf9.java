import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());

            PriorityQueue<Task> tasks = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                tasks.add(new Task(start, end, i));
            }

            char[] schedule = new char[n];
            int endJ = -1, endC = -1;
            boolean impossible = false;

            while (!tasks.isEmpty()) {
                Task current = tasks.poll();

                if (current.start >= endJ) {
                    schedule[current.index] = 'J';
                    endJ = current.end;
                } else if (current.start >= endC) {
                    schedule[current.index] = 'C';
                    endC = current.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                writer.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                writer.print("Case #" + t + ": ");
                for (char c : schedule) {
                    writer.print(c);
                }
                writer.println();
            }
        }

        writer.close();
    }

    static class Task implements Comparable<Task> {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }
}