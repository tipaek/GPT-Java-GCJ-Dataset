import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            List<Pair<Integer, Integer>> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new Pair<>(start, end));
            }

            intervals.sort(Comparator.comparingInt(Pair::getKey));

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder();

            for (Pair<Integer, Integer> interval : intervals) {
                int start = interval.getKey();
                int end = interval.getValue();

                if (start >= cameronEnd) {
                    schedule.append('C');
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    schedule.append('J');
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append(String.format("Case #%d: IMPOSSIBLE\n", caseNum));
            } else {
                result.append(String.format("Case #%d: %s\n", caseNum, schedule.toString()));
            }
        }

        out.print(result.toString());
        out.flush();
    }

    private static class FastReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}