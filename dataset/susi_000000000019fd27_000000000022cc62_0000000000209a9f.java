import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= cases; i++) {
            String s = input.nextLine();
            System.out.println("Case #" + i + ": " + paren(s));
        }
    }
    
    private static String paren(String s) {
        char[] chars = s.toCharArray();
        
        StringBuilder builder = new StringBuilder();
        int prevNum = 0;
        for (int i = 0; i < chars.length; i++) {
            int currNum = chars[i] - '0';
            
            if (currNum > prevNum) {
                int parenCount = currNum - prevNum;
                for (int j = 0; j < parenCount; j++) {
                    builder.append('(');
                }
            } else if (currNum < prevNum) {
                int parenCount = prevNum - currNum;
                for (int j = 0; j < parenCount; j++) {
                    builder.append(')');
                }
            }
            builder.append(chars[i]);
            prevNum = currNum;
        }
        
        for (int j = 0; j < prevNum; j++) {
            builder.append(')');
        }
        
        return builder.toString();
    }
}

