import java.util.*;
import java.io.*;
import java.awt.Point;

class SolutionGCJ {

    public void solve(FastReader in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int numActivities = in.nextInt();
            List<Point> activities = new ArrayList<>();
            List<Integer> indices = new ArrayList<>();
            List<Integer> assignments = new ArrayList<>();

            for (int i = 0; i < numActivities; i++) {
                activities.add(new Point(in.nextInt(), in.nextInt()));
                indices.add(i);
                assignments.add(0);
            }

            indices.sort(Comparator.comparingInt(a -> activities.get(a).x));

            int camEnd = -1000;
            int jamEnd = -1000;
            boolean impossible = false;

            for (int i : indices) {
                Point activity = activities.get(i);
                if (camEnd <= activity.x) {
                    assignments.set(i, 0);
                    camEnd = activity.y;
                } else if (jamEnd <= activity.x) {
                    assignments.set(i, 1);
                    jamEnd = activity.y;
                } else {
                    out.printf("Case #%d: IMPOSSIBLE%n", testCase);
                    impossible = true;
                    break;
                }
            }

            if (impossible) continue;

            StringBuilder result = new StringBuilder();
            for (int assignment : assignments) {
                result.append(assignment == 0 ? 'J' : 'C');
            }

            out.printf("Case #%d: %s%n", testCase, result.toString());
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new SolutionGCJ().solve(in, out);
        out.flush();
        out.close();
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
            System.exit(0);
        }
        return str;
    }
}