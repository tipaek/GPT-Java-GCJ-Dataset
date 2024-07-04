import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int x = 1; x <= t; ++x) {
            String s = in.nextLine();

            StringBuilder result = new StringBuilder();
            int openPar = 0;

            for (int i = 0; i < s.toCharArray().length; i++) {
                char c = s.charAt(i);
                int d = Character.getNumericValue(c);
                if (openPar <= d) {
                    for (int j = openPar; j < d; j++) {
                        result.append("(");
                        openPar++;
                    }
                } else {
                    for (int j = openPar; j > d; j--) {
                        result.append(")");
                        openPar--;
                    }
                }
                result.append(d);
            }
            if (openPar > 0) {
                while (openPar > 0) {
                    result.append(")");
                    openPar--;
                }
            }

            System.out.println("Case #" + x + ": " + result.toString());
        }
    }
}
