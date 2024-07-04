import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        int caseNumber = 1;

        while (numCases-- > 0) {
            int numStrings = scanner.nextInt();
            String[] strings = new String[numStrings];
            String longestString = "";
            int maxLength = 0;

            for (int i = 0; i < numStrings; i++) {
                strings[i] = scanner.next();
                if (strings[i].length() > maxLength) {
                    maxLength = strings[i].length();
                    longestString = strings[i];
                }
            }

            String suffixToMatch = longestString.substring(1);
            boolean isMatch = true;

            for (String str : strings) {
                int suffixLength = suffixToMatch.length() - 1;
                for (int j = str.length() - 1; j > 0; j--) {
                    if (str.charAt(j) != suffixToMatch.charAt(suffixLength)) {
                        isMatch = false;
                        break;
                    }
                    suffixLength--;
                }
                if (!isMatch) break;
            }

            if (isMatch) {
                System.out.println("Case #" + caseNumber + ": " + suffixToMatch);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
        }

        scanner.close();
    }
}