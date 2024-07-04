import java.util.*;
import java.io.*;

public class Solution {
    static char[] inputChars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            inputChars = scanner.next().toCharArray();
            ArrayList<Integer> digitList = new ArrayList<>();
            for (char c : inputChars) {
                digitList.add(c - '0');
            }
            System.out.println("Case #" + (t + 1) + ": " + generateBalancedParentheses(digitList));
        }
    }

    static String generateBalancedParentheses(ArrayList<Integer> digits) {
        int[] leftParentheses = new int[digits.size()];
        int[] rightParentheses = new int[digits.size()];
        int openingIndex = -1;
        int closingIndex = -1;

        while (!allZeros(digits)) {
            for (int i = 0; i < digits.size(); i++) {
                if (digits.get(i) > 0 && digits.size() == 1) {
                    leftParentheses[0]++;
                    rightParentheses[0]++;
                } else if (digits.get(i) > 0 && i == digits.size() - 1) {
                    if (openingIndex != -1) {
                        closingIndex = i;
                        leftParentheses[openingIndex]++;
                        rightParentheses[closingIndex]++;
                        openingIndex = -1;
                        closingIndex = -1;
                    } else {
                        leftParentheses[i]++;
                        rightParentheses[i]++;
                        openingIndex = -1;
                        closingIndex = -1;
                    }
                } else if (digits.get(i) > 0 && openingIndex == -1) {
                    openingIndex = i;
                } else if (digits.get(i) <= 0 && openingIndex != -1) {
                    closingIndex = i - 1;
                    leftParentheses[openingIndex]++;
                    rightParentheses[closingIndex]++;
                    openingIndex = -1;
                    closingIndex = -1;
                }
            }
            for (int i = 0; i < digits.size(); i++) {
                digits.set(i, digits.get(i) - 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputChars.length; i++) {
            for (int j = 0; j < leftParentheses[i]; j++) {
                result.append('(');
            }
            result.append(inputChars[i]);
            for (int j = 0; j < rightParentheses[i]; j++) {
                result.append(')');
            }
        }
        return result.toString();
    }

    static boolean allZeros(ArrayList<Integer> digits) {
        for (Integer digit : digits) {
            if (digit > 0) {
                return false;
            }
        }
        return true;
    }
}