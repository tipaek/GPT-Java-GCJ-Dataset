import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String s = in.next();
            StringBuilder result = new StringBuilder();

            int prefix = 0;
            for(int j = 0; j < s.length(); j++) {
                int currPrefix = prefix;
                char c = s.charAt(j);
                int charVal = Character.getNumericValue(c);
                if(currPrefix < charVal) {
                   for(int p = 0; p < charVal - currPrefix; p++) {
                       result.append('(');
                       prefix++;
                   }
                }
                else if(currPrefix > charVal) {
                    for(int p = 0; p < currPrefix - charVal ; p++) {
                        result.append(')');
                        prefix--;
                    }
                }

                result.append(c);
            }

            result.append(")".repeat(Math.max(0, prefix)));


            System.out.println("Case #" + i + ": " + result.toString());
        }
    }
}