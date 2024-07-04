import java.util.Scanner;

public class Solution {
    private static int testCases, depth;
    private static String[] buffer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        testCases = input.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            buffer = input.next().split("");
            depth = 0;
            
            for (int j = 0; j < buffer.length; j++) {
                int currentDigit = Integer.parseInt(buffer[j]);
                if (depth < currentDigit) {
                    printLeftParens(currentDigit - depth);
                    depth = currentDigit;
                } else {
                    printRightParens(depth - currentDigit);
                    depth = currentDigit;
                }
                System.out.print(currentDigit);
            }
            printRightParens(depth);
            System.out.println();  // Add a newline after each test case for better readability
        }
    }

    private static void printLeftParens(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("(");
        }
    }

    private static void printRightParens(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(")");
        }
    }
}