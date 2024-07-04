import java.io.*;
import java.util.*;
class Solution {

    public static void getBracket(StringBuilder s, int n) {
        if(n > 0) {
            for(int i = 0; i < n; i++) {
                s.append('(');
            }
        }
        else {
            n *= -1;
            for(int i = 0; i < n; i++) {
                s.append(')');
            }
        }
    }

    public static void getAnswer(String s, int ct) {
        int n = s.length();
        StringBuilder s3 = new StringBuilder();

        char ch = s.charAt(0);
        int a1 = ch - '0';
        getBracket(s3, a1);
        s3.append(ch);
        int count = a1;
                
        for(int i = 1; i < n; i++) {
            getBracket(s3, s.charAt(i) - s.charAt(i - 1));
            s3.append(s.charAt(i));
            count += s.charAt(i) - s.charAt(i - 1);
        }

        getBracket(s3, -1 * count);

        System.out.println("Case #" + ct + ": " + s3);
    }
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scn.nextInt();

        int ct = 1;
        while(ct <= t) {
            String s = scn.next();
            getAnswer(s, ct);
            ct++;
        }
    }
}