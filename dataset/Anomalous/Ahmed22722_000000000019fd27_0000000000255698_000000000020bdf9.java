import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Set;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            TreeMap<Integer, Integer> schedule = new TreeMap<>();
            
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                schedule.put(start, end);
            }
            
            int cameronEnd = 0;
            int jamieEnd = 0;
            boolean impossible = false;
            StringBuilder assignment = new StringBuilder();
            
            for (int start : schedule.keySet()) {
                int end = schedule.get(start);
                if (start >= cameronEnd) {
                    assignment.append('C');
                    cameronEnd = end;
                } else if (start >= jamieEnd) {
                    assignment.append('J');
                    jamieEnd = end;
                } else {
                    impossible = true;
                    break;
                }
            }
            
            if (impossible) {
                resultBuilder.append(String.format("Case #%d: IMPOSSIBLE\n", i));
            } else {
                resultBuilder.append(String.format("Case #%d: %s\n", i, assignment.toString()));
            }
        }
        
        out.print(resultBuilder.toString());
        out.flush();
    }

    private static class FastReader {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
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