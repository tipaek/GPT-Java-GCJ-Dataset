import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskSolver solver = new TaskSolver();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskSolver {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            int caseNumber = 1;

            while (t-- > 0) {
                int n = in.nextInt();
                Activity[] activities = new Activity[n];
                boolean[] assignments = new boolean[n];

                for (int i = 0; i < n; i++) {
                    int start = in.nextInt();
                    int end = in.nextInt();
                    activities[i] = new Activity(start, end, i);
                }

                Arrays.fill(assignments, false);
                Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

                boolean possible = true;
                assignments[activities[0].index] = true;
                ArrayList<Activity> conflicts = new ArrayList<>();
                int lastSelectedIndex = 0;

                for (int j = 1; j < n; j++) {
                    if (activities[j].start >= activities[lastSelectedIndex].end) {
                        assignments[activities[j].index] = true;
                        lastSelectedIndex = j;
                    } else {
                        conflicts.add(activities[j]);
                    }
                }

                if (conflicts.size() > 1) {
                    assignments[conflicts.get(0).index] = false;
                    lastSelectedIndex = 0;

                    for (int j = 1; j < conflicts.size(); j++) {
                        if (conflicts.get(j).start >= conflicts.get(lastSelectedIndex).end) {
                            assignments[conflicts.get(j).index] = false;
                            lastSelectedIndex = j;
                        } else {
                            possible = false;
                            break;
                        }
                    }
                }

                StringBuilder result = new StringBuilder();
                if (possible) {
                    for (boolean assigned : assignments) {
                        result.append(assigned ? 'C' : 'J');
                    }
                } else {
                    result.append("IMPOSSIBLE");
                }

                out.println("Case #" + caseNumber + ": " + result.toString());
                caseNumber++;
            }
        }

        static class Activity {
            int start;
            int end;
            int index;

            Activity(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }

            @Override
            public String toString() {
                return "(" + start + "," + end + " " + index + ")";
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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