import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
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
                out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            } else {
                activities.sort(Comparator.comparingInt(a -> a.id));
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    result[i] = activities.get(i).assignedTo;
                }
                out.printf("Case #%d: %s\n", testCase, new String(result));
            }
        }

        out.close();
    }

    static class Activity {
        int id;
        int start;
        int end;
        char assignedTo;

        public Activity(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}