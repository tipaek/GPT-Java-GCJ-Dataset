import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            String[] outputArray = input.split("");
            int length = input.length();
            int[] count = new int[length];
            char[] charArray = input.toCharArray();

            System.out.print("Case #" + t + ": ");

            int i = 0;
            while (i < length) {
                int currentDigit = charArray[i] - '0';
                int currentCount = count[i];

                if (currentDigit == currentCount) {
                    System.out.print(outputArray[i]);
                    i++;
                    continue;
                }

                int difference = currentDigit - currentCount;
                for (int j = 0; j < difference; j++) {
                    System.out.print("(");
                }
                System.out.print(outputArray[i]);

                while (count[i] < currentDigit) {
                    addParentheses(i, count, outputArray, charArray, length);
                }

                i++;
            }

            System.out.println();
        }
    }

    private static void addParentheses(int start, int[] count, String[] outputArray, char[] charArray, int length) {
        int maxDifference = charArray[start] - '0' - count[start];

        int i = start + 1;
        while (i < length && (charArray[i] - '0') - count[i] > 0) {
            maxDifference = Math.min(maxDifference, (charArray[i] - '0') - count[i]);
            i++;
        }

        for (int j = start; j < i; j++) {
            count[j] += maxDifference;
        }

        StringBuilder closingParentheses = new StringBuilder();
        for (int j = 0; j < maxDifference; j++) {
            closingParentheses.append(")");
        }

        if (i - 1 == start) {
            System.out.print(closingParentheses);
        } else {
            outputArray[i - 1] += closingParentheses;
        }
    }
}