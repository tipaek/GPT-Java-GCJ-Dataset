import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.println(String.format("Case #%d: %s", i, solve(in.nextLine())));
        }
    }

    private static String solve(String line) {

        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.length(); ++i) {
            int number = line.charAt(i) - '0';

            sb.append(putBraces(depth, number));
            depth = number;
            sb.append(line.charAt(i));
        }

        sb.append(putBraces(depth, 0));

        return sb.toString();
    }

    private static StringBuilder putBraces(int depth, int targetDepth) {

        StringBuilder braces = new StringBuilder();
        if(depth <= targetDepth) {
            braces.append("(".repeat(targetDepth - depth));
        } else {
            braces.append(")".repeat(depth - targetDepth));
        }

        return braces;
    }
}
  