import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            char[] input = scanner.next().toCharArray();
            int length = input.length;
            int[] digits = new int[length];

            for (int i = 0; i < length; i++) {
                digits[i] = input[i] - '0';
            }

            System.out.println("Case #" + caseNum + ": ");
            int currentDepth = 0;

            for (int i = 0; i < length; i++) {
                while (currentDepth < digits[i]) {
                    System.out.print("(");
                    currentDepth++;
                }

                while (currentDepth > digits[i]) {
                    System.out.print(")");
                    currentDepth--;
                }

                System.out.print(digits[i]);
            }

            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }

            System.out.println();
        }

        scanner.close();
    }
}