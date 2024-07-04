import java.util.*;
import java.io.*;

public class Solution {
    static char[] inputChars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            inputChars = scanner.next().toCharArray();
            List<Integer> numbers = new ArrayList<>();
            for (char c : inputChars) {
                numbers.add(c - '0');
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(numbers));
        }
    }

    static String solve(List<Integer> numbers) {
        int[] leftBrackets = new int[numbers.size()];
        int[] rightBrackets = new int[numbers.size()];
        int start = -1;

        while (!allZeros(numbers)) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) > 0) {
                    if (start == -1) {
                        start = i;
                    }
                    if (i == numbers.size() - 1 || numbers.get(i + 1) <= 0) {
                        leftBrackets[start]++;
                        rightBrackets[i]++;
                        start = -1;
                    }
                }
            }
            for (int i = 0; i < numbers.size(); i++) {
                numbers.set(i, numbers.get(i) - 1);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < inputChars.length; i++) {
            for (int j = 0; j < leftBrackets[i]; j++) {
                result.append('(');
            }
            result.append(inputChars[i]);
            for (int j = 0; j < rightBrackets[i]; j++) {
                result.append(')');
            }
        }
        return result.toString();
    }

    static boolean allZeros(List<Integer> numbers) {
        for (int num : numbers) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}