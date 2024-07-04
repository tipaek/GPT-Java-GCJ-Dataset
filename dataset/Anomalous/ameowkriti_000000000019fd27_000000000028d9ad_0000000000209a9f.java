import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int c = 1; c <= t; c++) {
            String s = scan.next();
            StringBuilder result = processString(s);
            System.out.printf("Case #%d: %s%n", c, result);
        }
    }

    public static StringBuilder processString(String s) {
        StringBuilder result = new StringBuilder();
        int previousDigit = s.charAt(0) - '0';
        int openBrackets = 0;

        for (int i = 0; i < previousDigit; i++) {
            result.append("(");
            openBrackets++;
        }
        result.append(previousDigit);

        for (int i = 1; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';
            if (currentDigit > previousDigit) {
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append("(");
                    openBrackets++;
                }
            } else if (currentDigit < previousDigit) {
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    result.append(")");
                    openBrackets--;
                }
            }
            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        for (int j = 0; j < openBrackets; j++) {
            result.append(")");
        }

        return result;
    }
}