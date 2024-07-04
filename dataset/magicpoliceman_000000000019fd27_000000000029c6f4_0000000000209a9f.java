import java.io.*;

public class Solution {

    static public void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));

        for (int i = 0; i < testCases; i++) {
            String line = bufferedReader.readLine();
            String solution = solve(line);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    static private String solve(String line) {
        String[] digitsStr = line.split("");
        int[] digits = convertToInt(digitsStr);
        int biggestDigitIndex = findBiggestDigit(digits);
        StringBuilder result = new StringBuilder();
        int biggestDigit = digits[biggestDigitIndex];

        if (biggestDigitIndex == 0) {
            append(result, "(", biggestDigit);
        } else {
            advanceLeft(digits, biggestDigitIndex, biggestDigit, result);
        }

        result.append(biggestDigit);

        if (biggestDigitIndex == digits.length - 1) {
            append(result, ")", biggestDigit);
        } else {
            advanceRight(digits, biggestDigitIndex, biggestDigit, result);
        }

        return result.toString();
    }

    private static int[] convertToInt(String[] digitsStr) {
        int[] result = new int[digitsStr.length];
        for (int i = 0; i < digitsStr.length; i++) {
            result[i] = Integer.parseInt(digitsStr[i]);
        }
        return result;
    }

    private static int findBiggestDigit(int[] digits) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            if (digit > max) {
                max = digit;
                index = i;
            }
        }
        return index;
    }

    private static void advanceLeft(int[] digits, int previousIndex, int bracketsLeft, StringBuilder result) {
        int currentIndex = previousIndex - 1;
        int current = digits[currentIndex];
        int diff = digits[previousIndex] - current;
        if (diff > 0) {
                insert(result, "(", diff);
        } else {
                insert(result, ")", -diff);
        }
        bracketsLeft -= diff;

        result.insert(0, current);

        if (currentIndex == 0) {
            insert(result, "(", current);
        } else {
            advanceLeft(digits, currentIndex, bracketsLeft, result);
        }
    }

    private static void advanceRight(int[] digits, int previousIndex, int bracketsLeft, StringBuilder result) {
        int currentIndex = previousIndex + 1;
        int current = digits[currentIndex];
        int diff = digits[previousIndex] - current;
        if (diff > 0) {
            append(result, ")", diff);
        } else {
            append(result, "(", -diff);
        }
        bracketsLeft -= diff;

        result.append(current);

        if (currentIndex == digits.length - 1) {
            append(result, ")", current);
        } else {
            advanceRight(digits, currentIndex, bracketsLeft, result);
        }
    }

    private static void append(StringBuilder result, String s, int times) {
        for (int j = 0; j < times; j++) {
            result.append(s);
        }
    }

    private static void insert(StringBuilder result, String s, int times) {
        for (int j = 0; j < times; j++) {
            result.insert(0, s);
        }
    }
}