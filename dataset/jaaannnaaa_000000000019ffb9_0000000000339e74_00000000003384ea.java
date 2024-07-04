import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in;
        int FROM_SYSTEM = 1;    // 1 on Submission !!!

        if (FROM_SYSTEM == 1) { // 1 on Submission !!!
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } else {
            System.out.println("reading from file");
            File myObj = new File("test.txt");
            in = new Scanner(myObj);
        }



        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int tt = 1; tt <= t; ++tt) {
            long l = in.nextLong();
            long r = in.nextLong();
            
            long i = 1;
            boolean canDo = (i <= l) || (i <= r);
            while (canDo) {
                // System.out.println(i + " " + l + " " + r);
                if (r > l) {
                    r = r - i;
                } else {
                    l = l - i;
                }
                i++;
                canDo = (i <= l) || (i <= r);
            }

            i--;
            System.out.println("Case #" + tt + ": " + i + " " + l + " " + r);
        }

        in.close();
    }
}
