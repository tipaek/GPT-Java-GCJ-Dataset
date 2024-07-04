import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            String inputLine = scanner.nextLine();
            String result = processInput(inputLine);
            System.out.println("Case #" + caseNo + ": " + result);
        }
    }

    private static String processInput(String inputLine) {
        String[] inputArray = inputLine.split("");
        int[] digits = new int[inputArray.length];
        int[] braceCount = new int[inputArray.length];
        String originalInput = String.join("", inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            digits[i] = Integer.parseInt(inputArray[i]);
        }

        Arrays.sort(inputArray);
        String sortedInput = String.join("", inputArray);

        StringBuilder result = new StringBuilder(originalInput);

        for (int i = 0; i < sortedInput.length(); i++) {
            char currentChar = sortedInput.charAt(i);
            int index = originalInput.indexOf(currentChar);
            int left = findLeftBoundary(digits, index);
            int right = findRightBoundary(digits, index);

            updateBraceCount(braceCount, digits, index, left, right);
            String subStr = originalInput.substring(left, right + 1);
            String replacement = createReplacementString(digits, index, braceCount, subStr);

            result = new StringBuilder(result.toString().replaceFirst(subStr, replacement));
            originalInput = originalInput.replaceFirst(Character.toString(currentChar), ".");
        }

        return finalizeResult(result.toString(), digits);
    }

    private static int findLeftBoundary(int[] digits, int index) {
        for (int j = index; j >= 0; j--) {
            if (digits[j] < digits[index]) {
                return j + 1;
            }
        }
        return 0;
    }

    private static int findRightBoundary(int[] digits, int index) {
        for (int j = index; j < digits.length; j++) {
            if (digits[j] < digits[index]) {
                return j - 1;
            }
        }
        return digits.length - 1;
    }

    private static void updateBraceCount(int[] braceCount, int[] digits, int index, int left, int right) {
        for (int j = left; j <= right; j++) {
            if (digits[index] != 0) {
                braceCount[j]++;
            }
        }
    }

    private static String createReplacementString(int[] digits, int index, int[] braceCount, String subStr) {
        if (digits[index] == 0) {
            return subStr;
        }

        String replacement = "(" + subStr + ")";
        int extraBraces = digits[index] - braceCount[index];

        for (int k = 0; k < extraBraces; k++) {
            replacement = "(" + replacement + ")";
        }

        for (int k = 0; k < subStr.length(); k++) {
            braceCount[index + k] = digits[index];
        }

        return replacement;
    }

    private static String finalizeResult(String result, int[] digits) {
        StringBuilder finalResult = new StringBuilder();
        int digitIndex = 0;

        for (int k = 0; k < result.length(); k++) {
            if (result.charAt(k) == '.') {
                finalResult.append(digits[digitIndex]);
                digitIndex++;
            } else {
                finalResult.append(result.charAt(k));
            }
        }

        return finalResult.toString();
    }
}