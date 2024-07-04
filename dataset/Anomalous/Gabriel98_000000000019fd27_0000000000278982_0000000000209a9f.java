import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = sc.next();
            int currentDepth = 0;

            System.out.print("Case #" + caseNumber + ": ");

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';

                while (currentDepth < digit) {
                    System.out.print("(");
                    currentDepth++;
                }

                while (currentDepth > digit) {
                    System.out.print(")");
                    currentDepth--;
                }

                System.out.print(digit);
            }

            while (currentDepth > 0) {
                System.out.print(")");
                currentDepth--;
            }

            System.out.println();
        }

        sc.close();
    }
}