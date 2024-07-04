import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            StringBuilder sb = new StringBuilder();

            int currentLevel = 0;

            for (String curr : s.split("|")) {

                int val = curr.charAt(0) - '0';

                while (val > currentLevel) {
                    sb.append("(");
                    currentLevel++;
                }

                while (val < currentLevel) {
                    sb.append(")");
                    currentLevel--;
                }

                sb.append(val);
            }

            while (currentLevel > 0) {
                sb.append(")");
                currentLevel--;
            }

            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}