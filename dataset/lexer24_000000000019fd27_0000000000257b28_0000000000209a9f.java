import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            String res = "";
            int cur = 0;
            for (int j = 0; j < s.length(); j++) {
                int digit = s.charAt(j) - 48;
                if(cur < digit){
                    res += addBegin("" + digit, digit -cur);
                } else
                if(cur > digit){
                    res += addEnd(cur - digit) + digit;
                } else {
                    res += digit;
                }
                cur = digit;
            }
            
            res += addEnd(cur);
            System.out.println("Case #" + i + ": " + res);
        }
        in.close();
    }
    
    static String addBegin(String s, int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res+="(";
        }
        return res + s;
    }
    
    static String addEnd(int n) {
        String res = "";
        for (int i = 0; i < n; i++) {
            res+=")";
        }
        return res;
    }

}
