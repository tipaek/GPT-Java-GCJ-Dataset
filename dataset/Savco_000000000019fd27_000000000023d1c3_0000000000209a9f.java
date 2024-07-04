import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder result = new StringBuilder();
            for (int j = 0; j <= s.length(); j++){
                int p = 0;
                if (j == 0) p = s.charAt(0) - 48;
                else if (j == s.length()) p = 48 - s.charAt(j-1);
                else p = s.charAt(j) - s.charAt(j-1);
                for (int k = 0; k < Math.abs(p); k++){
                    if (p > 0) result.append('(');
                    if (p < 0) result.append(')');
                }
                if(j != s.length()) {
                    result.append(s.charAt(j));
                }
            }
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}
