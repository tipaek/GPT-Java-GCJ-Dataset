
import java.util.*;
import java.io.*;

class Sol {

    public String solve(List<Pair> lst) {
        lst.sort((a, b) -> Integer.compare(a.start, b.start));
        int jTime = 0;
        int cTime = 0;
        char[] ch = new char[lst.size()];
        for (int i=0;i<lst.size();i++) {
            int startTime = lst.get(i).start;
            int endTime = lst.get(i).end;
            int idx = lst.get(i).idx;
            if (startTime >= jTime) {
                jTime = endTime;
                ch[idx] = 'J';
            } else if (startTime >= cTime) {
                cTime = endTime;
                ch[idx] = 'C';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(ch);
    }

}

class Pair {
    int start;
    int end;
    int idx;

    public Pair(int start, int end, int idx) {
        this.start = start;
        this.end = end;
        this.idx = idx;
    }
}

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int tests = in.nextInt();
        for (int tt = 1; tt <= tests; tt++) {
            Sol s = new Sol();
            int n = in.nextInt();
            List<Pair> lst = new ArrayList<>();
            for (int i=0;i<n;i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                Pair p = new Pair(start, end, i);
                lst.add(p);
            }
            out.print("Case #" + tt + ": ");
            out.println(s.solve(lst));
        }
        out.close();
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
