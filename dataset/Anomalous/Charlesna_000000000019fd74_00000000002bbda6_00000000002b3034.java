import java.io.*;
import java.util.InputMismatchException;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int N = Integer.parseInt(in.nextLine());
            String[] strs = new String[N];
            for (int j = 0; j < N; j++) {
                strs[j] = in.nextLine().trim();
            }
            processCase(strs, i, w);
        }
        w.flush();
        w.close();
    }

    private static void processCase(String[] strs, int caseNum, PrintWriter w) {
        int numStrings = strs.length;
        int[][] indices = new int[numStrings][2];

        String prefix = "", suffix = "";
        for (int i = 0; i < numStrings; i++) {
            String s = strs[i];
            int len = s.length(), left = 0, right = len - 1;
            while (left <= right && s.charAt(left) != '*') {
                left++;
            }
            while (left <= right && s.charAt(right) != '*') {
                right--;
            }

            if (!isValidPrefix(s, prefix, left) || !isValidSuffix(s, suffix, right)) {
                w.println("Case #" + caseNum + ": " + "*");
                return;
            }

            if (left > prefix.length()) prefix = s.substring(0, left);
            int suffixLen = len - right - 1;
            if (suffixLen > suffix.length()) suffix = s.substring(right + 1);

            indices[i][0] = left + 1;
            indices[i][1] = right - 1;
        }

        StringBuilder result = new StringBuilder();
        result.append(prefix);
        for (int i = 0; i < numStrings; i++) {
            for (int j = indices[i][0]; j <= indices[i][1]; j++) {
                if (strs[i].charAt(j) != '*') {
                    result.append(strs[i].charAt(j));
                }
            }
        }
        result.append(suffix);
        w.println("Case #" + caseNum + ": " + result.toString());
    }

    private static boolean isValidPrefix(String s, String prefix, int left) {
        return !(left <= prefix.length() && !prefix.startsWith(s.substring(0, left))) &&
                !(left > prefix.length() && !s.substring(0, left).startsWith(prefix));
    }

    private static boolean isValidSuffix(String s, String suffix, int right) {
        int suffixLen = s.length() - right - 1;
        return !(suffixLen <= suffix.length() && !suffix.startsWith(s.substring(right + 1))) &&
                !(suffixLen > suffix.length() && !s.substring(right + 1).startsWith(suffix));
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = res * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}