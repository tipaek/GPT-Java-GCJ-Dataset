import java.io.*;
import java.util.*;

public class Solution {

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
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

    static class TimePair implements Comparable<TimePair> {
        int start, end, idx;

        TimePair(int start, int end, int idx) {
            this.start = start;
            this.end = end;
            this.idx = idx;
        }

        @Override
        public int compareTo(TimePair o) {
            if (this.start != o.start) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            TimePair[] timePairs = new TimePair[N];
            char[] charArr = new char[N];

            for (int i = 0; i < N; i++) {
                timePairs[i] = new TimePair(sc.nextInt(), sc.nextInt(), i);
            }
            Arrays.sort(timePairs);

            boolean isPossible = true;
            int cTime = 0, jTime = 0;

            for (TimePair tp : timePairs) {
                if (cTime <= tp.start) {
                    cTime = tp.end;
                    charArr[tp.idx] = 'C';
                } else if (jTime <= tp.start) {
                    jTime = tp.end;
                    charArr[tp.idx] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }

            out.printf("Case #%d: ", tc);
            if (isPossible) {
                for (char c : charArr) {
                    out.print(c);
                }
            } else {
                out.print("IMPOSSIBLE");
            }
            out.println();
            out.flush();
        }
    }
}