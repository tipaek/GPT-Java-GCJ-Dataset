import java.util.Scanner;

public class Solution {
    private static int t, depth;
    private static String[] buffer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        t = input.nextInt();
        for (int a = 1; a <= t; a++) {
            System.out.print("Case #" + a + ": ");
            buffer = input.next().split("");
            depth = 0;
            for (String s : buffer) {
                int currentDigit = Integer.parseInt(s);
                if (depth < currentDigit) {
                    printLeftParentheses(currentDigit - depth);
                    depth = currentDigit;
                } else {
                    printRightParentheses(depth - currentDigit);
                    depth = currentDigit;
                }
                System.out.print(currentDigit);
            }
            printRightParentheses(depth);
            System.out.println();
        }
    }

    private static void printLeftParentheses(int count) {
        for (int k = 0; k < count; k++) {
            System.out.print("(");
        }
    }

    private static void printRightParentheses(int count) {
        for (int k = 0; k < count; k++) {
            System.out.print(")");
        }
    }
}