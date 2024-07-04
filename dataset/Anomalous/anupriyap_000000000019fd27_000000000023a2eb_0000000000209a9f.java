import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void findParentheses(int index, String s) {
        StringBuilder result = new StringBuilder();
        int openedBrackets = 0;
        int lastReadDigit = 0;

        for (int k = 0; k < s.length(); k++) {
            int readDigit = Character.getNumericValue(s.charAt(k));
            
            if (openedBrackets == 0) {
                appendBrackets(result, readDigit, '(');
                openedBrackets += readDigit;
                result.append(s.charAt(k));
            } else {
                if (lastReadDigit == readDigit) {
                    result.append(s.charAt(k));
                } else if (lastReadDigit < readDigit) {
                    int diff = readDigit - lastReadDigit;
                    appendBrackets(result, diff, '(');
                    openedBrackets += diff;
                    result.append(s.charAt(k));
                } else {
                    int diff = lastReadDigit - readDigit;
                    appendBrackets(result, diff, ')');
                    openedBrackets -= diff;
                    result.append(s.charAt(k));
                }
            }
            lastReadDigit = readDigit;
        }
        
        appendBrackets(result, openedBrackets, ')');
        System.out.println("Case #" + index + ": " + result);
    }

    private static void appendBrackets(StringBuilder result, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            result.append(bracket);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            findParentheses(i, n);
        }
        in.close();
    }
}