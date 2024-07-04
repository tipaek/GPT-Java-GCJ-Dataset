import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(i, start, end));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            boolean possible = true;
            int endC = 0, endJ = 0;
            for (Activity activity : activities) {
                if (activity.start >= endC) {
                    endC = activity.end;
                    activity.assignedTo = 'C';
                } else if (activity.start >= endJ) {
                    endJ = activity.end;
                    activity.assignedTo = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                out.printf("Case #%d: IMPOSSIBLE\n", t);
            } else {
                activities.sort(Comparator.comparingInt(a -> a.id));
                StringBuilder result = new StringBuilder();
                for (Activity activity : activities) {
                    result.append(activity.assignedTo);
                }
                out.printf("Case #%d: %s\n", t, result.toString());
            }
        }

        out.close();
    }

    static class Activity {
        int id;
        int start;
        int end;
        char assignedTo;

        Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
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