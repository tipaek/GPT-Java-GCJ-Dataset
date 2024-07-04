import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();
            int depth = 0;
            
            for (char ch : s.toCharArray()) {
                int digit = ch - '0';
                
                while (depth < digit) {
                    res.append('(');
                    depth++;
                }
                
                while (depth > digit) {
                    res.append(')');
                    depth--;
                }
                
                res.append(ch);
            }
            
            while (depth > 0) {
                res.append(')');
                depth--;
            }
            
            System.out.println("Case #" + (i + 1) + ": " + res.toString());
        }
    }
}