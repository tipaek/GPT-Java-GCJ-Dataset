import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            StringBuilder ans = new StringBuilder();
            int level = 0;
            for(int charIndex = 0; charIndex < line.length(); charIndex++) {
                char c = line.charAt(charIndex);
                int converted = Integer.parseInt(String.valueOf(c));
                if (converted > level) {
                    int diff = converted - level;
                    for (int k = 0; k < diff; k++) {
                        ans.append("(");
                        level++;
                    }
                } else if (level > converted) {
                    int diff = level - converted;
                    for (int k = 0; k < diff; k++) {
                        ans.append(")");
                        level--;
                    }
                }
                ans.append(c);
            }

            for (int remaining = 0; remaining < level; remaining++) {
                ans.append(")");
            }

            System.out.println("Case #" + i + ": " +ans.toString());
        }
    }
}