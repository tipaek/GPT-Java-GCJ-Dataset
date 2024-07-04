import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ActivityScheduler solver = new ActivityScheduler();
        solver.solve(1, in, out);
        out.close();
    }

    static class ActivityScheduler {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int t = sc.nextInt();
            for (int test = 1; test <= t; test++) {
                int n = sc.nextInt();
                Pair[][] activities = new Pair[n][2];
                for (int i = 0; i < n; i++) {
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    activities[i][0] = new Pair(start, end);
                    activities[i][1] = new Pair(i, 0);
                }

                Arrays.sort(activities, Comparator.comparingInt(o -> o[0].x));

                StringBuilder schedule = new StringBuilder();
                int cameronEnd = activities[0][0].y;
                activities[0][1].y = 'C';
                int jamieStart = -1, jamieEnd = -1;
                boolean possible = true;

                for (int i = 1; i < n; i++) {
                    if (activities[i][0].x < cameronEnd) {
                        if (jamieStart == -1 || activities[i][0].x >= jamieEnd) {
                            activities[i][1].y = 'J';
                            jamieStart = activities[i][0].x;
                            jamieEnd = activities[i][0].y;
                        } else {
                            possible = false;
                            break;
                        }
                    } else {
                        activities[i][1].y = 'C';
                        cameronEnd = activities[i][0].y;
                    }
                }

                if (!possible) {
                    out.println("Case #" + test + ": IMPOSSIBLE");
                } else {
                    Arrays.sort(activities, Comparator.comparingInt(o -> o[1].x));
                    for (Pair[] activity : activities) {
                        schedule.append((char) activity[1].y);
                    }
                    out.println("Case #" + test + ": " + schedule);
                }
            }
        }
    }

    static class Pair {
        public final int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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