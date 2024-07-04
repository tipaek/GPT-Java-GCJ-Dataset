import java.util.*;
import java.io.*;

class Solution {

    private String processString(String str, int already) {
        int left = 0, right = str.length() - 1;
        if (left > right) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int minVal = Integer.MAX_VALUE;
        
        for (int i = left; i <= right; i++) {
            minVal = Math.min(minVal, str.charAt(i) - '0');
        }
        
        for (int i = 1; i <= minVal - already; i++) {
            sb.append('(');
        }
        
        for (int i = left; i <= right;) {
            int start = i;
            while (i <= right && str.charAt(i) - '0' != minVal) {
                i++;
            }
            sb.append(processString(str.substring(start, i), minVal));
            if (i <= right) {
                sb.append(str.charAt(i));
            }
            i++;
        }
        
        for (int i = 1; i <= minVal - already; i++) {
            sb.append(')');
        }
        
        return sb.toString();
    }

    public String solve(String str) {
        int len = str.length();
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < len;) {
            int start = i;
            while (i < len && str.charAt(i) != '0') {
                i++;
            }
            res.append(processString(str.substring(start, i), 0));
            if (i < len) {
                res.append('0');
                i++;
            }
        }
        
        return res.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        Solution solver = new Solution();
        int n = in.nextInt();
        
        for (int i = 1; i <= n; i++) {
            String str = in.next();
            out.print("Case #" + i + ": ");
            out.println(solver.solve(str));
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