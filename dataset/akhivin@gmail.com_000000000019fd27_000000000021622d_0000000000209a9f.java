
import java.util.*;
import java.io.*;

import static java.lang.System.out;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        in.nextLine();
        for (int caseNum = 1; caseNum <= t; ++caseNum) {
            String s = in.nextLine();
            StringBuffer output = new StringBuffer();
            int open = 0;

            for (int di = 0; di < s.length(); di++) {
                int digit = s.charAt(di) - 48;
                while (true) {
                    if (open > digit) {
                        output.append(')');
                        open--;
                    }
                    if (open < digit) {
                        output.append('(');
                        open++;
                    }
                    if (open == digit) {
                        output.append(digit);
                        break;
                    }
                }
            }

            for (; open > 0; open--) {
                output.append(')');
            }

            System.out.println("Case #" + caseNum + ": " + output.toString());
        }
    }
}