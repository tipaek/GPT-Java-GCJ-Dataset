import java.util.Scanner;

public class Solution {

    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            String s = sc.next();
            processTestCase(s, i);
        }
    }

    private static void processTestCase(String s, int testCase) {
        StringBuilder finalVal = new StringBuilder();
        int limit = Integer.parseInt(s);
        
        if (limit == 0) {
            System.out.println("Case #" + (testCase + 1) + ": " + s);
        } else if (s.length() == 1) {
            appendBrackets(finalVal, limit, '(');
            finalVal.append(s);
            appendBrackets(finalVal, limit, ')');
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
        } else {
            buildNestedString(s, finalVal);
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
        }
    }

    private static void appendBrackets(StringBuilder sb, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }

    private static void buildNestedString(String s, StringBuilder finalVal) {
        finalVal.append(s.charAt(0));
        int length = s.length();

        for (int i = 0; i < length - 1; i++) {
            int current = Character.getNumericValue(s.charAt(i));
            int next = Character.getNumericValue(s.charAt(i + 1));
            
            if (current < next) {
                appendBrackets(finalVal, next - current, '(');
            } else if (current > next) {
                appendBrackets(finalVal, current - next, ')');
            }
            finalVal.append(s.charAt(i + 1));
        }
        
        int firstDigit = Character.getNumericValue(s.charAt(0));
        int lastDigit = Character.getNumericValue(s.charAt(length - 1));
        
        appendBrackets(finalVal, firstDigit, '(');
        appendBrackets(finalVal, lastDigit, ')');
    }
}