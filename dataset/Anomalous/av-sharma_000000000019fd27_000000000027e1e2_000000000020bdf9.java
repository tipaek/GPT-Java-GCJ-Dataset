import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = reader.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = reader.nextInt();
                endTimes[i] = reader.nextInt();
                tasks[i] = new Task(startTimes[i], endTimes[i], i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            boolean isPossible = true;
            int cFreeTime = 0;
            int jFreeTime = 0;
            char[] result = new char[n];

            for (Task task : tasks) {
                if (task.start >= cFreeTime) {
                    result[task.index] = 'C';
                    cFreeTime = task.end;
                } else if (task.start >= jFreeTime) {
                    result[task.index] = 'J';
                    jFreeTime = task.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            System.out.print("CASE #" + testCase + ": ");
            if (isPossible) {
                System.out.println(new String(result));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    static class Task {
        int start;
        int end;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }
}