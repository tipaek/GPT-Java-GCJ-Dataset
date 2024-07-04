import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end, i));
            }
            activities.sort(Comparator.comparingInt(a -> a.start));
            int cameronFinish = 0;
            int jamesFinish = 0;
            int[] result = new int[n];
            boolean possible = true;
            for (Activity activity : activities) {
                if (activity.start >= cameronFinish) {
                    cameronFinish = activity.end;
                    result[activity.index] = 1;
                } else if (activity.start >= jamesFinish) {
                    jamesFinish = activity.end;
                } else {
                    possible = false;
                }
            }
            out.printf("Case #%d: ", testNumber);
            if (possible) {
                for (int i = 0; i < n; ++i) {
                    if (result[i] == 1) {
                        out.print('C');
                    } else {
                        out.print('J');
                    }
                }
            }
            else {
                out.print("IMPOSSIBLE");
            }
            out.println();
        }
        out.close();

    }

    static class Activity {
        int start;
        int end;
        int index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
        public long nextLong() {
            return Long.parseLong(next());
        }


    }
}
