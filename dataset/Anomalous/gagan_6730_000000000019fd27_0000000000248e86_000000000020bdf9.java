import javax.swing.*;
import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        int t = s.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int n = s.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = s.nextInt();
                int end = s.nextInt();
                tasks.add(new Task(start, end, i));
            }
            tasks.sort(Comparator.comparingInt(task -> task.start));
            
            int cEnd = 0, jEnd = 0;
            char[] result = new char[n];
            boolean isPossible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    result[task.index] = 'C';
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    result[task.index] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + tc + ": " + new String(result));
            } else {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }
    }
}

class Task {
    int start, end, index;

    public Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
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

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
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
}