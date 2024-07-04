import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = reader.readLine();
            List<Character> output = new ArrayList<>();
            long currentDepth = 0L;
            int length = input.length();

            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';

                if (currentDepth == digit) {
                    output.add((char) (digit + '0'));
                } else if (currentDepth > digit) {
                    while (currentDepth > digit) {
                        output.add(')');
                        currentDepth--;
                    }
                    output.add((char) (digit + '0'));
                } else {
                    while (currentDepth < digit) {
                        output.add('(');
                        currentDepth++;
                    }
                    output.add((char) (digit + '0'));
                }
            }

            while (currentDepth > 0) {
                output.add(')');
                currentDepth--;
            }

            result.append("Case #").append(caseNumber).append(": ");
            for (char ch : output) {
                result.append(ch);
            }
            result.append("\n");
            caseNumber++;
        }

        System.out.print(result);
    }
}