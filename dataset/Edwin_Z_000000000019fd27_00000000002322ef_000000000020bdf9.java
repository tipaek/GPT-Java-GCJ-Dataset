import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            solver.solve(i + 1, in, out);
        }
        out.close();
    }

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {

            int n = in.nextInt();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });

            for(int i = 0; i < n; i++){
                int s = in.nextInt();
                int e = in.nextInt();
                pq.offer(new int[]{s, e, i});
            }

            char[] res = new char[n];
            int[] cur = new int[2];
            Arrays.fill(cur, -1);

            while(!pq.isEmpty()){
                int[] now = pq.poll();
                //out.println(Arrays.toString(now));
                int i;
                for(i = 0; i < 2; i++) {
                    if (cur[i] <= now[0]) {
                        cur[i] = now[1];
                        break;
                    }
                }

                if(i == 2) {
                    out.println("Case #" + testNumber + ": " + "IMPOSSIBLE");
                    return;
                }

                if(i == 0) res[now[2]] = 'C';
                if(i == 1) res[now[2]] = 'J';
            }

            out.println("Case #" + testNumber + ": " + String.valueOf(res));
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

    }
}