import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int numberOfTests = scanner.nextInt();

        for (int t = 0; t < numberOfTests; t++) {
            String inputLine = scanner.nextToken();
            List<Character> openBrackets = new ArrayList<>();
            List<String> output = new ArrayList<>();

            for (int i = 0; i < inputLine.length(); i++) {
                int currentDigit = inputLine.charAt(i) - '0';
                int openBracketsNeeded = currentDigit - openBrackets.size();

                for (int j = 0; j < openBracketsNeeded; j++) {
                    openBrackets.add('(');
                    output.add("(");
                }

                output.add(String.valueOf(inputLine.charAt(i)));

                int closeBracketsNeeded = currentDigit;
                if (i < inputLine.length() - 1) {
                    closeBracketsNeeded = currentDigit - (inputLine.charAt(i + 1) - '0');
                }

                for (int j = 0; j < closeBracketsNeeded; j++) {
                    output.add(")");
                    openBrackets.remove(openBrackets.size() - 1);
                }
            }

            System.out.print("Case #" + (t + 1) + ": ");
            for (String s : output) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}