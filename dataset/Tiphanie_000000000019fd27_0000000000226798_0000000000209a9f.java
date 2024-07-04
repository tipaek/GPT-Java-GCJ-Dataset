import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String next = in.next();
            String ans = helper(next);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String helper(String s) {
        char[] ch = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int open = 0;
        for (int i = 0; i < ch.length; i++) {
           int num = ch[i] - '0';
           while (open < num) {
               res.append('(');
               open++;
           }
           while (open > num) {
               res.append(')');
               open--;
           }
           res.append(num);
        }
        while (open > 0) {
            res.append(')');
            open--;
        }
        return res.toString();
    }
}