import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = Integer.parseInt(scanner.nextLine());

        for (int caseIndex = 1; caseIndex <= numberOfCases; caseIndex++) {
            String inputString = scanner.nextLine();
            ArrayList<Character> outputList = new ArrayList<>();
            char[] digits = inputString.toCharArray();
            int offset = 0;

            for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
                int currentDigit = Character.getNumericValue(digits[digitIndex]);
                int currentDepth = getDepth(outputList, digitIndex + offset);

                if (currentDigit > currentDepth) {
                    while (currentDigit > currentDepth) {
                        outputList.add(digitIndex + offset, ')');
                        offset++;
                        currentDepth++;
                    }
                } else {
                    while (currentDigit < currentDepth) {
                        outputList.add(digitIndex + offset, '(');
                        offset++;
                        currentDepth--;
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            for (char c : outputList) {
                output.append(c);
            }

            System.out.println("Case #" + caseIndex + ": " + output);
        }
    }

    public static int getDepth(ArrayList<Character> list, int index) {
        int depth = 0;
        for (int i = 0; i < index; i++) {
            if (list.get(i) == '(') {
                depth++;
            } else if (list.get(i) == ')') {
                depth--;
            }
        }
        return depth;
    }
}