import java.util.Scanner;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 0; caseIndex < cases; caseIndex++) {
            int patterns = Integer.parseInt(scanner.nextLine());
            StringJoiner startPattern = new StringJoiner("");
            StringJoiner endPattern = new StringJoiner("");
            boolean isValid = true;

            for (int patternIndex = 0; patternIndex < patterns; patternIndex++) {
                String input = scanner.nextLine();

                if (input.startsWith("*")) {
                    String subString = input.substring(1);
                    if (endPattern.length() < subString.length()) {
                        if (subString.endsWith(endPattern.toString())) {
                            endPattern = new StringJoiner(subString);
                        } else {
                            isValid = false;
                        }
                    } else {
                        if (endPattern.toString().endsWith(subString)) {
                            // valid case, do nothing
                        } else {
                            isValid = false;
                        }
                    }
                }
                if (!isValid) {
                    break;
                }
            }

            String result = isValid ? endPattern.toString() : "*";
            System.out.println("Case #" + (caseIndex + 1) + ": " + result);
        }
    }
}