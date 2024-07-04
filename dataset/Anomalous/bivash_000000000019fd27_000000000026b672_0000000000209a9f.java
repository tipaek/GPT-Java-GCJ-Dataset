import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        input.nextLine();
        String[] results = new String[t];

        for (int i = 0; i < t; i++) {
            String number = input.next();
            results[i] = processNumber(number);
        }

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private static String processNumber(String number) {
        StringBuilder intermediate = new StringBuilder();
        
        for (int j = 0; j < number.length() - 1; j++) {
            intermediate.append(number.charAt(j));
            if (number.charAt(j) != number.charAt(j + 1)) {
                intermediate.append(' ');
            }
        }
        intermediate.append(number.charAt(number.length() - 1));

        StringBuilder modified = new StringBuilder();
        String str = intermediate.toString();

        for (int j = 0; j < str.length(); j++) {
            if (j == 0) {
                modified.append(openBracket(str.charAt(j))).append(str.charAt(j));
            } else if (j == str.length() - 1) {
                modified.append(str.charAt(j)).append(closeBracket(str.charAt(j)));
            } else if (str.charAt(j) == ' ') {
                modified.append(closeBracket(str.charAt(j - 1))).append(openBracket(str.charAt(j + 1)));
            } else {
                modified.append(str.charAt(j));
            }
        }

        return cleanUpBrackets(modified.toString());
    }

    private static String openBracket(char c) {
        int n = Character.getNumericValue(c);
        return "(".repeat(n);
    }

    private static String closeBracket(char c) {
        int n = Character.getNumericValue(c);
        return ")".repeat(n);
    }

    private static String cleanUpBrackets(String str) {
        String[] redundantPatterns = {
            ")))))))))(((((((((",
            "))))))))((((((((",
            ")))))))(((((((",
            "))))))((((((",
            ")))))(((((",
            "))))((((",
            ")))(((",
            "))((",
            ")("
        };

        for (String pattern : redundantPatterns) {
            if (str.contains(pattern)) {
                return str.replace(pattern, "");
            }
        }
        return str;
    }
}