import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class Time implements Comparable<Time> {
        int value, type, task; // 0 is end, 1 is start

        public Time(int value, int type, int task) {
            this.value = value;
            this.type = type;
            this.task = task;
        }

        @Override
        public int compareTo(Time other) {
            if (this.value == other.value) return this.type - other.type;
            return this.value - other.value;
        }
    }

    static class Parent {
        boolean taken;
        int task;

        public Parent(boolean taken, int task) {
            this.taken = taken;
            this.task = task;
        }
    }

    static class Assignment implements Comparable<Assignment> {
        char parent;
        int index;

        public Assignment(char parent, int index) {
            this.parent = parent;
            this.index = index;
        }

        @Override
        public int compareTo(Assignment other) {
            return this.index - other.index;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int T = reader.nextInt();

        for (int t = 0; t < T; t++) {
            int N = reader.nextInt();
            Time[] tasks = new Time[2 * N];

            for (int i = 0; i < N; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                tasks[2 * i] = new Time(start, 1, i);
                tasks[2 * i + 1] = new Time(end, 0, i);
            }

            Arrays.sort(tasks);
            Assignment[] result = new Assignment[N];
            boolean isImpossible = false;
            Parent C = new Parent(false, -1), J = new Parent(false, -1);

            System.out.print("Case #" + (t + 1) + ": ");

            for (Time task : tasks) {
                if (task.type == 1) {
                    if (!C.taken) {
                        C.taken = true;
                        C.task = task.task;
                        result[task.task] = new Assignment('C', task.task);
                    } else if (!J.taken) {
                        J.taken = true;
                        J.task = task.task;
                        result[task.task] = new Assignment('J', task.task);
                    } else {
                        System.out.println("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                } else {
                    if (C.task == task.task) {
                        C.taken = false;
                    } else if (J.task == task.task) {
                        J.taken = false;
                    }
                }
            }

            if (isImpossible) continue;
            for (Assignment a : result) {
                System.out.print(a.parent);
            }
            System.out.println();
        }
    }

    public static class FastReader {
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
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}