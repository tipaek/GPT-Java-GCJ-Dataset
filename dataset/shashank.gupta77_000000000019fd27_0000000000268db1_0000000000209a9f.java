import java.io.*;
import java.util.*;
import java.lang.*;

class Solution {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) throws IOException {
        int t = scan.nextInt();
        for(int tc = 1;tc<=t;++tc) {
            String task = scan.next();
            String answer = solve(task);
            System.out.println(String.format("Case #%d: %s", tc, answer));
        }
    }
    private static String solve(String str) {
        StringBuilder ans = new StringBuilder();
        int open = 0;
        int n = str.length();
        for(int i=0;i<n;++i) {
            char c = str.charAt(i);
            int val = (int)c - (int)'0';
            while(val>open) {
                ans.append('(');
                open++;
            }
            while(val<open) {
                ans.append(')');
                open--;
            }
            ans.append(c);
        }
        while(open > 0) {
            ans.append(')');
            open--;
        }
        return ans.toString();
    }
}