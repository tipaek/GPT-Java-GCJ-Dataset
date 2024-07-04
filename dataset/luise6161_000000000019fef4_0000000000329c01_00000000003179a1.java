import java.util.*;
import java.io.*;


public class Solution {

    private static Scanner in;
    private static long[] a;
    private static int n,d;

    private static HashMap<Character, Integer> maxrep = new HashMap<>();

    private static void solve(){
        maxrep.clear();
        String num, str;
        int u =in.nextInt();
        for(int i=1;i<=10000;i++) {
            num = in.next();
            str = in.next();
            if(num.length() == str.length() && num.charAt(0) != '-') {
                int val = maxrep.getOrDefault(str.charAt(0), 10);
                val = Math.min(val, num.toCharArray()[0] - '0');
                maxrep.put(str.charAt(0), val);
                for(int j=1;j<str.length(); j++){
                    val = maxrep.getOrDefault(str.charAt(j), 10);
                    val = Math.min(val, 10);
                    maxrep.put(str.charAt(j), val);
                }
            } else {
                for (int j = 0; j < str.length(); j++) {
                    int val = maxrep.getOrDefault(str.charAt(j), 10);
                    val = Math.min(val, 10);
                    maxrep.put(str.charAt(j), val);
                }
            }
        }

        char[] ans = new char[10];

        for(Character c: maxrep.keySet()) {
            if(maxrep.get(c) < 10) {
                ans[maxrep.get(c)] = c;
            } else {
                ans[0] = ' ';
            }
        }
        int i=0;
        for(Character c: maxrep.keySet()) {
            if(maxrep.get(c) >= 10) {
                while(ans[i]!=' ')i++;
                ans[i] = c;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            solve();
        }
    }
}
