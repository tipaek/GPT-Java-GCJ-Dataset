import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void solve(Scanner input, int caseNumber, int patternCount) {
        Queue<char[]> patterns = new LinkedList<>();
        int maxLength = 0;
        
        for (int i = 0; i < patternCount; i++) {
            String pattern = input.next();
            maxLength = Math.max(maxLength, pattern.length());
            patterns.add(pattern.toCharArray());
        }

        boolean isSuccess = true;
        Stack<Character> resultStack = new Stack<>();
        
        for (int i = 1; i < maxLength; i++) {
            char commonChar = findCommonChar(patterns, i);
            if (commonChar == '-') {
                isSuccess = false;
                break;
            } else {
                resultStack.push(commonChar);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        while (!resultStack.isEmpty()) {
            resultBuilder.append(resultStack.pop());
        }

        if (isSuccess) {
            System.out.println("Case #" + caseNumber + ": " + resultBuilder.toString());
        } else {
            System.out.println("Case #" + caseNumber + ": *");
        }
    }

    private static char findCommonChar(Queue<char[]> patterns, int index) {
        char commonChar = '*';
        
        for (char[] pattern : patterns) {
            int length = pattern.length;
            if (length > index) {
                char currentChar = pattern[length - index];
                if (currentChar != '*') {
                    if (commonChar == '*') {
                        commonChar = currentChar;
                    } else if (currentChar != commonChar) {
                        return '-';
                    }
                }
            }
        }
        
        return commonChar;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = input.nextInt();
            solve(input, caseNumber, patternCount);
        }
    }
}