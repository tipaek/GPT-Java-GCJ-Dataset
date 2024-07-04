import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            int currentDepth = 0;

            System.out.print("Case #" + caseNumber + ": ");

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';

                while (currentDepth < digit) {
                    System.out.print("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    System.out.print(")");
                    currentDepth--;
                }

                System.out.print(digitChar);
            }

            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }
            System.out.println();
        }
    }
}