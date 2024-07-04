import java.io.*;
import java.util.Scanner;

/**
 * @author Holenko I.
 * @since 2020-04-04
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

                Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader(new File("/home/illia/Workspace/java_examples/java_simple/src/main/resources/jam2.txt"))));
        int     t  = in.nextInt();

        for (int tCase = 1; tCase <= t; tCase++) {
            final String next = in.next();


            StringBuilder b = new StringBuilder();

            int          opn   = 0;
            final char[] chars = next.toCharArray();
            for (char c : chars) {
                int i = Character.getNumericValue(c);

                if (i > opn) {
                    //                    close0(b, opn);
                    open0(b, i - opn);
                    opn = i;
                    b.append(i);
                } else if (i < opn) {
                    close0(b, opn - i);
                    opn -= opn - i;
                    b.append(i);
                } else {
                    b.append(i);
                }
            }

            close0(b, opn);

            System.out.println("Case #" + tCase + ": " + b);
        }
    }

    private static void close0(StringBuilder b, int opn) {
        for (int i = 0; i < opn; i++)
            b.append(")");
    }

    private static void open0(StringBuilder b, int opn) {
        for (int i = 0; i < opn; i++)
            b.append("(");
    }
}
