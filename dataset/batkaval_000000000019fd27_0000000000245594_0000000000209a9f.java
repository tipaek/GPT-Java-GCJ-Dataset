import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; i++) {
            String input = in.next();
            String output = "";

            boolean opened = false;
            for(int j = 0; j< input.length(); j++) {

                int d = Integer.parseInt(String.valueOf(input.charAt(j)));

                if (d == 0) {
                    if (opened) {
                        output += ")";
                        opened = false;
                    }
                }

                if (d == 1) {
                    if (!opened) {
                        opened = true;
                        output += "(";
                    }
                }

                output += d;
            }
            if (opened) {
                output += ")";
            }

            System.out.println("Case #" + i + ": " + output);
        }
    }
}
