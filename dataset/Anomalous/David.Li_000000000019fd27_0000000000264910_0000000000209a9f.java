import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int i = 1; i <= testCases; i++) {
            String input = reader.readLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = input.charAt(j) - '0';
                if (digit > currentDepth) {
                    int openBrackets = digit - currentDepth;
                    output.append("(".repeat(openBrackets));
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    int closeBrackets = currentDepth - digit;
                    output.append(")".repeat(closeBrackets));
                    currentDepth = digit;
                }
                output.append(digit);
            }

            if (currentDepth > 0) {
                output.append(")".repeat(currentDepth));
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}