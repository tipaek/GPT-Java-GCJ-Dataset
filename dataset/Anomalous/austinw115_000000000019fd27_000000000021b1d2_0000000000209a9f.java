import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int caseNumber = 1; caseNumber <= T; caseNumber++) {
            String S = reader.readLine().trim();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : S.toCharArray()) {
                int digit = ch - '0';
                while (currentDepth < digit) {
                    result.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(')');
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(')');
                currentDepth--;
            }

            writer.println("Case #" + caseNumber + ": " + result.toString());
        }
        writer.close();
    }
}