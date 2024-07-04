import java.io.*;
import java.util.*;
import java.math.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=  0; t < T; t++) {
            System.out.format("Case #%d: ", t + 1);
            String S = in.next();
            int depth = 0;
            
            for(int i = 0; i < S.length(); i++) {
                int d = S.charAt(i) - '0';
                while (depth < d) {
                    System.out.print('(');
                    depth++;
                }
                while (depth > d) {
                    System.out.print(')');
                    depth--;
                }
                System.out.print(d);
            }
            while(depth-- > 0) {
                System.out.print(')');
            }
            System.out.println();
        }
        
    }
}