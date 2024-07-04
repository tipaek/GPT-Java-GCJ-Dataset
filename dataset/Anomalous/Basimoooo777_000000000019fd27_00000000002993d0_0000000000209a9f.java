import java.util.*;

public class Solution {

    private static int findMinimum(int[] array, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    private static String generateNestedParentheses(int[] array, int start, int end, int previousMin) {
        StringBuilder result = new StringBuilder();

        int currentMin = findMinimum(array, start, end);

        for (int i = 0; i < currentMin - previousMin; i++) {
            result.append("(");
        }

        if (start == end) {
            result.append(array[start]);
        } else {
            int left = start, right = end;
            while (left <= end && right <= end) {
                while (left <= end && array[left] == currentMin) {
                    result.append(array[left]);
                    left++;
                }

                if (left > end) break;

                right = left;

                while (right <= end && array[right] != currentMin) {
                    right++;
                }

                right--;

                result.append(generateNestedParentheses(array, left, right, currentMin));
                left = right + 1;
            }
        }

        for (int i = 0; i < currentMin - previousMin; i++) {
            result.append(")");
        }

        return result.toString();
    }

    private static int[] convertStringToIntArray(String input) {
        int length = input.length();
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = input.charAt(i) - '0';
        }
        return intArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int[] inputArray = convertStringToIntArray(scanner.next());
            String result = generateNestedParentheses(inputArray, 0, inputArray.length - 1, 0);
            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}