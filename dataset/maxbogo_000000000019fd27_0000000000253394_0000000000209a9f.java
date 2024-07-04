import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 1; t <= T; ++t) {
            String rowString = in.next();
            System.out.print("Case #" + t + ": ");
            int curr = 0;
            int previous = 0;

            for (char ch: rowString.toCharArray()) {
                curr = Character.getNumericValue(ch);
                int diff = curr - previous;
                if (diff > 0) {
                    for (int i = 0; i < diff; i++) {
                        System.out.print('(');
                    }
                }
                if (diff < 0) {
                    for (int i = 0; i < ((-1)*diff); i++) {
                        System.out.print(')');
                    }
                }

                System.out.print(ch);
                previous = curr;
            }

            if ((0-previous) < 0) {
                for (int i = 0; i < previous; i++) {
                    System.out.print(')');
                }
            }
            System.out.println("");
        }


    }

}
