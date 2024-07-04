import java.util.*;
import java.io.*;

class SolutionHelper {

    private String processSegment(String segment) {
        int len = segment.length();
        int left = 0, right = len - 1;
        StringBuilder leftString = new StringBuilder();
        StringBuilder rightString = new StringBuilder();
        int balance = 0;
        
        while (left <= right) {
            int leftVal = segment.charAt(left) - '0' - balance;
            int rightVal = segment.charAt(right) - '0' - balance;
            
            if (leftVal < rightVal) {
                leftString.append("(".repeat(leftVal));
                rightString.insert(0, ")".repeat(leftVal));
                leftString.append(segment.charAt(left));
                left++;
            } else if (rightVal < leftVal) {
                leftString.append("(".repeat(rightVal));
                rightString.insert(0, ")".repeat(rightVal));
                rightString.insert(0, segment.charAt(right));
                right--;
            } else {
                leftString.append("(".repeat(rightVal));
                rightString.insert(0, ")".repeat(rightVal));
                rightString.insert(0, segment.charAt(right));
                if (left != right) {
                    leftString.append(segment.charAt(left));
                    left++;
                }
                right--;
            }
            balance += Math.min(leftVal, rightVal);
        }
        return leftString.append(rightString).toString();
    }

    public String solve(String str) {
        StringBuilder result = new StringBuilder();
        int len = str.length();
        
        for (int i = 0; i < len;) {
            int start = i;
            while (i < len && str.charAt(i) != '0') {
                i++;
            }
            result.append(processSegment(str.substring(start, i)));
            if (i < len) {
                result.append('0');
                i++;
            }
        }
        return result.toString();
    }
}

public class MainSolution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SolutionHelper solutionHelper = new SolutionHelper();
        int testCases = in.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String str = in.next();
            out.print("Case #" + i + ": ");
            out.println(solutionHelper.solve(str));
        }
        out.close();
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

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