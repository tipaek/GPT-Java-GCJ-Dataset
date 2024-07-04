/*
	ID: audreylee16
	LANG: JAVA
	TASK: default
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNum = 1; caseNum <= totalCases; caseNum++) {
            int wordCount = scanner.nextInt();
            scanner.nextLine();
            String[] words = new String[wordCount];
            int[] positions = new int[wordCount];

            for (int i = 0; i < wordCount; i++) {
                words[i] = new StringBuilder(scanner.nextLine()).reverse().toString();
            }

            int longestWordLength = 0;
            int longestWordIndex = 0;
            for (int i = 1; i < wordCount; i++) {
                if (words[i].length() > longestWordLength) {
                    longestWordLength = words[i].length();
                    longestWordIndex = i;
                }
            }

            String result = "*";
            for (int charIndex = 0; charIndex < longestWordLength; charIndex++) {
                char testChar;
                boolean isMismatch = false;
                boolean incrementIndex = false;

                if (words[longestWordIndex].charAt(charIndex) == '*') {
                    if (charIndex + 1 == words[longestWordIndex].length()) break;
                    testChar = words[longestWordIndex].charAt(charIndex + 1);
                    positions[longestWordIndex] = charIndex + 1;
                    incrementIndex = true;
                } else {
                    testChar = words[longestWordIndex].charAt(charIndex);
                    positions[longestWordIndex] = charIndex;
                }

                for (int wordIndex = 0; wordIndex < wordCount; wordIndex++) {
                    boolean isAsterisk = words[wordIndex].charAt(positions[wordIndex]) == '*';
                    char compareChar = isAsterisk ? testChar : words[wordIndex].charAt(positions[wordIndex]);

                    if (compareChar != testChar) {
                        positions[wordIndex] = -1;
                        isMismatch = true;
                    } else if (!isAsterisk) {
                        positions[wordIndex]++;
                    }
                }

                if (!isMismatch) {
                    result += testChar;
                } else {
                    result = "*";
                    break;
                }

                if (incrementIndex) charIndex++;
            }

            if (!result.equals("*")) {
                result = new StringBuilder(result.substring(1)).reverse().toString();
            }
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}