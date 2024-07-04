import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader inputReader = new FastReader();
        PrintWriter outputWriter = new PrintWriter(System.out);
        int testCases = inputReader.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String inputString = inputReader.nextLine();
            StringBuilder resultBuilder = new StringBuilder();
            int openParenthesesCount = 0;
            
            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                int currentValue = currentChar - '0';
                
                if (i > 0 && currentChar == inputString.charAt(i - 1)) {
                    resultBuilder.append(currentChar);
                } else {
                    while (openParenthesesCount < currentValue) {
                        resultBuilder.append('(');
                        openParenthesesCount++;
                    }
                    while (openParenthesesCount > currentValue) {
                        resultBuilder.append(')');
                        openParenthesesCount--;
                    }
                    resultBuilder.append(currentChar);
                }
            }
            
            while (openParenthesesCount > 0) {
                resultBuilder.append(')');
                openParenthesesCount--;
            }
            
            outputWriter.println("Case #" + t + ": " + resultBuilder);
        }
        
        outputWriter.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
}