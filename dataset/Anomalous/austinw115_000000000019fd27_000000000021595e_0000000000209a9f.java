import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = reader.readLine().trim();
            StringBuilder result = new StringBuilder();
            boolean isConsecutive = false;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (currentChar == '1') {
                    if (!isConsecutive) {
                        result.append('(');
                        isConsecutive = true;
                    }
                } else {
                    if (isConsecutive) {
                        result.append(')');
                        isConsecutive = false;
                    }
                }
                result.append(currentChar);
            }

            if (isConsecutive) {
                result.append(')');
            }

            writer.printf("Case #%d: %s%n", caseNum, result.toString());
        }

        writer.close();
    }
}