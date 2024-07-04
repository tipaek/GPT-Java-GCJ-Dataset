import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int patterns = Integer.parseInt(scanner.nextLine());
            StringBuilder startPattern = new StringBuilder();
            StringBuilder endPattern = new StringBuilder();
            boolean isValid = true;

            for (int patternIndex = 0; patternIndex < patterns; patternIndex++) {
                String pattern = scanner.nextLine();
                if (pattern.startsWith("*")) {
                    String subPattern = pattern.substring(1);
                    if (endPattern.length() < subPattern.length()) {
                        if (subPattern.endsWith(endPattern.toString())) {
                            endPattern = new StringBuilder(subPattern);
                        } else {
                            isValid = false;
                        }
                    } else {
                        if (!endPattern.toString().endsWith(subPattern)) {
                            isValid = false;
                        }
                    }
                } else if (pattern.endsWith("*")) {
                    String subPattern = pattern.substring(0, pattern.length() - 1);
                    if (startPattern.length() < subPattern.length()) {
                        if (subPattern.startsWith(startPattern.toString())) {
                            startPattern = new StringBuilder(subPattern);
                        } else {
                            isValid = false;
                        }
                    } else {
                        if (!startPattern.toString().startsWith(subPattern)) {
                            isValid = false;
                        }
                    }
                } else {
                    isValid = false;
                }
            }

            StringBuilder output = new StringBuilder();
            if (isValid) {
                output.append(startPattern).append(endPattern);
            } else {
                output.append("*");
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + output);
        }

        scanner.close();
    }
}