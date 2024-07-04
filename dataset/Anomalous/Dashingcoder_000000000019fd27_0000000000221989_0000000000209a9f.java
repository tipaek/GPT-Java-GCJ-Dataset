import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out, false);

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            char[] x = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < x.length; j++) {
                int currentDigit = x[j] - '0';

                while (openBrackets < currentDigit) {
                    sb.append('(');
                    openBrackets++;
                }

                while (openBrackets > currentDigit) {
                    sb.append(')');
                    openBrackets--;
                }

                sb.append(x[j]);
            }

            while (openBrackets > 0) {
                sb.append(')');
                openBrackets--;
            }

            pw.println("Case #" + i + ": " + sb.toString());
        }
        pw.flush();
    }
}