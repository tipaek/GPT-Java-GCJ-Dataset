import java.util.*;
import java.io.*;

public class Solution {

    private String addDepthParenthesis(String str) {
        StringBuilder newStr = new StringBuilder();
        int previousDepth = 0;

        for (int i = 0; i < str.length(); i++) {
            int currentDepth = Character.getNumericValue(str.charAt(i));

            while (previousDepth < currentDepth) {
                newStr.append('(');
                previousDepth++;
            }
            while (previousDepth > currentDepth) {
                newStr.append(')');
                previousDepth--;
            }

            newStr.append(str.charAt(i));
        }

        while (previousDepth > 0) {
            newStr.append(')');
            previousDepth--;
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