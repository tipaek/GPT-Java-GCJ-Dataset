import java.util.*;
import java.io.*;

public class Solution {
    static class Reader {
        private BufferedReader br;
        private StringTokenizer st;
        private BufferedWriter bw;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            try {
                bw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Node {
        int start, end, index;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }
            if (a.end != b.end) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.index, b.index);
        }
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int testCases = reader.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            reader.print("Case #" + testCase + ": ");
            int n = reader.nextInt();
            List<Node> intervals = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                intervals.add(new Node(reader.nextInt(), reader.nextInt(), i));
                result.append('0');
            }

            intervals.sort(new NodeComparator());
            int cameronEnd = -1, jamieEnd = -1;
            boolean impossible = false;

            for (Node interval : intervals) {
                if (cameronEnd <= interval.start) {
                    cameronEnd = interval.end;
                    result.setCharAt(interval.index, 'C');
                } else if (jamieEnd <= interval.start) {
                    jamieEnd = interval.end;
                    result.setCharAt(interval.index, 'J');
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                reader.println("IMPOSSIBLE");
            } else {
                reader.println(result.toString());
            }
        }
        reader.close();
    }
}