import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for(int tc = 1; tc <= T; tc++) {
            String S = in.next();

            String ans = "";
            int cntOpen = 0;

            for(char ch : S.toCharArray()) {
                int num = ch - '0';

                while(cntOpen < num) {
                    ans += "(";
                    cntOpen++;
                }

                while(num < cntOpen) {
                    ans += ")";
                    cntOpen--;
                }

                ans += ch;
            }

            while(cntOpen-- > 0) {
                ans += ")";
            }

            System.out.println("Case #" + tc + ": " + ans);
        }
    }
}