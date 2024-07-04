import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) {
            String str = in.next();
            
            System.out.println("Case #" + i + ": " + run(str));
        }
    }
    
    public static String run(String str)
    {
        char[] chars = str.toCharArray();
        int[] nums = new int[chars.length];
        
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int previous = 0;
        
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i] - '0';
            
            if (i > 0 && num != previous && count > 0) {
                for (int j = 0; j < count; j++) {
                    sb.append(')');
                }
                count = 0;
            }

            if (count == 0) {
                count = num;
                for (int j = 0; j < count; j++) {
                    sb.append('(');
                }
            }
            
            sb.append(chars[i]);
            
            if (i == chars.length - 1 && count > 0) {
                for (int j = 0; j < count; j++) {
                    sb.append(')');
                }
            }
            
            previous = num;
        }
        
        return sb.toString();
    }
}