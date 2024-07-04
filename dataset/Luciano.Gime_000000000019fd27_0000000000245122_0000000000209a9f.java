/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LUCIANO.
 */
import java.util.*;

public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.next());
        for(int tt = 0; tt < t; tt++) {
            String s = in.next();
            String ans = "";
            int prev = 0;
            for(int i = 0; i < s.length(); i++) {
                int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
                if(s.substring(i, i + 1).equals("0")) {
                    ans = ans + "0";
                }else {
                    if(ans.length() == 0) {
                        ans = ans + add(String.valueOf(s.charAt(i)), cur);
                    }else if(prev <= cur) {
                        int lst = last(ans);
                        if(lst + 1 < ans.length()) {
                            ans = ans.substring(0, lst + 1) + add(String.valueOf(s.charAt(i)), (cur - prev)) + ans.substring(lst + 1, ans.length());
                        } else {
                            ans = ans.substring(0, lst + 1) + add(String.valueOf(s.charAt(i)), (cur - prev));
                        }
                    }else {
                        int diff = prev - cur;
                        int lst = last(ans);
                        lst += diff;
                        ans = ans = ans.substring(0, lst + 1) + String.valueOf(s.charAt(i)) + ans.substring(lst + 1, ans.length());
                    }
                }
                prev = cur;
            }
            System.out.println("Case #" + (tt + 1) + ": " + ans);
        }
    }
    public static int last(String ans) {
        for(int i = ans.length() - 1; i >= 0; i--) {
            if((ans.charAt(i) != '(') && (ans.charAt(i) != ')')) {
                return i;
            }
        }
        return 0;
    }
    public static String add(String toadd, int depth) {
        String ret = "";
        for(int i = 0; i < depth; i++) {
            ret += "(";
        }
        ret += toadd;
        for(int i = 0; i < depth; i++) {
            ret += ")";
        }
        return ret;
    }
}