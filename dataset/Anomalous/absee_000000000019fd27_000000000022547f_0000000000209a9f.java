import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Skip the first line

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String input = scanner.nextLine();
            List<Group> groups = new ArrayList<>();
            char previousChar = ' ';
            Group currentGroup = null;

            for (char currentChar : input.toCharArray()) {
                if (currentChar == previousChar) {
                    currentGroup.appendChar(currentChar);
                } else {
                    currentGroup = new Group(currentChar);
                    groups.add(currentGroup);
                    previousChar = currentChar;
                }
            }

            StringBuilder resultBuilder = new StringBuilder();
            int currentDepth = 0;

            for (Group group : groups) {
                int digit = group.getDigit();
                if (digit > currentDepth) {
                    resultBuilder.append("(".repeat(digit - currentDepth));
                } else {
                    resultBuilder.append(")".repeat(currentDepth - digit));
                }
                currentDepth = digit;
                resultBuilder.append(group.getRepeatedValue());
            }

            resultBuilder.append(")".repeat(currentDepth));

            System.out.println("Case #" + caseNumber + ": " + resultBuilder);
        }
    }

    public static class Group {
        private final int digit;
        private final StringBuilder repeatedValue;

        public Group(char digitChar) {
            this.digit = Character.getNumericValue(digitChar);
            this.repeatedValue = new StringBuilder().append(digitChar);
        }

        public void appendChar(char digitChar) {
            this.repeatedValue.append(digitChar);
        }

        public int getDigit() {
            return digit;
        }

        public String getRepeatedValue() {
            return repeatedValue.toString();
        }
    }
}