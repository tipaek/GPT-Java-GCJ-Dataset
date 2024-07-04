import java.io.*;
import java.util.*;

public class Solution {
    public static String helper (String in) {
        boolean changed = false;
        boolean open = false;
        String ans = "";
        int num;
        for (int x = 0; x < in.length(); x++) {
            if (in.charAt(x) == ')' || in.charAt(x) == '(') {
                ans += Character.toString(in.charAt(x));
            }
            else {
                num = Integer.parseInt(Character.toString(in.charAt(x)));
                if (num > 0) {
                    if (!open) {
                        ans += "(";
                        open = true;
                    }
                    ans += (num-1);
                    changed = true;
                }
                else {
                    if (open) {
                        ans += ")";
                        open = false;
                    }
                    ans += num;
                }
            }
        }
        if (open) {
            ans += ")";
        }
        if (changed) {
            return helper(ans);
        }
        else {
            return ans;
        }
    }
    public static String inter(String s) {
        String ans = "";
        int in = 0;
        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) == '(') {
                in++;
                ans += "(";
            }
            else if (s.charAt(x) == ')') {
                in--;
                ans += ")";
            }
            else {
                ans += in;
            }
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(s.nextLine());
        for (int q = 1; q <= tests; q++) {
            String par = inter(helper(s.nextLine()));
            System.out.println("Case #" + q + ": " + par);
        }
    }
}