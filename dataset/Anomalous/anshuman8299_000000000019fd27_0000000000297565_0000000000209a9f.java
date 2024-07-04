import java.util.*;
import java.io.*;

public class Solution {

    private String addDepthParenthesis(String str) {
        StringBuilder newStr = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = Character.getNumericValue(str.charAt(i));
            while (currentDepth < digit) {
                newStr.append("(");
                currentDepth++;
            }
            while (currentDepth > digit) {
                newStr.append(")");
                currentDepth--;
            }
            newStr.append(digit);
        }

        while (currentDepth > 0) {
            newStr.append(")");
            currentDepth--;
        }

        return newStr.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Solution sol = new Solution();
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            String str = in.next();
            String addedParenthesis = sol.addDepthParenthesis(str);
            System.out.println("Case #" + i + ": " + addedParenthesis);
        }
    }
}