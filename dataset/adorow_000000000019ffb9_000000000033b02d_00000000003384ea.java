import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Long.max;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round2/A/A.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();

        for (int t = 1; t <= T; t++) {
            long l = in.nextLong();
            long r = in.nextLong();

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

//            int i = 1;

            long d = abs(l - r);
            long mx = max(l, r);

            int i = (int) ((-1 + sqrt(1 + 8 * d)) / 2);

            if (l >= r) {
                l -= ith(i);
            } else {
                r -= ith(i);
            }
            i++;

            while (i <= max(l, r)) {

                if (l >= r) {
                    l -= i;
                } else {
                    r -= i;
                }

                i++;
            }

            out.print(i-1);
            out.print(" ");
            out.print(l);
            out.print(" ");
            out.print(r);

            out.println();
        }
        out.flush();
    }

    static long ith(long n) {
        return (n * (n + 1)) / 2;
    }

}
