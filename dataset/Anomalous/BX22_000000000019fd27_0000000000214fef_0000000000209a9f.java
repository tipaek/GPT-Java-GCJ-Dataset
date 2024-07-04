import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("problem.in"));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            int length = input.length();
            int[] numbers = new int[length];
            int[] copy = new int[length];
            String[] openBrackets = new String[length];
            String[] closeBrackets = new String[length];

            for (int i = 0; i < length; i++) {
                numbers[i] = Character.getNumericValue(input.charAt(i));
                copy[i] = numbers[i];
                openBrackets[i] = "";
                closeBrackets[i] = "";
            }

            processBrackets(numbers, openBrackets, closeBrackets, 0, length - 1);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < length; i++) {
                result.append(openBrackets[i]);
                result.append(copy[i]);
                result.append(closeBrackets[i]);
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }

    private static void processBrackets(int[] numbers, String[] openBrackets, String[] closeBrackets, int left, int right) {
        if (left < 0 || right < 0 || right >= numbers.length || left >= numbers.length) {
            return;
        }

        if (allZeroes(numbers, left, right)) {
            return;
        }

        int minIndex = findMinIndex(numbers, left, right);
        int minValue = numbers[minIndex];

        for (int i = 0; i < minValue; i++) {
            openBrackets[left] += "(";
            closeBrackets[right] += ")";
        }

        boolean needsFurtherProcessing = false;
        for (int i = left; i <= right; i++) {
            numbers[i] -= minValue;
            if (numbers[i] != 0) {
                needsFurtherProcessing = true;
            }
        }

        if (minIndex == left && needsFurtherProcessing) {
            processBrackets(numbers, openBrackets, closeBrackets, left + 1, right);
        } else if (minIndex == right && needsFurtherProcessing) {
            processBrackets(numbers, openBrackets, closeBrackets, left, right - 1);
        } else if (needsFurtherProcessing) {
            processBrackets(numbers, openBrackets, closeBrackets, left, minIndex - 1);
            processBrackets(numbers, openBrackets, closeBrackets, minIndex + 1, right);
        }
    }

    private static boolean allZeroes(int[] numbers, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (numbers[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static int findMinIndex(int[] numbers, int left, int right) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = left; i <= right; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}