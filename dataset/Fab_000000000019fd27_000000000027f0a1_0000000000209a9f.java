import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution {
        static String PAR = "(";
        static String PAR_CLOSED = ")";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            String input = in.nextLine();
            int length = input.length();
            String res = "";

            // Iterate over number in input line
            int current;
            int previous = -1;
            for (int j = 0; j < length; j++) {
                current = Character.getNumericValue(input.charAt(j));
                if (j == 0) {
                    res = printStart(current);
                    previous = current;
                    continue;
                }

                if (current == previous) {
                    res = res.concat(String.valueOf(current));
                } else  if (previous > current){
                    res = res.concat(printClose(previous-current))
                            .concat(String.valueOf(current));
                } else if (previous < current) {
                    res = res.concat(printClose(previous))
                            .concat(printStart(current));
                }

                previous = current;
            }

            // End
            res = res.concat(printClose(Character.getNumericValue(input.charAt(length-1))));

            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String printStart(int current) {
        if (current == 0) {
            return "0";
        }
        return new String(new char[current]).replace("\0", PAR).concat(String.valueOf(current));
    }

    private static String printClose(int current) {
        if (current == 0) {
            return "";
        }
        return new String(new char[current]).replace("\0", PAR_CLOSED);
    }
}