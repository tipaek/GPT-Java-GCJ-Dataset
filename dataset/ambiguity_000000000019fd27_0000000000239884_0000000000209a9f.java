
import java.util.*;
import java.io.*;

class Sol {

    private String sol(String str) {
        int len = str.length();
        int left = 0, right = len - 1;
        StringBuilder leftString = new StringBuilder();
        StringBuilder rightString = new StringBuilder();
        int already = 0;
        while (left <= right) {
            int leftVal = str.charAt(left) - '0';
            int rightVal = str.charAt(right) - '0';
            leftVal -= already;
            rightVal -= already;
            if (leftVal < rightVal) {
                for (int i=0;i<leftVal;i++) {
                    leftString.append('(');
                    rightString.insert(0, ')');
                }
                leftString.append(str.charAt(left));
                left++;
            } else if (rightVal < leftVal) {
                for (int i=0;i<rightVal;i++) {
                    leftString.append('(');
                    rightString.insert(0, ')');
                }
                rightString.insert(0, str.charAt(right));
                right--;
            } else {
                for (int i=0;i<rightVal;i++) {
                    leftString.append('(');
                    rightString.insert(0, ')');
                }
                rightString.insert(0, str.charAt(right));
                if (left != right) {
                    leftString.append(str.charAt(left));
                    left++;
                }
                right--;
            }
            already += Math.min(leftVal, rightVal);
        }
        return leftString.append(rightString).toString();
    }

    public String solve(String str) {
        int len = str.length();
        StringBuilder res = new StringBuilder();
        for (int i=0;i<str.length();) {
            int start = i;
            while (i < len && str.charAt(i) != '0') {
                i++;
            }
            res.append(sol(str.substring(start, i)));
            if (i < len) {
                res.append('0');
                i++;
            }
        }
        return res.toString();
    }

}

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Sol s = new Sol();
        int n = in.nextInt();
        for (int i=1;i<=n;i++) {
            String str = in.next();
            out.print("Case #" + i + ": ");
            out.println(s.solve(str));
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
