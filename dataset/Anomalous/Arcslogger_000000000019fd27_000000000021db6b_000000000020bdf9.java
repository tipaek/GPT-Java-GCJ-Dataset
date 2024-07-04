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
        int type;

        public Assignment(char parent, int type) {
            this.parent = parent;
            this.type = type;
        }

        @Override
        public int compareTo(Assignment other) {
            return this.type - other.type;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = reader.nextInt();
            Time[] tasks = new Time[2 * n];

            for (int i = 0; i < 2 * n; i += 2) {
                tasks[i] = new Time(reader.nextInt(), 1, i);
                tasks[i + 1] = new Time(reader.nextInt(), 0, i);
            }

            Arrays.sort(tasks);
            Assignment[] result = new Assignment[n];
            int resultIndex = 0;
            boolean isImpossible = false;
            Parent c = new Parent(false, -1), j = new Parent(false, -1);

            System.out.print("Case #" + (t + 1) + ": ");

            for (int i = 0; i < 2 * n; i++) {
                if (tasks[i].type == 1) {
                    if (!c.taken) {
                        c.taken = true;
                        c.task = tasks[i].task;
                        result[resultIndex++] = new Assignment('C', tasks[i].task);
                    } else if (!j.taken) {
                        j.taken = true;
                        j.task = tasks[i].task;
                        result[resultIndex++] = new Assignment('J', tasks[i].task);
                    } else {
                        System.out.println("IMPOSSIBLE");
                        isImpossible = true;
                        break;
                    }
                } else if (tasks[i].type == 0) {
                    int task = tasks[i].task;
                    if (c.task == task) {
                        c.taken = false;
                        c.task = -1;
                    } else if (j.task == task) {
                        j.taken = false;
                        j.task = -1;
                    }
                }
            }

            if (isImpossible) continue;
            Arrays.sort(result);
            for (Assignment a : result) System.out.print(a.parent);
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