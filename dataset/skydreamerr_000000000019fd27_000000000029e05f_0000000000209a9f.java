import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            String str = in.next();

            String ans = solve(str);
            System.out.printf("Case #%d: %s%n", x, ans);
        }
    }

    static private String solve(String str) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < str.length(); i++) {
            int l = str.charAt(i) - '0';
            if(l>=depth) {
                while(l > depth) {
                    ans.append('(');
                    depth++;
                }

            }

            else  {
                while(l < depth) {
                    ans.append(')');
                    depth--;
                }
            }
            ans.append(str.charAt(i));

        }
        while(depth-->0) {
            ans.append(')');

        }

            return ans.toString();
    }
}