import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder input = new StringBuilder(in.next());
            int openCount = 0;
            StringBuffer output = new StringBuffer();
            for(int j = 0; j < input.length(); j++)
            {
                int d = input.charAt(j) - 48;
                if (d < openCount) {
                    output.append(repeat(')', openCount - d));
                    openCount = d;
                } else {
                    output.append(repeat('(', d - openCount));
                    openCount = d;
                }
                output.append(d);
            }
            output.append(repeat(')', openCount));
            System.out.println("Case #" + i + ": " + output.toString());
        }
    }

    private static String repeat(char ch, int n) {
        StringBuffer out = new StringBuffer();
        IntStream.range(0, n).forEach(i -> out.append(ch));
        return out.toString();
    }
}
