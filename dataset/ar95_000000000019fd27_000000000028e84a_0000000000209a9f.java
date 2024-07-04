// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tc = 1; tc <= t; ++tc) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int open = 0;
            for(char c: s.toCharArray()){
                int digit = c-'0';
                if(open<digit){
                    for(int i=open; i<digit; i++) sb.append('(');
                }else if(open>digit){
                    for(int i=digit; i<open; i++) sb.append(')');
                }
                sb.append(digit);
                open = digit;
            }
            for(int i=0; i<open; i++) sb.append(')');
            System.out.println("Case #" + tc + ": " +sb.toString());
        }
    }
}