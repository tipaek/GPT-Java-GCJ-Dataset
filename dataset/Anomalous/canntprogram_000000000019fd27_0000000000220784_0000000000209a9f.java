import java.util.Scanner;

public class Solution {
    public static void solve(int caseNumber, String inputString) {
        String result = processString(inputString, 0);
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    public static String processString(String inputString, int previousNum) {
        if (inputString.isEmpty()) {
            return inputString;
        }

        int minValue = Integer.MAX_VALUE;
        int minPosition = inputString.length();

        for (int i = 0; i < inputString.length(); i++) {
            int currentValue = inputString.charAt(i) - '0';
            if (currentValue < minValue) {
                minValue = currentValue;
                minPosition = i;
            }
        }

        int segmentStart = minPosition;
        int segmentEnd = minPosition;

        while (segmentStart > 0 && inputString.charAt(segmentStart - 1) - '0' == minValue) {
            segmentStart--;
        }

        while (segmentEnd < inputString.length() - 1 && inputString.charAt(segmentEnd + 1) - '0' == minValue) {
            segmentEnd++;
        }

        String leftPart = processString(inputString.substring(0, segmentStart), minValue);
        String middlePart = inputString.substring(segmentStart, segmentEnd + 1);
        String rightPart = processString(inputString.substring(segmentEnd + 1), minValue);

        String combinedString = leftPart + middlePart + rightPart;

        for (int i = 0; i < minValue - previousNum; i++) {
            combinedString = '(' + combinedString + ')';
        }

        return combinedString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.nextLine();
            solve(caseNumber, inputString);
        }

        scanner.close();
    }
}