import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            String S = br.readLine().trim();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : S.toCharArray()) {
                int num = Character.getNumericValue(ch);
                while (currentDepth < num) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > num) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(num);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            pw.println("Case #" + i + ": " + result.toString());
        }
        pw.close();
    }
}