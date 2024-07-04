import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int k = 1; k <= t; ++k) {
            String s = in.nextLine();
            StringBuilder ans = new StringBuilder();
            int count = 0;
            for(int i = 0; i < s.length(); i++) {
                if(!Character.isDigit(s.charAt(i))) continue;
                int digit = Character.getNumericValue(s.charAt(i));
                while(digit > count) {
                    ans.append('(');
                    count++;
                }
                while(digit < count) {
                    ans.append(')');
                    count--;
                }
                ans.append(s.charAt(i));
            }
            while(count > 0) {
                ans.append(')');
                count--;
            }
            System.out.println("Case #" + k + ": " + ans);
        }
    }
}