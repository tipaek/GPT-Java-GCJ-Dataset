import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = reader.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = reader.nextInt();
            int[] timeline = new int[1441];
            boolean[] isStart = new boolean[1441];
            ArrayList<Character> result = new ArrayList<>();
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                timeline[start]++;
                timeline[end]--;
                isStart[start] = true;
            }

            int currentActivities = 0;
            for (int time = 0; time < 1441; time++) {
                currentActivities += timeline[time];
                if (currentActivities > 2) {
                    impossible = true;
                    break;
                }
                if (isStart[time]) {
                    result.add(currentActivities == 1 ? 'C' : 'J');
                }
            }

            writer.print("Case #" + caseNum + ": ");
            if (impossible) {
                writer.println("IMPOSSIBLE");
            } else {
                for (char ch : result) {
                    writer.print(ch);
                }
                writer.println();
            }
        }
        writer.close();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}