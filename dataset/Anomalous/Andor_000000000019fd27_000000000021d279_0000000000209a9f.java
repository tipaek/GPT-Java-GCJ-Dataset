import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            String[] digits = input.next().split("");
            System.out.print("Case #" + caseNum + ": ");
            
            int currentDepth = 0;
            for (String digitStr : digits) {
                int digit = Integer.parseInt(digitStr);
                if (currentDepth < digit) {
                    printBrackets('(', digit - currentDepth);
                } else if (currentDepth > digit) {
                    printBrackets(')', currentDepth - digit);
                }
                currentDepth = digit;
                System.out.print(digit);
            }
            printBrackets(')', currentDepth);
            System.out.println();
        }
    }

    private static void printBrackets(char bracket, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(bracket);
        }
    }
}