import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            int nestingDepth = 0;
            int[] opening = new int[s.length()];
            int[] closing = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - 48;
                int remainingBrackets = digit - nestingDepth;
                if (remainingBrackets >= 0) {
                    opening[j] = remainingBrackets;
                } else {
                    closing[j] = -remainingBrackets;
                }
                nestingDepth = digit;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (opening[j] != 0) {
                    for (int k = 0; k < opening[j]; k++) {
                        sb.append('(');
                    }
                } else {
                    for (int k = 0; k < closing[j]; k++) {
                        sb.append(')');
                    }
                }
                sb.append(s.charAt(j));
            }
            for (int j = 0; j < s.charAt(s.length()-1) - 48; j++) {
                sb.append(')');
            }
            pw.println("Case #" + i + ": " + sb);
        }
        pw.close();
    }
}