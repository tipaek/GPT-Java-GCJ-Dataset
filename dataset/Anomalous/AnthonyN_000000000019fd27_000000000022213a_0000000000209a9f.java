import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < numOfTestCases; i++) {
            String result = nest(scanner.nextLine());
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int countRemainingParen(StringBuilder sb, int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
        }
        return count;
    }

    private static String generateParen(int num, char parenType) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(parenType);
        }
        return sb.toString();
    }

    private static int getLeftIndex(StringBuilder sb, int digit, int index) {
        for (int i = index - 1; i >= 0; i--) {
            int num = sb.charAt(i) - '0';
            if (num >= 0 && num < digit) {
                return i + 1;
            }
        }
        return 0;
    }

    private static int getRightIndex(StringBuilder sb, int digit, int index) {
        for (int i = index + 1; i < sb.length(); i++) {
            int num = sb.charAt(i) - '0';
            if (num >= 0 && num < digit) {
                return i;
            }
        }
        return sb.length();
    }

    private static String nest(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int digit = 1; digit <= 9; digit++) {
            int startIndex = 0;
            int nextIndex;

            while ((nextIndex = sb.indexOf(Integer.toString(digit), startIndex)) != -1) {
                int remainingParen = digit - countRemainingParen(sb, nextIndex);

                if (remainingParen != 0) {
                    int leftIndex = getLeftIndex(sb, digit, nextIndex);
                    sb.insert(leftIndex, generateParen(remainingParen, '('));

                    int rightIndex = getRightIndex(sb, digit, nextIndex + remainingParen);
                    sb.insert(rightIndex, generateParen(remainingParen, ')'));
                }

                startIndex = nextIndex + remainingParen + 1;
            }
        }

        return sb.toString();
    }
}