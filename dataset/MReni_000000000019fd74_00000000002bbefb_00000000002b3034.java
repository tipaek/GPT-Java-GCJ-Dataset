import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      in.nextLine();
      for (int i = 1; i <= t; ++i) {
        int lineCount = in.nextInt();
        in.nextLine();

        String[] lines = new String[lineCount];
        for (int j = 0; j < lineCount; j++) {
            lines[j] = in.nextLine();
        }
        String output = getOutput(lines);
        System.out.println("Case #" + i + ": " + output);
      }
    }

    public static String getOutput(String[] lines) {
        String output = lines[0].substring(1, lines[0].length());
        for (String line : lines) {
            String subline = line.substring(1, line.length());
            if (subline.endsWith(output)) {
                output = subline;
            } else if (!output.endsWith(subline)){
                return "*";
            }
        }
        return output;
    }
}