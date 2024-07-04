import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            char[] inputChars = scanner.nextLine().toCharArray();
            StringBuilder[] parentheses = new StringBuilder[inputChars.length + 1];

            int balance = 0;

            parentheses[0] = new StringBuilder("(".repeat(Character.getNumericValue(inputChars[0])));

            for (int i = 1; i < inputChars.length; i++) {
                balance = Character.getNumericValue(inputChars[i - 1]) - Character.getNumericValue(inputChars[i]);
                if (balance < 0) {
                    parentheses[i] = new StringBuilder("(".repeat(Math.abs(balance)));
                } else {
                    parentheses[i] = new StringBuilder(")".repeat(balance));
                }
            }
            parentheses[inputChars.length] = new StringBuilder(")".repeat(Character.getNumericValue(inputChars[inputChars.length - 1])));

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < inputChars.length + parentheses.length; j++) {
                if (j % 2 == 0) {
                    result.append(parentheses[j / 2]);
                } else {
                    result.append(inputChars[(j - 1) / 2]);
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
        }
    }
}