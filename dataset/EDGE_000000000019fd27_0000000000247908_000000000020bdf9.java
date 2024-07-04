import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author EDGE
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskPracticeC solver = new TaskPracticeC();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskPracticeC {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int k = 1;

            while (t-- > 0) {
                int n = in.nextInt();
                TaskPracticeC.Pair[] p = new TaskPracticeC.Pair[n];
                boolean ans[] = new boolean[n];
                for (int i = 0; i < n; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int w = i;
                    p[i] = new TaskPracticeC.Pair(x, y, w);
                }
                Arrays.fill(ans, false);
                Arrays.sort(p, new Comparator<TaskPracticeC.Pair>() {

                    public int compare(TaskPracticeC.Pair o1, TaskPracticeC.Pair o2) {

                        return o1.y - o2.y;

                    }
                });
                boolean flag = true;
                ans[p[0].w] = true;
                ArrayList<TaskPracticeC.Pair> hs = new ArrayList<>();
                int i = 0;
                for (int j = 1; j < n; j++) {
                    // If this activity has start time greater than or
                    // equal to the finish time of previously selected
                    // activity, then select it
                    if (p[j].x >= p[i].y) {
                        ans[p[j].w] = true;
                        i = j;

                    } else {
                        hs.add(p[j]);
                    }
                }
                if (hs.size() > 1) {
                    int k1 = hs.size();

                    ans[hs.get(0).w] = false;
                /*for (int j = 0; j < k1; j++) {
                    out.println(hs.get(j).toString());

                }*/
                    i = 0;
                    for (int j = 1; j < k1; j++) {
                        if (hs.get(j).x >= hs.get(i).y) {
                            ans[hs.get(j).w] = false;
                            i = j;
                        } else {
                            flag = false;
                            break;
                        }
                    }

                }
                StringBuilder sb = new StringBuilder();
                //out.println(Arrays.toString(ans));
                if (flag) {

                    for (int j = 0; j < ans.length; j++) {
                        sb.append(ans[j] ? 'C' : 'J');
                    }
                } else
                    sb.append("IMPOSSIBLE");
                out.println("case #" + k + ": " + sb.toString());
                k++;
            }
        }

        static class Pair {
            int x;
            int y;
            int w;

            Pair(int x, int y, int w) {
                this.x = x;
                this.y = y;
                this.w = w;
            }

            public String toString() {
                return "(" + x + "," + y + " " + w + ")";
            }

        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

