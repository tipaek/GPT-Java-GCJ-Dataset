import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = input.nextInt();
        String[] results = new String[t];
        input.nextLine();  // Consume the newline

        String[] numbers = new String[t];
        for (int i = 0; i < t; i++) {
            numbers[i] = input.next();
        }

        for (int i = 0; i < t; i++) {
            String str = numbers[i];
            StringBuilder intermediate = new StringBuilder();

            for (int j = 0; j < str.length() - 1; j++) {
                intermediate.append(str.charAt(j));
                if (str.charAt(j) != str.charAt(j + 1)) {
                    intermediate.append(' ');
                }
            }
            intermediate.append(str.charAt(str.length() - 1));

            StringBuilder modified = new StringBuilder();
            String spacedStr = intermediate.toString();

            if (spacedStr.length() == 1) {
                modified.append(openBrackets(spacedStr.charAt(0)))
                        .append(spacedStr.charAt(0))
                        .append(closeBrackets(spacedStr.charAt(0)));
            } else {
                for (int j = 0; j < spacedStr.length(); j++) {
                    if (j == 0) {
                        modified.append(openBrackets(spacedStr.charAt(j)))
                                .append(spacedStr.charAt(j));
                    } else if (j == spacedStr.length() - 1) {
                        modified.append(spacedStr.charAt(j))
                                .append(closeBrackets(spacedStr.charAt(j)));
                    } else if (spacedStr.charAt(j) == ' ') {
                        modified.append(closeBrackets(spacedStr.charAt(j - 1)))
                                .append(openBrackets(spacedStr.charAt(j + 1)));
                    } else {
                        modified.append(spacedStr.charAt(j));
                    }
                }
            }

            String finalResult = modified.toString().replace(")(", "");
            results[i] = "Case #" + (i + 1) + ": " + finalResult;
        }

        for (String result : results) {
            System.out.println(result);
        }
    }

    private static String openBrackets(char c) {
        int count = Character.getNumericValue(c);
        return "(".repeat(count);
    }

    private static String closeBrackets(char c) {
        int count = Character.getNumericValue(c);
        return ")".repeat(count);
    }
}