import java.util.*;
import java.io.*;

public class Solution {

    public static String processString(String s) {
        int maxDigit = -1;
        int position = 0;
        int tempDigit = 0;

        // Find the highest digit in the string
        for (int i = 0; i < s.length(); i++) {
            char charAtI = s.charAt(i);
            if (Character.isDigit(charAtI) && (tempDigit = Character.getNumericValue(charAtI)) > maxDigit) {
                maxDigit = tempDigit;
                position = i;
            }
        }

        // If the highest digit is 0, return the original string
        if (maxDigit == 0) {
            return s;
        }

        int left = position, right = position;

        // Find the left boundary (first zero before the highest digit)
        while (left >= 0 && s.charAt(left) != '0') {
            left--;
        }

        // Find the right boundary (first zero after the highest digit)
        while (right < s.length() && s.charAt(right) != '0') {
            right++;
        }

        // Extract the substring between the boundaries
        String sub = s.substring(left + 1, right);
        StringBuilder rep = new StringBuilder();

        // Decrease each digit in the substring by 1
        for (int i = 0; i < sub.length(); i++) {
            char charAtI = sub.charAt(i);
            if (Character.isDigit(charAtI)) {
                rep.append(charAtI - 1);
            } else {
                rep.append(charAtI);
            }
        }

        // Reconstruct the string with the modified substring in parentheses
        s = s.substring(0, left + 1) + "(" + rep.toString() + ")" + s.substring(right);

        // Recursively process the modified string
        return processString(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; ++t) {
            String originalString = scanner.next();
            String processedString = processString(originalString);
            StringBuilder finalAnswer = new StringBuilder();
            int count = 0;

            // Replace '0' in the processed string with corresponding characters from the original string
            for (int i = 0; i < processedString.length(); i++) {
                if (processedString.charAt(i) == '0') {
                    finalAnswer.append(originalString.charAt(count++));
                } else {
                    finalAnswer.append(processedString.charAt(i));
                }
            }

            System.out.println("Case #" + t + ": " + finalAnswer.toString());
        }

        scanner.close();
    }
}