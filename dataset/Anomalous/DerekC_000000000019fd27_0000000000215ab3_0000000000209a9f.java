import java.util.*;
import java.io.*;

class Solution {

    public static String nestedDepth(String s) {
        StringBuilder sb = new StringBuilder();
        int openBrackets = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));

            if (i > 0) {
                int previousDigit = Character.getNumericValue(s.charAt(i - 1));
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    sb.append("(".repeat(difference));
                    openBrackets += difference;
                } else if (difference < 0) {
                    sb.append(")".repeat(-difference));
                    openBrackets += difference;
                }
            } else {
                sb.append("(".repeat(currentDigit));
                openBrackets = currentDigit;
            }

            sb.append(currentDigit);
        }

        sb.append(")".repeat(openBrackets));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + nestedDepth(input));
        }

        scanner.close();
    }
}