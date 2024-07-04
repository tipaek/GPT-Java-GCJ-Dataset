import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream in = System.in;
        InputReader scan = new InputReader(in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            String str = scan.next();
            ArrayList<Integer> digits = new ArrayList<>();
            for (char ch : str.toCharArray()) {
                digits.add(ch - '0');
            }
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (int digit : digits) {
                while (previousDigit < digit) {
                    result.append("(");
                    previousDigit++;
                }
                while (previousDigit > digit) {
                    result.append(")");
                    previousDigit--;
                }
                result.append(digit);
            }
            
            while (previousDigit > 0) {
                result.append(")");
                previousDigit--;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
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