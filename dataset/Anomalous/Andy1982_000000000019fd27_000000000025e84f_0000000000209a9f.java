import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestCases = input.nextInt();
        input.nextLine(); // Consume the newline left-over

        List<String> testCases = new ArrayList<>();
        for (int i = 0; i < noOfTestCases; i++) {
            testCases.add(input.nextLine());
        }

        int caseNumber = 1;
        for (String testCase : testCases) {
            System.out.flush();
            System.out.println("Case #" + caseNumber + ": " + createPattern(testCase));
            System.out.flush();
            caseNumber++;
        }
    }

    private static String createPattern(String str) {
        StringBuilder result = new StringBuilder();
        int prevValue = Integer.MAX_VALUE;

        for (int i = str.length() - 1; i >= 0; i--) {
            int currentValue = Character.getNumericValue(str.charAt(i));
            
            if (prevValue == Integer.MAX_VALUE) {
                appendPattern(result, currentValue, currentValue, ")");
            } else {
                if (currentValue > prevValue) {
                    appendPattern(result, currentValue - prevValue, currentValue, ")");
                } else if (currentValue == prevValue) {
                    appendPattern(result, 0, currentValue, "");
                } else {
                    appendPattern(result, prevValue - currentValue, currentValue, "(");
                }
            }
            prevValue = currentValue;
        }
        appendPattern(result, prevValue, Integer.MAX_VALUE, "(");

        return result.toString();
    }

    private static void appendPattern(StringBuilder result, int repeatCount, int value, String paren) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            temp.append(paren);
        }

        if (value != Integer.MAX_VALUE) {
            temp.insert(0, value);
        }

        result.insert(0, temp);
    }
}