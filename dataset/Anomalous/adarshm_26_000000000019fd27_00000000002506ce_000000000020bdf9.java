import java.io.InputStream;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = reader.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = reader.nextInt();
            int[] timeline = new int[1441];
            boolean[] isStart = new boolean[1441];
            boolean impossible = false;
            ArrayList<Character> result = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = reader.nextInt();
                int end = reader.nextInt();
                timeline[start]++;
                timeline[end]--;
                isStart[start] = true;
            }

            int currentEvents = 0;
            for (int j = 0; j < 1441; j++) {
                currentEvents += timeline[j];
                if (currentEvents > 2) {
                    impossible = true;
                    break;
                }
                if (isStart[j]) {
                    result.add(currentEvents == 1 && timeline[j] != 0 ? 'C' : 'J');
                }
            }

            if (impossible) {
                writer.println("Case #" + caseNum + ": IMPOSSIBLE");
            } else {
                writer.print("Case #" + caseNum + ": ");
                for (char c : result) {
                    writer.print(c);
                }
                writer.println();
            }
        }
        writer.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
            }
            return str;
        }
    }
}