import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int testCase = 1; testCase <= t; testCase++) {
            StringBuilder sb = new StringBuilder();
            String s = sc.next();
            int n = s.length();
            
            sb.append("Case #").append(testCase).append(": ");
            
            for (int i = 0; i < s.charAt(0) - '0'; i++) {
                sb.append('(');
            }
            
            for (int i = 0; i < n - 1; i++) {
                sb.append(s.charAt(i));
                int currentDigit = s.charAt(i) - '0';
                int nextDigit = s.charAt(i + 1) - '0';
                
                if (currentDigit > nextDigit) {
                    for (int j = 0; j < currentDigit - nextDigit; j++) {
                        sb.append(')');
                    }
                } else if (currentDigit < nextDigit) {
                    for (int j = 0; j < nextDigit - currentDigit; j++) {
                        sb.append('(');
                    }
                }
            }
            
            sb.append(s.charAt(n - 1));
            for (int i = 0; i < s.charAt(n - 1) - '0'; i++) {
                sb.append(')');
            }
            
            sb.append("\n");
            result.append(sb);
        }
        
        System.out.print(result);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    }
}