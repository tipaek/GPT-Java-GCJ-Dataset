import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        
        for (int i = 0; i < t; i++) {
            String str = in.nextLine();
            System.out.println("Case #" + (i+1) + ": " 
                                + nestingString(str));
        }
    }
    
    public static String nestingString(String str) {
        StringBuilder sb = new StringBuilder();
        int last = 0;
        
        for (int i = 0; i < str.length(); i++) {
            int d = Character.getNumericValue(str.charAt(i));
            
            if (last > d) {
                appendChar(sb, ')', last-d);
            } else if (last < d) {
                appendChar(sb, '(', d-last);
            }
            sb.append(d);
            
            last = d;
        }
        
        appendChar(sb, ')', last);
        
        return sb.toString();
    }
    
    private static void appendChar(StringBuilder sb, char c, int n) {
        for (int j = 0; j < n;j++) {
            sb.append(c);
        }
    }
}