import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();

        for (int test = 1; test <= numTests; test++) {
            String digits = in.next();
            String nestingDepth = getNestingDepth(digits);
            System.out.printf("Case #%s: %s", test, nestingDepth);
            System.out.println();
        }
    }
    
    public static String getNestingDepth(String digits) {
        int currentDepth = 0;
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < digits.length(); index++) {
            int newDepth = digits.charAt(index) - '0';
            int bracketsToAdd = newDepth - currentDepth;
            if (bracketsToAdd >= 0) {
                for (int num = 0; num < bracketsToAdd; num++) {
                    builder.append('(');
                }
            }
            else {
                bracketsToAdd = Math.abs(bracketsToAdd);
                for (int num = 0; num < bracketsToAdd; num++) {
                    builder.append(')');
                }
            }
            builder.append(digits.charAt(index));
            currentDepth = newDepth;
        }

        for (int bracketsLeft = 0; bracketsLeft < currentDepth; bracketsLeft++) {
            builder.append(')');
        }

        return builder.toString();
    }
}