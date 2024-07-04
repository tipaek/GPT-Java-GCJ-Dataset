import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    public void execute() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int cur = reader.nextInt();
            System.out.println("Case #" + caseNum + ": ");
            printPattern(cur);
        }
    }

    private void printPattern(int cur) {
        if (cur == 1) {
            System.out.println("1 1");
        } else if (cur == 2) {
            System.out.println("1 1\n2 1");
        } else if (cur == 3) {
            System.out.println("1 1\n2 1\n3 1");
        } else {
            System.out.println("1 1\n2 1\n3 2");
            for (int i = 3; i < cur; i++) {
                System.out.println("1 " + i);
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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