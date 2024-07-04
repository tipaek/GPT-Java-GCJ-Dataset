import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    }

    private String digitString;
    private String resultString;

    private String getParaString(String digit) {
        int num = Integer.parseInt(digit);
        StringBuilder openBrackets = new StringBuilder();
        StringBuilder closeBrackets = new StringBuilder();
        for (int i = 0; i < num; i++) {
            openBrackets.append("(");
            closeBrackets.append(")");
        }
        return openBrackets.toString() + digit + closeBrackets.toString();
    }

    private void getResult() {
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < digitString.length(); i++) {
            resultBuilder.append(getParaString(digitString.substring(i, i + 1)));
        }

        resultString = resultBuilder.toString();
        int i = 2;
        while (i < resultString.length() - 3) {
            if (resultString.charAt(i) == ')' && resultString.charAt(i + 1) == '(') {
                resultString = resultString.substring(0, i) + resultString.substring(i + 2);
                int key = i, counter = 0;
                while (resultString.charAt(key) == '(') {
                    counter++;
                    key++;
                }
                i -= counter + 1;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            Solution obj = new Solution();
            obj.digitString = sc.next();
            obj.getResult();
            System.out.println("Case #" + t + ": " + obj.resultString);
        }
    }
}