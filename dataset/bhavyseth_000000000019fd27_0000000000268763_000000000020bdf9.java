import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author bhavy seth
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        activitycdjam solver = new activitycdjam();
        solver.solve(1, in, out);
        out.close();
    }

    static class activitycdjam {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int t = sc.nextInt();
            int test = 0;
            while (t-- > 0) {
                test++;
                int n = sc.nextInt();
                Pair a[][] = new Pair[n][2];
                for (int i = 0; i < n; i++) {
                    int s = sc.nextInt();
                    int e = sc.nextInt();
                    a[i][0] = new Pair(s, e);
                    a[i][1] = new Pair(i, 0);
                }
                Arrays.sort(a, new Comparator<Pair[]>() {

                    public int compare(Pair[] o1, Pair[] o2) {
                        if (o1[0].x == o2[0].y) {
                            return o1[0].y - o2[0].y;
                        } else
                            return o1[0].x - o2[0].x;
                    }
                });
                StringBuilder ans = new StringBuilder();
                int cs = a[0][0].x, ce = a[0][0].y;
                a[0][1] = new Pair(a[0][1].x, (int) 'C');
                int js = -1, je = -1;
                boolean ispos = true;
                for (int i = 1; i < n; i++) {
                    if (a[i][0].x >= cs && a[i][0].x < ce) {
                        if (js == -1 || je == -1) {
                            //ans.append('J');
                            a[i][1] = new Pair(a[i][1].x, (int) 'J');
                            js = a[i][0].x;
                            je = a[i][0].y;
                        } else {
                            if (a[i][0].x >= js && a[i][0].x < je) {
                                ispos = false;
                                break;
                            } else {
                                //ans.append('J');
                                a[i][1] = new Pair(a[i][1].x, (int) 'J');
                                js = a[i][0].x;
                                je = a[i][0].y;
                            }
                        }
                    } else {
                        // ans.append('C');
                        a[i][1] = new Pair(a[i][1].x, (int) 'C');
                        cs = a[i][0].x;
                        ce = a[i][0].y;
                    }
                }
                if (!ispos) {
                    out.println("Case #" + test + ": IMPOSSIBLE");
                } else {
                    Arrays.sort(a, new Comparator<Pair[]>() {

                        public int compare(Pair[] o1, Pair[] o2) {
                            return o1[1].x - o2[1].x;
                        }
                    });
                    for (int i = 0; i < n; i++) {
                        ans.append((char) a[i][1].y);
                    }
                    out.println("Case #" + test + ": " + ans);
                }
            }
        }

    }

    static class Pair {
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair key = (Pair) o;
            return x == key.x && y == key.y;
        }

        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new
                    InputStreamReader(inputStream));
        }

        public String next() {
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

