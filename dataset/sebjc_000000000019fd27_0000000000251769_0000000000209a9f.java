
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine(); // chomp newline

        for (int i = 1; i <= t; ++i) {
            String ln = in.nextLine();
            String[] input = ln.split("");
            StringBuilder output = new StringBuilder();

            int start = 0;
            int end = input.length;
            for(int j =0; j<end; j++) {
                String cur_s = input[j];
                int cur_i = Integer.valueOf(cur_s);

                // calc the comparison val preceeding
                int pre;
                if(j == start) {
                    // comparing against zero here as default
                    pre = 0;
                } else {
                    pre = Integer.valueOf(input[j-1]);
                }

                if(pre == cur_i) {
                    // don't add any braces as both are the same
                    output.append(cur_s);
                } else if(pre > cur_i) {
                    // stepping down, need to
                    // - add closing braces
                    int diff = pre - cur_i;
                    String toAppend = generate(")", diff);
                    output.append(toAppend);

                    // - add number
                    output.append(cur_s);
                } else {
                    // pre < cur_i stepping up, need to
                    // - add preceeding opening braces
                    int diff = cur_i - pre;
                    String toAppend = generate("(", diff);
                    output.append(toAppend);
                    // - append number
                    output.append(cur_s);
                }
            }

            // Add closing braces if any
            String last_s = input[end-1];
            int diff = Integer.valueOf(last_s);
            String toAppend = generate(")", diff);
            output.append(toAppend);

            System.out.println("Case #" + i + ": " + output.toString());
        }
    }

    private static String generate(String toRepeat, int times) {
        return String.join("", Collections.nCopies(times, toRepeat));
    }
}