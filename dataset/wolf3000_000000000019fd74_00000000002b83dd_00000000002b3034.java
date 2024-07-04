import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] p = new String[n];
            for (int j = 0; j < n; ++j) {
                p[j] = in.next();
            }
            System.out.println("Case #" + i + ": " + solve(p));
        }

    }

    private static String solve(String[] p) {
        String prefix = "";
        String suffix = "";

        int[] index = new int[p.length];

        for (int i = 0; i < p.length; ++i) {
            String s = p[i];
            if (!s.startsWith("*")) {
                String currP = s.substring(0, s.indexOf('*'));
                if (prefix.length() == 0 || currP.startsWith(prefix)) {
                    prefix = currP;
                    int astIndex = s.indexOf('*');
                    p[i] = p[i].substring(astIndex);
                } else if(!prefix.startsWith(currP)){
                    return "*";
                }
            }
        }

        for (int i = 0; i < p.length; ++i) {
            String s = p[i];
            if (!s.endsWith("*")) {
                String currS = s.substring(s.lastIndexOf('*') + 1, s.length());
                if (suffix.length() == 0 || currS.endsWith(suffix)) {
                    int astIndex = s.lastIndexOf('*');
                    p[i] = p[i].substring(0, astIndex + 1);
                    suffix = currS;
                } else if(!suffix.endsWith(currS)){
                    return "*";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while(true) {
            boolean moved = false;
            for (int i = 0; i < index.length; ++i) {
                String s = p[i];
                if (index[i] < p[i].length()) {
                    int j = index[i] + 1;
                    while (j < s.length() && s.charAt(j) != '*') {
                        result.append(s.charAt(j));
                        j++;
                    }
                    index[i] = j;
                    moved = true;
                }
            }
            if(!moved){
                break;
            }
        }

        return prefix + result.toString() + suffix;
    }

}