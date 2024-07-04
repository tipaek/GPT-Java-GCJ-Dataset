import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class time implements Comparable <time> {

        int val, type, task; //0 is end, 1 is start
        public time (int v, int t, int task) {
            val = v;
            type = t;
            this.task = task;
        }

        @Override
        public int compareTo(time o) {
            if(this.val == o.val) return this.type - o.type;
            return this.val - o.val;
        }
    }

    static class parent {
        boolean taken;
        int task;

        public parent(boolean taken, int task) {
            this.taken = taken;
            this.task = task;
        }
    }

    static class assignment implements Comparable <assignment> {
        char parent;
        int type;

        public assignment (char parent, int type) {
            this.parent = parent;
            this.type = type;
        }

        @Override
        public int compareTo(assignment o) {
            return this.type - o.type;
        }

    }

    public static void main(String[] args) {
        FastReader read = new FastReader ();
        
        int T = read.nextInt();
        for(int t = 0; t < T; t++) {

            
            int N = read.nextInt();
            time [] tasks = new time [2 * N];
            for(int i = 0; i < 2 * N; i += 2) {
                tasks[i] = new time(read.nextInt(), 1, i);
                tasks[i + 1] = new time(read.nextInt(), 0, i);
            }

            Arrays.sort(tasks);
            assignment [] ans = new assignment [N];
            int ansIndex = 0;
            boolean flag = false;
            parent C = new parent (false, -1), J = new parent (false, -1);
            //for(time i : tasks) System.out.println(i.val + " " + i.type + " " + i.task);
            System.out.print("Case #" + (t + 1) + ": ");

            for(int i = 0; i < 2 * N; i++) {
                if(tasks[i].type == 1) {
                    if(!C.taken) {
                        C.taken = true;
                        C.task = tasks[i].task;
                        ans[ansIndex++] = new assignment('C', tasks[i].task);
                    } else if (!J.taken) {
                        J.taken = true;
                        J.task = tasks[i].task;
                        ans[ansIndex++] = new assignment('J', tasks[i].task);
                    } else {
                        System.out.println("IMPOSSIBLE");
                        flag = true;
                        break;
                    }
                } else if (tasks[i].type == 0) {
                    int task = tasks[i].task;
                    if(C.task == task) {
                        C.taken = false;
                        C.task = -1;
                    } else if (J.task == task) {
                        J.taken = false;
                        J.task = -1;
                    }
                }
            }

            if(flag) continue;
            Arrays.sort(ans);
            for(assignment a : ans) System.out.print(a.parent);
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